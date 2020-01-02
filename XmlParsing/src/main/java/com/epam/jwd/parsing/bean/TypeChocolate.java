package com.epam.jwd.parsing.bean;

public enum TypeChocolate {
    MILK, WHITE, DARK;

    public static TypeChocolate getTypeChocolate(String str) {
        switch (str) {
            case "MILK":
                return MILK;
            case "DARK":
                return DARK;
            case "WHITE":
                return WHITE;
            default:
                return null;
        }
    }
}
