package server;

import server.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private static final String DELIMITER = "\\|";
    private final Map<String, Command> commands = new HashMap<>();
    private final Command defaultCommand = new DefaultCommand();

    public CommandManager(SessionManager sessionManager, RoomManager roomManager) {
        commands.put("/join", new JoinCommand(sessionManager));
        commands.put("/rooms", new RoomsCommand(roomManager));
        commands.put("/make", new MakeCommand(roomManager));
        commands.put("/enter", new EnterCommand(roomManager));
        commands.put("/message", new MessageCommand(roomManager));
        commands.put("/change", new ChangeCommand(roomManager));
        commands.put("/users", new UsersCommand(roomManager, sessionManager));
        commands.put("/leave", new LeaveCommand(roomManager));
        commands.put("/exit", new ExitCommand());
    }

    public void execute(String totalMessage, Session session) throws IOException {
        String[] args = totalMessage.split(DELIMITER);
        String key = args[0];

        Command command = commands.getOrDefault(key, defaultCommand);
        command.execute(args, session);
    }
}
