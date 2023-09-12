package com.wipro.eb.service;
import com.wipro.eb.exception.*;
import com.wipro.eb.entity.*;
public class ConnectionService {
	float slabs1[]=new float[] {(float)2.3,(float)4.2,(float)5.5};
	float slabs2[]=new float[] {(float)5.2,(float)6.8,(float)8.3};
	public boolean validate(int currentReading,int previousReading,String type)throws InvalidReadingException,InvalidConnectionType  {
		if(currentReading<previousReading||currentReading<0||previousReading<0) {
			throw new InvalidReadingException("");
		}
		if(! type.toLowerCase().equals("domestic")&&! type.toLowerCase().equals("commercial")) {
			throw new InvalidConnectionType("");
		}
		return true;
	}
	
	public float calculateBillAmt(int currentReading,int previousreading,String type) {
		try {
			validate(currentReading, previousreading, type);
		}
		catch(InvalidReadingException e) {
			return -1;
		}
		catch(InvalidConnectionType e) {
			return -2;
		}
		if(type.toLowerCase().equals("commercial")) {
			return (new Commercial(currentReading, previousreading, slabs2).computeBill());
		}
		return new Domestic(currentReading, previousreading, slabs1).computeBill();
	}
	
	public String generateBill(int currentReading,int previousreading,String type) {
		float res=calculateBillAmt(currentReading, previousreading, type);
		if(res==-1) return "Incorrect reading";
		if(res==-2) return "Invalid Connection Type";
		return "Amount to be Paid:"+res;
	}
	
}
