package com.nickilous.pebbletracks;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.widget.TextView;

import com.google.android.apps.mytracks.content.MyTracksProviderUtils;
import com.google.android.apps.mytracks.services.ITrackRecordingService;

public class PebbleMyTracksService extends Service {
	private static final String TAG = PebbleMyTracksService.class.getSimpleName();

	  // utils to access the MyTracks content provider
	  private MyTracksProviderUtils myTracksProviderUtils;

	  // display output from the MyTracks content provider
	  private TextView outputTextView;

	  // MyTracks service
	  private ITrackRecordingService myTracksService;
	  
	// intent to access the MyTracks service
	  private Intent myTracksIntent = new Intent();
	 	  
	
    
 // connection to the MyTracks service
    private ServiceConnection serviceConnection = new ServiceConnection() {
      @Override
      public void onServiceConnected(ComponentName className, IBinder service) {
        myTracksService = ITrackRecordingService.Stub.asInterface(service);
      }

      @Override
      public void onServiceDisconnected(ComponentName className) {
        myTracksService = null;
      }
    };

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// for the MyTracks service
	    ComponentName componentName = new ComponentName(
	        getString(R.string.mytracks_service_package), getString(R.string.mytracks_service_class));
	    myTracksIntent.setComponent(componentName);
	    
	    
		return super.onStartCommand(intent, flags, startId);
		
	}

	public PebbleMyTracksService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
