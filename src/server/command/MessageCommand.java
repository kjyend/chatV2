package server.command;

import server.Room;
import server.RoomManager;
import server.Session;

import java.io.IOException;
import java.util.List;

public class MessageCommand implements Command {

    private final RoomManager roomManager;

    public MessageCommand(RoomManager roomManager) {
        this.roomManager = roomManager;
    }


    @Override
    public void execute(String[] args, Session session) throws IOException {
        String message = args[1];
        List<Room> rooms = roomManager.getRooms();
        for (Room room : rooms) {
            if (session.getRoomName().equals(room.getName())) {
                room.sendRoomAll("[" + session.getUsername() + "] " + message);
            }
        }
    }
}
