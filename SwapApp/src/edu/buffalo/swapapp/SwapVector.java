package edu.buffalo.swapapp;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class SwapVector<E extends Serializable> extends AbstractList<E> 
                                                implements Swappable,
                                                           List<E>,
                                                           RandomAccess, 
                                                           Cloneable, 
                                                           java.io.Serializable {
	protected int capacityIncrement;
	private static final long serialVersionUID = -8062241491045229885L;
    
    public SwapVector(int initialCapacity, int capacityIncrement) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        // Create file of given initialCapacity perhaps?
        this.capacityIncrement = capacityIncrement;
    }

    @Override
    public E get(int location) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

	@Override
	public long overhead() {
		// TODO Auto-generated method stub
		return 0;
	}
}
