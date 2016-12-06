


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import logic.Potencia;

public class comando {
	private static Scanner scanner;
	private static int base;
	private static int exponent;
	
	public static void main(String[] args) {
	scanner = new Scanner(System.in);
//		System.out.println("hola");
//		
//		System.out.println("---------------------------Aplicacion a ejecutar ---------------------------");
//		System.out.println( " 1 : SUMA");
//		Scanner scanner1 = new Scanner(System.in);
//		switch (scanner1.next()) {
//		case "1":

	System.out.print("Base: ");
	base = scanner.nextInt();
	System.out.print("Exponente: ");
	exponent = scanner.nextInt();
		try{
//			String[] cmd ={" java -jar pote.jar base exponent"};
			Process p;
			Runtime app = Runtime.getRuntime();
			p = app.exec(" java -jar pote.jar "+base+" "+exponent);
			InputStream is = p.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String aux ;
			do {
				aux = reader.readLine();
				if (aux != null) {
					System.out.println(aux);

				}

			} while (aux != null);

		} catch (IOException e) {
		}
//			break;
//		}
	}

}
