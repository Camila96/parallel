package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import node.Node;
import task.Message;

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

	public Server(int port, Node node) throws IOException {

		this.status = Constant.WAITING;

		this.port = port;
		this.node = node;

		this.serverSocket = new ServerSocket(this.port);
		this.threadServer = new Thread(this);

		this.rightMessages = node.getRightMessages();
		this.leftMessages = node.getLeftMessages();
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

	private void listening(){
		try {
			Message message = (Message) this.objectInputStream.readObject();
			switch (this.node.getType()) {
			case Constant.P:

				break;
			case Constant.S:
				this.node.setBase(message.getBase());
				this.node.setExponent(message.getExponent().get(0));
				System.out.println(message.toString());
				message.getExponent().remove(0);
				this.node.getRightMessages().add(message);
				break;
			default:
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
