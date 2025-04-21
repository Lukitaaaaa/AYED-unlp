package tp2.ejercicio3;

import tp2.ejercicio2.*;
import java.util.ArrayList;

public class ContadorArbol {
	
	private BinaryTree<Integer> arbol;
	
	
	
	public ContadorArbol(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

	public ArrayList<Integer> numerosParesInOrden(){
		ArrayList<Integer> array = new ArrayList<Integer>();
		//if(!arbol.isEmpty())
			//recorridoInorden(arbol, array);
		if(!arbol.isEmpty())
			recorridoInorden(arbol, array);
		return array;
	}
	
	public ArrayList<Integer> numerosParesPostOrden(){
		ArrayList<Integer> array = new ArrayList<Integer>();
		if(!arbol.isEmpty())
			recorridoPostorden(arbol, array);
		
		return array;
	}
	
	public void recorridoInorden(BinaryTree<Integer> a, ArrayList<Integer> l) {
		
		if(a.hasLeftChild()) {
			this.recorridoInorden(a.getLeftChild(), l);
		}
		
		System.out.print(a.getData() + " - ");
		if(a.getData() % 2 == 0)
			l.add(a.getData());
		if(a.hasRightChild()) {
			this.recorridoInorden(a.getRightChild(), l);
		}
	}
	
	public void recorridoPostorden(BinaryTree<Integer> a, ArrayList<Integer> l) {
		if(a.hasLeftChild()) {
			this.recorridoPostorden(a.getLeftChild(), l);
		}
		if(a.hasRightChild()) {
			this.recorridoPostorden(a.getRightChild(), l);
		}
		System.out.print(a.getData() + " - ");
		if(a.getData() % 2 == 0)
			l.add(a.getData());
	}
	
	public static void main (String[] args) {
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
        BinaryTree<Integer> hijoIzq = new BinaryTree<Integer>(25);
        hijoIzq.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzq.addRightChild(new BinaryTree<Integer>(32));
        BinaryTree<Integer> hijoDer = new BinaryTree<Integer>(78);
        ab.addLeftChild(hijoIzq);
        ab.addRightChild(hijoDer);
        
        ContadorArbol c = new ContadorArbol(ab);
        System.out.println("Recorrido inorden: ");
        ArrayList<Integer> listInOrden = c.numerosParesInOrden();
        System.out.println(listInOrden);
        
        System.out.println("Recorrido postorden: ");
        ArrayList<Integer> listPostOrden = c.numerosParesPostOrden();
        System.out.println(listPostOrden);
    }
}
