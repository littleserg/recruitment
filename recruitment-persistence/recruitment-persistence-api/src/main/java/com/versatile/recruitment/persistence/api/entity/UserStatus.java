package com.versatile.recruitment.persistence.api.entity;


public enum UserStatus {
    ACTIVE('A'),
    LOCKED('L'),
    INACTIVE('I');

    private char id;

    private UserStatus(Character id) {
        this.id = id;
    }

    public static UserStatus fromValue(char value) {
        for (UserStatus color : values()) {
            if (color.id == value) {
                return color;
            }
        }
        return INACTIVE;
    }

    public char toValue() {
        return id;
    }
}
