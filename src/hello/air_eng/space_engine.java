package hello.air_eng;

import java.util.ArrayList;
import java.util.HashMap;

import hello.node.nodeBase;

public class space_engine {

	private static space_engine instance = new space_engine();
	public static space_engine getInstance() {
		
		return instance;
	}
	
	
	public boolean registerNode(nodeBase nodeCB) {
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
	
	private HashMap<String, nodeBase> mNodesInfMap = new HashMap<String, nodeBase>();
	private Object mLockNodesInf = new Object();
	
	
	public void space_spread_driver(ArrayList<byte[]> nodesDataSend) {
		
		
	}
	
	
	
	
}
