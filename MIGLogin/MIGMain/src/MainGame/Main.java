package MainGame;

import MIG.ka.bprocess.LoginScreenController.LoginScreenController;
import com.jme3.app.SimpleApplication;

/**
 * test
 * @author Dennis
 */
public class Main extends SimpleApplication {

   
    public static void main(String[] args){
    LoginScreenController app = new LoginScreenController();
    app.setPauseOnLostFocus(false);
    app.start();
    }

    @Override
    public void simpleInitApp() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
