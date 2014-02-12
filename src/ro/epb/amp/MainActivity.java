package ro.epb.amp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.widget.RemoteViews;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new TextView(this));
		//	finish();
		RemoteViews remoteViews = new RemoteViews(getPackageName(),  
                R.layout.activity_main);  
      NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(  
                this).setSmallIcon(R.drawable.ic_launcher).setContent(  
                remoteViews);  
      mBuilder.setOngoing(true);
      // Creates an explicit intent for an Activity in your app  
      Intent resultIntent = new Intent(this, MainActivity.class);  
      // The stack builder object will contain an artificial back stack for  
      // the  
      // started Activity.  
      // This ensures that navigating backward from the Activity leads out of  
      // your application to the Home screen.  
      TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);  
      // Adds the back stack for the Intent (but not the Intent itself)  
      stackBuilder.addParentStack(MainActivity.class);  
      // Adds the Intent that starts the Activity to the top of the stack  
      stackBuilder.addNextIntent(resultIntent);  
      PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,  
                PendingIntent.FLAG_UPDATE_CURRENT);  
     // remoteViews.setOnClickPendingIntent(R.id.button1, resultPendingIntent);  
      NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  
      // mId allows you to update the notification later on.  
      mNotificationManager.notify(100, mBuilder.build()); 

      finish();

	}
}
