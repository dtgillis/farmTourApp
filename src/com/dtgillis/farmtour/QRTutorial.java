package com.dtgillis.farmtour;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.dtgillis.farmtour.attractions.AttractionBaseActivity;


import jim.h.common.android.lib.zxing.integrator.IntentIntegrator;
import jim.h.common.android.lib.zxing.integrator.IntentResult;

public class QRTutorial extends SherlockActivity implements OnClickListener {
	
	Handler handler = new Handler();
	TextView resultsText;
	TextView qrHowText;
	Button scanButton;
	Button startButton;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.qr_tutorial);
		scanButton = (Button) findViewById(R.id.scan_button);
		qrHowText = (TextView) findViewById(R.id.qr_how);
		resultsText = (TextView) findViewById(R.id.scan_result);
		scanButton.setOnClickListener(this);
		startButton = (Button) findViewById(R.id.start_button);
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
		if(v.getId() == R.id.scan_button){
		IntentIntegrator.initiateScan(QRTutorial.this, R.layout.capture,
                R.id.viewfinder_view, R.id.preview_view, true);
		}
		else if(v.getId()==R.id.start_button){
			Intent startTour = new Intent(this,AttractionBaseActivity.class);
			startActivity(startTour);
		}
		
	}
	@Override
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
                            resultsText.setText("You have figured this out");
                            
                        }
                    });
                }
                break;
            default:
        }

	}
}
