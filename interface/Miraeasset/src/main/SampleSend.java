package main;

import com.e1.eai.service.Eai;
import com.e1.eai.excp.APIException;

public class SampleSend {
	public static void main(String[] args) {

		Eai eai = null;

		/** 입력 파라미터중 인터페이스 ID를 String로 넘겨줍니다. **/
		String interfaceID = "JAVA1way2";
		//String interfaceID = "JAVA1way2";`
		
		/** 입력 파라미터중 sndString를 String로 넘겨줍니다. **/
		String sndString1 =	"msg Send";

				
		/** 결과값 성공: API0000 **/
		String result = "";

		try {
			/** APIAdapter ConfigLoad **/
			eai = new Eai();

			/** APIAdapter MQ Connect **/
			eai.eaiInit();

			for(int i=0 ; i<1; i++) {
				result = eai.eaiSendAPAsync(interfaceID, sndString1);
			}
			
			if(result == "API0000")
				System.out.println("Msg Snd complete.");

			/** APIAdapter MQ Disconnect **/
			eai.eaiDestroy();
			
			
		} catch (APIException e) {
			System.out.println("ErrorCode : " + e.getErrorCd());
			System.out.println("   ErrMsg : " + e.getErrorMessage());
		}
	}
}