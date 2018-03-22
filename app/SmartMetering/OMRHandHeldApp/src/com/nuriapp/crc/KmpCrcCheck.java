package com.nuriapp.crc;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class KmpCrcCheck {
	CrcVO crcVO;

	public KmpCrcCheck(){
		crcVO = new CrcVO();
	}
	
	/// <summary>
	/// Function of KMP crc generate.
	/// </summary>
	/// <param name="pszBuffer"></param>
	/// <param name="nLength"></param>
	public short KmpGetCrc(byte[] pszBuffer, int nLength)
	{
		short nCrc = 0x00;
		int i;

		for (i = 0; i<nLength; i++)
		{
			nCrc = (short) ((nCrc << 8) ^ crcVO.CrcTable[(((nCrc >> 8) ^ pszBuffer[i]) & 0xff)]);
		}
		return nCrc;
	}
	
	/// <summary>
	/// Function of KMP crc verify.
	/// </summary>
	/// <param name="pszBuffer"></param>
	/// <param name="nLength"></param>
	public boolean KmpVerifyCrc(byte[] pszBuffer, int nLength)
	{		
		short	nCalcCrc;
		
		//pFrame = (KMP_FRAME_t *)pszBuffer;
		crcVO.KMP_FRAME_t.hdr.start = pszBuffer[0];
		crcVO.KMP_FRAME_t.hdr.address = pszBuffer[1];
		crcVO.KMP_FRAME_t.hdr.cid = pszBuffer[2];
		crcVO.KMP_FRAME_t.body = new byte[nLength-2];
		for(int i=0; i<crcVO.KMP_FRAME_t.body.length; i++){
			crcVO.KMP_FRAME_t.body[i] = pszBuffer[i+2];
		}
		//System.out.printf("%x\n", crcVO.KMP_FRAME_t.body[16]);
		if (crcVO.KMP_FRAME_t.hdr.start == crcVO.KMP_ACK && nLength == 1) return true;
		if (nLength < 3) return false;

		//pTail = (KMP_TAIL_t *)&pszBuffer[nLength - 2];
		crcVO.KMP_TAIL_t.crc[0] = pszBuffer[nLength - 2];
		crcVO.KMP_TAIL_t.crc[1] = pszBuffer[nLength - 1];
		
		nCalcCrc = BigToHostShort(KmpGetCrc(pszBuffer, nLength - 2));
		short pTailCrc = ByteBuffer.wrap(crcVO.KMP_TAIL_t.crc, 0, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
		
		//if (nCalcCrc != pTail->crc)
		if (nCalcCrc != pTailCrc)
		{
			//System.out.printf("KmpStream: CRC Error (CALC=0x%04X, CRC=0x%04X)\xd\xa", nCalcCrc, crcVO.KMP_TAIL_t.crc);
			//System.out.printf("KmpStream: CRC Error (CALC=0x%04X, CRC=0x%04X)", nCalcCrc, pTailCrc);
			return false;
		}
		return true;
	}
	
	/// <summary>
	/// Function of unsigned short ??bin endian unsigned short?쇰줈 蹂?섑븯??湲곕뒫??泥섎━?쒕떎.
	/// </summary>x
	/// <param name="big"></param>
	short BigToHostShort(short big)
	{
		short u16;

		u16 = (short)(big & 0xff);
		u16 <<= 8;
		u16 += (big >> 8) & 0xff;
		
		return u16;
	}
	
	/// <summary>
	/// Function of unsigned long ??bin endian unsigned long?쇰줈 蹂?섑븯??湲곕뒫??泥섎━?쒕떎.
	/// </summary>
	/// <param name="big"></param>
	int BigToHostLong(int big)
	{
		int u32;

		u32 = (big & 0xff);
		u32 <<= 8;
		u32 += ((big >> 8) & 0xff);
		u32 <<= 8;
		u32 += ((big >> 16) & 0xff);
		u32 <<= 8;
		u32 += ((big >> 24) & 0xff);
		
		return u32;
	}
	
	public static void main(String[] args){
		KmpCrcCheck kcc = new KmpCrcCheck();
/*	// Test KmpGetCrc
		 byte test[] = {
				 (byte)0x3F,
				(byte)0xB8,
				(byte)0x2,
				(byte)0x1,
				(byte)0x1,
				(byte)0x4,
				(byte)0x17,
				(byte)0x0,
				(byte)0x1,
				(byte)0x0,
				(byte)0x0,
				(byte)0x0,
				(byte)0x1
			};

		 
			short crc = kcc.KmpGetCrc(test, test.length);
			System.out.printf("%x\n", crc);
	*/
		//Test KmpVerifyCrc
		byte response[] = {
				(byte)0x80,
				(byte)0x3f,
				(byte)0x10,
				(byte)0x3,
				(byte)0xf2,
				(byte)0x33,
				(byte)0xa,
				(byte)0x0,
				(byte)0x0,
				(byte)0x0,
				(byte)0x0,
				(byte)0x0,
				(byte)0x0,
				(byte)0x0,
				(byte)0x8,
				(byte)0x69,
				(byte)0x3,
				(byte)0xe2,
				(byte)0x27,
				(byte)0x94,
				(byte)0xd
			};
		
		
		byte[] verifyCrc = new byte[response.length-2];
		for(int i=1; i<=response.length-2; i++){
			verifyCrc[i-1] = response[i];
		}
		
		boolean verify = kcc.KmpVerifyCrc(verifyCrc, verifyCrc.length);
		System.out.println("verify = " + verify);
	}
}
