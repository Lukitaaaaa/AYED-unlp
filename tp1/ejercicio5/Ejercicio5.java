package tp1.ejercicio5;

public class Ejercicio5 {
	
	static String RESULTADOS; //Las variables estaticas son como las variables golbales

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] valores = {5, 2, 8, 1, 9, 3};
		
		int[] resultadosReturn = calcularMaxMinPromReturn(valores);
		
		System.out.println("Max: "+ resultadosReturn[0]);
		System.out.println("Min: "+resultadosReturn[1]);
		System.out.println("Prom: "+resultadosReturn[2]);
		
		Resultado resultados = new Resultado();
		calcularMaxMinPromParametro(valores, resultados);
		System.out.println(resultados.toString());
		
		calcularMaxMinProm(valores);
		System.out.println(RESULTADOS);
	}
	
	public static int[] calcularMaxMinPromReturn(int[] v) {
		int[] resultados = new int[3];
		
		int max = 0;
		int min = 9999999;
		int promedio = 0;
		for (int elem: v) {
			//System.out.println(elem < max);
			if(elem > max)
				max = elem;
			if(elem < min)
				min = elem;
			promedio += elem;
		}
		//System.out.println(v.length);
		resultados[0] = max;
		resultados[1] = min;
		resultados[2] = promedio / v.length;
		return resultados;
	}
	
	public static void calcularMaxMinPromParametro(int[] v, Resultado res) {
		
		int max = 0;
		int min = 9999999;
		int promedio = 0;
		for (int elem: v) {
			//System.out.println(elem < max);
			if(elem > max)
				max = elem;
			if(elem < min)
				min = elem;
			promedio += elem;
		}
		
		res.setMax(max);
		res.setMin(min);
		res.setProm(promedio);
	}
	
	
	public static void calcularMaxMinProm(int[] v) {
		int max = 0;
		int min = 9999999;
		int promedio = 0;
		for (int elem: v) {
			//System.out.println(elem < max);
			if(elem > max)
				max = elem;
			if(elem < min)
				min = elem;
			promedio += elem;
		}
		
		setString("Resultados, max: "+max+ " min: "+ min + " prom: "+promedio);
	}
	
	public static void setString (String res) {
		RESULTADOS = res;
	}
}
