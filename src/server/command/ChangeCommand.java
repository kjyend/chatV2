package server.command;

import server.Room;
import server.RoomManager;
import server.Session;

import java.io.IOException;
import java.util.List;

public class ChangeCommand implements Command {

    private final RoomManager roomManager;

    public ChangeCommand(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String changeName = args[1];

        if (session.getRoomName() != null) {
            List<Room> rooms = roomManager.getRooms();
            for (Room room : rooms) {
                if (room.getName().equals(session.getRoomName())) {
                    room.sendRoomAll(session.getUsername() + "님이 " + changeName + "로 이름을 변경했습니다.");
                }
            }
        } else {
            session.send(session.getUsername() + "님이 " + changeName + "로 이름을 변경했습니다.");
        }
        session.setUsername(changeName);
    }
}
