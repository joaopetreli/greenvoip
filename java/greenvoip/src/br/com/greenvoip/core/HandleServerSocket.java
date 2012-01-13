package br.com.greenvoip.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HandleServerSocket {

	private boolean stop = false;
	private static final int TIMEOUT_TASK_FINISH = 10;
	
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
		
			System.out.println("Wainting task(s) finish.");
			executorService.awaitTermination(TIMEOUT_TASK_FINISH, TimeUnit.SECONDS);
			serverSocket.close();
		} catch (IOException e) {
			System.err.println("Could not listen at port: " + port);
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println("An error ocurr while waiting task(s) finish.");
			e.printStackTrace();
		}
	}
}