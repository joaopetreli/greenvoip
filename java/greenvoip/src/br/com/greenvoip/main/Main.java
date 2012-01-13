package br.com.greenvoip.main;

import br.com.greenvoip.core.HandleServerSocket;

public class Main {
	public static void main(String[] args) {
		HandleServerSocket handleSocket = new HandleServerSocket();
		handleSocket.handle(5, 9898);
	}
}
