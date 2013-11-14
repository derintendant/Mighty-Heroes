package OptionsSeverModule;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Jan
 * Date: 12.11.13
 * Time: 18:52
 * To change this template use File | Settings | File Templates.
 */
public interface OptionsServerAccessable {
    void changePassword(Vector params);

    void changeUsername(Vector params);

    void sendWithParams(String methodName, Vector params);
}
