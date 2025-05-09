package tp3.ejercicio6;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.*;

public class RedDeAguaPotable {
	
	private GeneralTree<Character> gt;
	
	public RedDeAguaPotable(GeneralTree<Character> gt) {
		super();
		this.gt = gt;
	}

	public double minimoCaudal(double caudal) {
		if(gt.isEmpty())
			return 0.0;
		return (gt.isLeaf()) ? caudal : this.minimoCaudal(gt, caudal);
	}
	
	private double minimoCaudal(GeneralTree<Character> aux, double caudal) {
		double min = 999999;
		GeneralTree<Character> tree_aux;
		Queue<GeneralTree<Character>> queue = new Queue<GeneralTree<Character>>();
		queue.enqueue(aux);
		while (!queue.isEmpty()) {
			int cantHijos = queue.size();
			for(int i=0; i<cantHijos; i++) {
				
				tree_aux = queue.dequeue();
				List<GeneralTree<Character>> children = tree_aux.getChildren();
				for (GeneralTree<Character> child: children) {
					queue.enqueue(child);
				}
			}
			System.out.println(caudal +" / "+cantHijos);
			caudal = caudal / cantHijos;
			if(caudal<min)
				min=caudal;

			System.out.println("RESULT: "+min);
		}
		return min;
	}
	
	private void imprimir (GeneralTree <Character> a){
		GeneralTree<Character> tree_aux;
		Queue<GeneralTree <Character>> queue = new Queue<GeneralTree <Character>>();
		queue.enqueue(a);
		
		while (!queue.isEmpty()) {
			System.out.print(queue.size() + "NODOS ");
			int cant = queue.size();
			for(int i=0; i<cant; i++) {
				tree_aux = queue.dequeue();
				
				System.out.print(tree_aux.getData()+" | ");
				List<GeneralTree<Character>> children = tree_aux.getChildren();
				for (GeneralTree<Character> child: children) {
					queue.enqueue(child);
				}
			}
				
			System.out.println();
			
		}
	}
	
	public static void main(String[] args) {
		GeneralTree<Character> ab1 = new GeneralTree<Character>('B');
        
		List<GeneralTree<Character>> subChildren1 = new LinkedList<GeneralTree<Character>>();
		subChildren1.add(new GeneralTree<Character>('L'));
		GeneralTree<Character> subAb1 = new GeneralTree<Character>('G', subChildren1);
		List<GeneralTree<Character>> subChildren2 = new LinkedList<GeneralTree<Character>>();
		subChildren2.add(new GeneralTree<Character>('F'));
		subChildren2.add(subAb1);
		GeneralTree<Character> ab2 = new GeneralTree<Character>('C', subChildren2);
		
		List<GeneralTree<Character>> subChildren3 = new LinkedList<GeneralTree<Character>>();
		subChildren3.add(new GeneralTree<Character>('M'));
		subChildren3.add(new GeneralTree<Character>('N'));
		GeneralTree<Character> subAb2 = new GeneralTree<Character>('J', subChildren3);
		List<GeneralTree<Character>> subChildren4 = new LinkedList<GeneralTree<Character>>();
		subChildren4.add(new GeneralTree<Character>('H'));
		subChildren4.add(new GeneralTree<Character>('I'));
		subChildren4.add(subAb2);
		subChildren4.add(new GeneralTree<Character>('K'));
		subChildren4.add(new GeneralTree<Character>('P'));
		GeneralTree<Character> ab3 = new GeneralTree<Character>('D', subChildren4);
		
		GeneralTree<Character> ab4 = new GeneralTree<Character>('E');
		
		List<GeneralTree<Character>> arbol = new LinkedList<GeneralTree<Character>>();
		arbol.add(ab1);
		arbol.add(ab2);
		arbol.add(ab3);
		arbol.add(ab4);
		GeneralTree<Character> ab = new GeneralTree<Character>('A', arbol);
		
		RedDeAguaPotable red = new RedDeAguaPotable(ab);
		red.imprimir(ab);
		System.out.println();
		System.out.print("Min: "+ red.minimoCaudal(1000));
		
	}
	
}
