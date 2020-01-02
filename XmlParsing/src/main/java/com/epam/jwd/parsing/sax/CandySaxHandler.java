package com.epam.jwd.parsing.sax;


import com.epam.jwd.parsing.bean.*;
import com.epam.jwd.parsing.builder.Builder;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class CandySaxHandler extends DefaultHandler {
    private List<Builder> builderList;
    private StringBuilder text;
    private Builder builder;

    public CandySaxHandler() {
        builderList = new ArrayList<>();
        text = new StringBuilder();
        builder = new Builder();
    }

    public List<Builder> getBuildList() {
        return builderList;
    }

    public void startDocument() throws SAXException {
        System.out.println("Parsing started.");
    }

    public void endDocument() throws SAXException {
        System.out.println("Parsing ended.");
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text = new StringBuilder();
        if (qName.equals("candy")) {
            builder.setId(Integer.parseInt(attributes.getValue("id")));
        }

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        CandyTag tagName = CandyTag.valueOf(qName.toUpperCase());
        switch (tagName) {
            case NAME:
                builder.setName(text.toString());
                break;
            case ENERGY:
                builder.setEnergy(Integer.parseInt(text.toString()));
                break;
            case TYPECANDY:
                builder.setTypeCandy(TypeCandy.getTypeCandy(text.toString()));
                break;
            case NAMEINGREDIENT:
                builder.addIngredient(new Ingredient());
                int lastInd = builder.getIngredients().size() - 1;
                builder.getIngredients().get(lastInd).setNameIngredient(text.toString());
                break;
            case WEIGHT:
                lastInd = builder.getIngredients().size() - 1;
                builder.getIngredients().get(lastInd).setWeight(Integer.parseInt(text.toString()));
                break;
            case TYPECHOCOLATE:
                builder.setTypeChocolate(TypeChocolate.getTypeChocolate(text.toString()));
                break;
            case PROTEIN:
                builder.getValue().setProtein(Integer.parseInt(text.toString()));
                break;
            case FAT:
                builder.getValue().setFat(Integer.parseInt(text.toString()));
                break;
            case CARBOHYDRATE:
                builder.getValue().setCarbohydrate(Integer.parseInt(text.toString()));
                break;
            case PRODUCTION:
                builder.setProduction(text.toString());
                break;
            case CANDY:
                builderList.add(builder);
                builder = null;
                break;
        }
    }
}