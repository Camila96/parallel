package testGUI;

import java.io.IOException;

import frameConsole.ConsoleNode;

public class TestJFrameNode {

	public static void main(String[] args) {

		try {
			@SuppressWarnings("unused")
			ConsoleNode consoleNode = new ConsoleNode();
		} catch (IOException e) {
			System.err.println("Message from TestJFrameNode: " + e.getMessage());
		}

	}

}

