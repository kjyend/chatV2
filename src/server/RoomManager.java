package server;

import java.util.ArrayList;

public class RoomManager {

    private final ArrayList<Room> rooms = new ArrayList<>();

    public synchronized void addRoom(Room room) {
        rooms.add(room);
    }

    public synchronized void removeRoom(Room room) {
        rooms.remove(room);
    }
}
