package server.command;

import server.Room;
import server.RoomManager;
import server.Session;

import java.io.IOException;
import java.util.Optional;

public class EnterCommand implements Command {

    private final RoomManager roomManager;

    public EnterCommand(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String roomName = args[1];

        Optional<Room> optionalRoom = roomManager.getRooms().stream().filter(r -> r.getName().equals(roomName))
                .findFirst();

        if (optionalRoom.isEmpty()) {
            session.send("같은 이름의 방이 없습니다: " + roomName);
            return;
        }

        Room room = optionalRoom.get();
        if (room.getPassword() != null) {
            if (args.length < 3) {
                session.send("비밀번호가 필요합니다.");
                return;
            }

            if (!room.getPassword().equals(args[2])) {
                session.send("비밀번호가 맞지 않습니다.");
                return;
            }
        }

        session.setRoomName(roomName);
        room.addSession(session);
        room.sendRoomAll(session.getUsername() + "님이 " + roomName + "방에 입장했습니다.");
    }
}
