package LoginClientModule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Jan
 * Date: 12.11.13
 * Time: 16:21
 * To change this template use File | Settings | File Templates.
 */
public class LoginController implements CommonsModule.ServerConnectable, ActionListener, LoginServerConnectable {
    private static final LoginView view = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void sendWithParams(String methodName, Vector params) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
