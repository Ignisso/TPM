package bdbt_bada_project.SpringApplication;
import bdbt_bada_project.SpringApplication.Database.*;
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
            model.addAttribute("updateBilet", new Bilet());

            return "/admin/bilety";
        }

        @RequestMapping("/main_admin/przystanki")
        public String viewPrzystankiAdminPanel(Model model) {
            System.out.println("/main_admin/przystanki");
            Przystanek przystanek = new Przystanek();
            DAO<Przystanek> przystanekDAO = new DAO<Przystanek>();
            List<Przystanek> przystanekList = przystanekDAO.selectAll(przystanek);
            for(Przystanek b: przystanekList) {
                System.out.println(b);
            }
            model.addAttribute("przystanekList", przystanekList);
            model.addAttribute("updatePrzystanek", new Przystanek());

            return "/admin/przystanki";
        }

        @RequestMapping("/main_admin/trasy")
        public String viewTrasyAdminPanel(Model model) {
            System.out.println("/main_admin/trasy");
            Trasa trasa = new Trasa();
            DAO<Trasa> trasaDAO = new DAO<>();
            List<Trasa> trasaList = trasaDAO.selectAll(trasa);
            for(Trasa b: trasaList) {
                System.out.println(b);
            }
            model.addAttribute("trasaList", trasaList);
            model.addAttribute("updateTrasa", new Trasa());

            return "/admin/trasy";
        }

        @RequestMapping("/main_user")
        public String viewUser(Model model) {
            System.out.println("/main_user");
            Bilet bilet = new Bilet();
            bilet.setnr_pasazera(22);
            DAO<Bilet> biletDAO = new DAO<Bilet>();
            String[] fields = {"nr_pasazera"};
            List<Bilet> biletList = biletDAO.selectByFieldsName(bilet, fields);
            for(Bilet b: biletList) {
                System.out.println(b);
            }
            model.addAttribute("biletList", biletList);
            model.addAttribute("updateBilet", new Bilet());

            return "/user/main_user";
        }

        @RequestMapping(value = "/updateBilet", method = RequestMethod.POST)
        public String viewBiletyAdminPanel(@ModelAttribute("bilet")  Bilet bilet) {
            Bilet temp = new Bilet();
            DAO<Bilet> biletDAO = new DAO<Bilet>();
            List<Bilet> biletList = biletDAO.selectAll(temp);
            Collections.reverse(biletList);
            System.out.println(bilet);
            if((Integer)bilet.getField("nr_biletu") == (Integer)biletList.get(biletList.size() - 1).getField("nr_biletu") + 1) {
                biletDAO.insert(bilet);
                // We are adding
            } else {
                // We are updating
                biletDAO.update(bilet);
            }
            return "redirect:/main_user";
        }

        @RequestMapping(value = "/buyBilet", method = RequestMethod.POST)
        public String viewBoughtTicker(@ModelAttribute("bilet")  Bilet bilet, Model model) {
            DAO<Bilet> biletDAO = new DAO<Bilet>();
            List<Bilet> biletList = biletDAO.selectAll(new Bilet());
            bilet.setnr_biletu(biletList.size() + 1);
            bilet.setnr_pasazera(22);
            System.out.println(bilet);
            biletDAO.insert(bilet);

            return "redirect:/main_user";
        }

        @RequestMapping(value = "/updatePrzystanek", method = RequestMethod.POST)
        public String viewPrzystankiAdminPanel(@ModelAttribute("przystanek")  Przystanek przystanek) {
            Przystanek temp = new Przystanek();
            DAO<Przystanek> przystanekDAO = new DAO<Przystanek>();
            List<Przystanek> przystanekList = przystanekDAO.selectAll(temp);
            System.out.println(przystanek);
            if((Integer)przystanek.getField("nr_przystanku") == (Integer)przystanekList.get(przystanekList.size() - 1).getField("nr_przystanku") + 1) {
                przystanekDAO.insert(przystanek);
                // We are adding
            } else {
                // We are updating
                przystanekDAO.update(przystanek);
            }
            return "redirect:/main_admin/przystanki";
        }

        @RequestMapping(value = "/updateTrasa", method = RequestMethod.POST)
        public String viewTrasyAdminPanel(@ModelAttribute("trasa")  Trasa trasa) {
            Trasa temp = new Trasa();
            DAO<Trasa> trasaDAO = new DAO<>();
            List<Trasa> trasaList = trasaDAO.selectAll(temp);
            System.out.println(trasa);
            if((Integer)trasa.getField("nr_trasy") == (Integer)trasaList.get(trasaList.size() - 1).getField("nr_trasy") + 1) {
                trasaDAO.insert(trasa);
                // We are adding
            } else {
                // We are updating
                trasaDAO.update(trasa);
            }
            return "redirect:/main_admin/trasy";
        }

        @RequestMapping(value = "/deleteBilet", method = RequestMethod.POST)
        public String viewBiletyAdminPanelAfterDeletion(@ModelAttribute("bilet")  Bilet bilet) {
            Bilet temp = new Bilet();
            DAO<Bilet> biletDAO = new DAO<Bilet>();
            System.out.println(bilet);
            biletDAO.delete(bilet);

            return "redirect:/main_admin/bilety";
        }

        @RequestMapping(value = "/deletePrzystanek", method = RequestMethod.POST)
        public String viewPrzystankiAdminPanelAfterDeletion(@ModelAttribute("przystanek")  Przystanek przystanek) {
            Przystanek temp = new Przystanek();
            DAO<Przystanek> przystanekDAO = new DAO<Przystanek>();
            System.out.println(przystanek);
            przystanekDAO.delete(przystanek);

            return "redirect:/main_admin/przystanki";
        }

        @RequestMapping(value = "/deleteTrasa", method = RequestMethod.POST)
        public String viewTrasyAdminPanelAfterDeletion(@ModelAttribute("trasa")  Trasa trasa) {
            Trasa temp = new Trasa();
            DAO<Trasa> trasaDAO = new DAO<>();
            System.out.println(trasa);
            trasaDAO.delete(trasa);

            return "redirect:/main_admin/trasy";
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