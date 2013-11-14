package LoginClientModule;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Jan
 * Date: 12.11.13
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
public interface LoginServerConnectable {
    void sendWithParams(String methodName, Vector params);
}
