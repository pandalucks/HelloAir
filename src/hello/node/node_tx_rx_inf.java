package hello.node;

public interface node_tx_rx_inf {

	public byte[] time_drive_tx(long unitCount, boolean lastMiniChnlState);
	public void space_driver_rx(byte[] buf, int len);

}
