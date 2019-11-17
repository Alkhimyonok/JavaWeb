package com.epam.jwd.tetrahedron.view;

import com.epam.jwd.tetrahedron.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        String response = controller.execute("CREATE_TETRAHEDRON");
        System.out.println(response);
    }
}
