package com.epam.jwd.parsing.bean;

public class Ingredient {
    private String nameIngredient;
    private int weight;

    public Ingredient() {
    }

    public Ingredient(String nameIngredient, int weight) {
        this.nameIngredient = nameIngredient;
        this.weight = weight;
    }

    public String getNameIngredient() {
        return nameIngredient;
    }

    public void setNameIngredient(String nameIngredient) {
        this.nameIngredient = nameIngredient;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "nameIngredient='" + nameIngredient + '\'' +
                ", weight=" + weight +
                '}';
    }
}
