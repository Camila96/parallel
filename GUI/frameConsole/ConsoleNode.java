package frameConsole;

import java.io.IOException;
import java.util.Scanner;
import connection.Constant;
import node.Node;
import task.Message;

public class ConsoleNode implements Runnable{

	private Thread threadConsoleNode;
	private int serverPort;
	private int clientPort;
	private String ip;
	private Scanner scanner;
	private Node node;


	public ConsoleNode() throws IOException {

		this.threadConsoleNode = new Thread(this);	
		this.scanner = new Scanner(System.in);
		System.out.println("--------------------------- Informacion local ---------------------------");
		System.out.println("NODE IP: " + Constant.findIp());
		System.out.println("--------------------------Conectarse a otro host------------------------------");
		System.out.print("Client ip: ");
		this.ip = this.scanner.next();
		System.out.println("----------------------------------------------------------------------");
		System.out.print("Server port: ");
		this.serverPort = this.scanner.nextInt();
		System.out.print("Client port: ");
		this.clientPort = this.scanner.nextInt();
		System.out.println("--------- Digite si la maquina es principal(p) o suplente(s) ----------");
		switch (scanner.next()) {
		case Constant.P:
			System.out.println("Digite numero de maquinas");
			int numberMachines = scanner.nextInt();
			System.out.println("Digite la base");
			double base = scanner.nextDouble();
			System.out.println("Digite el exponente");
			Integer exponent = scanner.nextInt();
			this.node = new Node(Constant.P, numberMachines, base, exponent);
			this.threadConsoleNode.start();
			break;
		case Constant.S:
			this.node = new Node(Constant.S);
			break;
		}
		this.node.turnOnServer(this.serverPort);
		this.node.turnOnClient(this.clientPort, this.ip);
		System.out.println("----------------------------------------------------------------------");
	}

	@Override
	public void run() {
		while(true){
			System.out.println(" Start? ");
			@SuppressWarnings("resource")
			Scanner scanner1 = new Scanner(System.in);
			switch (scanner1.next()) {
			case "yes":
				this.node.getRightMessages().add(new Message(Constant.CHECK, this.node.weighing(this.node.getNumberMachines(), this.node.getExponent()), this.node.getBase()));
				break;
			case "no":
				System.exit(0);
				break;
			default: 
				System.out.println("No valido");
				break;
			}
		}
	}
}