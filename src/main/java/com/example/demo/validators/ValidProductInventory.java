package com.example.demo.validators;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProductInventoryValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidProductInventory {
    String message() default "Product inventory cannot be lower than the part's minimum inventory";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}