package com.epam.jwd.tetrahedron.controller.command.impl;

import com.epam.jwd.tetrahedron.controller.command.Command;
import com.epam.jwd.tetrahedron.service.TetrahedronService;
import com.epam.jwd.tetrahedron.service.exception.ServiceException;
import com.epam.jwd.tetrahedron.service.factory.ServiceFactory;

public class CreateTetrahedron implements Command {
    @Override
    public String execute(String request) {
        System.out.println(request);
        TetrahedronService tetrahedronService = ServiceFactory.getTetrahedronService();
        String response;
        try {
            tetrahedronService.createTetrahedron();
            response = "Tetrahedron was created";
        } catch (ServiceException e) {
            response = "Incorrect data.";
        }
        return response;
    }
}
