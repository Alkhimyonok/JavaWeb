package com.epam.jwd.tetrahedron.view;

import com.epam.jwd.tetrahedron.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        Controller controller = new Controller();
        String response = controller.execute("CREATE_TETRAHEDRON");
        logger.error(response);
    }
}
