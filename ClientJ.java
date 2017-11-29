import java.io.*;
import java.net.*;

public class ClientJ {
	public static void main(String[] args) {
		String message = null;
		
		try {
			BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
			Socket csock = new Socket("192.168.62.132", 57177);
			DataOutputStream outNet = new DataOutputStream(csock.getOutputStream());
			BufferedReader inNet = new BufferedReader(new InputStreamReader(csock.getInputStream()));
			
			message = kbd.readLine();
			outNet.writeBytes(message + "\n");
			
			message = inNet.readLine();
			csock.close();
			
			System.out.println("Server sent: " +message);
		}
		
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}