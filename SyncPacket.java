public class SyncPacket extends Packet {
	private String fileName;
	private int fileSize;

	public SyncPacket (boolean ack, boolean payL, boolean sync, String fn, int fs) {
		super(ack, payL, sync);
		this.fileName = fn;
		this.fileSize = fs;
	}

	public String getFileName () {
		return fileName;
	}

	public int getFileSize () {
		return fileSize;
	}
}