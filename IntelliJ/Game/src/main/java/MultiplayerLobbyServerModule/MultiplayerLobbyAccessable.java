package MultiplayerLobbyServerModule;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Jan
 * Date: 13.11.13
 * Time: 12:48
 * To change this template use File | Settings | File Templates.
 */
public interface MultiplayerLobbyAccessable {
    void createGame(Vector params);

    void joinGame(Vector params);
}
