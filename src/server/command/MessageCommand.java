package server.command;

import server.RoomManager;
import server.Session;

import java.io.IOException;

public class MessageCommand implements Command {

    private final RoomManager roomManager;

    public MessageCommand(RoomManager roomManager) {
        this.roomManager = roomManager;
    }


    @Override
    public void execute(String[] args, Session session) throws IOException {
        String message = "[" + session.getUsername() + "] " + args[1];
        roomManager.sendRoomMessage(session.getRoomName(), message);
    }
}
