package tp3.ejercicio4;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp3.ejercicio3.GeneralTree;

public class AnalizadorArbol {
	
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		double mayorPromedio = 0;
		double suma;
		GeneralTree<AreaEmpresa> tree_aux;
		Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();
		queue.enqueue(arbol);
		while (!queue.isEmpty()) {
			suma = 0;
			int cant = queue.size();
			for(int i=0; i<cant; i++) {
				tree_aux=queue.dequeue();
				suma += tree_aux.getData().getTardanza();
				List<GeneralTree<AreaEmpresa>> children = tree_aux.getChildren();
				for (GeneralTree<AreaEmpresa> child: children) {
					queue.enqueue(child);
				}
			}
			
			if(suma / cant > mayorPromedio)
				mayorPromedio = suma / cant;
			System.out.println("mp: "+ mayorPromedio);
		}
		return mayorPromedio;
	}
	
	public static void main(String[] args) {
		AreaEmpresa ae1 = new AreaEmpresa("a", 2);
		AreaEmpresa ae2 = new AreaEmpresa("b", 4);
		AreaEmpresa ae3 = new AreaEmpresa("c", 8);
		AreaEmpresa ae4 = new AreaEmpresa("d", 12);
		AreaEmpresa ae5 = new AreaEmpresa("e", 4);
		AreaEmpresa ae6 = new AreaEmpresa("f", 5);
		AreaEmpresa ae7 = new AreaEmpresa("g", 12);
		
		
		List<GeneralTree<AreaEmpresa>> children1 = new LinkedList<GeneralTree<AreaEmpresa>>();
		children1.add(new GeneralTree<AreaEmpresa>(ae6));
		children1.add(new GeneralTree<AreaEmpresa>(ae7));
		GeneralTree<AreaEmpresa> a2 = new GeneralTree<AreaEmpresa>(ae2);
		GeneralTree<AreaEmpresa> a3 = new GeneralTree<AreaEmpresa>(ae3, children1);
		GeneralTree<AreaEmpresa> a4 = new GeneralTree<AreaEmpresa>(ae4);
		GeneralTree<AreaEmpresa> a5 = new GeneralTree<AreaEmpresa>(ae5);
		
		
		List<GeneralTree<AreaEmpresa>> children = new LinkedList<GeneralTree<AreaEmpresa>>();
		children.add(a2);
		children.add(a3);
		children.add(a4);
		children.add(a5);
		
		GeneralTree<AreaEmpresa> a1 = new GeneralTree<AreaEmpresa>(ae1, children);
		
		AnalizadorArbol ana = new AnalizadorArbol();
		System.out.println("promedio: "+ ana.devolverMaximoPromedio(a1));
		
	}
}
