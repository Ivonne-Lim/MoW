package org.mm.mow.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.http.HttpMethod;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    public static final String[] ANONYMOUS_GET_ENDPOINT = {

        "/access", "/login_error", "/logout_success"    // URL defined in AccessController

    };

    public static final String[] ANONYMOUS_POST_ENDPOINT = {

        "/login"                                        // URL defined in AccessController

    };

    public static final String[] WHITELIST_GET_ENDPOINT = {

        "/*.jpg",                                        // Image files located in static folder

        "/*.css",                                        // CSS files located in static folder
        "/*.js",                                         // JS files located in static folder

        "/header.jsp", "/footer.jsp",                    // Includes located in views folder

        "/", "/home",                                    // URL defined in AppController
        "/register",                                     // URL defined in RegisterController
        "/access_denial"                                 // URL defined in AccessDenialController

    };

    public static final String[] WHITELIST_POST_ENDPOINT = {

        "/register"                                       // URL defined in RegisterController

    };

    public static final String[] ANY_GET_ENDPOINT = {

        "/login_success", "/logout"                       // URL defined in AccessController

    };

    public static final String[] ANY_POST_ENDPOINT = {

        "/access"                                         // URL defined in AccessController

    };

    public static final String[] MANAGEMENT_GET_ENDPOINT = {

        "/management/plans",                              // URL defined in MealPlanController
        "/management/plan", "/management/plan_deletion",  // URL defined in MealPlanController
        "/management/reports"                             // URL defined in ReportController

    };

    public static final String[] MANAGEMENT_POST_ENDPOINT = {

        "/management/plan"                                // URL defined in MealPlanController

    };

    public static final String LOGIN_PAGE_URL = "/access";
    public static final String LOGIN_PROCESS_URL = "/login";
    public static final String LOGIN_FAILURE_URL = "/login_error";
    public static final String LOGIN_SUCCESS_URL = "/login_success";
    public static final String USERNAME_PARAMETER = "address_email";
    public static final String PASSWORD_PARAMETER = "password";

    public static final String LOGOUT_PROCESS_URL = "/access";
      // public static final String LOGOUT_PROCESS_URL = "/logout";
    public static final String LOGOUT_SUCCESS_URL = "/logout_success";

    public static final String ACCESS_DENIAL_URL = "/access_denial";


    @Bean
    public UserDetailsService getUserDetailsService() {

        return new UserDetailsServiceImpl();

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http

            .formLogin(form -> form
                .loginPage(LOGIN_PAGE_URL)
                .loginProcessingUrl(LOGIN_PROCESS_URL)
                .failureUrl(LOGIN_FAILURE_URL)
                .permitAll()
                .defaultSuccessUrl(LOGIN_SUCCESS_URL)
                .usernameParameter(USERNAME_PARAMETER)
                .passwordParameter(PASSWORD_PARAMETER))

            .authorizeHttpRequests(request -> request
                    .requestMatchers(HttpMethod.GET, ANONYMOUS_GET_ENDPOINT).anonymous()
                    .requestMatchers(HttpMethod.POST, ANONYMOUS_POST_ENDPOINT).anonymous()
            		.requestMatchers(HttpMethod.GET, WHITELIST_GET_ENDPOINT).permitAll()
                    .requestMatchers(HttpMethod.POST, WHITELIST_POST_ENDPOINT).permitAll()
                    .requestMatchers(HttpMethod.GET, ANY_GET_ENDPOINT).hasAnyRole("CAREGIVER", "MEMBER", "FSP", "RIDER", "MANAGEMENT")
                    .requestMatchers(HttpMethod.POST, ANY_POST_ENDPOINT).hasAnyRole("CAREGIVER", "MEMBER", "FSP", "RIDER", "MANAGEMENT")
                    .requestMatchers(HttpMethod.GET, MANAGEMENT_GET_ENDPOINT).hasRole("MANAGEMENT")
                    .requestMatchers(HttpMethod.POST, MANAGEMENT_POST_ENDPOINT).hasRole("MANAGEMENT")
                    .anyRequest().permitAll())
                      // anyRequest().authenticated())

            .logout(logout -> logout
                .logoutSuccessUrl(LOGOUT_SUCCESS_URL)
                .permitAll()
                .logoutUrl(LOGOUT_PROCESS_URL)
                .deleteCookies("JSESSIONID", "remember-me")
                .clearAuthentication(true)
                .invalidateHttpSession(true));

        http

            .exceptionHandling(exception-> exception
                .accessDeniedPage(ACCESS_DENIAL_URL));

        return http.build();

    }


}
