package com.example.pic_04;

import android.app.Activity;
import android.os.Bundle;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;


public class MainActivity extends Activity {
	
	ImageView Img1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Img1 = (ImageView)findViewById(R.id.imageView1);
		Img1.setVisibility(View.INVISIBLE);
		
		((Button) findViewById(R.id.button1)).setOnClickListener(B1Listener);
		((Button) findViewById(R.id.button2)).setOnClickListener(B2Listener);
	}
	
	OnClickListener B1Listener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {

			Resources r = getResources();
			Bitmap bitmap = BitmapFactory.decodeResource(r, R.drawable.spring);
			BitmapDrawable drawable = new BitmapDrawable(bitmap);
			Img1.setImageDrawable(drawable);
			Img1.setVisibility(View.VISIBLE);
			
			AnimationSet set = new AnimationSet(true);
			 
			RotateAnimation rotate = new RotateAnimation(0, 360, Img1.getWidth()/2, Img1.getHeight()/2);
			set.addAnimation(rotate);
			 
			ScaleAnimation scale = new ScaleAnimation(1, 2, 1, 2);
			set.addAnimation(scale);
			 
			set.setDuration(5000);
			Img1.startAnimation(set);
		}

	};
	
	OnClickListener B2Listener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {

			Resources r = getResources();
			Bitmap bitmap = BitmapFactory.decodeResource(r, R.drawable.spring);
			BitmapDrawable drawable = new BitmapDrawable(bitmap);
			Img1.setImageDrawable(drawable);
			
			//画像の透明度を5秒にかけて変化させ、非表示にする。
			AnimationSet set = new AnimationSet(true);
			
			ScaleAnimation scale = new ScaleAnimation(1, 0.5f, 1, 0.5f);
			set.addAnimation(scale);
			
			AlphaAnimation alpha = new AlphaAnimation(1, 0);
			set.addAnimation(alpha);
			
			set.setDuration(5000);
			Img1.startAnimation(set);
			
			Img1.setVisibility(View.INVISIBLE);
		}
	};

	}


	

