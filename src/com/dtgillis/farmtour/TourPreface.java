package com.dtgillis.farmtour;


import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuInflater;
import com.dtgillis.farmtour.attractions.AttractionBaseActivity;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.widget.ImageView;


public class TourPreface extends SherlockActivity  implements OnClickListener{
	LocationManager locationManager; 
	//Criteria criteria = new Criteria();
	Button tutorialButton;
	Button qrCodeButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.farm_finder);
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,  0, 0 ,locationListener );
		tutorialButton = (Button) findViewById(R.id.tutorialButton);
		qrCodeButton = (Button) findViewById(R.id.qrCodeButton);
		tutorialButton.setOnClickListener(this);
		qrCodeButton.setOnClickListener(this);
		}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.activity_main, menu);
		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.menubackground));
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent back = new Intent(this,MainActivity.class);
			//NavUtils.navigateUpFromSameTask(this);
			startActivity(back);
			return true;
		
		case R.id.menu_settings:
			Intent settings = new Intent(this,FarmSettings.class);
			startActivity(settings);
			return true;
		}	
		//return super.onContextItemSelected(item);
		return true;
	}

	// Define a listener that responds to location updates
	LocationListener locationListener = new LocationListener() {
	    public void onLocationChanged(Location location) {
	      // Called when a new location is found by the network location provider.
	    	
	    	locationManager.removeUpdates(this);
	    	
	    	
	    }

	    public void onStatusChanged(String provider, int status, Bundle extras) {}

	    public void onProviderEnabled(String provider) {}

	    public void onProviderDisabled(String provider) {}

		
	  };
	  public void onStop(){
		  super.onStop();
		  locationManager.removeUpdates(locationListener);
	  }

	@Override
	public void onClick(View v) {
		
		
		if(v.getId()==R.id.tutorialButton){
			Log.d("atag", "tutorial Button pressed");
			Intent tutorial = new Intent(this,QRTutorial.class);
			startActivity(tutorial);
		}
		else if (v.getId() == R.id.qrCodeButton){
			Log.d("atag","qrcodebutton called");
			Intent qrCode = new Intent(this,AttractionBaseActivity.class);
			startActivity(qrCode);
			}
			
		
		}
		
	}

