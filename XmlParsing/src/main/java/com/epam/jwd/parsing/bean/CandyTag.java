package com.epam.jwd.parsing.bean;

public enum CandyTag {
    NAME, ENERGY, TYPECANDY, INGREDIENT, VALUE, PRODUCTION, CANDY, CANDIES, WEIGHT, TYPECHOCOLATE,
    PROTEIN, FAT, CARBOHYDRATE, NAMEINGREDIENT;

    public static CandyTag getElementTagName(String localName) {
        switch (localName) {
            case "candy":
                return CANDY;
            case "name":
                return NAME;
            case "energy":
                return ENERGY;
            case "ingredient":
                return INGREDIENT;
            case "typeChocolate":
                return TYPECHOCOLATE;
            case "value":
                return VALUE;
            case "production":
                return PRODUCTION;
            case "candies":
                return CANDIES;
            case "nameIngredient":
                return NAMEINGREDIENT;
            case "weight":
                return WEIGHT;
            case "protein":
                return PROTEIN;
            case "typeCandy":
                return TYPECANDY;
            case "fat":
                return FAT;
            case "carbohydrate":
                return CARBOHYDRATE;
            default:
                throw new EnumConstantNotPresentException(CandyTag.class, localName);

        }
    }
}
