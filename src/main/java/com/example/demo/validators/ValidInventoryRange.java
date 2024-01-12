package com.example.demo.validators;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InventoryRangeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInventoryRange {
    String message() default "Invalid inventory value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}