package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
      BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
      return bCryptPasswordEncoder;
  }
  
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {	  
    auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
      withUser("admin").password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("ADMIN"); //password = 123456 - passwordEncoder().encode("123456")
    auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
      withUser("user").password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("USER");  //password = 123456 - passwordEncoder().encode("123456")
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Chỉ cho phép user có quyền ADMIN truy cập đường dẫn /ProductList
    http.authorizeRequests().antMatchers("/ProductList").access("hasRole('ROLE_ADMIN')");
    // Chỉ cho phép user có quyền ADMIN hoặc USER truy cập đường dẫn /Form
    http.authorizeRequests().antMatchers("/Form").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')");
    
    // Khi người dùng đã login, với vai trò USER, Nhưng truy cập vào trang yêu cầu vai trò ADMIN, sẽ chuyển hướng tới trang /403
    http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
    http.csrf().disable();
    // Cấu hình cho Login Form.
    http.authorizeRequests().and().formLogin()//
        .loginProcessingUrl("/perform_login") // action in login.jsp file
        .loginPage("/loginPage")//
        .defaultSuccessUrl("/loginSuccess")//
        .failureUrl("/loginPage?message=error")//
        .usernameParameter("username")//
        .passwordParameter("password")
        // Cấu hình cho Logout Page.
        .and().logout().logoutUrl("/logout").logoutSuccessUrl("/loginPage?message=logout");
  }
}