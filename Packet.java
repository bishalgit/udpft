import java.io.Serializable;

public class Packet implements Serializable {
	private boolean isAck;
	private boolean isPayLoad;
	private boolean isSync;

	public Packet(boolean ack, boolean payL, boolean sync){
		isAck = ack;
		isPayLoad = payL;
		isSync = sync;
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
}