package tp3.ejercicio2;

import tp3.ejercicio1.*;

import java.util.List;
import java.util.LinkedList;
import tp1.ejercicio8.Queue;


public class RecorridosAG {

	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> aux = new LinkedList<Integer>();
		this.numerosImparesMayoresQuePreOrden(a, aux, n);	
		return aux;
	}
	
	private void numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a, List<Integer> aux, Integer n){
		if((a.getData()>n) && (a.getData()%2 != 0)) {
			aux.add(a.getData());
			System.out.print(a.getData()+" ");
		}
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> child: children) {	
			this.numerosImparesMayoresQuePreOrden(child, aux, n);
		}
			 
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> aux = new LinkedList<Integer>();
		this.numerosImparesMayoresQueInOrden(a, aux, n);
		return aux;
	}
	
	private void numerosImparesMayoresQueInOrden(GeneralTree <Integer> a, List<Integer> aux,Integer n){
		if(a.hasChildren())
			this.numerosImparesMayoresQueInOrden(a.getChildren().getFirst(), aux, n);
		
		if((a.getData()>n) && (a.getData()%2 != 0)) {
			aux.add(a.getData());
			System.out.print(a.getData()+" ");
		}
		
		for(int i=1; i< a.getChildren().size(); i++)
            numerosImparesMayoresQueInOrden(a.getChildren().get(i),aux,n);
		
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> aux = new LinkedList<Integer>();
		this.numerosImparesMayoresQuePostOrden(a, aux, n);
		return aux;
	}
	
	private void numerosImparesMayoresQuePostOrden(GeneralTree <Integer> a, List<Integer> aux,Integer n){
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> child: children)
			this.numerosImparesMayoresQueInOrden(child, aux, n);
		
		if((a.getData()>n) && (a.getData()%2 != 0)) {
			aux.add(a.getData());
			System.out.print(a.getData()+" - ");
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles (GeneralTree <Integer> a,Integer n){
		List<Integer> aux = new LinkedList<Integer>();
		this.numerosImparesMayoresQuePorNiveles(a, aux, n);
		return aux;
	}
	
	private void numerosImparesMayoresQuePorNiveles (GeneralTree <Integer> a, List<Integer> aux,Integer n){
		GeneralTree<Integer> tree_aux;
		Queue<GeneralTree <Integer>> queue = new Queue<GeneralTree <Integer>>();
		queue.enqueue(a);
		
		while (!queue.isEmpty()) {
			tree_aux = queue.dequeue();
			if((tree_aux.getData()>n) && (tree_aux.getData()%2 != 0)) {
				aux.add(tree_aux.getData());
				System.out.print(tree_aux.getData()+" ");
			}
			List<GeneralTree<Integer>> children = tree_aux.getChildren();
			for (GeneralTree<Integer> child: children) {
				queue.enqueue(child);
			}
		}
	}
	
	public static void main(String[] args) {
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(21));
		children2.add(new GeneralTree<Integer>(22));
		children2.add(new GeneralTree<Integer>(23));
		
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(31));
		children3.add(new GeneralTree<Integer>(32));
		
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
		List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
		childen.add(a1);childen.add(a2);childen.add(a3);
		
		GeneralTree<Integer> a = new GeneralTree<Integer>(0, childen);
		
		RecorridosAG r = new RecorridosAG();
		r.numerosImparesMayoresQuePreOrden(a, 3);
		System.out.println();
		r.numerosImparesMayoresQueInOrden(a, 3);
		System.out.println();
		r.numerosImparesMayoresQuePostOrden(a, 3);
		System.out.println();
		r.numerosImparesMayoresQuePorNiveles(a, 3);
	}
	
}