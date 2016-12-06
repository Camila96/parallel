package node;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import connection.Client;
import connection.Server;
import task.Message;

public class Node {

	private ArrayList<Message> leftMessages;
	private ArrayList<Message> rightMessages;
	private double base;
	private double exponent;
	private int numberMachines;

	private Server server;
	private Client client;
	private String type;

	public Node(String type, int numberMachines, double base, double exponent) {
		this.type = type;
		this.numberMachines = numberMachines;
		this.base = base;
		this.exponent = exponent;
		this.leftMessages = new ArrayList<Message>();
		this.rightMessages = new ArrayList<Message>();
		this.server = null;
		this.client = null;
	}

	public Node(String type) {
		this.type = type;
		this.leftMessages = new ArrayList<Message>();
		this.rightMessages = new ArrayList<Message>();
		this.server = null;
		this.client = null;
	}

	public ArrayList<Double> weighing(int numberMachine, double exponent){
		ArrayList<Double> arrayList = new ArrayList<Double>();
		arrayList.add(3.2);
		arrayList.add(3.2);
		arrayList.add(1.6);
		return arrayList;
	}



	public void turnOnServer(int port) throws IOException{
		this.server = new Server(port, this);
		this.server.getThreadServer().start();
	}

	public void turnOnClient(int port, String ip) throws UnknownHostException, IOException{

		this.client = new Client(port, ip, this);
		this.client.getThreadClient().start();
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getExponent() {
		return exponent;
	}

	public void setExponent(double exponent) {
		this.exponent = exponent;
	}

	public int getNumberMachines() {
		return numberMachines;
	}

	public void setNumberMachines(int numberMachines) {
		this.numberMachines = numberMachines;
	}

	public ArrayList<Message> getLeftMessages() {
		return leftMessages;
	}

	public void setLeftMessages(ArrayList<Message> leftMessages) {
		this.leftMessages = leftMessages;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ArrayList<Message> getRightMessages() {
		return rightMessages;
	}

	public void setRightMessages(ArrayList<Message> rightMessages) {
		this.rightMessages = rightMessages;
	}
}