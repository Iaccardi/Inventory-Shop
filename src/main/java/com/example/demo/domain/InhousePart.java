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
@DiscriminatorValue("1")
public class InhousePart extends Part{
    int partId;

    public InhousePart() {
    }

    public InhousePart(String name, int price, int inv, int minInv, int maxInv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minInv = minInv;
        this.maxInv = maxInv;
    }
    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
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
