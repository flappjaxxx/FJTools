package com.flappjaxxx.fjtools;

import com.flappjaxxx.fjtools.R;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class ToolsActivity extends TabActivity {
	TextView   consoleView = null;

	public static final int TAB_APPS = 0;
	public static final int TAB_GPS = 1;
	public static final int TAB_CONSOLE = 2;	
	
    private static ToolsActivity INSTANCE = null;     

    private synchronized static void setInstance(ToolsActivity theInstance) {
        if (INSTANCE == null) { 
            INSTANCE = theInstance;
        }
    }
    
    public static ToolsActivity getInstance() {
        return INSTANCE;
    }	
	public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException(); 
	}
		
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    
	    ToolsActivity.setInstance(this);
	    
	    Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab
    
	    // Create an Intent to launch an Activity for the tab (to be reused)
	    // Tools tab
	    intent = new Intent().setClass(this, AppsActivity.class);
	    spec = tabHost.newTabSpec("apps").setIndicator("Tools")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    // GPS tab
	    intent = new Intent().setClass(this, GPSActivity.class);	    
	    spec = tabHost.newTabSpec("gps").setIndicator("GPS")
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    
	 /** Display tab
	    intent = new Intent().setClass(this, DisplayActivity.class);
	    spec = tabHost.newTabSpec("display").setIndicator("DPI")
	                  .setContent(intent);
	    tabHost.addTab(spec);

	 // Extras tab
	    intent = new Intent().setClass(this, ExtrasActivity.class);
	    spec = tabHost.newTabSpec("extras").setIndicator("Extras")
	                 .setContent(intent);
	  tabHost.addTab(spec);  */
	    
	 
	    // Console tab
	    intent = new Intent().setClass(this, ConsoleActivity.class);
	    spec = tabHost.newTabSpec("console").setIndicator("Out")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    	    
	    tabHost.setCurrentTab(TAB_APPS);
	    
	}

	public void setConsoleView(TextView textView) {
		consoleView = textView;		
	}

	public TextView getConsoleView() {
		return consoleView;
	}

	
}
