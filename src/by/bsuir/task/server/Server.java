package by.bsuir.task.server;

import by.bsuir.task.server.controller.ServerController;

public class Server {
    public static void main(String[] args) {
        var server = new ServerController();
        server.start();
    }
}
