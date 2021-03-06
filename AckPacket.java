import java.util.Arrays;
import java.io.*;

public class AckPacket extends Packet {
	private int id;
	private int length;
	private int[] missingIds;

	public AckPacket (boolean ack, boolean payL, boolean sync, int i, int l, int[] d) {
		super(ack, payL, sync);
		this.id = i;
		this.length = l;
		this.data = new int[l];
		this.data = Arrays.copyOf(d,l);
	}

	public int getId () {
		return id;
	}

	public int getLength () {
		return length;
	}

	public int[] getMissingIds () {
		return missingIds;
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
			this = (AckPacket) in.readObject();
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