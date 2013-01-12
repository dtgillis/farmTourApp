package com.dtgillis.farmtour.utilities;

import java.util.HashMap;

import com.actionbarsherlock.app.SherlockFragment;
import com.dtgillis.farmtour.attractions.LlamaFragment;
import com.dtgillis.farmtour.attractions.RabbitFragment;
import com.dtgillis.farmtour.attractions.StartFragment;

public class AttractionFragmentList {
	
	public HashMap<String, SherlockFragment> attractionFragmentList = new HashMap<String, SherlockFragment>();
	public AttractionFragmentList(){
		attractionFragmentList.put("start", new StartFragment());
		attractionFragmentList.put("rabbit", new RabbitFragment());
		attractionFragmentList.put("llama", new LlamaFragment());
	}
	
	

}
