package com.codingblocks.onclicklisteners;

public class Apple implements Fruit {

    public Apple(Boolean isEdible, Boolean hasSeed) {
    }

    @Override
    public String getOrigin() {
        return "Test";
    }

    @Override
    public String getTaste() {
        return "Sweet";
    }

    @Override
    public String getPrice() {
        return "30 Rs";
    }

}
