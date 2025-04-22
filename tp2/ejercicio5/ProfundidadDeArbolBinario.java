package tp2.ejercicio5;

import java.util.*;

import tp2.ejercicio2.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;

	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	public int sumaElementosProfundidad(int p) {
		if(arbol.isEmpty()) 
        	return 0;
		int suma = 0;
        Queue<BinaryTree<Integer>> q = new LinkedList<>();
        q.add(arbol);
        int nivel = 0;
        while(!q.isEmpty()){
            int cantNodosNivel = q.size();
            for(int i=0; i<cantNodosNivel; i++){
                BinaryTree<Integer> nodoAct = q.remove();
                if(nivel <= p){
                    System.out.print( " | "  + nodoAct.getData() +  " | ");
                    suma += nodoAct.getData();
                    if(nodoAct.hasLeftChild()) q.add(nodoAct.getLeftChild());
                    if(nodoAct.hasRightChild()) q.add(nodoAct.getRightChild());
                }
                else {
                    if (nodoAct.hasLeftChild()) q.add(nodoAct.getLeftChild());
                    if (nodoAct.hasRightChild()) q.add(nodoAct.getRightChild());
                }
            }
            System.out.println(); 
            nivel++;
        }
		return suma;
	}
	
	// Forma mas correcta
	public int sumaElementosProfundidad2(int p) {
        return sumaAux(this.arbol,p,0);
    }
    
    private int sumaAux(BinaryTree<Integer> a, int p, int profActual) {
        if((profActual > p) || (a == null))
            return 0;
        else
            return a.getData() + sumaAux(a.getLeftChild(),p,profActual+1) + sumaAux(a.getRightChild(),p,profActual+1);
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
        
        ProfundidadDeArbolBinario pab = new ProfundidadDeArbolBinario(ab);
        int p = 1;
        System.out.println("Profundidad: ");
        System.out.println(pab.sumaElementosProfundidad(p));
        
        
    }
}