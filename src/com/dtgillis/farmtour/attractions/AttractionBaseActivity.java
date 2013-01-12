package com.dtgillis.farmtour.attractions;

import jim.h.common.android.lib.zxing.integrator.IntentIntegrator;
import jim.h.common.android.lib.zxing.integrator.IntentResult;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.dtgillis.farmtour.R;
import com.dtgillis.farmtour.utilities.AttractionFragmentList;
//need to make it save the state incase it is destroyed it does not go back to start
public class AttractionBaseActivity extends SherlockFragmentActivity implements OnClickListener{
	Button scanQrCode,cameraButton;
	Handler handler = new Handler();
	AttractionFragmentList fragList = new AttractionFragmentList();
	public void onCreate(Bundle SavedInstanceState){
		
		super.onCreate(SavedInstanceState);
		setContentView(R.layout.attraction_base);
		scanQrCode = (Button) findViewById(R.id.qrCodeButton);
		cameraButton = (Button) findViewById(R.id.take_picture);
		scanQrCode.setOnClickListener(this);
		cameraButton.setOnClickListener(this);
		fragList.attractionFragmentList.get("start").setArguments(getIntent().getExtras());
		getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
				fragList.attractionFragmentList.get("start")).commit();
		
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
		if(v.getId() == R.id.qrCodeButton){
			//now we scan a new qrcode and implement a new fragement
			IntentIntegrator.initiateScan(AttractionBaseActivity.this, R.layout.capture,
	                R.id.viewfinder_view, R.id.preview_view, true);
		}
		else if (v.getId() == R.id.take_picture){
			// now we should let them take a picture and save it 
			
		}
	}
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	        switch (requestCode) {
	            case IntentIntegrator.REQUEST_CODE:
	                IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode,
	                        resultCode, data);
	                if (scanResult == null) {
	                    return;
	                }
	                final String result = scanResult.getContents();
	                if (result != null) {
	                    handler.post(new Runnable() {
	                        @Override
	                        public void run() {
	                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_base,
	                            		fragList.attractionFragmentList.get(result)).commit();
	                            
	                        }
	                    });
	                }
	                break;
	            default:
	        }
	
	 }
}
