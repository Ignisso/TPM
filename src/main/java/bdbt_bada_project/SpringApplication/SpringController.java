package bdbt_bada_project.SpringApplication;
import bdbt_bada_project.SpringApplication.Database.DAO;
import bdbt_bada_project.SpringApplication.Database.Przystanek;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

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
        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN"))
                return "redirect:/main_admin/bilety";
            else if (request.isUserInRole("USER"))
                return "redirect:/main_user";
            else if (request.isUserInRole("CONTROLLER"))
                return "redirect:/main_controller";
            else
                return "/index";
        }

        @RequestMapping("/login")
        public String keepLoggedIn(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            }
            else if (request.isUserInRole("CONTROLLER")) {
                return "redirect:/main_controller";
            }
            return null;
        }
    }



    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }
    @RequestMapping(value={"/main_controller"})
    public String showControllerPage(Model model) {
        return "user/main_controller";
    }

    /**
     * 		Integer in_line = 17;
     * 		Integer forward = 1; // or 0
     *
     * 		DatabaseController dc = new DatabaseController();
     * 		ResultSet rs = dc.select("SELECT DISTINCT(linia) FROM linie");
     * 		List<Integer> distinct_lines = new ArrayList<>();
     * 		try {
     * 			while (rs.next())
     * 				distinct_lines.add(rs.getInt(1));
     * 			dc.closeConnection();
     *                } catch (Exception ex) {
     * 			ex.printStackTrace();
     *        }
     *
     * 		//if (!distinct_lines.contains(in_line))
     * 		//	redirect 404
     *
     * 		rs = dc.select("SELECT nr_linii FROM linie WHERE linia = " + in_line);
     * 		List<Integer> direction = new ArrayList<>();
     * 		try {
     * 			while (rs.next())
     * 				direction.add(rs.getInt(1));
     * 			dc.closeConnection();
     *        } catch (Exception ex) {
     * 			ex.printStackTrace();
     *        }
     *
     * 		rs = dc.select("SELECT godzina_odjazdu FROM rozklady WHERE nr_linii = " + direction.get(forward));
     * 		List<String> departure = new ArrayList<>();
     * 		try {
     * 			while (rs.next())
     * 				departure.add(rs.getString(1));
     * 			dc.closeConnection();
     *        } catch (Exception ex) {
     * 			ex.printStackTrace();
     *        }
     *
     * 		rs = dc.select("SELECT czas, nazwa FROM trasy LEFT JOIN przystanki ON " +
     * 				"trasy.nr_przystanku = przystanki.nr_przystanku WHERE nr_linii = " + direction.get(forward) +
     * 				" ORDER BY czas");
     * 		List<Integer> time = new ArrayList<>();
     * 		List<String> stops = new ArrayList<>();
     * 		try {
     * 			while (rs.next()) {
     * 				time.add(rs.getInt(1));
     * 				stops.add(rs.getString(2));
     *            }
     * 			dc.closeConnection();
     *        } catch (Exception ex) {
     * 			ex.printStackTrace();
     *        }
     */
}