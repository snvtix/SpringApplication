package bdbt_bada_project.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("klient")
                .password("klient")
                .roles("USER")
                .and()
                .withUser("pracownik")
                .password("pracownik")
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/main").authenticated()
                .antMatchers("/main_admin").access("hasRole('ADMIN')")
                .antMatchers("/prac_zarzad").access("hasRole('ADMIN')")
                .antMatchers("/edit_pracownicy").access("hasRole('ADMIN')")
                .antMatchers("/wynagrodzenia_zarzad").access("hasRole('ADMIN')")
                .antMatchers("/studia_zarzad").access("hasRole('ADMIN')")
                .antMatchers("/new_studia").access("hasRole('ADMIN')")
                .antMatchers("/edit_studia").access("hasRole('ADMIN')")
                .antMatchers("/sprzety_zarzad").access("hasRole('ADMIN')")
                .antMatchers("/new_sprzety").access("hasRole('ADMIN')")
                .antMatchers("/edit_sprzety").access("hasRole('ADMIN')")
                .antMatchers("/firmy_zarzad").access("hasRole('ADMIN')")
                .antMatchers("/new_firmy").access("hasRole('ADMIN')")
                .antMatchers("/edit_firmy").access("hasRole('ADMIN')")
                .antMatchers("/main_user").access("hasRole('USER')")
                .antMatchers("/klienci_zarzad").access("hasRole('USER')")
                .antMatchers("/oferty_zarzad").access("hasRole('USER')")
                .antMatchers("/edit_klienci").access("hasRole('USER')")
                .antMatchers("/new_oferty").access("hasRole('USER')")
                .antMatchers("/edit_klienci").access("hasRole('USER')")
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

