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
}