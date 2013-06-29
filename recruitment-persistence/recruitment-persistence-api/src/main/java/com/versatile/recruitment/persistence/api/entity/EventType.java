package com.versatile.recruitment.persistence.api.entity;

public enum EventType {
    UNDEFINED('U');

    private char id;

    private EventType(Character id) {
        this.id = id;
    }

    public static EventType fromValue(char value) {
        for (EventType color : values()) {
            if (color.id == value) {
                return color;
            }
        }
        return UNDEFINED;
    }

    public char toValue() {
        return id;
    }
}
