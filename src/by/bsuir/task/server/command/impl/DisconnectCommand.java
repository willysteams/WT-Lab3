package by.bsuir.task.server.command.impl;

import by.bsuir.task.server.command.Command;
import by.bsuir.task.server.command.exception.CommandException;
import by.bsuir.task.server.model.AuthType;
import by.bsuir.task.server.service.ServiceFactory;

public class DisconnectCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        ServiceFactory.getInstance().getAuthService().setAuthType(caller, AuthType.unauth);
        return "Disconnected";
    }
}
