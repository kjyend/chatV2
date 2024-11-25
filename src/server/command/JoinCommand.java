package server.command;

import server.Session;
import server.SessionManager;

import java.io.IOException;

public class JoinCommand implements Command {

    private final SessionManager sessionManager;

    public JoinCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }


    @Override
    public void execute(String[] args, Session session) throws IOException {
        String username = args[1];
        session.setUsername(username);
        session.send(username + "님이 입장했습니다.");
    }
}
