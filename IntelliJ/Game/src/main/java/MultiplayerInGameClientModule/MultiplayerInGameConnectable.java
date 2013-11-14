package MultiplayerInGameClientModule;

import CommonsModule.ServerConnectable;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Jan
 * Date: 13.11.13
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public interface MultiplayerInGameConnectable extends ServerConnectable {
    void unitKilled(Vector params);

    void serverTerminated(Vector params);

    void unitSelectionResponse(Vector params);

    void startTurn(Vector params);

    void setEntityStats(Vector params);

    void setSkillStats(Vector params);

    void skillSelectionResponse(Vector params);
}
