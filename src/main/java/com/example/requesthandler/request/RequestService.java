package com.example.requesthandler.request;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Service;

import com.example.requesthandler.bean.Request;

@Service
public class RequestService {
	private Lock lock = new ReentrantLock();;
	private HashMap<Integer,Request> requestDataMap=new HashMap<>();
	
	private HashMap<Integer,String> requestStatusMap=new HashMap<>();
	
	public  void processRequest(Request req) throws Exception {
		int reqId=req.getRequestId();
		if(lock.tryLock()) {
			if(!requestDataMap.containsKey(reqId)&&!requestStatusMap.containsKey(reqId)){
		
			requestDataMap.put(reqId, req);
			requestStatusMap.put(reqId, "processing");
		}

		Thread.sleep(10000); // for testing multiple hit
		}else {
			throw new Exception("Already processing");
		}
		
	}
	
	
	public  void endRequest(Request req) throws Exception {
		int reqId=req.getRequestId();
			if(!requestDataMap.containsKey(reqId)&&!requestStatusMap.containsKey(reqId)){
				throw new Exception("Data don't exist");
		}
			
		if("processed".equals(requestStatusMap.get(reqId))){
			throw new Exception("Already processed");
	}
		requestStatusMap.put(reqId, "processed");
		
		
	}
	
}


