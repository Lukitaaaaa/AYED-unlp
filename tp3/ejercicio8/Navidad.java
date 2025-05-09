package tp3.ejercicio8;

import tp3.ejercicio3.GeneralTree;
import java.util.List;
import java.util.LinkedList;

public class Navidad {
	
	private GeneralTree<Integer> gt;
	
	public Navidad(GeneralTree<Integer> gt) {
		super();
		this.gt = gt;
	}
	
	public String esAbetoNavidenio() {
		boolean aux=false;
		if(gt.isEmpty() || gt.isLeaf())
			return "No";
		aux = this.isAbetoNavidenio(gt);
		return (aux) ? "Yes" : "No";
	}
	
	private boolean isAbetoNavidenio(GeneralTree<Integer> aux) {
		int cantHojas = 0;
		List<GeneralTree<Integer>> children = aux.getChildren();
		for(GeneralTree<Integer> child: children)
			if(child.isLeaf())
				cantHojas++;
			else if(!isAbetoNavidenio(child))
				return false;
		return cantHojas >= 3;
	}
	
	public static void main(String[] args) {
		List<GeneralTree<Integer>> subArb1 = new LinkedList<GeneralTree<Integer>>();
        subArb1.add(new GeneralTree<Integer>(2));
        subArb1.add(new GeneralTree<Integer>(3));
        subArb1.add(new GeneralTree<Integer>(4));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(1, subArb1);
        
        List<GeneralTree<Integer>> subArb2A = new LinkedList<GeneralTree<Integer>>();
        subArb2A.add(new GeneralTree<Integer>(5));
        subArb2A.add(new GeneralTree<Integer>(6));
        subArb2A.add(new GeneralTree<Integer>(7));
        GeneralTree<Integer> subA2 = new GeneralTree<Integer>(2, subArb2A);
        List<GeneralTree<Integer>> subArb2B = new LinkedList<GeneralTree<Integer>>();
        subArb2B.add(subA2);
        subArb2B.add(new GeneralTree<Integer>(3));
        subArb2B.add(new GeneralTree<Integer>(4));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, subArb2B);
        
        List<GeneralTree<Integer>> subArb3A = new LinkedList<GeneralTree<Integer>>();
        subArb3A.add(new GeneralTree<Integer>(6));
        subArb3A.add(new GeneralTree<Integer>(7));
        subArb3A.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> subA3 = new GeneralTree<Integer>(3, subArb3A);
        List<GeneralTree<Integer>> subArb3B = new LinkedList<GeneralTree<Integer>>();
        subArb3B.add(new GeneralTree<Integer>(2));
        subArb3B.add(subA3);
        subArb3B.add(new GeneralTree<Integer>(4));
        subArb3B.add(new GeneralTree<Integer>(5));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(1, subArb3B);
        
        Navidad nav1 = new Navidad(a1);
        Navidad nav2 = new Navidad(a2);
        Navidad nav3 = new Navidad(a3);
        
        System.out.println("Es abeto navidenio A1? " + nav1.esAbetoNavidenio()); //Yes
        System.out.println("Es abeto navidenio A2? " + nav2.esAbetoNavidenio()); //No
        System.out.println("Es abeto navidenio A3? " + nav3.esAbetoNavidenio()); //Yes
	}

}
