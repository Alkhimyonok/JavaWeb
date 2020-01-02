package com.epam.jwd.parsing.dom;

import com.epam.jwd.parsing.bean.Candy;
import com.epam.jwd.parsing.builder.Builder;

public class Dom {
    public static void main(String[] args) {
        DomParser parser = new DomParser();
        for (Builder builder : parser.parse())
            System.out.println(builder.Build());
    }
}