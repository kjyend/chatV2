package server.command;

import server.Room;
import server.RoomManager;
import server.Session;
import server.SessionManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersCommand implements Command {

    private final RoomManager roomManager;
    private final SessionManager sessionManager;

    public UsersCommand(RoomManager roomManager, SessionManager sessionManager) {
        this.roomManager = roomManager;
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        List<Room> rooms = roomManager.getRooms();
        StringBuilder sb = new StringBuilder();
        List<String> usernames = new ArrayList<>();
        String roomName = "";
        for (Room room : rooms) {
            if (room.getName().equals(session.getRoomName())) {
                usernames = room.getAllUsers();
                roomName = room.getName();
            }
        }
        if (!usernames.isEmpty()) {
            sb.append(roomName).append("방 접속자 :").append(usernames.size()).append("\n");
            for (String username : usernames) {
                sb.append(" - ").append(username).append("\n");
            }
        } else {
            List<String> allUsernames = sessionManager.getAllUsername();
            sb.append("전체 접속자 :").append(allUsernames.size()).append("\n");
            for (String allUsername : allUsernames) {
                sb.append(" - ").append(allUsername).append("\n");
            }
        }
        session.send(sb.toString());
    }
}
