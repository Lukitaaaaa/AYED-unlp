package tp2.ejercicio6;

import tp2.ejercicio2.*;

public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> suma2() {
        suma2(this.arbol);
        return this.arbol;
    }
    
    private int suma2(BinaryTree<Integer> tree) {
        int aux = 0;
        if(tree.isLeaf()) {
            aux = tree.getData();
            tree.setData(0);
            return aux;
        }
        if(tree.hasLeftChild())
            aux += suma2(tree.getLeftChild());
        if(tree.hasRightChild())
            aux += suma2(tree.getRightChild());
        int data = tree.getData();
        tree.setData(aux);
        return data + aux;
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
