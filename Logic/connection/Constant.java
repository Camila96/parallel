package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Constant{
	public static final String P ="p";
	public static final String S ="s";

	
	
	public static final String LEFT = "LEFT";
	public static final String RIGHT = "RIGHT";
	public static final String WEIGHING = "weighing";

	public static final String ON = "ON";

	public static final String WAITING = "WAITING";
	public static final String SEARCHING = "SEARCHING";
	public static final String CONNECTED = "CONNECTED";
	public static final String LISTENING = "LISTENING";

	public static final String SERVER = "SERVER";
	public static final String CLIENT = "CLIENT";

	public static final String OPEN = "OPEN";
	public static final String CLOSE = "CLOSE";


	public static final String REAL = "REAL";
	public static final String CHECK = "CHECK";
	public static final String COME_BACK = "COME_BACK";

	public static final String WAITING_PROCESS = "Esperando proceso";
	
	public static final int TIME = 5000;

//	public static void Power(){
//		try{
//			Process p;
//			Runtime app = Runtime.getRuntime();
//			p = app.exec(" java -jar pote.jar "++" "+exponent);
//			InputStream is = p.getInputStream();
//			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//			String aux ;
//			do {
//				aux = reader.readLine();
//				if (aux != null) {
//					System.out.println(aux);
//
//				}
//
//			} while (aux != null);
//
//		} catch (IOException e) {
//		}
//	}
	public static void waitThread(){
		try {
			Thread.sleep(Constant.TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String findIp() throws UnknownHostException{
		return InetAddress.getLocalHost().getHostAddress();
	}
	//	wlp3s0 enp0s3	
//	public static String findIp(){
//		NetworkInterface networkInterface;
//		InetAddress ia = null;
//		try {
//			networkInterface = NetworkInterface.getByName("enp0s3");
//			Enumeration<InetAddress> inetAddress = networkInterface.getInetAddresses();
//			while (inetAddress.hasMoreElements()) {
//				ia = inetAddress.nextElement();
//				if (!ia.isLinkLocalAddress()) {
//				}
//			}
//		} catch (SocketException e) {
//			e.printStackTrace();
//		}
//		return ia.getHostAddress();
//	}
}
