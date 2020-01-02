package com.epam.jwd.parsing.builder;

import com.epam.jwd.parsing.bean.*;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private int id;
    private String name;
    private int energy;
    private TypeCandy typeCandy;
    private List<Ingredient> ingredients;
    private TypeChocolate typeChocolate;
    private Value value;
    private String production;

    public Builder() {
        ingredients = new ArrayList<>();
        value = new Value();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setTypeCandy(TypeCandy typeCandy) {
        this.typeCandy = typeCandy;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void setTypeChocolate(TypeChocolate typeChocolate) {
        this.typeChocolate = typeChocolate;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public Candy Build() {
        return new Candy(id, name, energy, typeCandy, ingredients, typeChocolate, value, production);
    }
}
