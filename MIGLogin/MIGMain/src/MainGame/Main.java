package MainGame;

import GameController.GameController;
import MIG.ka.bprocess.LoginScreenController.LoginScreenController;

/**
 * test
 * @author Dennis
 */
public class Main {

    public static void main(String[] args){
	GameController game = new GameController();
	LoginScreenController login = new LoginScreenController();
	login.setPauseOnLostFocus(false);
	login.start();
    }

}
