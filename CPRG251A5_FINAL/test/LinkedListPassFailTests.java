import static org.junit.jupiter.api.Assertions.*;

import java.io.NotSerializableException;

import org.junit.jupiter.api.*;


import contracts.*;
import managers.SLL;

/**
 * @author ElMenshawy
 * @version 14-03-2020
 *
 */
public class LinkedListPassFailTests {
	/**
	 * References the linked list that is manipulated in each test.
	 */
	private LinkedListADT linkedList;

	@BeforeEach
	void init() {
		try {
			// Create object from your implemented linked list here.
			linkedList = new SLL();
		} catch (NotSerializableException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Test the linked list is empty.
	 */
	@Test // test-to-pass
	void testIsEmpty() {
		assertTrue(linkedList.isEmpty());
		assertEquals(0, linkedList.size());
	}

	/**
	 * Tests appending elements to the linked list.
	 */
	@Test // test-to-pass
	void testAppendNode() {
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */

		// Test the linked list is not empty.
		assertFalse(linkedList.isEmpty());

		// Test the size is 4
		assertEquals(4, linkedList.size());

		// Test the first node value is a
		assertEquals("a", linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", linkedList.retrieve(1));

		// Test the third node value is c
		assertEquals("c", linkedList.retrieve(2));

		// Test the fourth node value is d
		assertEquals("d", linkedList.retrieve(3));
	}

	/**
	 * Tests prepending nodes to linked list.
	 */
	@Test // test-to-pass
	void testPrependNodes() {
		linkedList.prepend("a");
		linkedList.prepend("b");
		linkedList.prepend("c");
		linkedList.prepend("d");

		/**
		 * Linked list should now be:
		 * 
		 * d -> c -> b -> a
		 */

		// Test the linked list is not empty.
		assertFalse(linkedList.isEmpty());

		// Test the size is 4
		assertEquals(4, linkedList.size());

		// Test the first node value is d
		assertEquals("d", linkedList.retrieve(0));

		// Test the second node value is c
		assertEquals("c", linkedList.retrieve(1));

		// Test the third node value is b
		assertEquals("b", linkedList.retrieve(2));

		// Test the fourth node value is a
		assertEquals("a", linkedList.retrieve(3));
	}

	/**
	 * Tests inserting node at valid index.
	 */
	@Test // test-to-pass
	void testInsertNode() {
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		try {
			linkedList.insert("e", 2);
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> e -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(linkedList.isEmpty());

			// Test the size is 5
			assertEquals(5, linkedList.size());

			// Test the first node value is a
			assertEquals("a", linkedList.retrieve(0));

			// Test the second node value is b
			assertEquals("b", linkedList.retrieve(1));

			// Test the third node value is e
			assertEquals("e", linkedList.retrieve(2));

			// Test the fourth node value is c
			assertEquals("c", linkedList.retrieve(3));

			// Test the fifth node value is d
			assertEquals("d", linkedList.retrieve(4));
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Tests replacing existing nodes data.
	 */
	@Test // test-to-pass
	void testReplaceNode() {
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		try {
			linkedList.replace("e", 2);

			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> e -> d
			 */

			// Test the linked list is not empty.
			assertFalse(linkedList.isEmpty());

			// Test the size is 4
			assertEquals(4, linkedList.size());

			// Test the first node value is a
			assertEquals("a", linkedList.retrieve(0));

			// Test the second node value is b
			assertEquals("b", linkedList.retrieve(1));

			// Test the third node value is e
			assertEquals("e", linkedList.retrieve(2));

			// Test the fourth node value is d
			assertEquals("d", linkedList.retrieve(3));
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Tests deleting node from linked list.
	 */
	@Test // test-to-pass
	void testDeleteNode() {
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		try {
			linkedList.delete(2);

			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> d
			 */

			// Test the linked list is not empty.
			assertFalse(linkedList.isEmpty());

			// Test the size is 3
			assertEquals(3, linkedList.size());

			// Test the first node value is a
			assertEquals("a", linkedList.retrieve(0));

			// Test the second node value is b
			assertEquals("b", linkedList.retrieve(1));

			// Test the third node value is d
			assertEquals("d", linkedList.retrieve(2));
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Tests finding and retrieving node in linked list.
	 */
	@Test // test-to-pass
	void testFindNode() {
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		try {
			boolean contains = linkedList.contains("b");
			assertTrue(contains);

			int index = linkedList.indexOf("b");
			assertEquals(1, index);

			String value = (String) linkedList.retrieve(1);
			assertEquals("b", value);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Test to clear the linked list
	 */
	@Test // test-to-pass
	void testClear() {
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		linkedList.clear();

		// test to see if linked list is empty
		assertTrue(linkedList.isEmpty());
	}

	/**
	 * Test to determine linked list size
	 */
	@Test // test-to-pass
	void testSize() {
		linkedList.append("a");
		linkedList.prepend("b");
		linkedList.insert("c", 2);
		linkedList.append("d");

		// test to see if linked list size matches the expected
		assertEquals(4, linkedList.size());
	}

	// --------------------------- TEST TO FAIL BELOW --------------------------------//

	
	/**
	 * Test if the linked list is null.
	 */
	@Test // test-to-fail
	void testIsNull() {
		assertNull(linkedList.size(),"Error linkedList size is Null");
	}

	/**
	 * Tests finding and retrieving node that is out of bounds in linked list.
	 */
	@Test // test-to-fail
	void testOutOfBoundsFindNode() {
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		assertThrows(IndexOutOfBoundsException.class, () -> {
			linkedList.indexOf(7);
		},"Error, Attempting to find a node out of bounds");
	}

	/**
	 * Tests inserting a node to an index that is out of bounds
	 */
	@Test // test-to-fail
	void testOutOfBoundsAddNode(){
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		assertThrows(IndexOutOfBoundsException.class, () -> {
			linkedList.insert("f", 7);
		},"Error, Attempting to insert out of bounds");
	}
	/**
	 * Tests removing a node that is out of bounds
	 */
	@Test //test-to-fail
	void testOutOfBoundsRemoveNode(){
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		assertThrows(IndexOutOfBoundsException.class, () -> {
			linkedList.delete(7);
		},"Error, Attempting to delete out of bounds");
	}

	/**
	 * Tests replacing a node that is out of bounds
	 */
	@Test //test-to-fail
	void testOutOfBoundsReplaceNode(){
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		assertThrows(IndexOutOfBoundsException.class, () -> {
			linkedList.replace("f", 7);
		},"Error, Attempting to replace out of bounds");
	}
	
	/**
	 * Tests clearing a null linked list
	 */
	@Test //test-to-fail
	void testNullClear(){
		assertThrows(NullPointerException.class,() -> {
			linkedList.clear();
		},"Error, Trying to clear a NULL linkedList");
	}

	/**
	 * Tests if the head of the linked list is used as the next value
	 */
	@Test //test-to-fail
	void testNodeLoop(){
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");
		linkedList.append(linkedList.retrieve(0));

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d -> a
		 */

		Boolean looping = false;
		for(int i = 1; i < linkedList.size(); i++ ){
			if(linkedList.retrieve(i).equals(linkedList.retrieve(0)))
				looping = true;
		}

		assertFalse(looping, "Error, head of the linkedList is used as a tail");
	}

	@AfterEach
	void tearDown() {
		linkedList.clear();
	}
}