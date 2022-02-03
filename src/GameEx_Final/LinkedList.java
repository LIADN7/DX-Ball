package GameEx_Final;

/**
 * This is a simple LinkedList class that implements LinkedListInterface.
 * Ex4: you should implement this class!
 * @author Asaly.Saed
 *
 */
public class LinkedList implements LinkedListInterface{
	
	private NodeInterface head;
	
	public LinkedList(){
		this.head = null;
	}

	public LinkedList(NodeInterface head){
		this.head = head;
	}
	
	@Override
	public NodeInterface getHead() {
		return this.head;
	}

	@Override
	public void add(NodeInterface p) {
		if(this.head==null) {
			this.head = p;
		}
		else {
			NodeInterface temp = this.head;
			while(temp.getNext()!=null) {
				temp=temp.getNext();
			}
			temp.setNext(p);
		}

	}

	@Override
	public void remove(NodeInterface p) {
		if(this.head!=null) {
			if(this.head==p) {
				this.head=this.head.getNext();
			}
			else {
				NodeInterface nodeNext = this.head.getNext();
				NodeInterface node = this.head;
				boolean flag = true;
				while(nodeNext!=null && flag) {
					if(nodeNext==p) {
						node.setNext(nodeNext.getNext());
						flag = false;
					}
					else {
						node = nodeNext;
						nodeNext = nodeNext.getNext();
					}
				}

			}
			
		}

		
		
		
	}
	
	
	
	
}
