package com.nuriapp.vo_dontuse;

public class SendFormVO {
	private byte stx=(byte)0x02;
	private byte [] length=new byte[3];
	private byte systemID=(byte)0x01;
	private byte pANaddrH=(byte)0x12;
	private byte pANaddrL=(byte)0x34;
	private byte destinationAddrH;
	private byte destinationAddrL;
	private byte sourceH;
	private byte sourceL;
	private byte sequeunceNum=(byte)0x01;
	private byte [][] payLoad=new byte[3][];
	private byte [] checkSum=new byte[3];
	private byte footerH=(byte)0x00;
	private byte footerL=(byte)0x03;
	
	public void setSource(String source){
	     byte[] buf = new byte[8];
	        this.sourceH = (byte)( (Integer.parseInt(source) >>>8) & 0xFF );
	        this.sourceL = (byte)( (Integer.parseInt(source) >>>0) & 0xFF );
	}
	public void setDestination(String destination){
	     byte[] buf = new byte[8];
	        this.sourceH = (byte)( (Integer.parseInt(destination) >>>8) & 0xFF );
	        this.sourceL = (byte)( (Integer.parseInt(destination) >>>0) & 0xFF );
	}
	
	public void setPayLoad(byte [][] payLoad){
		byte payLoadSum=0;
		byte pCheckSum;
		for(int i=0;i<3;i++){
			payLoadSum=0;
			this.payLoad[i]=payLoad[i];
			this.length[i]=(byte)(13+((this.payLoad[i]).length));
			pCheckSum=(byte) (this.stx+this.length[i]+this.systemID+this.pANaddrH+
					this.pANaddrL+destinationAddrH+destinationAddrL+sourceH+sourceL+
					sequeunceNum+footerH+footerL);
			for(byte j:payLoad[i]){  //payLoad의 합을 계산하기 위한 부분
				payLoadSum+=j;
			}
			pCheckSum+= payLoadSum; //다시 checkSum에 PayLoad의 합을 더해준다.
			pCheckSum=(byte) ((~(pCheckSum))+1);
			this.checkSum[i]=pCheckSum;
		}

	}
	
}

