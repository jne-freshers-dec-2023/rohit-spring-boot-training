package com.spring.learnspringsecurity.basicsecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
public class BasicAuthSecurityConfiguration {

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
//    {
//        http.authorizeHttpRequests().anyRequest().authenticated();
//        http.formLogin();
//        http.httpBasic();
//        return http.build();
//    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> {
//            requestMatchers("/user").hasRole("USER").requestMatchers("/admin/**").hasRole("ADMIN").
            auth.anyRequest().authenticated();
        });
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.httpBasic(Customizer.withDefaults());
//        http.csrf();
//        http.headers().frameOptions().sameOrigin();
        return (SecurityFilterChain)http.build();
    }


    //create user for in memory not good for production
    @Bean
    public UserDetailsService userDetailService()
    {
         var user=User.withUsername("rohit")
                .password("{noop}rohit123")
                .roles("user")
                .build();
         var admin=User.withUsername("admin")
                 .password("{noop}admin123")
                 .roles("Admin")
                 .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
    @Bean
    public DataSource dataSource()
    {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }


//    @Bean
//    public UserDetailsService userDetailService(DataSource dataSource)
//    {
//        var user=User.withUsername("rohit")
//                .password("rohit123")
//                .passwordEncoder(str -> passwordEncoder().encode(str))
//                .roles("user")
//                .build();
//
//        var admin=User.withUsername("admin")
//                .password("admin123")
//                .passwordEncoder(str -> passwordEncoder().encode(str))
//                .roles("Admin")
//                .build();
//
//        var jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
//        jdbcUserDetailsManager.createUser(user);
//        jdbcUserDetailsManager.createUser(admin);
//
//        return jdbcUserDetailsManager;
//    }



//    Store Password

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
