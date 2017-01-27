

package com.kish.xdoc.sec;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by ThejKishore on 12/29/2016.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/console/**").permitAll()
                .antMatchers("/contactUI").hasAuthority("USER")
                /*.anyRequest().hasAnyRole("USER","ADMIN")*/
                .anyRequest().authenticated()
                .and()
                .formLogin()
                /*.loginPage()*/
                .permitAll()
                .and()
                .logout()
                .permitAll();

       /*
       for enabling the h2 console
        http.csrf().disable();

        http.headers().disable();
        */
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       /* auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("root").password("root").roles("ADMIN");*/
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
                "select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, authority from authorities where username=?")
        ;
    }
}


