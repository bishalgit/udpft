import java.net.*;
import java.io.*;
import java.nio.file.*;

public class Netcpy{

	public static void main(String[] args) {
		File temp = new File(args[0]);
		if (temp.exists()) {
			System.out.println("File " + args[0] + " exists!");
			System.out.println("****File details: ****");
			System.out.println("File Name: " + temp.getName());
			System.out.println("Absolute File Name: " + temp.getAbsoluteFile());

			System.out.println("Reading File...");
			try{
				FileHandle readFH = new FileHandle(temp);
				Path outputPath = Paths.get("save/output.mp4");
				Files.createFile(outputPath);
				FileOutputStream fOS = new FileOutputStream(new File("save/output.mp4"),true);
				
				while(!readFH.getIsReadComplete()){
					byte[] bfn = readFH.read();
					//convert into udp packets and start sending operation
					//check if all the packets reach the destination
					//once they reach then start reading again and sending again until
					//all the file is transfered to the destination.
					fOS.write(bfn);					
				}

				fOS.close();
			}catch(FileNotFoundException e){
				System.out.println("File not found"+e.getMessage());
			}catch(IOException e){
				System.out.println("IO: "+e.getMessage());
			}

		}else{
			System.out.println("File "+args[0]+" doesn't exists!");
		}
		/*String src_file_name = args[0];
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
			System.out.println("message sent to server....");
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
		}*/
	}
}