package tp2.ejercicio8;

import tp2.ejercicio2.*;

public class ParcialArboles {
	
	
	public boolean esPrefijo(BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
		boolean ok = true;
		if(a1.getData() != a2.getData())
			return false;
		if(a2.hasLeftChild() && ok)
			if(a1.hasLeftChild())
				ok = this.esPrefijo(a1.getLeftChild(), a2.getLeftChild());
			else
				return false;
		if(a2.hasRightChild() && ok)
			if(a1.hasRightChild())
				ok = this.esPrefijo(a1.getRightChild(), a2.getRightChild());
			else
				return false;
		System.out.println(a1.getData()+" - "+a2.getData());
		return ok;
	}
	
	
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(65);
		BinaryTree<Integer> izq1 = new BinaryTree<Integer>(37);
		BinaryTree<Integer> izq2 = new BinaryTree<Integer>(22);
		BinaryTree<Integer> izq3 = new BinaryTree<Integer>(47);
		ab.addLeftChild(izq1);
		izq1.addLeftChild(izq2);
		izq1.addRightChild(izq3);
		
		izq2.addLeftChild(new BinaryTree<Integer>(11));
		izq2.addRightChild(new BinaryTree<Integer>(29));
		
		BinaryTree<Integer> der1 = new BinaryTree<Integer>(81);
		BinaryTree<Integer> der2 = new BinaryTree<Integer>(76);
		BinaryTree<Integer> der3 = new BinaryTree<Integer>(93);
		ab.addRightChild(der1);
		der1.addLeftChild(der2);
		der1.addRightChild(der3);
		der3.addLeftChild(new BinaryTree<Integer>(85));
		der3.addRightChild(new BinaryTree<Integer>(94));	
		
		BinaryTree<Integer> abB = new BinaryTree<Integer>(65);
		BinaryTree<Integer> izqB = new BinaryTree<Integer>(37);
		BinaryTree<Integer> derB = new BinaryTree<Integer>(81);
		abB.addLeftChild(izqB);
		abB.addRightChild(derB);
		izqB.addRightChild(new BinaryTree<Integer>(47));
		derB.addRightChild(new BinaryTree<Integer>(93));
		
		
		System.out.println("Arbol chiquito");
		abB.imprimirArbol();
		System.out.println("");

		System.out.println("Arbol original");
		ab.imprimirArbol();
		System.out.println("");
		
		System.out.println("Resultado:");
		ParcialArboles pa = new ParcialArboles();
		System.out.println(pa.esPrefijo(ab, abB)); 
	}

}
