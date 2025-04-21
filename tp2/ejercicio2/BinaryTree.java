package tp2.ejercicio2;

//import tp1.ejercicio8.Queue;
import java.util.*;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 
	
	
	public BinaryTree() {
		super();
	}
	
	public BinaryTree(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}
	
	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}
	
	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}
	
	public void removeLeftChild() {
		this.leftChild = null;
	}
	
	public void removeRightChild() {
		this.rightChild = null;
	}
	
	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}
	
	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());
	
	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}
	
	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}
	
	public  int contarHojas() {
		
		int left = 0; 
	    int right = 0;
	    
	    if (this.isEmpty()) 
	    	return 0;	 
	    	
	    else {
	        if(this.hasLeftChild()) { 
	            left = this.getLeftChild().contarHojas();
	        }
	        if(this.hasRightChild()) { 
	            right = this.getRightChild().contarHojas();
	        }
	        if(this.isLeaf())
	        	return 1;
	        return left + right;
	    }
	}
		
		
		 
	public BinaryTree<T> espejo(){
		BinaryTree<T> abInv = new BinaryTree<T>(this.getData());
		if(this.hasLeftChild())
			abInv.addRightChild(this.getRightChild());
		if(this.hasRightChild())
			abInv.addLeftChild(this.getLeftChild());
		return abInv;
	}
	
	// 0<=n<=m
	public void entreNiveles(int n, int m){
		
        if(this.isEmpty() || n<0 || m<n) 
        	return;
        Queue<BinaryTree<T>> q = new LinkedList<>();
        q.add(this);
        int nivel = 0;
        while(!q.isEmpty()){
            int cantNodosNivel = q.size();
            for(int i=0; i<cantNodosNivel; i++){
                BinaryTree<T> nodoAct = q.remove();
                if(nivel >= n && nivel <= m){
                    System.out.print( " | "  + nodoAct.getData() +  " | ");
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
	}
	
	public void imprimirArbol() {
		System.out.print(this.getData() + " - ");
		if(this.hasLeftChild()) {
			this.getLeftChild().imprimirArbol();
		}
		if(this.hasRightChild()) {
			this.getRightChild().imprimirArbol();
		}
	}
	
	public static void main (String[] args) {
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
        BinaryTree<Integer> hijoIzq = new BinaryTree<Integer>(25);
        hijoIzq.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzq.addRightChild(new BinaryTree<Integer>(32));
        BinaryTree<Integer> hijoDer = new BinaryTree<Integer>(78);
        ab.addLeftChild(hijoIzq);
        ab.addRightChild(hijoDer);
        
        ab.imprimirArbol();
        System.out.println();
        System.out.println(ab.contarHojas());
        System.out.println();
        ab.entreNiveles(1, 2);
    }
		
}