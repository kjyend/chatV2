package server;

import java.io.IOException;
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
        if (currentUsers + 1 > maxUsers) {
            throw new RuntimeException("최대 인원 수를 초과하여 입장할 수 없습니다.");
        }
        currentUsers++;
        sessions.add(session);
    }

    public synchronized void removeSession(Session session) {
        currentUsers--;
        sessions.remove(session);
        if (currentUsers == 0) {
            roomManager.removeRoom(this);
        }
    }

    public synchronized void sendRoomAll(String message) {
        for (Session session : sessions) {
            try {
                session.send(message);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public synchronized void setMaxUsers(int maxUsers) {
        if (currentUsers > maxUsers) {
            throw new IllegalArgumentException("현재 인원이 최대 인원보다 많습니다.");
        }
        this.maxUsers = maxUsers;
    }

    public synchronized List<String> getAllUsers() {
        List<String> usernames = new ArrayList<>();
        for (Session session : sessions) {
            if (session.getUsername() != null) {
                usernames.add(session.getUsername());
            }
        }
        return usernames;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized String getPassword() {
        return password;
    }
}
