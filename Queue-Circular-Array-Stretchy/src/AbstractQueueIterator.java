


public interface AbstractQueueIterator<E>{
	public void	add(E e);
//	Inserts the specified element into the list (optional operation).
	public boolean	hasNext();
//	Returns true if this list iterator has more elements when traversing the list in the forward direction.
	public boolean	hasPrevious();
//	Returns true if this list iterator has more elements when traversing the list in the reverse direction.
	public E	next();
	//Returns the next element in the list and advances the cursor position.
	public int	nextIndex();
	//Returns the index of the element that would be returned by a subsequent call to next().
	public E	previous();
	//Returns the previous element in the list and moves the cursor position backwards.
	public int	previousIndex();
	//Returns the index of the element that would be returned by a subsequent call to previous().
	public void	remove();
	//Removes from the list the last element that was returned by next() or previous() (optional operation).
	public void	set(E e);
}