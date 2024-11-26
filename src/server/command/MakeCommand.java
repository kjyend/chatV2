package server.command;

import server.Room;
import server.RoomManager;
import server.Session;

import java.io.IOException;
import java.util.List;

public class MakeCommand implements Command {

    private final RoomManager roomManager;

    public MakeCommand(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String roomName = args[1];

        List<Room> rooms = roomManager.getRooms();
        for (Room room : rooms) {
            if (room.getName().equals(roomName)) {
                session.send("같은 이름의 방이 있습니다.");
                return;
            }
        }

        if (args.length < 3) {
            new Room(roomName, null, roomManager);
        } else {
            new Room(roomName, args[2], roomManager);
        }
        session.send(roomName + "방을 만들었습니다.");
    }
}
