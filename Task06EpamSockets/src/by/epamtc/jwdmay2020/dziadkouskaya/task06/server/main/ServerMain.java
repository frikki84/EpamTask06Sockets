package by.epamtc.jwdmay2020.dziadkouskaya.task06.server.main;

import java.io.IOException;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.server.controller.ServerController;


public class ServerMain {
	public static final int portNumber = 4004;
	
	public static void main(String[] args) {
		ServerController controller = new ServerController();
		
		try {
			controller.createResultString(portNumber);
	 
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
