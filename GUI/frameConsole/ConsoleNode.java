package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import logic.Constant;
import logic.Message;
import logic.Node;


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
			double exponent = scanner.nextDouble();
			this.node = new Node(Constant.P, numberMachines, base, exponent);
			
			break;
			
		case Constant.S:
			this.node = new Node(Constant.S);

			break;
		}

		this.node.turnOnServer(this.serverPort);
		this.node.turnOnClient(this.clientPort, this.ip);
		System.out.println("----------------------------------------------------------------------");

		this.threadConsoleNode.start();


	}

	@Override
	public void run() {

		while(true){
			System.out.println(" Iniciar? ");
			@SuppressWarnings("resource")
			Scanner scanner1 = new Scanner(System.in);
			switch (scanner1.next()) {
			case "yes":
				this.node.getRightMessages().add(new Message(this.node.weighing(this.node.getNumberMachines(), this.node.getExponent()), this.node.getBase()));
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