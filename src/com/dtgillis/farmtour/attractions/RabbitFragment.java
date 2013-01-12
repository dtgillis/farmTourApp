package com.dtgillis.farmtour.attractions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dtgillis.farmtour.R;

public class RabbitFragment extends StartFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.frag_experiment, container, false);	
	}
	public void onStart(){
		super.onStart();
		ImageView someImage = (ImageView) getActivity().findViewById(R.id.base_fragment_pic);
		someImage.setImageResource(R.drawable.chicken);
		TextView someText = (TextView) getActivity().findViewById(R.id.base_fragment_text);
		someText.setText(TourText.rabbitText[0]);
		
		
		
	}
}
