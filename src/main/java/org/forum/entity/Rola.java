package org.forum.entity;

public enum Rola {
    UNDEFINED("UNDEFINED"),
    USER("USER"),
    ADMIN("ADMIN");

    private String name;

    Rola(String name) {
        this.name = name;
    }
}
