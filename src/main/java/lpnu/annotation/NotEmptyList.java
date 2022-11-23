package lpnu.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NotEmptyListValidator.class)
public @interface NotEmptyList {
    public String message() default "The list can't be empty";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
