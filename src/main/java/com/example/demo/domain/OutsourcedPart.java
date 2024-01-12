package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("2")
public class OutsourcedPart extends Part{
String companyName;

    public OutsourcedPart() {

    }

    public OutsourcedPart(String name, int price, int inv, int minInv, int maxInv, String companyName) {
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minInv = minInv;
        this.maxInv = maxInv;
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getMinInv() {
        return minInv;
    }

    public void setMinInv(Integer minInv) {
        this.minInv = minInv;
    }

    public Integer getMaxInv() {
        return maxInv;
    }

    public void setMaxInv(Integer maxInv) {
        this.maxInv = maxInv;
    }
}
