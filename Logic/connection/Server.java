package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import node.Node;
import task.Message;
import task.Potencia;

public class Server implements Runnable{

	private int port;
	private Node node;

	private Socket socket;
	private ServerSocket serverSocket;
	private Thread threadServer;
	private String status;
	private ArrayList<Message> leftMessages;
	private ArrayList<Message> rightMessages;

	private ObjectInputStream objectInputStream;

	private ServerWrite serverWrite;

	private Thread thread;

	public Server(int port, Node node) throws IOException {

		this.status = Constant.WAITING;

		this.port = port;
		this.node = node;

		this.serverSocket = new ServerSocket(this.port);
		this.threadServer = new Thread(this);

		this.rightMessages = node.getRightMessages();
		this.leftMessages = node.getLeftMessages();
	}

	private void calculate(){
		this.thread = new Thread(new Runnable() {
			Potencia potencia = new Potencia();
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				while(true){
					potencia.setBase(node.getBase());
					potencia.setExponent(node.getExponent());
					String result = String.valueOf(potencia.elv());
					System.out.println("Resultado del nodo: " + result);
					node.getRightMessages().add(new Message(Constant.RESULT, result));
					thread.stop();
				}
			}
		});
		thread.start();
	}

	private void waiting(){
		try {
			this.socket = this.serverSocket.accept();
			this.objectInputStream = new ObjectInputStream(this.socket.getInputStream());
			this.status = Constant.LISTENING;
			this.serverWrite = new ServerWrite(this);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}		
	}

	private void s(Message message){
		switch (message.getType()) {
		case Constant.CHECK:
			this.node.setBase(message.getBase());
			this.node.setExponent(message.getExponent().get(0));
			//---------------------------------------------------------
			System.out.println("Info node\nBase: " + this.node.getBase() + "\nExponent: " + this.node.getExponent());
			//---------------------------------------------------------
			message.getExponent().remove(0);
			this.node.getRightMessages().add(message);
			this.calculate();
			break;
		case Constant.RESULT:
			this.node.getRightMessages().add(message);
			break;
		}
	}

	private void p(Message message){
		switch (message.getType()) {
		case Constant.RESULT:
			System.out.println("Resultado que llega: " + message.getResult());
			this.node.getResults().add(message.getResult());
			if (this.node.getResults().size() == this.node.getNumberMachines()) {
				double result  = 1;
				for (int i = 0; i < this.node.getNumberMachines(); i++) {
					result *= Double.parseDouble(this.node.getResults().get(i));
				}
				System.out.println("Resultado final " + result);
				this.node.setResults(new ArrayList<>());
			}
			break;
		case Constant.CHECK:
			System.out.println("Nodos listos");
			break;
		}
	}

	private void listening(){
		try {
			Message message = (Message) this.objectInputStream.readObject();
			switch (this.node.getType()) {
			case Constant.P:
				this.p(message);
				break;
			case Constant.S:
				this.s(message);
				break;
			}
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("No escucha: " + e.getMessage());
		}
	}


	private void server() {
		switch (this.status) {
		case Constant.WAITING:
			this.waiting();
			break;
		case Constant.LISTENING:
			this.listening();
			break;
		}
	}

	@Override
	public void run() {
		while(true){
			this.server();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ArrayList<Message> getLeftMessages() {
		return leftMessages;
	}

	public void setLeftMessages(ArrayList<Message> leftMessages) {
		this.leftMessages = leftMessages;
	}

	public ArrayList<Message> getRightMessages() {
		return rightMessages;
	}

	public void setRightMessages(ArrayList<Message> rightMessages) {
		this.rightMessages = rightMessages;
	}

	public ObjectInputStream getObjectInputStream() {
		return objectInputStream;
	}

	public void setObjectInputStream(ObjectInputStream objectInputStream) {
		this.objectInputStream = objectInputStream;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public Thread getThreadServer() {
		return threadServer;
	}

	public void setThreadServer(Thread threadServer) {
		this.threadServer = threadServer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ServerWrite getServerWrite() {
		return serverWrite;
	}

	public void setServerWrite(ServerWrite serverWrite) {
		this.serverWrite = serverWrite;
	}

}
