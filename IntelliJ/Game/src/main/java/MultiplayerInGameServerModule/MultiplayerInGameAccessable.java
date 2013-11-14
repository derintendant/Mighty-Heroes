package MultiplayerInGameServerModule;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Jan
 * Date: 13.11.13
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
public interface MultiplayerInGameAccessable {
    void exit(Vector params);

    void entitySelected(Vector params);

    void sendWithParams(String methodName, Vector params);

    void endTurn(Vector params);

    void moveEntity(Vector params);

    void attackMove(Vector params);

    void useSkill(Vector params);

    void getEntityStats(Vector params);

    void getSkillStats(Vector params);
}
