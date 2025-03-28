package tp1.ejercicio7;

import java.util.*;
//import java.util.stream.Collectors;


public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> valores = new ArrayList<Integer>();
		int i;
		for(i=0; i<args.length; i++)
			valores.add(Integer.parseInt(args[i]));
		
		for(i=0; i < valores.size(); i++)
            System.out.println(valores.get(i));
		
		System.out.println("Punto B");
		
		List<Integer> valores2 = new LinkedList<Integer>();
		
		for(i=0; i<args.length; i++)
			valores2.add(Integer.parseInt(args[i]));
		
		for(i=0; i< valores2.size(); i++)
			System.out.println(valores2.get(i));
		
		System.out.println("Punto C");
		
        for(Integer I: valores) // For Each
            System.out.println(I);
        
        System.out.println("Punto D");
        
        puntoD();
        
        ArrayList<Integer> miLista = new ArrayList<>();
        
        for(i=0; i<6; i++)
            miLista.add(i);
        boolean capicua = esCapicua(miLista);
        System.out.println(capicua ? "Es capicua" : "No es capicua");
        
        
	}
	public static void puntoD() {
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		Estudiante student = new Estudiante();
		estudiantes.add(student);
		estudiantes.add(student);
		estudiantes.add(student);
		
		List<Estudiante> estudiantes2 = estudiantes;
		
		for(Estudiante e: estudiantes)
        	System.out.println(e.tusDatos());
        
        for(Estudiante e: estudiantes2)
        	System.out.println(e.tusDatos());
        
        estudiantes.get(0).setApellido("Perez");
        
        for(Estudiante e: estudiantes)
        	System.out.println(e.tusDatos());
        
        for(Estudiante e: estudiantes2)
        	System.out.println(e.tusDatos());
        
        // Conclusiones: todo objeto que se modifique también se verá afectado en cualquier otra estructura a la que pertenezca.
        
        // Formas de copiar una lista
        // Mediante addAll(): también es una copia superficial (no duplica nada, sigue usando las mismas referencias);
        List<Estudiante> copiaAddAll = new ArrayList<>();
        copiaAddAll.addAll(estudiantes);
        
        // Con List.copyOf(): crea una lista inmutable (no se pueden agregar ni modificar elementos) y también copia superficialmente;
        //List<Estudiante> copiaCopyOf = List.copyOf(estudiantes);
        
        // Utilizando clone(): solo disponible para ArrayList;
        //ArrayList<Estudiante> copiaClone = (ArrayList<Estudiante>) ((ArrayList<Estudiante>) estudiantes).clone();
        
        // Copia profunda con stream() y map(): copia NO SUPERFICIAL, crea una copia independiente de cada objeto;
        //List<Estudiante> copiaProfunda = estudiantes.stream()
        //        .map(Estudiante -> new Estudiante())
        //        .collect(Collectors.toList());
        
        //punto E
        Estudiante nuevo = new Estudiante();
        nuevo.setApellido("Mendoza");
        nuevo.setNombre("Nicoloas");
        
        if(!estudiantes.contains(nuevo))
        	estudiantes.add(nuevo);
	}
	
	public static boolean esCapicua(ArrayList<Integer> lista) {
		boolean ok = lista.size() > 0;
        int pri = 0;
        int ult = lista.size() - 1;
        while((ok)&&(pri<ult))
            if(!Objects.equals(lista.get(pri++), lista.get(ult--)))
                ok = false;
        return ok;
	}
	
	public static List<Integer> calcularSucesion (int n){
		List<Integer> lista = new ArrayList<>();
		aux(n, lista);
		return lista;
	}
	
	private static List<Integer> aux(int n, List<Integer> l){
		l.add(n);
		if(n % 2 == 0)
			aux(n / 2, l);
		else
			aux(n * 3 + 1, l);
		return l;
	}
	
	public void invertirArrayList(ArrayList<Integer> lista) {
		invertirArrayListAux(lista,0,lista.size()-1);
	}
	
	public static void invertirArrayListAux(ArrayList<Integer> lista, int ini, int fin) {
        if(ini < fin) {
            Integer aux = lista.get(ini);
            lista.set(ini, lista.get(fin));
            lista.set(fin, aux);
            invertirArrayListAux(lista,++ini,--fin);
        }
    }
	
	public int sumarLinkedList(LinkedList<Integer> lista) {
		return sumarLinkedListAux(lista,0);
	}
	
	public static int sumarLinkedListAux(LinkedList<Integer> lista, int pos) {
        if(pos < lista.size())
            return lista.get(pos) + sumarLinkedListAux(lista,++pos);
        else
            return 0;
    }
	
	public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        ArrayList<Integer> l = new ArrayList<>();
        while(!l1.isEmpty() & !l2.isEmpty()) {
            if(l1.getFirst() <= l2.getFirst()) {
                l.add(l1.get(0));
                l1.remove(0);
            } else {
                l.add(l2.get(0));
                l2.remove(0);
            }
        }
        while(!l1.isEmpty()) {
            l.add(l1.get(0));
            l1.remove(0);
        }
        while(!l2.isEmpty()) {
            l.add(l2.get(0));
            l2.remove(0);
        }
        return l;
    }
}
