package server;

import java.io.IOException;

public class ServerMain {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();
        RoomManager roomManager = new RoomManager();

        CommandManager commandManager = new CommandManager(sessionManager, roomManager);

        Server server = new Server(PORT, commandManager, sessionManager);
        server.start();
    }
}
