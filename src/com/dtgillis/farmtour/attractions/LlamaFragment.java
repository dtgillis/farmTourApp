package com.dtgillis.farmtour.attractions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dtgillis.farmtour.R;

public class LlamaFragment extends StartFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.start_text, container, false);	
	}
	public void onStart(){
		super.onStart();
		TextView someText = (TextView) getActivity().findViewById(R.id.start_text);
		someText.setText(TourText.llamaText[0]);
		
		
		
	}
}
