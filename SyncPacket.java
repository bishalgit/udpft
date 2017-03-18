import java.io.*;

public class SyncPacket extends Packet {
	private String fileName;
	private long fileSize;

	public SyncPacket (boolean ack, boolean payL, boolean sync, String fn, long fs) {
		super(ack, payL, sync);
		this.fileName = fn;
		this.fileSize = fs;
	}

	public String getFileName () {
		return fileName;
	}

	public long getFileSize () {
		return fileSize;
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
			this = (SyncPacket) in.readObject();
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