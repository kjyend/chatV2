package server.command;

import server.RoomManager;
import server.Session;

import java.io.IOException;

public class ChangeCommand implements Command {

    private final RoomManager roomManager;

    public ChangeCommand(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String changeName = args[1];
        String message = session.getUsername() + "님이 " + changeName + "로 이름을 변경했습니다.";
        if (session.getRoomName() != null) {
            roomManager.sendRoomMessage(session.getRoomName(), message);
        } else {
            session.send(message);
        }
        session.setUsername(changeName);
    }
}
