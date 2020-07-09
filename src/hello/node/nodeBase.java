package hello.node;

import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public class nodeBase implements node_tx_rx_inf {
	
	private static int node_count = 0;
	private String uuid;
	private int mac;
	
	
	private ConcurrentLinkedQueue mAirSendQueue = new ConcurrentLinkedQueue();
	private byte[] mAirSendArray = new byte[8192];
	
	
	
	public nodeBase() {
		uuid = UUID.randomUUID().toString();
		mac = node_count ++;
		
		System.out.println("nodeBase: mac=" + mac + ",uuid=" + uuid);
		//������ ע�� �տ�callback
		
	}
	
	public String getUuid() {
		return uuid;
	}
	
	
	public byte[] time_drive_tx(long unitCount, boolean lastMiniChnlState) {
		System.out.println("time_drive_tx: mac=" + mac);
		
		if(mAirSendQueue.isEmpty()) {
			return (byte[])mAirSendQueue.poll();
		}else {
			return null;
		}
		
	}
	
	public void space_driver_rx(byte[] buf, int len) {
		System.out.println("space_driver_rx: mac=" + mac);

		
	}
	
	
	//Thread �����������
	
	
	//Thread ���������� ����
	

	//Runnable �ڵ㴦���߼�
	
	
}
