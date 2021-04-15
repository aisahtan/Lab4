package demotcpclienttext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientTextApplication {

	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		
		// Launch client-side frame
		ClientTextFrame clientTextFrame = new ClientTextFrame();
		clientTextFrame.setVisible(true);
		
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Update the status of the connection
		clientTextFrame.updateConnectionStatus(socket.isConnected());
		
		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		BufferedReader bufferedReader2 = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		// Display the current date
		String currentText = bufferedReader.readLine();
		clientTextFrame.updateServerText(currentText);
		
		String wordCount = bufferedReader2.readLine();
		clientTextFrame.updateServerWord(wordCount);
		
		// Close everything
		bufferedReader.close();
		//bufferedReader2.close();
		socket.close();

	}

}

