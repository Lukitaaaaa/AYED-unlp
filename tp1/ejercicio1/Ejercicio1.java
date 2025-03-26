package tp1.ejercicio1;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ejercicio1 prueba = new Ejercicio1();
		int valor1 = 1;
		int valor2 = 4;
		Ejercicio1.metodoFor(valor1, valor2);
		Ejercicio1.metodoWhile(valor1, valor2);
		Ejercicio1.metodoSin(1, 9);
	}
	
	public static void metodoFor(int a, int b) {
		int i;
		for(i=a; i<=b;i++) {
			System.out.println(i);
		}
	}
	
	public static void metodoWhile(int a, int b) {
		int i =a;
		while(i<=b) {
			System.out.println(i);
			i++;
		}
	}
	
	public static void metodoSin(int a, int b) {
		System.out.println(a);
		
		if(a<b) {
			a++;
			//System.out.println(a);
			metodoSin(a,b);
		}
	}
}
