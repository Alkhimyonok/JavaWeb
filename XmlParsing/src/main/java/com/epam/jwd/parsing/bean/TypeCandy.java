package com.epam.jwd.parsing.bean;

public enum TypeCandy {
    CARAMEL, IRIS, CHOCOLATE;
    public static TypeCandy getTypeCandy(String str) {
        switch (str) {
            case "CARAMEL":
                return CARAMEL;
            case "IRIS":
                return IRIS;
            case "CHOCOLATE":
                return CHOCOLATE;
            default:
                return null;
        }
    }
}
