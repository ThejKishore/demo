

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

    private String[] exceptionUrls={"/Contacts","/Contact","/Contact/**","/console/**"};


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
//              h2 console doesn't work with headers enabled since most of the screens are called in iframes.
//              .antMatchers("/console/**").permitAll()
                .antMatchers("/contactUI").hasAnyAuthority("USER","ADMIN")

                /*.anyRequest().hasAnyRole("USER","ADMIN")*/
                .anyRequest().authenticated()
                .and()
                .formLogin()
                /*.loginPage()*/
                .permitAll()
                .and()
                .logout()
                .permitAll();

        //exempting the Rest URI from the csrf checking.
        http.csrf().ignoringAntMatchers(exceptionUrls);

       /****for enabling the h2 console*****/
       /*
        http.csrf().disable();
        http.headers().disable();
        */
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //Setting up the auth using the inmemory...
       /* auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("root").password("root").roles("ADMIN");*/

       //Setting the auth using the jdbcAuthentication.
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
                "select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, authority from authorities where username=?");
    }
}


