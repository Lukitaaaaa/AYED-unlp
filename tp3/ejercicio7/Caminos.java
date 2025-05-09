package tp3.ejercicio7;

import tp3.ejercicio3.GeneralTree;
import java.util.List;
import java.util.LinkedList;

public class Caminos {
	
	private GeneralTree<Integer> gt;
	
	public Caminos(GeneralTree<Integer> gt) {
		super();
		this.gt = gt;
	}
	
	public List<Integer> caminoAHojaMasLejana(){
		List<Integer> aux = new LinkedList<Integer>();
		if(gt.isEmpty())
			return aux;
		return this.caminoAHojaMasLejana(gt, aux);
	}
	
	private List<Integer> caminoAHojaMasLejana(GeneralTree<Integer> aux, List<Integer> l){
		int max = -1;
		System.out.println("Agrego el: "+aux.getData());
		GeneralTree<Integer> maxChild = null;
		l.add(aux.getData());
		List<GeneralTree<Integer>> children = aux.getChildren();
		for(GeneralTree<Integer> child: children) {
			System.out.println("Hijo: "+child.getData());
			System.out.println("Con altura: "+child.altura());
			if(child.altura()>max && (child.hasChildren() || child.isLeaf())) {
				
				max = child.altura();
				maxChild = child;
			}
			
			
		}
		//System.out.println("Hoal");
		
		System.out.println("El hijo con mas altura es: "+maxChild.getData());
		if(maxChild.isLeaf()) {
			l.add(maxChild.getData());
			System.out.println("Agrego el ultimo: "+maxChild.getData());
			return l;
		}
		else
			l = this.caminoAHojaMasLejana(maxChild, l);
		return l;
	}
	
	public static void main(String[] args) {
		List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
		subChildren1.add(new GeneralTree<Integer>(1));
		GeneralTree<Integer> subA = new GeneralTree<Integer>(6, subChildren1);
		List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
		subChildren2.add(new GeneralTree<Integer>(10));
		subChildren2.add(subA);
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(17, subChildren2);
		
		List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
		subChildren3.add(new GeneralTree<Integer>(8));
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(9, subChildren3);
		
		List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
		subChildren4.add(new GeneralTree<Integer>(16));
		subChildren4.add(new GeneralTree<Integer>(7));
		GeneralTree<Integer> subB = new GeneralTree<Integer>(14, subChildren4);
		List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
		subChildren5.add(subB);
		subChildren5.add(new GeneralTree<Integer>(18));
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(15, subChildren5);
		
		List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
		arbol.add(a1);
		arbol.add(a2);
		arbol.add(a3);
		GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol);
		
		Caminos c = new Caminos(a);
		c.caminoAHojaMasLejana();
	}

}
