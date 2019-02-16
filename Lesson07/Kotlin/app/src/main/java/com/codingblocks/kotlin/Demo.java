package com.codingblocks.kotlin;

public class Demo {

    public static void main(String[] args) {

        Note note = new Note("ssd", "dfjds", "sfge");

        Note defaultNote = new Note();

        Notes noteWithTimeeAndDesc = new Notes("sdhjds", "dsfds");

    }

    public Boolean test(int num) {

        boolean isEven;

        if (num % 2 == 0) {
            isEven = true;
        } else
            isEven = false;

        return isEven;

    }


}
