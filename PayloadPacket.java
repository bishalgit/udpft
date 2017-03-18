import java.util.Arrays;
import java.io.*;

public class PayloadPacket extends Packet {
	private int id;
	private int length;
	private byte[] data;

	public PayloadPacket (boolean ack, boolean payL, boolean sync, int i, int l, byte[] d) {
		super(ack, payL, sync);
		this.id = i;
		this.length = l;
		this.data = new byte[l];
		this.data = Arrays.copyOf(d,l);
	}

	public int getId () {
		return id;
	}

	public int getLength () {
		return length;
	}

	public byte[] getData () {
		return data;
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
			this = (PayloadPacket) in.readObject();
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