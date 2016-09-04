package com.glemontree.spannablestringdemo;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.DynamicDrawableSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView mTextView;
	private Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTextView = (TextView) findViewById(R.id.textView);
		mTextView.setText(getString2());
		mTextView.setMovementMethod(LinkMovementMethod.getInstance());
	}
	
	private SpannableString getString() {
		final SpannableString spannableString = new SpannableString("这是测试字符串，百度地址如下：http://www.baidu.com");
		spannableString.setSpan(new BackgroundColorSpan(Color.GREEN), 15, spannableString.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		spannableString.setSpan(new UnderlineSpan(), 15, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannableString.setSpan(new ClickableSpan() {
			
			@Override
			public void onClick(View widget) {
				// TODO Auto-generated method stub
				Log.d("MainActivity", "click");
			}
		}, 15, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		return spannableString;
	}
	
	private SpannableString getString2() {
		SpannableString spannableString = new SpannableString("这是测试字符串，这是测试字符串");
		DynamicDrawableSpan drawableSpan = new DynamicDrawableSpan(DynamicDrawableSpan.ALIGN_BASELINE) {
			
			@Override
			public Drawable getDrawable() {
				// TODO Auto-generated method stub
				Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);
				drawable.setBounds(0, 0, 50, 50);
				return drawable;
			}
		};
		DynamicDrawableSpan drawableSpan2 = new DynamicDrawableSpan(DynamicDrawableSpan.ALIGN_BOTTOM) {
			
			@Override
			public Drawable getDrawable() {
				// TODO Auto-generated method stub
				Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);
				drawable.setBounds(0, 0, 50, 50);
				return drawable;
			}
		};
		spannableString.setSpan(drawableSpan, 3, 4, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		spannableString.setSpan(drawableSpan2, 7, 8, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		return spannableString;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
