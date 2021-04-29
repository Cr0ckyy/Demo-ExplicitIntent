package com.myapplicationdev.android.c347_l2_ex1demoexplicitintent;

import java.io.Serializable;

/*
Serializability of a class is enabled by the class
implementing the java.io.Serializable interface.
Classes that do not implement this interface will not have
any of their state serialized or deserialized.
 All subtypes of a serializable class are themselves serializable.
 The serialization interface has no methods or fields
and serves only to identify the semantics of being serializable.
* */
public class Hero implements Serializable {
    private final String name;
    private final int strength;
    private final int technicalProwess;

    public Hero(String name, int strength,
                int technicalProwess) {
        this.name = name;
        this.strength = strength;
        this.technicalProwess = technicalProwess;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getTechnicalProwess() {
        return technicalProwess;
    }
}
