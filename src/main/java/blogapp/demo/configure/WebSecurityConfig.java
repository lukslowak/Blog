package blogapp.demo.configure;

import blogapp.demo.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService basicUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/addOnePost").hasAnyRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/posts")
                .loginProcessingUrl("/login-process")
                .usernameParameter("userName")
                .passwordParameter("password")
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied")
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(basicUserDetailsService);
    }
}
