package bdbt_bada_project.SpringApplication;
import bdbt_bada_project.SpringApplication.Database.Bilet;
import bdbt_bada_project.SpringApplication.Database.DAO;
import bdbt_bada_project.SpringApplication.Database.Pair;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.util.*;

@Configuration
public class SpringController implements WebMvcConfigurer {
    @RequestMapping("/")
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("logout");
        registry.addViewController("/line").setViewName("line");

        registry.addViewController("/main_admin/bilety").setViewName("admin/bilety");
        registry.addViewController("/main_admin/przystanki").setViewName("admin/przystanki");
        registry.addViewController("/main_admin/trasy").setViewName("admin/trasy");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/buy").setViewName("user/buy");
        registry.addViewController("/main_controller").setViewName("controller/main_controller");
    }

    @Controller
    public class DashboardController {
        @RequestMapping(value = "/line")
        public String viewRozklad(Model model,
                                  @RequestParam(value = "linia", required = true, defaultValue = "1") Integer line,
                                  @RequestParam(value = "kierunek", required = true, defaultValue = "0") Integer forward) {
            DatabaseController dc = new DatabaseController();
            ResultSet rs = dc.select("SELECT DISTINCT(linia) FROM linie");
            List<Integer> distinct_lines = new ArrayList<>();
            try {
                while (rs.next())
                    distinct_lines.add(rs.getInt(1));
                dc.closeConnection();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (!distinct_lines.contains(line))
                return "errors/404";

            rs = dc.select("SELECT nr_linii FROM linie WHERE linia = " + line);
            List<Integer> direction = new ArrayList<>();
            try {
                while (rs.next())
                    direction.add(rs.getInt(1));
                dc.closeConnection();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            rs = dc.select("SELECT godzina_odjazdu FROM rozklady WHERE nr_linii = " + direction.get(forward));
            List<String> departure = new ArrayList<>();
            try {
                while (rs.next())
                    departure.add(rs.getString(1));
                dc.closeConnection();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            rs = dc.select("SELECT czas, nazwa FROM trasy LEFT JOIN przystanki ON " +
                    "trasy.nr_przystanku = przystanki.nr_przystanku WHERE nr_linii = " + direction.get(forward) +
                    " ORDER BY czas");
            List<Pair<String, Integer>> stops_info = new ArrayList<>();
            try {
                while (rs.next()) {
                    stops_info.add(new Pair<>(rs.getString(2), rs.getInt(1)));
                }
                dc.closeConnection();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            List<List<String>> departure_info = new ArrayList<>(24);
            for (int i = 0; i < 24; i++) {
                departure_info.add(new ArrayList<String>());
                departure_info.get(i).add(Integer.toString(i));
            }
            for (String s : departure) {
                String[] n = s.split(":");
                departure_info.get(Integer.parseInt(n[0])).add(n[1]);
            }
            for (Iterator<List<String>> iter = departure_info.listIterator(); iter.hasNext(); ) {
                if (iter.next().size() <= 1) {
                    iter.remove();
                }
            }

            model.addAttribute("line", line);
            model.addAttribute("change_forward", (forward + 1) % 2);
            model.addAttribute("distinct_lines", distinct_lines);
            model.addAttribute("departures", departure_info);
            model.addAttribute("stops", stops_info);
            model.addAttribute("first_stop", stops_info.get(0).getLeft());
            model.addAttribute("last_stop", stops_info.get(stops_info.size() - 1).getLeft());
            return "/line";
        }
        @RequestMapping("/main_admin/bilety")
        public String viewBiletyAdminPanel(Model model) {
            System.out.println("/main_admin/bilety");
            Bilet bilet = new Bilet();
            DAO<Bilet> biletDAO = new DAO<Bilet>();
            List<Bilet> biletList = biletDAO.selectAll(bilet);
            for (Bilet b : biletList) {
                System.out.println(b);
            }
            model.addAttribute("biletList", biletList);
            Bilet updateBilet = new Bilet();
            model.addAttribute("updateBilet", updateBilet);

            return "/admin/bilety";
        }

        @RequestMapping(value = "/update", method = RequestMethod.POST)
        public String viewBiletyAdminPanel(@ModelAttribute("bilet") Bilet bilet) {
            Bilet temp = new Bilet();
            DAO<Bilet> biletDAO = new DAO<Bilet>();
            List<Bilet> biletList = biletDAO.selectAll(temp);

            if ((Integer) bilet.getField("nr_biletu") == (Integer) biletList.get(biletList.size() - 1).getField("nr_biletu") + 1) {
                biletDAO.insert(bilet);
                // We are adding
            } else {
                // We are updating
                biletDAO.update(bilet);
            }
            return "/admin/bilety";
        }

        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                System.out.println("XD2");
                return "redirect:/main_admin/bilety";
            } else if (request.isUserInRole("USER"))
                return "redirect:/main_user";
            else if (request.isUserInRole("CONTROLLER"))
                return "redirect:/main_controller";
            else
                return "/index";
        }

        @RequestMapping("/login")
        public String keepLoggedIn(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin/bilety";
            } else if (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            } else if (request.isUserInRole("CONTROLLER")) {
                return "redirect:/main_controller";
            }
            return null;
        }
    }


    @RequestMapping(value = {"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }

    @RequestMapping(value = {"/main_controller"})
    public String showControllerPage(Model model) {
        return "user/main_controller";
    }
}