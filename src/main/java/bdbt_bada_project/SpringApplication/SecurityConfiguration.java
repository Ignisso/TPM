package bdbt_bada_project.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("$2a$12$EMmMwnH9WSWQQjd3aWcsgefJva.iSciPwVScAQm2MsT8B9UGJNig.") // "user"
                .roles("USER")
                .and()
                .withUser("admin")
                .password("$2a$12$37DUQhRa8bQB8mr9rXSgE.wKKrRKcNRJP2byuRbfctAUCK28.9Oju") // "admin"
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/", "/index").permitAll()
            .antMatchers("/resources/static/**").permitAll()
            .antMatchers("/main").authenticated()
            .antMatchers("/main_admin").access("hasRole('ADMIN')")
            .antMatchers("/main_user").access("hasRole('USER')")
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/main")
            .permitAll()
            .and()
            .logout()
            .logoutUrl("/index")
            .logoutSuccessUrl("/index")
            .permitAll();
    }
}