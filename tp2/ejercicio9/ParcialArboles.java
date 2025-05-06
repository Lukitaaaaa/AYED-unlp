package tp2.ejercicio9;

import tp2.ejercicio2.*;

public class ParcialArboles {

	public BinaryTree<int[]> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<int[]> nuevo = this.sumaAndDif(arbol, 0, 0);
		return nuevo;
	}
	
	private BinaryTree<int[]> sumaAndDif(BinaryTree<Integer> a, int valorPadre, int difPadre) {
		if(a.isEmpty())
			return null;
		int[]array = new int[2];
		array[0] = a.getData() + valorPadre;
		array[1] = a.getData() - difPadre;
		
		//System.out.print("Nodo "+a.getData()+": ");
		//System.out.println("["+array[0]+"|"+array[1]+"]");
		BinaryTree<int[]> nuevo = new BinaryTree<int[]>(array);
		if(a.hasLeftChild())
			nuevo.addLeftChild(this.sumaAndDif(a.getLeftChild(), array[0],a.getData()));
		if(a.hasRightChild())
			nuevo.addRightChild(this.sumaAndDif(a.getRightChild(),array[0] , a.getData()));
		return nuevo;
	}
	
	public void imprimir(BinaryTree<int[]> a) {
		if(a.isEmpty()) return;
		int[] r = new int[2];
		r = a.getData();
		System.out.println("["+r[0]+"|"+r[1]+"]");
		if(a.hasLeftChild())
			this.imprimir(a.getLeftChild());
		if(a.hasRightChild())
			this.imprimir(a.getRightChild());
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(20);
		BinaryTree<Integer> izq1 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> izq2 = new BinaryTree<Integer>(-5);
		BinaryTree<Integer> izq3 = new BinaryTree<Integer>(10);
		ab.addLeftChild(izq1);
		izq1.addLeftChild(izq2);
		izq1.addRightChild(izq3);
		
		izq3.addLeftChild(new BinaryTree<Integer>(1));
		
		BinaryTree<Integer> der1 = new BinaryTree<Integer>(30);
		BinaryTree<Integer> der2 = new BinaryTree<Integer>(50);
		BinaryTree<Integer> der3 = new BinaryTree<Integer>(-9);
		BinaryTree<Integer> der4 = new BinaryTree<Integer>(4);
		ab.addRightChild(der1);
		der1.addLeftChild(der2);
		der1.addRightChild(der3);
		der2.addRightChild(der4);
		der4.addRightChild(new BinaryTree<Integer>(6));
		
		System.out.println("Arbol original");
		ab.imprimirArbol();
		System.out.println("");
		
		System.out.println("Resultado: ");
		ParcialArboles pa = new ParcialArboles();
		
		BinaryTree<int[]> result = pa.sumAndDif(ab);
		pa.imprimir(result);
	}

}
