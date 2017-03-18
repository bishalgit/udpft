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
}