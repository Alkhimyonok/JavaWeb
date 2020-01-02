package com.epam.jwd.parsing.sax;

import com.epam.jwd.parsing.bean.Candy;
import com.epam.jwd.parsing.builder.Builder;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class Sax {
    public static void main(String[] args) throws SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        CandySaxHandler handler = new CandySaxHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource("resources\\candies.xml"));
        List<Builder> builders = handler.getBuildList();
        for (Builder candy : builders) {
            System.out.println(candy.Build());
        }
    }
}