package net.nalpari.crawling.model;

import lombok.*;

@Data
@Builder
public class Person {
    private String name;
    private String job;
    private int age;

    public Person() {}

    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
