package com.nuriapp.serial;

import java.nio.ByteBuffer;

import com.nuriapp.crc.KmpCrcCheck;

import android.util.Log;

public class SerialCommandConfig {
	public static byte[][] sendData={
	{ (byte)0x3F,(byte)0xB8,(byte)0x02,(byte)0x1,(byte)0x1,(byte)0x4,(byte)0x17,(byte)0x0,(byte)0x1,(byte)0x0,(byte)0x0,(byte)0x0,(byte)0x00}, //9DE3
	{(byte)0X3f,(byte)0Xb8,(byte)0X02,(byte)0X01,(byte)0X02,(byte)0X04,(byte)0X17,(byte)0X00,(byte)0X01,(byte)0X00,(byte)0X01,(byte)0X00,(byte)0X00,(byte)0X00,(byte)0X01}, 
	{(byte) 0x3F, (byte) 0x10,(byte) 0x01, (byte) 0x03, (byte) 0xF2}
	};
//	public static byte[][] sendData02={
//		{ (byte)0x3F,(byte)0xB8,(byte)0x02,(byte)0x1,(byte)0x1,(byte)0x4,(byte)0x17,(byte)0x0,(byte)0x1,(byte)0x0,(byte)0x0,(byte)0x0,(byte)0x01}, //9DE3
//		{(byte)0X3f,(byte)0Xb8,(byte)0X02,(byte)0X01,(byte)0X02,(byte)0X04,(byte)0X17,(byte)0X00,(byte)0X01,(byte)0X00,(byte)0X01,(byte)0X00,(byte)0X00,(byte)0X00,(byte)0X01}, 
//		{(byte) 0x3F, (byte) 0x10,(byte) 0x01, (byte) 0x03, (byte) 0xF2}
//	};
//	public static byte[][] sendData03={
//		{ (byte)0x3F,(byte)0xB8,(byte)0x02,(byte)0x1,(byte)0x1,(byte)0x4,(byte)0x17,(byte)0x0,(byte)0x1,(byte)0x0,(byte)0x0,(byte)0x0,(byte)0x01}, //AD80
//		{(byte)0X3f,(byte)0Xb8,(byte)0X02,(byte)0X01,(byte)0X02,(byte)0X04,(byte)0X17,(byte)0X00,(byte)0X01,(byte)0X00,(byte)0X01,(byte)0X00,(byte)0X00,(byte)0X00,(byte)0x0b}, 
//		{(byte) 0x3F, (byte) 0x10,(byte) 0x01, (byte) 0x03, (byte) 0xF2}
//	};
	
	public static final int HEADER_MODEM_ID_START = 5;
	public static final int HEADER_MODEM_ID_END = 6;
	public static final int src_copy_Start = 22+11; // Header 추가로 인한 +11
//	public static final int src_copy_Start = 31+11; // Header 추가로 인한 +11
	public static final int dest_copy_start = 12-1; // crc를 writeDataTo 함수에서 붙인다. 첫 번째 데이터도 붙이므로 -1을 해줌
	public static  final int startCommand = 0;
	public static KmpCrcCheck kcc = new KmpCrcCheck();
	
	
	public static byte[] getCommand(int _command, short _modemId){		
		byte[] header = {(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0x00,(byte)0x03,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF};
		byte[] payload = get_SendBuffer(sendData[_command]);
//		byte[] payload=null;
//		if(_modemId == 2){
//			payload = get_SendBuffer(sendData02[_command]);
//		}else if(_modemId == 3){
//			payload = get_SendBuffer(sendData03[_command]);
//		}else{
//			payload = get_SendBuffer(sendData02[_command]);
//		}
		byte[] tail = {(byte)0xFF,(byte)0xFF};
		////////////////////////////////////////////////////////////////////////////////////////////////////// Header 완성
		//modem_id를 2바이트로 변환
		ByteBuffer bbuf = ByteBuffer.allocate(2);
		bbuf.putShort(_modemId);
		byte[] modem_id = bbuf.array();
		//modem_id를 header에 대입
		header[HEADER_MODEM_ID_START] = modem_id[0];
		header[HEADER_MODEM_ID_END] = modem_id[1];
		
		///////////////////////////////////////////////////////////////////////////////////////////////////// 명령어 조합
		byte headerCommand[] = new byte[header.length + payload.length +  tail.length];
		//Header
		for(int i =0; i<header.length; i++){
			headerCommand[i] = header[i];
		}
		//Payload
		for(int i =0; i<payload.length; i++){
			headerCommand[header.length+i] = payload[i];
		}
		//Footer
		for(int i =0; i<tail.length; i++){
			headerCommand[header.length+ payload.length+i] = tail[i];
		}
		//Log
//		for(int i =0; i<headerCommand.length; i++){
//			Log.i("header", i + " = " + headerCommand[i]+"");
//		}
		
		return headerCommand;
	}
	
	public static byte[] get_SendBuffer(byte[] crcInput) {

		final int crcSize = crcInput .length;

		short crc = kcc.KmpGetCrc(crcInput , crcInput .length);
		Log.i("crcSize = ", ""+crcSize);
		byte[] sendBuffer = new byte[crcSize+4];

		byte startCRC,endCRC;
		startCRC = (byte)(crc>>8);
		endCRC = (byte)(crc);
		//Log.i("startCRC,endCRC" ,startCRC+","+ endCRC);

		for(int i = 1; i < crcSize+1; i++){
			sendBuffer[i] = crcInput[i-1];
			///Log.i("sendBuffer, crcInput = " ,sendBuffer[i]+","+ crcInput[i-1]);
		}
		sendBuffer[0] = (byte) 0x80;
		sendBuffer[crcSize+1] = startCRC;
		sendBuffer[crcSize+2] = endCRC;
		sendBuffer[crcSize+3] = (byte)0xd;
		for(int i=0;i<crcSize+4;i++){
			//Log.i("","sendBuffer["+i+"]"+sendBuffer[i]+"");
		}
		return sendBuffer;
	}
}


// Network Header ( stx, length, systemID, PANadd, DestinationAddr, SourceAddr, SeqNum
//{(byte)FF,(byte)FF,(byte)FF,(byte)FF,(byte)FF,(byte)00,(byte)03,(byte)FF,(byte)FF,(byte)FF,(byte)FF};

// Tail (CheckSum, Footer)
//{(byte)FF,(byte)03};