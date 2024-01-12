package com.example.demo.validators;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.example.demo.domain.Part;



public class InventoryRangeValidator implements ConstraintValidator<ValidInventoryRange, Part> {

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        int inventory = part.getInv();
        int minInv = part.getMinInv();
        int maxInv = part.getMaxInv();
        return inventory >= minInv && inventory <= maxInv;
    }
}