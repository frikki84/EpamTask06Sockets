package by.epamtc.jwdmay2020.dziadkouskaya.task06.client.service.serverlink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.net.UnknownHostException;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.ClientServerTransferObject;

public class ServerLink {
	public static final String INTERNET_ADDRESS = "localhost";

	private int portLink;
	private String address;
	private Socket clientSocket = null;

	public ServerLink() {
		super();
		this.address = INTERNET_ADDRESS;
	}

	public ServerLink(int portLink) throws UnknownHostException, IOException {
		super();
		this.address = INTERNET_ADDRESS;
		this.portLink = portLink;
		this.clientSocket = new Socket(address, portLink);
	}

	public ServerLink(int portLink, String address) throws UnknownHostException, IOException {
		super();
		this.portLink = portLink;
		this.address = address;
		this.clientSocket = new Socket(address, portLink);
	}

	public int getPortLink() {
		return portLink;
	}

	public void setPortLink(int portLink) {
		this.portLink = portLink;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public String workWithServer(ClientServerTransferObject transferObject) throws IOException {

		ObjectOutputStream writer = null;

		BufferedReader clientReader = null;

		String resultString = "";

		try {

			writer = new ObjectOutputStream(getClientSocket().getOutputStream());

			writer.writeObject(transferObject);

			clientReader = new BufferedReader(new InputStreamReader(getClientSocket().getInputStream()));

			StringBuilder builder = new StringBuilder();

			String line;

			while ((line = clientReader.readLine()) != null) {

				builder.append(line + "\n");
			}

			resultString = builder.toString();

		} finally {

			if (writer != null | clientReader != null | clientSocket != null) {
				try {
					writer.close();
					clientReader.close();
					clientSocket.close();

				} catch (Exception e) {
					System.err.println("ServerLink error!!!");
				}

			}

		}

		return resultString;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((clientSocket == null) ? 0 : clientSocket.hashCode());
		result = prime * result + portLink;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServerLink other = (ServerLink) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (clientSocket == null) {
			if (other.clientSocket != null)
				return false;
		} else if (!clientSocket.equals(other.clientSocket))
			return false;
		if (portLink != other.portLink)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass() + " [portLink=" + portLink + ", address=" + address + ", clientSocket=" + clientSocket + "]";
	}

	
	
	
}
