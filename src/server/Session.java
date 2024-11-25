package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static socket.SocketCloseUtil.closeAll;

public class Session implements Runnable {

    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;
    private final CommandManager commandManager;
    private final SessionManager sessionManager;

    private boolean closed = false;
    private String username;
    private String roomName;

    public Session(Socket socket, CommandManager commandManager, SessionManager sessionManager) throws IOException {
        this.socket = socket;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        this.commandManager = commandManager;
        this.sessionManager = sessionManager;
        this.sessionManager.add(this);
    }


    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF();

                commandManager.execute(received, this);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            sessionManager.remove(this);
            sessionManager.sendAll(username + "님이 퇴장했습니다.");
        }
    }

    public void send(String message) throws IOException {
        output.writeUTF(message);
    }

    public void close() {
        if (closed) {
            return;
        }
        closeAll(socket, input, output);
        closed = true;
        System.out.println("연결 종료: " + socket);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
