import java.net.*;
import java.io.*;

public class MainServer {
	private static final int port = 109; // nice port

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("Listening on port " + port + " failed.");
			e.printStackTrace();
			System.exit(1);
		}

		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("Client did not accept connection.");
			e.printStackTrace();
			System.exit(1);
		}

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		String inputLine, outputLine;
		ComProtocol cp = new ComProtocol();

		outputLine = cp.processInput(null);
		out.println(outputLine);

		while ((inputLine = in.readLine()) != null) {
			outputLine = cp.processInput(inputLine);
			out.println(outputLine);
			if (outputLine.equals("Bye."))
				break;
		}
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();

	}

}