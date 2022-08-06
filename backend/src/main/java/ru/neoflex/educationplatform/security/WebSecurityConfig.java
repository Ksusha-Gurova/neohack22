package ru.neoflex.educationplatform.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{

  private final JwtTokenProvider jwtTokenProvider;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
            .csrf().disable()
            .cors().disable()
            .authorizeRequests()

            .anyRequest().permitAll();

//            .antMatchers("/auth/login").permitAll()
//            .antMatchers("/auth/registration").permitAll()
//            .anyRequest().authenticated()
//            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and().exceptionHandling().accessDeniedPage("/auth/login")
//            .and().apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/v2/api-docs")//
        .antMatchers("/swagger-resources/**")//
        .antMatchers("/swagger-ui.html")//
        .antMatchers("/configuration/**")//
        .antMatchers("/webjars/**")//
        .antMatchers("/public");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins("http://localhost:8880", "http://localhost:8080", "http://localhost:3000")
            .allowedMethods("*");
    WebMvcConfigurer.super.addCorsMappings(registry);
  }
}
