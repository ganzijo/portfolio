package com.nuriapp.serial;

public class SerialReceiveConfig {
	// Receive
	public static byte[][] receiveData = new byte[3][4096];
	// Header & Tail
	public static final int HEADER_LENGTH = 11; // Header 추가로 인한 +11
	public static final int TAIL_LENGTH = 2;
	public static final int HEADER_TAIL_LENGTH = HEADER_LENGTH + TAIL_LENGTH; // Header 추가로 인한 +11
	public static final int[] length_ReceiveData = {31+HEADER_TAIL_LENGTH, 40+HEADER_TAIL_LENGTH, 21+HEADER_TAIL_LENGTH};
	public static final int[] length_Receive_Payload = {31, 40, 21};
//	public static final int[] length_Receive_Payload = {40, 40, 21};
	// CRC
	public static final int LAST_WITH_CRC_INDEX = 2;
	//Calc
	public static final int SIEX0 = 14+HEADER_LENGTH; 
	public static final int SIEX1 = 24+HEADER_LENGTH; 
	public static final int VALUE_INDEX = 25 + HEADER_LENGTH; 
	public static final int LOGID_INDEX = 22 + HEADER_LENGTH; 
	public static final int RTC_INDEX = 16 + HEADER_LENGTH; 
	public static final int METER_SERIAL_INDEX = 8 + HEADER_LENGTH; 
	
	public static void InitReceiveBuffer()
	{
		for(int i = 0; i < 4096; i++) {
			receiveData[0][i] = 0;
			receiveData[1][i] = 0;
			receiveData[2][i] = 0;
		}
	}
	
	public static byte[] getPayload(int _currentSendDataID){
		byte[] payload = new byte[length_Receive_Payload[_currentSendDataID]];
		for(int i=0; i<payload.length; i++){
			payload[i] = receiveData[_currentSendDataID][i+HEADER_LENGTH];
		}
		
		return payload;
	}
}
