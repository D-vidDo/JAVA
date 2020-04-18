import java.io.*;
import java.io.NotSerializableException;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import contracts.LinkedListADT;
import managers.SLL;
import problemdomain.*;

public class SerializationPassTests {
	/**
	 * References the linked list that is manipulated in each test.
	 */
	private LinkedListADT linkedList;

	@BeforeEach
	void init() {
		try {
			linkedList = new SLL();
			linkedList.append(new User(1, "Joe Blow", "jblow@gmail.com", "password"));
			linkedList.append(new User(2, "Joe Schmoe", "joe.schmoe@outlook.com", "abcdef"));
			linkedList.append(new User(3, "Colonel Sanders", "chickenlover1890@gmail.com", "kfc5555"));
			linkedList.append(new User(4, "Ronald McDonald", "burgers4life63@outlook.com", "mcdonalds999"));
		} catch (NotSerializableException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Serialize method
	 * 
	 * @param obj
	 * @param fileName
	 * @throws IOException
	 */
	public static void serialize(Object obj, String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);

		fos.close();
	}

	/**
	 * de-serialize method
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	@Test
	public void serializeTest() throws NotSerializableException {
		String filename = "serial.bin";
		try {
			serialize(linkedList, filename);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

	@Test
	public void deserializeTest() {
		String fileName = "serial.bin";
		User test = null;

		try {
			test = (User) deserialize(fileName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	@AfterEach
	void tearDown() {
		linkedList.clear();
	}

}

