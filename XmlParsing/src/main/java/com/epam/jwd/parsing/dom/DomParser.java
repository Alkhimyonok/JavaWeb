package com.epam.jwd.parsing.dom;

import com.epam.jwd.parsing.bean.*;
import com.epam.jwd.parsing.builder.Builder;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser {
    private List<Builder> builderList;

    public DomParser() {
        builderList = new ArrayList<>();
    }

    public List<Builder> parse() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder_ = factory.newDocumentBuilder();
            Document document = builder_.parse("resources\\candies.xml");
            document.getDocumentElement().normalize();
            NodeList candyList = document.getDocumentElement().getElementsByTagName("candy");
            for (int i = 0; i < candyList.getLength(); i++) {
                Builder builder = new Builder();
                Element element = (Element) candyList.item(i);
                builder.setId(Integer.parseInt(element.getAttribute("id")));
                builder.setName(getElement(element, "name").getTextContent().trim());
                builder.setEnergy(Integer.parseInt(getElement(element, "energy").getTextContent().trim()));
                builder.setTypeCandy(TypeCandy.getTypeCandy(getElement(element, "typeCandy").getTextContent().trim()));
                builder.addIngredient(new Ingredient(getElement(element, "nameIngredient").getTextContent().trim(),
                        Integer.parseInt(getElement(element, "weight").getTextContent().trim())));
                builder.setTypeChocolate(TypeChocolate.getTypeChocolate(getElement(element, "typeChocolate").getTextContent().trim()));
                builder.setValue(new Value(Integer.parseInt(getElement(element, "protein").getTextContent().trim()),
                        Integer.parseInt(getElement(element, "fat").getTextContent().trim()),
                        Integer.parseInt(getElement(element, "carbohydrate").getTextContent().trim())));
                builder.setProduction(getElement(element, "production").getTextContent().trim());
                this.builderList.add(builder);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return builderList;
    }

    private static Element getElement(Element element, String name) {
        NodeList nodeList = element.getElementsByTagName(name);
        Element firstElement = (Element) nodeList.item(0);
        return firstElement;
    }
}