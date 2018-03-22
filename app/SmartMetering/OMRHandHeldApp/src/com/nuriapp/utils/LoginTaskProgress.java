package com.nuriapp.utils;

import com.nuriapp.omrhandheldapp.LoginActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;





 // 실행순서 
 // onPreExecute() -> doInBackground() -> (publishProgress() 를 통해서 넘어온 값) -> onProgressUpdate() 실행 -> onPostExecute()
public class LoginTaskProgress extends AsyncTask<Integer, String, Integer> {
	// Integer - excute()실행시 넘겨줄 데이터 타입
	// Progress - 진행정보 데이터 타입 publishProgress(), onProgressUpdate()의 인수
	// Result - doInBackGround()종료시 리턴될 데이터 타입 onPostExecute()의 인수

	// ProgressDialog를 멤버로 하나 넣어줌
	private ProgressDialog mDlg;
	private Context mContext;


	public LoginTaskProgress(LoginActivity loginActivity) {
		// TODO Auto-generated constructor stub
		mContext = loginActivity;
	}

	
	// excute() 실행 시 doInBackground() 실행 전에 호출되는 함수
	// ProgressDialog 생성 및 기본 Setting and show()
	@Override
	protected void onPreExecute() {
		mDlg = new ProgressDialog(mContext);
		mDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		mDlg.setTitle("로그인중");
		mDlg.setMessage("잠시만 기다리세요...");
		mDlg.setIndeterminate(true);
		mDlg.setCancelable(false);
		mDlg.show();

		super.onPreExecute();
	}

	
	// excute() 실행시 실행됨 - 여기서 인수로는 작업개수를 넘겨주었다.
	@Override
	protected Integer doInBackground(Integer... params) {

		final int taskCnt = params[0];
		// 넘겨받은 작업개수를 ProgressDialog의 맥스값으로 세팅하기 위해 publishProgress()로 데이터를 넘겨준다.
		// publishProgress()로 넘기면 onProgressUpdate()함수가 실행된다.
		publishProgress("max", Integer.toString(taskCnt));

		// 작업 진행, 여기선 넘겨준 작업개수 * 100 만큼 sleep() 걸어줌
		for (int i = 0; i < taskCnt; ++i) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 작업 진행 마다 진행률을 갱신하기 위해 진행된 개수와 설명을 publishProgress() 로 넘겨줌.
			/*publishProgress("progress", Integer.toString(i),"작업 번호 " + Integer.toString(i) + "번 수행중");*/
		}

		// 작업이 끝나고 작업된 개수를 리턴 . onPostExecute()함수의 인수가 됨
		return taskCnt;
	}

	
	// publishProgress() 함수로 넘겨준 데이터들을 받아옴, 진행중에 해당하는 값을 가지고 처리하고 싶은 일을 실행하는 메소드
	// 일반적으로 프로그레스바의 값을 증가시키기 위해 사용 
	protected void onProgressUpdate(String... progress) {
		if (progress[0].equals("progress")) {
			mDlg.setProgress(Integer.parseInt(progress[1]));
			mDlg.setMessage(progress[2]);
		} else if (progress[0].equals("max")) {
			mDlg.setMax(Integer.parseInt(progress[1]));
		}
	}

	
	// doInBackground() 함수가 종료되면 실행됨,  결과값을 가지고 처리하고 싶은 일을 실행하는 메소드
	protected void onPostExecute(Integer result) {
		mDlg.dismiss();
		//Toast.makeText(mContext, Integer.toString(result) + "개의 작업 완료",Toast.LENGTH_SHORT).show();
		Toast.makeText(mContext, "로그인 성공",Toast.LENGTH_SHORT).show();
	}

	

	

}
