package com.epam.jwd.tetrahedron.controller.command.impl;

import com.epam.jwd.tetrahedron.controller.command.Command;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) {
        return "Wrong request.";
    }
}
