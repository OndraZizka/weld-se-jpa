
//package de.laliluna.transactions;
package org.jboss.weld.environment.se.jpa;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * The @JpaTransactional is introduced because Java EE's @Transactional 
 * has more functionality than weld-se-jpa currently provides. Maybe later ;-)
 * 
 * The @InterceptorBinding tells Weld that this annotation can be used with an interceptor.
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface JpaTransactional {

}// class

