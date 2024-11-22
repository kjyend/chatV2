package server;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {

    private ArrayList<Room> rooms = new ArrayList<>();

    public synchronized void addRoom(Room room) {
        rooms.add(room);
    }

    public synchronized void removeRoom(Room room) {
        rooms.remove(room);
    }

    public synchronized List<Room> getRooms() {
        List<Room> roomList = new ArrayList<>();
        for (Room room : rooms) {
            if (room != null) {
                roomList.add(room);
            }
        }
        return roomList;
    }
}
