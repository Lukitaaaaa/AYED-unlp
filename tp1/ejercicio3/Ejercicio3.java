package tp1.ejercicio3;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estudiante[] estudiantes = new Estudiante[2];
		Profesor[] profesores = new Profesor[3];
		
		
		estudiantes[0] = new Estudiante();
		estudiantes[1] = new Estudiante();
		
		profesores[0] = new Profesor();
		profesores[1] = new Profesor();
		profesores[2] = new Profesor();	
		
		for(Estudiante esto:estudiantes)
			System.out.println(esto.tusDatos());
		
		for(Profesor esto:profesores)
			System.out.println(esto.tusDatos());
	}

}
