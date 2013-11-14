package LoginServerModule;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Jan
 * Date: 12.11.13
 * Time: 17:06
 * To change this template use File | Settings | File Templates.
 */
public interface LoginServerAccessable {
    void login(Vector params);

    void sendWithParams(String methodName, Vector params);
}
