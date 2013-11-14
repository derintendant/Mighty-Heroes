package MultiplayerLobbyClientModule;

import CommonsModule.ServerConnectable;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Jan
 * Date: 13.11.13
 * Time: 12:25
 * To change this template use File | Settings | File Templates.
 */
public class MultiplayerLobbyController implements ServerConnectable {
    private static final MultiplayerCreateGameController createController;
    private static final MultiplayerLobbyView view;

    @Override
    public void sendWithParams(String methodName, Vector params) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
