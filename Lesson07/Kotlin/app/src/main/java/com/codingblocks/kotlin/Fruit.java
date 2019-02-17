package com.codingblocks.kotlin;

public class Fruit {

    String taste, price;

    public Fruit(String taste, String price) {
        this.taste = taste;
        this.price = price;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
