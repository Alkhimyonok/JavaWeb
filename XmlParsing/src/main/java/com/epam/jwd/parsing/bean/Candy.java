package com.epam.jwd.parsing.bean;

import java.util.ArrayList;
import java.util.List;

public class Candy {
    private int id;
    private String name;
    private int energy;
    private TypeCandy typeCandy;
    private List<Ingredient> ingredients;
    private TypeChocolate typeChocolate;
    private Value value;
    private String production;

    public Candy(int id, String name, int energy, TypeCandy typeCandy,
                 List<Ingredient> ingredients, TypeChocolate typeChocolate, Value value, String production) {
        this.id = id;
        this.name = name;
        this.energy = energy;
        this.typeCandy = typeCandy;
        this.ingredients = ingredients;
        this.typeChocolate = typeChocolate;
        this.value = value;
        this.production = production;
    }

    public Candy() {
        ingredients = new ArrayList<>();
        value = new Value();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public TypeCandy getTypeCandy() {
        return typeCandy;
    }

    public void setTypeCandy(TypeCandy typeCandy) {
        this.typeCandy = typeCandy;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public TypeChocolate getTypeChocolate() {
        return typeChocolate;
    }

    public void setTypeChocolate(TypeChocolate typeChocolate) {
        this.typeChocolate = typeChocolate;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", type=" + typeCandy +
                ", ingredients=" + ingredients +
                ", value=" + value +
                ", production='" + production + '\'' +
                '}';
    }
}
