package problemdomain;

import java.io.*;

/**
 * Represents a Node in a linked list.
 * @author ElMenshawy
 * @version 14-03-2020
 *
 */
public class Node 
{
	private Object data;
	
	private Node next;
	
	/**
	 * Creates a new node.
	 * @param Object data Data in a node.
	 */
	public Node(Object data) 
	{
		this.data = data;
	}
	
	/**
	 * Gets the data in the node.
	 * @return Object data
	 */
	public Object getData() 
	{
		return data;
	}
	
	/**
	 * Sets the data in the node.
	 * @param Oject data New data to set.
	 */
	public void setData(Object data) 
	{
		this.data = data;
	}
	
	/**
	 * Gets the next node or null (if there is no next node).
	 * @return Next node.
	 */
	public Node getNext() 
	{
		return next;
	}
	
	/**
	 * Sets the next node.
	 * @param Node Next node to set.
	 */
	public void setNext(Node next) 
	{
		this.next = next;
	}
}