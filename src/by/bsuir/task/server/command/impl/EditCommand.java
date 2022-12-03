package by.bsuir.task.server.command.impl;

import by.bsuir.task.server.command.Command;
import by.bsuir.task.server.command.exception.CommandException;
import by.bsuir.task.server.model.AuthType;
import by.bsuir.task.server.service.ServiceFactory;

public class EditCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        var arguments = request.split(" ");
        if (arguments.length != 4) throw new CommandException("Invalid syntax 'edit'");

        if (ServiceFactory.getInstance().getAuthService().getAuthType(caller) != AuthType.manager)
            return "Should be 'manager'";

        int id;
        try {
            id = Integer.parseInt(arguments[1]);
        } catch (NumberFormatException ignored) {
            return "Invalid id";
        }

        if (!ServiceFactory.getInstance().getCaseService().containsCase(id))
            return "No such case";

        ServiceFactory.getInstance().getCaseService().editCase(id, arguments[2], arguments[3]);
        return "Success";
    }
}
