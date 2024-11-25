package server.command;

import server.Room;
import server.RoomManager;
import server.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersCommand implements Command {

    private final RoomManager roomManager;

    public UsersCommand(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        List<Room> rooms = roomManager.getRooms();
        StringBuilder sb = new StringBuilder();
        List<String> usernames = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getName().equals(session.getRoomName())) {
                usernames = room.getAllUsers();
            }
        }
        sb.append("전체 접속자 :").append(usernames.size()).append("\n");
        for (String username : usernames) {
            sb.append(" - ").append(username).append("\n");
        }
        session.send(sb.toString());
    }
}
