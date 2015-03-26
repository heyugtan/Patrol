package com.ihalma.patrol.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.ihalma.patrol.R;
import com.ihalma.patrol.anim.Rotate3dAnimation;
import com.ihalma.patrol.utils.DensityUtil;

/**
 * Title: 主界面</br><br>
 * Description: </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * 
 * @author and</br><br>
 * @version 1 </br><br>
 *          data: 2015-3-26</br>
 */
public class MainActivity extends Activity implements OnClickListener {

	//动画
	private ImageView ivPhoto;
	private ImageView ivVideo;
	private ImageView ivText;
	private Animation animPhoto;
	
	private Button btnSelect;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initializeView();
	}

	private void initializeView() {
		ivPhoto = (ImageView) findViewById(R.id.iv_photo_anim);
		ivVideo = (ImageView) findViewById(R.id.iv_video_anim);
		ivText = (ImageView) findViewById(R.id.iv_text_anim);
		
		btnSelect = (Button) findViewById(R.id.btn_select);
		
		final float centerX = ivVideo.getWidth();
		final float centerY = ivVideo.getHeight();
		Log.i("and", "value"+ centerX +" - "+ centerY);
		
		//摄像动画
		final Rotate3dAnimation anim = new Rotate3dAnimation(360, 0, DensityUtil.dip2px(this, 45), DensityUtil.dip2px(this, 45), 20f, true);
		anim.setDuration(5000);
		anim.setInterpolator(new LinearInterpolator());
		anim.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
			}
			@Override
			public void onAnimationEnd(Animation animation) {
				ivVideo.startAnimation(anim);
			}
		});
		
		//相片动画
		animPhoto = AnimationUtils.loadAnimation(this, R.anim.photo_animation);
		LinearInterpolator speed = new LinearInterpolator(); // 速度-匀速
		animPhoto.setInterpolator(speed);
		
		//文字动画
		final Animation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f);  
		//设置动画时间  
		scaleAnimation.setDuration(5000);
		scaleAnimation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
			}
			@Override
			public void onAnimationEnd(Animation animation) {
				ivText.startAnimation(animation);
			}
		});
		
		ivPhoto.startAnimation(animPhoto);
		ivVideo.startAnimation(anim);
		ivText.startAnimation(scaleAnimation);
		
		btnSelect.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_select:
			//TODO
			startActivityForResult(new Intent(MainActivity.this, PopActivity.class), 11);
			break;

		default:
			break;
		}
	}

}
