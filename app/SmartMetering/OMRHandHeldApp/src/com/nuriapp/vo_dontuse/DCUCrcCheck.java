package com.nuriapp.vo_dontuse;

import com.nuriapp.crc.CrcVO;

public class DCUCrcCheck {
	CrcVO crcVO;
	
	public DCUCrcCheck(){
		crcVO = new CrcVO();
	}
	
	// CMD, MeterId 넣고 XOR값 넣기
	public byte DCUGetCrc(byte[] crcInput, int length) {
		// TODO Auto-generated method stub	byte sum = 0;
		byte sum = 0x00;
		for (int cnt = 0; cnt < length ; cnt++) {
			sum ^= crcInput[cnt];
		}
		return sum;
	}
	//CMD, MeterID, MeteringDate, MonthBill
	public boolean DCUVerifyCrc(byte[] pszBuffer, int nLength){
		//넘겨준 CMD, MeterID, MeteringDate, MonthBill값 계산하기
		// CDM
		
		
		
		return true;
	}
}

/*public static String DcuGetCrc(byte[] bytes) {
	byte sum = 0;
	for (int cnt = 0; cnt < crcCheckBuf[1].length; cnt++) {
		sum ^= crcCheckBuf[1][cnt];
	}
	return String.format("0x%x", sum);
}*/

