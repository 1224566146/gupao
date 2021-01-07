package com.gupaoedu.mall.goods.bean;

import java.util.List;


public class Product {
    // Spu
    private Spu spu;
    // Sku
    private List<Sku> skus;

    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }
}
