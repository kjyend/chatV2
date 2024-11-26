package server.command;

import server.Room;
import server.RoomManager;
import server.Session;

import java.io.IOException;
import java.util.List;

public class RoomsCommand implements Command {

    private final RoomManager roomManager;

    public RoomsCommand(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        List<Room> rooms = roomManager.getRooms();
        StringBuilder sb = new StringBuilder();
        sb.append("전체 방 갯수 : ").append(rooms.size()).append("\n");
        for (Room room : rooms) {
            sb.append(" - ").append(room.getName()).append("\n");
        }
        session.send(sb.toString());
    }
}
