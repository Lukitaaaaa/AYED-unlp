package tp3.ejercicio2;

import tp3.ejercicio1.*;
import java.util.List;
import java.util.LinkedList;

public class RecorridosAG {

	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> aux = new LinkedList<Integer>();
		return this.numerosImparesMayoresQuePreOrden(a, aux, n);
	}
	
	private List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a, List<Integer> aux, Integer n){
		if((a.getData()>n) && (a.getData()%2 != 0)) {
			aux.add(a.getData());
			System.out.print(a.getData()+" ");
		}
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> child: children) {	
			aux = this.numerosImparesMayoresQuePreOrden(child, aux, n);
		}
		return aux;
			 
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> aux = new LinkedList<Integer>();
		return aux;
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> aux = new LinkedList<Integer>();
		return aux;
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles (GeneralTree <Integer> a,Integer n){
		List<Integer> aux = new LinkedList<Integer>();
		return aux;
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
	}
	
}