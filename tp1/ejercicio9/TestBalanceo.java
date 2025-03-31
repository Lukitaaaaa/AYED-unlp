package tp1.ejercicio9;

import java.util.Stack;

public class TestBalanceo {
	
	public static void main(String[] args) {

        String inputString = args[0];
        boolean balanceado = balanceo(inputString);

        if (balanceado) {
            System.out.println("El string \"" + inputString + "\" está balanceado.");
        } else {
            System.out.println("El string \"" + inputString + "\" NO está balanceado.");
        }
    }
	
	public static boolean balanceo(String s) {
		
		Stack<Character> pila = new Stack<>();
		for (char caracter : s.toCharArray()) {
            if (caracter == '(' || caracter == '[' || caracter == '{') {
                pila.push(caracter);
            } else if (caracter == ')' || caracter == ']' || caracter == '}') {
                if (pila.isEmpty()) {
                    return false; // Cierre sin apertura previa
                }

                char ultimoApertura = pila.pop();
                if ((caracter == ')' && ultimoApertura != '(') ||
                    (caracter == ']' && ultimoApertura != '[') ||
                    (caracter == '}' && ultimoApertura != '{')) {
                    return false; // No coinciden los tipos de paréntesis
                }
            }
        }

        return pila.isEmpty(); // Si la pila está vacía al final, está balanceado
    }
}
