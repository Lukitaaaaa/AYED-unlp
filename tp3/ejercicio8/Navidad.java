package tp3.ejercicio8;

import tp3.ejercicio3.GeneralTree;
import java.util.List;

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
		return cantHojas <= 3;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
