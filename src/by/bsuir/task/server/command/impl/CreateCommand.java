package by.bsuir.task.server.command.impl;

import by.bsuir.task.server.command.Command;
import by.bsuir.task.server.command.exception.CommandException;
import by.bsuir.task.server.model.AuthType;
import by.bsuir.task.server.service.ServiceFactory;

public class CreateCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        var arguments = request.split(" ");
        if (arguments.length != 3) throw new CommandException("CREATE invalid syntax");

        if (ServiceFactory.getInstance().getAuthService().getAuthType(caller) != AuthType.manager)
            return "Should be manager";

        ServiceFactory.getInstance().getCaseService().addCase(arguments[1], arguments[2]);
        return "Success";
    }
}
