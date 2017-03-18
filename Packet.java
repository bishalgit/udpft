import java.util.Arrays;
import java.io.Serializable;
import java.io.*;

public class Packet implements Serializable {
	private boolean isAck;
	private boolean isPayLoad;
	private boolean isSync;
	private int length;
	private byte[] data;
	private int id;

	public Packet(boolean ack, boolean payL, boolean sync, int i, int l, byte[] d){
		isAck = ack;
		isPayLoad = payL;
		isSync = payL;
		
		this.id = i;
		this.length = l;
		this.data = new byte[512];
		this.data = Arrays.copyOf(d,512);
	}

	public boolean getIsAck () {
		return isAck;
	}

	public boolean getIsPayLoad () {
		return isPayLoad;
	}

	public boolean getIsSync () {
		return isSync;
	}

	public int getLength () {
		return length;
	}

	public byte[] getData () {
		return data;
	}

	public int getId () {
		return id;
	}
	
	public void SerializePacket (String fileName) {
		try{
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved as " + fileName);
		}catch(IOException i){
			i.printStackTrace();
		}
	}

	public void DeSerializePacket (String fileName){
		try{
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			this = (Packet) in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException i){
			i.printStackTrace();
		}catch(ClassNotFoundException c){
			System.out.println("Student class not found");
			c.printStackTrace();
		}
	}

}