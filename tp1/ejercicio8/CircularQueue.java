package tp1.ejercicio8;

public class CircularQueue<T> extends Queue<T>{
	
	public T shift() {
		T elem;
		elem = data.get(0); // rotamos el primero 
		data.add(elem); // lo mandamos a la ultima posicion
		return elem;
	}
	
}
