package com.epam.jwd.tetrahedron.controller;

import com.epam.jwd.tetrahedron.controller.command.Command;
import com.epam.jwd.tetrahedron.controller.command.impl.CreateTetrahedron;
import com.epam.jwd.tetrahedron.controller.command.impl.WrongRequest;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.CREATE_TETRAHEDRON, new CreateTetrahedron());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
