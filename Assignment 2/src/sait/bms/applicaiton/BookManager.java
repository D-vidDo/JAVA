package sait.bms.applicaiton;

import java.io.FileNotFoundException;

import sait.bms.managers.Manager;

/**
 * @author 605712, 714163
 *
 */
public class BookManager {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Manager man = new Manager();
		
		man.menu();
	}

}
