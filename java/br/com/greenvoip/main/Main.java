package br.com.greenvoip.main;

import br.com.greenvoip.core.HandleSocket;

public class Main {
	public static void main(String[] args) {
		HandleSocket handleSocket = new HandleSocket();
		handleSocket.handle(5, 9898);
	}
}
