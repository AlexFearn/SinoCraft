package sinocraft.core.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* 
 * 定义注解 SCConfigAnnotation 
 * 运行级别定为 运行时,可以反射
 */ 
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
// @Inherited
public @interface SCBlockAnnotation {
	int DefaultID();
	String Name();
	String Material() default ""; 
}