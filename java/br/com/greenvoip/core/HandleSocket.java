package br.com.greenvoip.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandleSocket {

	private boolean stop = false;
	
	private ExecutorService getExecutor(int threadPoolSize) {
		ExecutorService executorService;
		
		if (threadPoolSize > 0) {
			executorService = Executors.newFixedThreadPool(threadPoolSize);
		} else {
			executorService = Executors.newCachedThreadPool();
		}
		
		return executorService;
	}

	public void handle(int threadPoolSize, int port) {
		ExecutorService executorService = getExecutor(threadPoolSize);
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			
			while (stop  == false) {
				Socket socket = serverSocket.accept();
				SocketThread socketThread = new SocketThread(socket);
				executorService.execute(socketThread);
			}
			
			serverSocket.close();
		} catch (IOException e) {
			System.out.println("Could not listen at port: " + port);
			e.printStackTrace();
		}

		executorService.shutdown();
	}
}
