package ch.cvarta;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MADStromActivity extends Activity {
	//Flag indicating if application is running in a emulator
	//emulator implicates no Bluetooth
	boolean onEmulator;
	View connectView;
	View controlView;
	
    // Intent request codes
    private static final int REQUEST_CONNECT_DEVICE = 1;
    private static final int REQUEST_ENABLE_BT = 2;
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//creation of Views to accelerate Content-Switching
		connectView = findViewById(R.layout.connectview);
		controlView = findViewById(R.layout.controlview);
		//set initial View to the connection view
		setContentView(connectView);
		
		onEmulator = "sdk".equals(Build.PRODUCT);

		((Button)findViewById(R.id.connect_button)).setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

	}

	/**
	 * Handles the result returned by the device list activity. */
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case REQUEST_CONNECT_DEVICE:
			// When DeviceListActivity returns with a device to connect if (resultCode == Activity.RESULT_CANCELED) {
			// do nothing
			if( resultCode == Activity.RESULT_CANCELED){
				//do nothing
			} else if (resultCode == Activity.RESULT_OK) {
				if (onEmulator) { setEmulationSetup();
				} else {
					// TODO: Connect NXT
				}
			}
			break;
		}
	}

	private void setEmulationSetup() {
		// TODO Auto-generated method stub
		
	}
}