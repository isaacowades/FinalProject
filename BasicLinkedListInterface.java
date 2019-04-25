
public interface BasicLinkedListInterface<E> {
	
	public void addFirst(E data);

	public int getSize();

	public void addLast(E data);
	
	public void addAt(int index, E data);

	public Node<E> removeFirst();
	
	public Node<E> removeLast();
	
	public Node<E> removeAt(int index);
	
	public void shuffle(int swapps);
	
	public E getAt(int index);
}
