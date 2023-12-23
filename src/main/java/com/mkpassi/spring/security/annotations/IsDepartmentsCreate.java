package com.mkpassi.spring.security.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.security.access.annotation.Secured;

import static com.mkpassi.spring.security.SecurityRoles.DEPARTMENTS_CREATE;
import static com.mkpassi.spring.security.SecurityRoles.ROLE_PREFIX;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Secured(ROLE_PREFIX + DEPARTMENTS_CREATE)
public @interface IsDepartmentsCreate {}
