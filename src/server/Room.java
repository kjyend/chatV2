package server;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private final String name;
    private final String password;
    private final RoomManager roomManager;
    private int currentUsers;
    private int maxUsers;
    private List<Session> sessions = new ArrayList<>();

    public Room(String name, String password, RoomManager roomManager) {
        this.name = name;
        this.password = password;
        this.roomManager = roomManager;
        this.currentUsers = 0;
        this.maxUsers = 100;
        roomManager.addRoom(this);
    }

    public synchronized void addSession(Session session) {
        sessions.add(session);
    }

    public synchronized void removeSession(Session session) {
        sessions.remove(session);
    }
}
