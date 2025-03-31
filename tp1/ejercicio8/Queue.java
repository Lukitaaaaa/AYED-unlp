package tp1.ejercicio8;

import java.util.*;



public class Queue<T> extends Sequence{
	
	protected List<T> data;
	
	public Queue() {
		this.data = new ArrayList<>();
	}

	public void enqueue(T dato) {
		data.add(this.size(),dato);
	}
	
	public T dequeue(){
		T dato = this.head();
		data.remove(this.size()-1);
		return dato;
		
	}
	
	public T head() {
		T dato = null;
		if(this.isEmpty())
			System.out.print("Error: cola vacia");
		else
			dato = data.get(this.size()-1);
		return dato;
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public String toString() {
		return "Queue [data=" + data + "]";
	}
}
