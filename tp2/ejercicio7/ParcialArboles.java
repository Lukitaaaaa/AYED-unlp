package tp2.ejercicio7;

import tp2.ejercicio2.*;

public class ParcialArboles {
	BinaryTree<Integer> arbol;

	public ParcialArboles(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	/*
	 * El método devuelve true si el subárbol cuya raíz es “num”, tiene en su subárbol izquierdo una
		cantidad mayor estricta de árboles con un único hijo que en su subárbol derecho. Y false en caso
		contrario. Consideraciones:
	 * */
	
	public boolean isLeafTree(int num) {
		boolean aux = false;
		BinaryTree<Integer> nodo = this.esta(arbol, num);
		System.out.println(nodo.getData());
		if(nodo != null) {
			System.out.println("esta");
			aux = this.contarRamas(nodo);
		}
		return aux;
		
	}
	
	private BinaryTree<Integer> esta(BinaryTree<Integer> a, int n) {
		
		if(a.getData() == n) 
			return a;
		
		BinaryTree<Integer> nodo = new BinaryTree<Integer>();
		
		if(a.hasLeftChild() && nodo.isEmpty())
			nodo = this.esta(a.getLeftChild(), n);
		if(a.hasRightChild() && nodo.isEmpty())
			nodo = this.esta(a.getRightChild(), n);
			
		
		//System.out.println(nodo.getData());
		return nodo;
	}
	
	private boolean contarRamas(BinaryTree<Integer> raiz) {
		int l = 0;
		int r = 0;
		if(!raiz.hasLeftChild()) 
			l = -1;
		else
			l = isLeafTree(raiz.getLeftChild());
		
		if(!raiz.hasRightChild())
			r = -1;
		else
			r = isLeafTree(raiz.getRightChild());
		
		System.out.println(l + " - " + r);
		return (l>r);
	}
	private int isLeafTree(BinaryTree<Integer> a) {
		int total = 0;
		
		if(a.isEmpty()) {
			return 0;
		}
		
		if(a.hasLeftChild())
			total += this.isLeafTree(a.getLeftChild());
		if(a.hasRightChild())
			total += this.isLeafTree(a.getRightChild());
		
		
		if( (a.hasLeftChild() && !a.hasRightChild()) || (!a.hasLeftChild() && a.hasRightChild())) 
			total++;
		
		
		return total;
	}
	
	public static void main (String[] args) {
		
		BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
		BinaryTree<Integer> izq1 = new BinaryTree<Integer>(7);
		BinaryTree<Integer> izq2 = new BinaryTree<Integer>(23);
		BinaryTree<Integer> izq3 = new BinaryTree<Integer>(6);
		ab.addLeftChild(izq1);
		izq1.addLeftChild(izq2);
		izq1.addRightChild(izq3);
		
		izq2.addLeftChild(new BinaryTree<Integer>(-3));
		izq3.addLeftChild(new BinaryTree<Integer>(55));
		izq3.addRightChild(new BinaryTree<Integer>(11));
		
		BinaryTree<Integer> der1 = new BinaryTree<Integer>(-5);
		BinaryTree<Integer> der2 = new BinaryTree<Integer>(19);
		BinaryTree<Integer> der3 = new BinaryTree<Integer>(4);
		ab.addRightChild(der1);
		der1.addLeftChild(der2);
		der2.addRightChild(der3);
		der3.addLeftChild(new BinaryTree<Integer>(18));
		
		System.out.println("Arbol original");
		ab.imprimirArbol();
		System.out.println("");
		
		ParcialArboles pa = new ParcialArboles(ab);
		System.out.println(pa.isLeafTree(-5));
		
        
    }
}
