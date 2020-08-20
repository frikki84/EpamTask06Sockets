package by.epamtc.jwdmay2020.dziadkouskaya.task06.server.controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.ClientServerTransferObject;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.commander.CommandProvider;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.commander.ServiceCommand;

public class ServerController {

	public void createResultString(int portNumber) throws ClassNotFoundException, IOException {

		ServerSocket serverSocket = null;
		Socket clientSocketOnServer = null;
		ObjectInputStream serverReader = null;

		ClientServerTransferObject transferObject = null;

		BufferedWriter serverWriter = null;

		try {

			serverSocket = new ServerSocket(portNumber);

			System.out.println("Server is working!!!");

			clientSocketOnServer = serverSocket.accept();

			serverReader = new ObjectInputStream(clientSocketOnServer.getInputStream());

			transferObject = (ClientServerTransferObject) serverReader.readObject();
			

			final CommandProvider provider = new CommandProvider();

			ServiceCommand command = provider.returnRightCommand(transferObject);

			String resultString = command.createResultString(transferObject);

			serverWriter = new BufferedWriter(new OutputStreamWriter(clientSocketOnServer.getOutputStream()));

			serverWriter.write(resultString);
			serverWriter.flush();

		} finally {
			if (serverReader != null | serverWriter != null | clientSocketOnServer != null | serverSocket != null) {
				try {
					serverReader.close();
					serverWriter.close();
					clientSocketOnServer.close();
					serverSocket.close();

				} catch (Exception e) {
					System.err.println("ServerController error!!!");
				}
			}

		}

	}
}
