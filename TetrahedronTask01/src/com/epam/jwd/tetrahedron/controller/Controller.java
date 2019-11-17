package com.epam.jwd.tetrahedron.controller;

import com.epam.jwd.tetrahedron.controller.command.Command;

public class Controller {
    private final CommandProvider commandProvider = new CommandProvider();

    public String execute(String request) {
        Command executionCommand = commandProvider.getCommand(request);
        return executionCommand.execute(request);
    }
}
