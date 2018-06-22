package ninja.oscaz.common.spigot.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ninja.oscaz.hero.transform.intercept.Intercept;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Intercept
public @interface MustBeOp {

}
