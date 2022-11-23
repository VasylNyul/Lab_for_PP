package lpnu.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List> {
    @Override
    public boolean isValid(final List list, final ConstraintValidatorContext constraintValidatorContext) {
        return !list.isEmpty();
    }
}
