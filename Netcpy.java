import java.net.*;
import java.io.*;

public class Netcpy{

	public static void main(String[] args) {
		String src_file_name = args[0];
		String des_file_name = args[1];
		String comp_ip = args[2];
		String comp_port = args[3];

		DatagramSocket socket = null;
		try
		{	
			//Read file first
			socket = new DatagramSocket();
			//get bytes
			byte[] m = msg.getBytes();
			InetAddress server_ip = InetAddress.getByName("localhost");
			int server_port = 6789;
			DatagramPacket request = new DatagramPacket(m, m.length, server_ip, server_port);
			//convert to packets
			//send to server
			//find acknowledgement
			socket.send(request);
			System.out.println("message sent toserver....");
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);

			socket.receive(reply);
			System.out.println("message from server: " + new String(reply.getData()));
		}
		catch(SocketException e)
		{
			System.out.println(e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e)
		{
			System.err.println("Unexpected IO ERROR: " + e);	
		}
		finally
		{
			if(socket != null)
				socket.close();
		}
	}
}