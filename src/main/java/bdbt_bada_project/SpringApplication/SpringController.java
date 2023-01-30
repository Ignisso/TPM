package bdbt_bada_project.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping(value={"/logout"})
    public String finalizeLogOut(Model model) {
        return "redirect:/index";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }
    @RequestMapping(value={"/main_controller"})
    public String showControllerPage(Model model) {
        return "user/main_controller";
    }

}