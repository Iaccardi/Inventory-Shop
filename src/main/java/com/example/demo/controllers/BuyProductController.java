package com.example.demo.controllers;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.domain.Product;
import java.util.Optional;


@Controller
public class BuyProductController {

    private final ProductRepository productRepository;

    @Autowired
    public BuyProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") Long productId, Model model) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            int currentInventory = product.getInv();
            if (currentInventory > 0) {
                product.setInv(currentInventory - 1);
                productRepository.save(product);
                return "purchaseResult";
            } else {
                return "purchaseFailed";
            }
        } else {
            return "mainscreen";
        }
    }
}

