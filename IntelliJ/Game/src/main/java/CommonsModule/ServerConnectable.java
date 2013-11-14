package CommonsModule;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Jan
 * Date: 12.11.13
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */
public interface ServerConnectable {
    void sendWithParams(String methodName, Vector params);
}
