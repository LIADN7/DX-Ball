package GameEx_Final;
/**
 * This interface represents a single node in a LinkedList which holds a GeoShape object as the data, 
 * and NodeInterface as the next node.
 * The methods includes: get/set the data, get/set the next node.
 * @author Asaly.Saed
 *
 */
public interface NodeInterface {
//Constructor must acquire (GeoShape g, NodeInterface next) parameters (in this order) 
	public GeoShape getData();
	public void setData(GeoShape g);
	public NodeInterface getNext();
	public void setNext(NodeInterface next);
}
