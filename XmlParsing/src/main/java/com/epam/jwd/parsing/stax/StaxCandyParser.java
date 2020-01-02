package com.epam.jwd.parsing.stax;


import com.epam.jwd.parsing.bean.*;
import com.epam.jwd.parsing.builder.Builder;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StaxCandyParser {

    public static void main(String[] args) throws FileNotFoundException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            InputStream input = new FileInputStream("resources\\candies.xml");
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            List<Builder> builderList = process(reader);
            for (Builder builder : builderList) {
                System.out.println(builder.Build().toString());
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static List<Builder> process(XMLStreamReader reader) throws XMLStreamException {
        List<Builder> builderList = new ArrayList<>();
        Builder builder = null;
        CandyTag elementName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = CandyTag.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case CANDY:
                            builder = new Builder();
                            Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                            builder.setId(id);
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case NAME:
                            builder.setName(text);
                            break;
                        case ENERGY:
                            builder.setEnergy(Integer.parseInt(text));
                            break;
                        case TYPECANDY:
                            builder.setTypeCandy(TypeCandy.getTypeCandy(text));
                            break;
                        case NAMEINGREDIENT:
                            builder.getIngredients().add(new Ingredient());
                            int lastInd = builder.getIngredients().size() - 1;
                            builder.getIngredients().get(lastInd).setNameIngredient(text);
                            break;
                        case WEIGHT:
                            lastInd = builder.getIngredients().size() - 1;
                            builder.getIngredients().get(lastInd).setWeight(Integer.parseInt(text));
                            break;
                        case TYPECHOCOLATE:
                            builder.setTypeChocolate(TypeChocolate.getTypeChocolate(text));
                            break;
                        case PROTEIN:
                            builder.getValue().setProtein(Integer.parseInt(text));
                            break;
                        case FAT:
                            builder.getValue().setFat(Integer.parseInt(text));
                            break;
                        case CARBOHYDRATE:
                            builder.getValue().setCarbohydrate(Integer.parseInt(text));
                            break;
                        case PRODUCTION:
                            builder.setProduction(text);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = CandyTag.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case CANDY:
                            builderList.add(builder);
                    }
            }
        }
        return builderList;
    }
}
