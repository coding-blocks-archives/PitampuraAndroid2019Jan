package com.codingblocks.kotlin;

public class Mango extends Fruit {

    private String origin;

    public Mango(String taste, String price, String origin) {
        super(taste, price);
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
