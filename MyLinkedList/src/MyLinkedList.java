
import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E>{
    
	
	private class DNode<E> {
        private E data;
        private DNode<E> previous;
        private DNode<E> next;
        	
        public DNode(E data, DNode<E> previous, DNode<E> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
        
        public E getData() {
            return this.data;
        }
        
        public DNode<E> getPrevious() {
            return this.previous;
        }
        
        public DNode<E> getNext() {
            return this.next;
        }
        
        public void setData(E newData) {
            this.data = newData;
        }
        
        public void setPrevious(DNode<E> newPrevious) {
            this.previous = newPrevious;
        }
        
        public void setNext(DNode<E> newNext) {
            this.next = newNext;
        }
    }
    private DNode<E> front;
    private DNode<E> back;
    private int numStored;
    
    public MyLinkedList() {
        this.front = new DNode(null, null, null);
        this.back = new DNode(null, front, null);
        this.front.setNext(this.back);
        this.numStored = 0;
    }
    
    public void add(int index, E newItem) {
        this.rangeCheck(index, "ArrayList add()", this.numStored);
        
        DNode<E> beforeNode = this.getNode(index-1);
        DNode<E> afterNode = beforeNode.getNext();
        
        DNode<E> newNode = new DNode<E>(newItem, beforeNode, afterNode);
        beforeNode.setNext(newNode);
        afterNode.setPrevious(newNode);
                	
        this.numStored++;
    }
    
    public boolean add(E newItem) {
        this.add(this.numStored, newItem);
        return true;
    }
    
    void clear()
    { 
    	this.front=null;
    	this.back=null;
    	this.numStored=0;
    }
    
    boolean isEmpty() {
    	
    	
        return this.numStored == 0;
    }
    
   public E get(int index) {
        this.rangeCheck(index, "ArrayList get()", this.numStored-1);
        return this.getNode(index).getData();
    }
    
    public int indexOf(E oldItem) {
        DNode<E> stepper = this.front.getNext(); 
        for (int i = 0; i < this.numStored; i++) {
            if (oldItem.equals(stepper.getData())) {
                return i;
            }
            stepper = stepper.getNext();
        }    
        return -1;
    }
    
    public boolean contains(E oldItem) {
        return (this.indexOf(oldItem) >= 0);
    }
    
    public int size() {
        return this.numStored;
    }
    
    public E set(int index, E element){
    	 DNode<E> myNode = this.getNode(index);
    	 myNode.data = element ;
    	return myNode.getData();
    }
    
    
   
    
    public E remove(int index) {
        this.rangeCheck(index, "ArrayList remove()", this.numStored-1);
        
        DNode<E> removeNode = this.getNode(index);
        DNode<E> temp = removeNode;
        removeNode.getPrevious().setNext(removeNode.getNext());
        removeNode.getNext().setPrevious(removeNode.getPrevious());
        this.numStored--;
        return temp.getData();
    }
    
    public E remove() {
        //this.rangeCheck(index, "ArrayList remove()", this.numStored-1);
        
        DNode<E> removeNode = this.getNode(0);
        DNode<E> temp = removeNode;
        removeNode.getPrevious().setNext(removeNode.getNext());
        removeNode.getNext().setPrevious(removeNode.getPrevious());
        this.numStored--;
        return temp.getData();
    }
    
    public E element() {
        //this.rangeCheck(index, "ArrayList remove()", this.numStored-1);
    	// this.getNode(0).getData(0)
    	
    	 DNode<E> thisNode = this.getNode(0);
         DNode<E> temp = thisNode;
        return  temp.getData();
    }
    
    public boolean remove(E oldItem) {
        int index = this.indexOf(oldItem);
        if (index >= 0) {
            this.remove(index);
            return true;
        }
        return false;
    }
    
        
    private void rangeCheck(int index, String msg, int upperBound)  {
        if (index < 0 || index > upperBound)
            throw new IndexOutOfBoundsException("\n" + msg + ": index " 
                    + index + " out of bounds. Should be in the range 0 to " +
                    upperBound);
    }

    private DNode<E> getNode(int index) {
        if (index <= this.numStored/2) {
            DNode<E> stepper = this.front;
            for (int i = 0; i <= index; i++) {
                stepper = stepper.getNext();
            }
            return stepper;
        }
        else {
            DNode<E> stepper = this.back;
            for (int i = this.numStored-1; i >= index; i--) {
                stepper = stepper.getPrevious();
            }
            return stepper;
        }
    }
    
    private class LinkedIterator implements Iterator<E> {
        private DNode<E> nextNode;
        public LinkedIterator() {
            this.nextNode = front.getNext();
        }

        public boolean hasNext() {
            return this.nextNode != MyLinkedList.this.back;
        }

        public E next() {
            this.nextNode = this.nextNode.getNext();
            return this.nextNode.getPrevious().getData();
        }

        public void remove() {
           if (this.nextNode == front.getNext()) {
               throw new RuntimeException("Iterator call " +
                                           "to next() required before " +
                                           "calling remove()");
           }
           this.nextNode.setPrevious(this.nextNode.getPrevious().getPrevious());
           this.nextNode.getPrevious().setNext(this.nextNode);
           MyLinkedList.this.numStored--;
       }
    }
           
    public Iterator<E> iterator() {
         return new LinkedIterator();
    }
}
