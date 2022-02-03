package GameEx_Final;
/**
 * This class represents a single node in a LinkedList that implements LinkedListInterface.
 * @author Asaly.Saed
 *
 */
public class Node implements NodeInterface{
	private GeoShape data;
	private NodeInterface next;


	public Node(){
		this.data = null;
		this.next = null;
	}

	public Node(GeoShape data){
		this.data = data;
		this.next = null;
	}

	public Node(GeoShape data, NodeInterface next){
		this.data = data;
		this.next = next;
	}

	@Override
	public GeoShape getData() {
		return this.data;
	}

	@Override
	public void setData(GeoShape g) {
			this.data = g;
	}

	@Override
	public NodeInterface getNext() {
		return this.next;
	}

	@Override
	public void setNext(NodeInterface next) {
		this.next=next;
	}



}
