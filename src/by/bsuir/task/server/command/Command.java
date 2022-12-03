package by.bsuir.task.server.command;

import by.bsuir.task.server.command.exception.CommandException;

public interface Command {
    String execute(Object caller, String request) throws CommandException;
}
