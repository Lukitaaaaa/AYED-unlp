package tp3.ejercicio5;

import java.util.LinkedList;

import java.util.List;

import tp1.ejercicio8.Queue;


public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public boolean esAncestro(T a, T b) {
		
		boolean estaAntesB= false;
		GeneralTree<T> nodo = null;
		GeneralTree<T> tree_aux;
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		queue.enqueue(this);
		while (!queue.isEmpty()&& (!estaAntesB) && nodo == null) {
			
			tree_aux = queue.dequeue();
			System.out.println(tree_aux.getData());
			if(tree_aux.getData() == b)
				estaAntesB = true;
			if(tree_aux.getData() == a && (!estaAntesB)) {
				nodo = tree_aux;
				System.out.println("ESTA EL ANCESTRO");
			}
			List<GeneralTree<T>> children = tree_aux.getChildren();
			for (GeneralTree<T> child: children) {
				queue.enqueue(child);
			}
		}
		
		return (!estaAntesB) ? this.esAncestro(nodo, a, b) : false;
	}
	
	private boolean esAncestro(GeneralTree<T> aux, T a, T b) {
		
		boolean estaB = false;
		GeneralTree<T> tree_aux;
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		queue.enqueue(aux);
		while (!queue.isEmpty()) {
			
			tree_aux = queue.dequeue();
			System.out.println(tree_aux.getData());
			if(tree_aux.getData() == b)
				return true;
			List<GeneralTree<T>> children = tree_aux.getChildren();
			for (GeneralTree<T> child: children) {
				queue.enqueue(child);
			}
		}
		
		return estaB;
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
		
		System.out.println(a.esAncestro(2, 22));
		
	}
}