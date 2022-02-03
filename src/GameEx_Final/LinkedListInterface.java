package GameEx_Final;
/**
 * This interface represents a LinkedList.
 * The methods includes: getting the head of the LinkedList, add a node to the LinkedList, remove a node from the LinkedList  
 * @author Asaly.Saed
 *
 */
public interface LinkedListInterface {
	public NodeInterface getHead();//gets a pointer to the head of the LinkedList

	public void add(NodeInterface p);//appends p to the list

	public void remove(NodeInterface p);//removes the **node** p from the list
}
