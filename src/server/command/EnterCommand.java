package server.command;

import server.Room;
import server.RoomManager;
import server.Session;

import java.io.IOException;

public class EnterCommand implements Command {

    private final RoomManager roomManager;

    public EnterCommand(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String message = args[1];

        Room room = roomManager.getRooms().stream().filter(r -> r.getName().equals(message))
                .findFirst().orElseThrow(() -> new IOException("같은 이름의 방이 없습니다: " + message));

        if (!room.getPassword().isEmpty()) {
            if (room.getPassword().equals(args[2])) {
                throw new IllegalArgumentException("비밀번호가 맞지 않습니다.");
            }
        }

        room.addSession(session);

        room.sendRoomAll(session.getUsername() + "님이 입장했습니다.");
    }
}
