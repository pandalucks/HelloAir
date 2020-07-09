package hello.air_eng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import hello.node.nodeBase;
import hello.node.node_tx_rx_inf;

public class time_engine {
	
	public static int MINI_TIME_UNIT = 1000;
	
	private static volatile time_engine instance = new time_engine();
	public static time_engine getInstance() {
		
		return instance;
	}
	

	private HashMap<String, nodeBase> mNodesInfMap = new HashMap<String, nodeBase>();
	private Object mLockNodesInf = new Object();
	
	
	public boolean registerNode(nodeBase nodeCB) {
		//����Ƿ����ظ��ڵ�
		String uuid = nodeCB.getUuid();
		synchronized(mLockNodesInf) {
			mNodesInfMap.put(uuid, nodeCB);
		}
		return true;
	}
	
	public boolean unregisterNode(nodeBase nodeCB) {
		String uuid = nodeCB.getUuid();
		synchronized(mLockNodesInf) {
			mNodesInfMap.remove(uuid);
		}
		return true;
		
	}
	
	
	private long mUnitCount = 0;
	private void driveMiniTimeUnit() {
		space_engine se = space_engine.getInstance();
		
		synchronized(mLockNodesInf) {
			Iterator iter = mNodesInfMap.entrySet().iterator();
			while(iter.hasNext()) {
				Map.Entry<String, nodeBase> entry = (Map.Entry<String, nodeBase>)iter.next();
				nodeBase node = entry.getValue();
				
				//todo 
				//��һ��miniTimeUnit�ŵ�״̬����Ҫ����space�����˹�ϵ��ȡ������˴��򻯴�����ʱΪfalse
				byte[] nodeDataSend = node.time_drive_tx(mUnitCount ,false);		//node�Ƿ������ݷ��ͣ�
				
				//���нڵ� ��������
			}
			
			//����ڵ㷢�����ݣ����ܴ���
			
			// �����͵����� ת�� space_engine ���� 
			se.space_spread_driver(new ArrayList<byte[]>()); // ???????
			
			System.out.println("driveMiniTimeUnit: done one time: " + mUnitCount);
			
		}
		mUnitCount++;
	}
	
	private boolean mTimeDriveFlag = false;
	//Thread: time driver
	private Thread mTimeDriveThread = new Thread() {
		@Override
		public void run() {
			System.out.println("TimeDriveThread start :");
			
			while(mTimeDriveFlag) {
				
				driveMiniTimeUnit();
				
				try {
					Thread.sleep(2000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	};
	
	
	public void startTimeEngine() {
		mTimeDriveFlag = true;
		mTimeDriveThread.start();
	}
	
	
	

}
