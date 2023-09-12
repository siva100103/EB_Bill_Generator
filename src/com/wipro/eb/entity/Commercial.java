package com.wipro.eb.entity;

public class Commercial extends Connection{

	public Commercial(int currentReading,int previousReading,float slabs[]) {
		super(currentReading,previousReading,slabs);
	}
	public float computeBill() {
		float res=0;
		if(currentReading<=50) {
		res= (float)currentReading*(float)5.2;
		if(res>=10000) res=(float) (res+(res*0.09));
		else if(res>=5000) res=(float)(res+(res*0.06));
		else res=(float)(res+(res*0.02));
		return res;
		}
		res+=50*5.2;
		currentReading-=50;
		if(res<=50) {
			res= (float) res+((float)currentReading*(float)6.8);
			if(res>=10000) res=(float) (res+(res*0.09));
			else if(res>=5000) res=(float)(res+(res*0.06));
			else res=(float)(res+(res*0.02));
			return res;
		}
		res+=50*6.8;
		currentReading-=50;
		res=res+(float)currentReading*(float)8.3;
		if(res>=10000) res=(float) (res+(res*0.09));
		else if(res>=5000) res=(float)(res+(res*0.06));
		else res=(float)(res+(res*0.02));
		return res;
	}

}
