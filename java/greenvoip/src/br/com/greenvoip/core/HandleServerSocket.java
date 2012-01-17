package br.com.greenvoip.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import br.com.greenvoip.util.Tools;

public class HandleServerSocket {

	private boolean stop = false;
	private static final int TIMEOUT_TASK_FINISH = 10;
	
	private int threadPoolSize = 5;
	private int port = 8080;
	
	public HandleServerSocket() {
		init();
	}
	
	private void init() {
		Tools tools = new Tools();
		
		int poolSizeTmp = tools.getIntegerParameter("ThreadPoolSize");
		int portTmp = tools.getIntegerParameter("Port");
		
		if (poolSizeTmp != 0) {
			threadPoolSize = poolSizeTmp;
		}
		
		if (portTmp != 0) {
			port = portTmp;
		}
	}
	
	private ExecutorService getExecutor(int threadPoolSize) {
		ExecutorService executorService;
		
		if (threadPoolSize > 0) {
			executorService = Executors.newFixedThreadPool(threadPoolSize);
		} else {
			executorService = Executors.newCachedThreadPool();
		}
		
		return executorService;
	}

	public void handle() {
		ExecutorService executorService = getExecutor(threadPoolSize);
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server was started successfully.");
			
			while (stop  == false) {
				Socket socket = serverSocket.accept();
				System.out.println("Handling connection from " + socket.getRemoteSocketAddress());
				
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