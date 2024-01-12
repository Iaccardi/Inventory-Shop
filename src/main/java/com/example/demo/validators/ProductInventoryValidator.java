package com.example.demo.validators;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;



public class ProductInventoryValidator implements ConstraintValidator<ValidProductInventory, Part> {

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        if (part == null) {
            return true;
        }

        int partMinInv = part.getMinInv();
        int productInv;
        for (Product product : part.getProducts()) {
            productInv = product.getInv();
            if (productInv < partMinInv) {
                return false;
            }
        }

        return true;
    }
}
