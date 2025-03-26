package tp1.ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n =s.nextInt();
		int[] array = null;
		Ejercicio2.metodo(n, array);

	}
	
	public static int[] metodo(int n, int[] a) {
		a = new int[n];
		for (int i=0; i<n; i++) {
			a[i]= (i+1)*n;
			System.out.println(a[i]);
		}
		return a;
	}
}