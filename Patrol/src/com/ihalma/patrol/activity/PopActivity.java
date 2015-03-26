package com.ihalma.patrol.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ihalma.patrol.R;

/**
 * Title: 底下弹出选择框</br><br>
 * Description: </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * 
 * @author and</br><br>
 * @version 1 </br><br>
 *          data: 2015-3-26</br>
 */
public class PopActivity extends Activity implements OnClickListener {

	private Button btnPhoto;
	private Button btnVideo;
	private Button btnText;
	private Button btnCacel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pop);

		findViewById();
	}

	private void findViewById() {
		btnPhoto = (Button) findViewById(R.id.btn_photo);
		btnVideo = (Button) findViewById(R.id.btn_video);
		btnText = (Button) findViewById(R.id.btn_text);
		btnCacel = (Button) findViewById(R.id.btn_cancel);
		btnPhoto.setOnClickListener(this);
		btnVideo.setOnClickListener(this);
		btnCacel.setOnClickListener(this);
		btnText.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_photo:
			finish();
			break;

		case R.id.btn_video:
			finish();
			break;

		case R.id.btn_text:
			finish();
			break;

		case R.id.btn_cancel:
			finish();
			break;

		default:
			finish();
			break;
		}
	}

	/**
	 * 点击他处退出activity
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		finish();
		return true;
	}

}
