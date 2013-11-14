package MultiplayerInGameClientModule;

import MultiplayerInGameServerModule.MultiplayerInGameModel;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Jan
 * Date: 13.11.13
 * Time: 13:21
 * To change this template use File | Settings | File Templates.
 */
public class MultiplayerInGameController implements MultiplayerInGameConnectable {
    private static final MultiplayerInGameMenuOverlayController overlayController;
    private static final MultiplayerInGameView view;

    @Override
    public void sendWithParams(String methodName, Vector params) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void unitKilled(Vector params) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void serverTerminated(Vector params) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void unitSelectionResponse(Vector params) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void startTurn(Vector params) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setEntityStats(Vector params) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setSkillStats(Vector params) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void skillSelectionResponse(Vector params) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
