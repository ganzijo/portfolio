package com.nuriapp.vo_dontuse;
/*package com.nuriapp.popup;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class ReadStorageTaskProgress extends AsyncTask<Integer, String, Integer> {
	// ProgressDialog를 멤버로 하나 넣어줌
	private ProgressDialog mDlg;
	private Context mContext;

	public ReadStorageTaskProgress(Context readStorageFragment) {
		mContext = readStorageFragment;
	}




	@Override
	protected void onPreExecute() {
		mDlg = new ProgressDialog(mContext);
		mDlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mDlg.setTitle("데이터 로딩중");
		mDlg.setMessage("잠시만 기다리세요...");
		mDlg.show();
		
		super.onPreExecute();
	}

	@Override
	protected Integer doInBackground(Integer... params) {

		final int taskCnt = params[0];
		publishProgress("max", Integer.toString(taskCnt));

		
		for (int i = 0; i < taskCnt; ++i) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 작업 진행 마다 진행률을 갱신하기 위해 진행된 개수와 설명을 publishProgress() 로 넘겨줌.
			publishProgress("progress", Integer.toString(i),"작업 번호 " + Integer.toString(i) + "번 수행중");
		}

		// 작업이 끝나고 작업된 개수를 리턴 . onPostExecute()함수의 인수가 됨
		return taskCnt;
	}

	// onProgressUpdate() 함수는 publishProgress() 함수로 넘겨준 데이터들을 받아옴
	@Override
	protected void onProgressUpdate(String... progress) {
		if (progress[0].equals("progress")) {
			mDlg.setProgress(Integer.parseInt(progress[1]));
			mDlg.setMessage(progress[2]);
		} else if (progress[0].equals("max")) {
			mDlg.setMax(Integer.parseInt(progress[1]));
		}
	}

	// onPostExecute() 함수는 doInBackground() 함수가 종료되면 실행됨
	@Override
	protected void onPostExecute(Integer result) {
		mDlg.dismiss();
		Toast.makeText(mContext, Integer.toString(result) + "개의 작업 완료",Toast.LENGTH_SHORT).show();
	}
}*/