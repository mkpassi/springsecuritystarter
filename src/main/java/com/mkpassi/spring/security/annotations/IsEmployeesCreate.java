package com.mkpassi.spring.security.annotations;

import static com.mkpassi.spring.security.SecurityRoles.EMPLOYEES_CREATE;
import static com.mkpassi.spring.security.SecurityRoles.ROLE_PREFIX;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.security.access.annotation.Secured;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Secured(ROLE_PREFIX + EMPLOYEES_CREATE)
public @interface IsEmployeesCreate {
}
