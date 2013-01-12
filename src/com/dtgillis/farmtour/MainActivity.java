package com.dtgillis.farmtour;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuInflater;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends SherlockActivity implements OnClickListener {
	Button startButton;
	TextView welcomeText;
	ImageView mImage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		welcomeText = (TextView) findViewById(R.id.welcome_text);
		mImage = (ImageView) findViewById(R.id.mainPic);
		startButton =  (Button) findViewById(R.id.start_button);
		startButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.activity_main, menu);
		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.menubackground));
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.start_button){
			Intent intent = new Intent(this,TourPreface.class);
			startActivity(intent);
		}
		
	}

}
