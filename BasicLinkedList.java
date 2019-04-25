public class BasicLinkedList<E>  implements BasicLinkedListInterface<E> {
	protected Node<E> head;
	protected Node<E> tail;
	protected int size;
	

	public void addFirst(E data) {
		Node<E> newNode = new Node<E>(data);
		newNode.next = head;
		head = newNode;
		if (size==0) tail = head;
		size++;
		
	}

	public int getSize() {
		return size;
	}

	public void addLast(E data) {
		if(head == null) {
			addFirst(data);
		}
		else {
			Node<E> current = head;
			while(current.next != null) {
				current = current.next;
			}
			tail = current.next = new Node<E>(data);
			size++;
		}
	}
	
	public void addAt(int index, E data) {
		if (index <= 0) {
			addFirst(data);
		}
		else if(index >= size) {
			addLast(data);
		}
		else {
			Node<E> current = head;
			for (int j = 0; j < index - 1; j++) {
				current = current.next;
			}
			Node<E> next = current.next;
			current.next = tail = new Node<E>(data);
			current.next.next = next;
			size++;
		}
	}
	
	public E getAt(int index) {
		if (index <= 0) {
			if (head != null)
			return (E) (head.data);
			return null;
		}
		else if(index >= size) {
			
			return (E) tail.data;
		}
		else {
			Node<E> current = head;
			for (int j = 0; j < index; j++) {
				current = current.next;
			}
			return current.data;
		}
	}

	public Node<E> removeFirst() {
		if(head == null) {
			tail = null;
			return null;
		}
		else {
			Node<E> removedNode = head;
			head = head.next;
			size--;
			return removedNode;
		}
	}
	
	public Node<E> removeLast() {
		if (size == 0) {
			return null;
		}
		else if (size == 1) {
			return removeFirst();
		}
		else {
			Node<E> current = head;
			for (int i = 0; current.next.next!=null; i++) {
				current = current.next;
			}
			Node<E> removedNode = current.next;
			current.next = null;
			tail = current;
			size--;
			return removedNode;
		}
	}
	
	public Node<E> removeAt(int index) {
		if (index <= 0) {
			return removeFirst();
		}
		else if (index >= size) {
			return removeLast();
		}
		else {
			Node<E> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			Node<E> removedNode = current.next;
			current.next = current.next.next;
			size--;
			return removedNode;
		}
	}
	
	public void shuffle(int swapps) {
		int rand = 0;
		System.out.println();
		for(int count=0; count<=swapps; count++) {
			rand = (int)(Math.random()*(size+1));
			addAt(rand, (E)head.data);
			removeFirst();
		}
	}
}

class Node<E>{
	E data;
	Node<E> next;
	
	Node(E data){
		this.data = data;
	}
}