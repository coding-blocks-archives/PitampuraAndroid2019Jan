package com.codingblocks.listviewcustomadapter;

public class Student {

    private String name, surname, batch;

    public Student(String name, String surname, String batch) {
        this.name = name;
        this.surname = surname;
        this.batch = batch;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBatch() {
        return batch;
    }
}
