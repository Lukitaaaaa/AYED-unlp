package tp2.ejercicio6;

import tp2.ejercicio2.*;

public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
    
	public BinaryTree<Integer> suma(){
		sumaAux(this.arbol);
		return arbol;
	}
	
	private int sumaAux(BinaryTree<Integer> arbol){
		
		int r = 0;
		
		if(arbol.isLeaf()) {
			r= arbol.getData();
			arbol.setData(0);
			return r;
		}
		
		if(arbol.hasLeftChild()) 
			r += sumaAux(arbol.getLeftChild());
			
		if(arbol.hasRightChild())
			r += sumaAux(arbol.getRightChild());
		
		int data = arbol.getData();
		arbol.setData(r);
		
		return r+data;
	}
	
	public static void main (String[] args) {
		
		BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
		BinaryTree<Integer> hijoIzq = new BinaryTree<Integer>(25);
		hijoIzq.addLeftChild(new BinaryTree<Integer>(10));
		hijoIzq.addRightChild(new BinaryTree<Integer>(32));
		BinaryTree<Integer> hijoDer = new BinaryTree<Integer>(78);
		ab.addLeftChild(hijoIzq);
		ab.addRightChild(hijoDer);
		
		System.out.println("Arbol originar");
		ab.imprimirArbol();
		System.out.println("");
		
		Transformacion t = new Transformacion(ab);
		BinaryTree<Integer> abResult = t.suma();
		System.out.println("Resultado");
		abResult.imprimirArbol();
        
    }
}
