package com.mouhcine.SchoolSpringApp.config;

import com.mouhcine.SchoolSpringApp.services.impl.CustomAuthentificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    /**
     *
     * Nous avons choisi d'implémenter une gestion personnalisée de
     * l'authentification Ainsi, nous devons indiquer à Spring Security quelle est
     * notre gestionnaire d'authentification Ce gestionnaire est
     * CustomAuthentificationService
     *
     */
    @Autowired // injection du gestionnaire CustomAuthentificationService
    private CustomAuthentificationService userService;

    @Autowired // Injection de Success Handler qui permet d'inidquer à Spring les redirections
    // à faire après le succès de l'authentification
    @Qualifier("redirectionAfterAuthenticationSuccessHandler")
    private AuthenticationSuccessHandler authSuccessHandler;

    public AppSecurityConfig() {

        LOGGER.debug("AppSecurityConfig Initialisé");
    }

    // Configurer DaoAuthenticationProvider (Vous pouvez laisser cette configuration
    // telle quelle)
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // Indiquer à Spring Security votre Gestionnaire d'authentification
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userService);

    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    // Configuration de l'algorithme de hashage des mots de passe
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Par défaut on utilise bcrypt
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // TODO : Configurer la securité de votre application

        http.authorizeRequests().antMatchers("/student/**").hasRole("STUDENT")
                .antMatchers("/cadreadmin/**").hasRole("CADRE_ADMIN")
                .antMatchers("/prof/**").hasRole("PROF")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/biblio/**").hasRole("BIBLIO")

                .and()

                .formLogin().loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .failureHandler(authenticationFailureHandler())

                .successHandler(authSuccessHandler).and().logout() // Configurer le logout

//		.logoutUrl("/perform_logout")   //Nous avons utiliser la valeur par défaut qui est /logout
                .deleteCookies("JSESSIONID")
                .and().csrf().disable().exceptionHandling().accessDeniedPage("/access-denied");

    }
}
