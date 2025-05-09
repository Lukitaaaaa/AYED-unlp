package tp3.ejercicio9;

import tp3.ejercicio3.GeneralTree;
import java.util.List;

public class ParcialArboles {
	
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		boolean esta =false;
		
		List<GeneralTree<Integer>> children = arbol.getChildren();
		for(GeneralTree<Integer> child: children) {
			if(child.getData() == arbol.getData())
				esta = true;
			esta = esDeSeleccion(child);
		}
			
		if(!esta)
			return false;
		return esta;
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
