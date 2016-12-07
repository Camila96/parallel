package testGUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {


	public static String power(String base, String exponent){
		try{
			Process p;
			Runtime app = Runtime.getRuntime();
			p = app.exec(" java -jar pote.jar "+ base +" "+exponent);
			InputStream is = p.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String aux ;
			String result = "";
			do {
				aux = reader.readLine();
				if (aux != null) {
					String string[] = aux.split(";");
					result = string[0];
				}
			} while (aux != null);
			return result;
		} catch (IOException e) {
			return "Message from Constant " + e.getMessage();
		}
	}


	public static void main(String[] args) {
		Test.power(String.valueOf(2), String.valueOf(8));
		
	}
}
