package server.command;

import server.Room;
import server.RoomManager;
import server.Session;

import java.io.IOException;

public class MakeCommand implements Command {

    private final RoomManager roomManager;

    public MakeCommand(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String roomName = args[1];
        String password = args[2];

        roomManager.getRooms().stream()
                .filter(r -> r.getName().equals(roomName))
                .findFirst()
                .ifPresent(r -> {
                    throw new IllegalArgumentException("같은 이름의 방이 있습니다.");
                });
        
        if (password.isEmpty()) {
            new Room(roomName, null, roomManager);
        } else {
            new Room(roomName, password, roomManager);
        }

    }
}
