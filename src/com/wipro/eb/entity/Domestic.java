package com.wipro.eb.entity;
public class Domestic extends Connection{
	
	public Domestic(int currentReading,int previousReading,float slabs[]) {
		super(currentReading,previousReading,slabs);
	}
	public float computeBill() {
		float res=0;
		if(currentReading<=50) {
		res= (float)currentReading*(float)2.3;
		return res;
		}
		res+=50*2.3;
		currentReading-=50;
		if(res<=50) {
			res= (float) res+((float)currentReading*(float)4.2);
			return res;
		}
		res+=50*4.2;
		currentReading-=50;
		res=res+(float)currentReading*(float)5.5;
		return res;
	}
}
