package server;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private final String name;
    private final String password;
    private final RoomManager roomManager;
    private List<Session> sessions = new ArrayList<>();

    public Room(String name, String password, RoomManager roomManager) {
        this.name = name;
        this.password = password;
        this.roomManager = roomManager;
        roomManager.addRoom(this);
    }

    public synchronized void addSession(Session session) {
        sessions.add(session);
    }

    public synchronized void removeSession(Session session) {
        sessions.remove(session);
    }
}
