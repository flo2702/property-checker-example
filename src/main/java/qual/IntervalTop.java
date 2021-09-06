package qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.DefaultQualifierInHierarchy;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE})
@DefaultQualifierInHierarchy
public @interface IntervalTop {}
