package com.spring_training.domain;

public class Member {
    private long id;
    private String name;

    // Member(long id, String name) {
    //     this.id = id;
    //     this.name = name;
    // }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
