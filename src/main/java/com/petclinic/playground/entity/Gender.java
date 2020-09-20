package com.petclinic.playground.entity;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    UNSPECIFIED("Unspecified");

    private final String name;

    private Gender(String name) {
        this.name = name;
    }

    /**
     * @return The string representation of this element in the enumeration.
     */
    public String getName() {
        return this.name;
    }
}
