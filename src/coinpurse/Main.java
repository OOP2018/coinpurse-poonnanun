package coinpurse;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author your name
 */
public class Main extends Application{

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
    	Purse purse = new Purse(10);
    	ConsoleDialog ui = new ConsoleDialog(purse);
    	ui.run();
    }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
