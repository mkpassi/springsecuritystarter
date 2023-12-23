package com.mkpassi.spring.security;

import static com.mkpassi.spring.security.SecurityRoles.*;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
        authorizeRequests -> {
          authorizeRequests
              .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR)
              .permitAll()
              .requestMatchers("/", "/home")
              .permitAll()
                          .requestMatchers("/employees").hasRole(EMPLOYEES_PAG_VIEW)
              .anyRequest()
              .authenticated();
        });
    return http.build();
  }

  @Bean
  static RoleHierarchy roleHierarchy() {
    RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
    roleHierarchy.setHierarchy(
        new RolesHierarchyBuilder()
            .append(SUPER_ADMIN, CUSTOMERS_ADMIN)
            .append(CUSTOMERS_ADMIN, CUSTOMERS_CREATE)
            .append(CUSTOMERS_ADMIN, CUSTOMERS_READ)
            .append(CUSTOMERS_ADMIN, CUSTOMERS_DELETE)
            .append(CUSTOMERS_ADMIN, CUSTOMERS_PAG_VIEW)
            .append(SUPER_ADMIN, EMPLOYEES_ADMIN)
            .append(EMPLOYEES_ADMIN, EMPLOYEES_CREATE)
            .append(EMPLOYEES_ADMIN, EMPLOYEES_READ)
            .append(EMPLOYEES_ADMIN, EMPLOYEES_DELETE)
            .append(EMPLOYEES_ADMIN, EMPLOYEES_PAG_VIEW)
            .append(SUPER_ADMIN, DEPARTMENTS_ADMIN)
            .append(DEPARTMENTS_ADMIN, DEPARTMENTS_CREATE)
            .append(DEPARTMENTS_ADMIN, DEPARTMENTS_READ)
            .append(DEPARTMENTS_ADMIN, DEPARTMENTS_DELETE)
            .append(DEPARTMENTS_ADMIN, DEPARTMENTS_PAG_VIEW)
            .build());
    return roleHierarchy;
  }

  @Bean
	static SecurityExpressionHandler securityExpressionHandler(RoleHierarchy roleHierarchy){
    DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
    expressionHandler.setRoleHierarchy(roleHierarchy);
    return expressionHandler;
  }
}
