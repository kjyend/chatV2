package server.command;

import server.Room;
import server.RoomManager;
import server.Session;

import java.io.IOException;
import java.util.List;

public class LeaveCommand implements Command {

    private final RoomManager roomManager;

    public LeaveCommand(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        List<Room> rooms = roomManager.getRooms();
        for (Room room : rooms) {
            if (session.getRoomName().equals(room.getName())) {
                room.removeSession(session);
                room.sendRoomAll(session.getUsername() + "님이 방을 나갔습니다.");
            }
        }
    }
}
