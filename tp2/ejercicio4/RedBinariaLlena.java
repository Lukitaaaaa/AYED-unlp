package tp2.ejercicio4;

import java.util.ArrayList;

import tp2.ejercicio2.BinaryTree;

public class RedBinariaLlena {
	
	private BinaryTree<Integer> arbol;

	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	public int retardoReenvio() {
		int retardo;
		if(arbol.isEmpty())
			return 0;
		else
			retardo = this.retardo(arbol);
		return retardo;
	}
	
	private int retardo(BinaryTree<Integer> a) {
		int aux = a.getData();
		//System.out.print(a.getData());
		if(!a.isLeaf())
			if(a.getLeftChild().getData() < a.getRightChild().getData())
				aux+= this.retardo(a.getRightChild());
			else
				aux+= this.retardo(a.getLeftChild());
		return aux;
	}
	
	public static void main (String[] args) {    
        BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
        BinaryTree<Integer> hijoIzq = new BinaryTree<Integer>(25);
        hijoIzq.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzq.addRightChild(new BinaryTree<Integer>(32));
        BinaryTree<Integer> hijoDer = new BinaryTree<Integer>(78);
        hijoDer.addLeftChild(new BinaryTree<Integer>(41));
        hijoDer.addRightChild(new BinaryTree<Integer>(86));
        ab.addLeftChild(hijoIzq);
        ab.addRightChild(hijoDer);
        
        RedBinariaLlena rb = new RedBinariaLlena(ab);
        System.out.print("Retardo: ");
        System.out.println(rb.retardoReenvio());
        
        System.out.print("Retardo2: ");
        BinaryTree<Integer> ab2 = new BinaryTree<Integer>();
        RedBinariaLlena rb2 = new RedBinariaLlena(ab2);
        System.out.println(rb2.retardoReenvio());
    }
}
