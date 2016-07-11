package and08c.lektion2;

import java.io.OutputStreamWriter;



import android.app.Activity;
//import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button btCall = (Button) this.findViewById(R.id.bt_call);
		btCall.setOnClickListener(new OnClickListener()
		{
		

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			MainActivity.this.call("(0676)3058689");
		}
		});
		
		Button btMail = (Button) this.findViewById(R.id.bt_mail);
		btMail.setOnClickListener(new OnClickListener()
		{
		

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String[] strArray = new String[] {"sohrab_hejazi@yahoo.com", "hejazi.sohrab@gmail.com"};
			MainActivity.this.sendMail(strArray);
		}
		});
		
		Button btDatei = (Button) this.findViewById(R.id.bt_datei);
		btDatei.setOnClickListener(new OnClickListener()
		{
		

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String[] strArray = new String[] {"sohrab_hejazi@yahoo.com", "hejazi.sohrab@gmail.com"};
			MainActivity.this.backupFile(strArray);
		}
		});
		
		Button btSuche = (Button) this.findViewById(R.id.bt_suche);
		btSuche.setOnClickListener(new OnClickListener()
		{
		

		@Override
		public void onClick(View v) {
			
			Intent eMailIntent = new Intent(Intent.ACTION_SEND);
			eMailIntent.setType("text/plain");
			eMailIntent.putExtra(Intent.EXTRA_EMAIL, "java08c-esa@android.de");
			eMailIntent.putExtra(Intent.EXTRA_SUBJECT,
			"Suche nach dem Mail-Dummy");
			eMailIntent.putExtra(Intent.EXTRA_TEXT,
			"Dummy gefunden!");
			startActivity(Intent.createChooser(eMailIntent,"Mail versenden"));
			
		}
		});
	}
	
	protected void backupFile(String[] adresses) {
			Intent eMailIntent = new Intent(Intent.ACTION_SEND);
			eMailIntent.putExtra(Intent.EXTRA_EMAIL, adresses);
			eMailIntent.putExtra(Intent.EXTRA_SUBJECT,
			"Mail mit Anhang aus AND08C_Lektion2");
			eMailIntent.setType("text/*");
			String file = "Test.txt";
			createFile(file);
			int var = 1;
			switch (var) {
				case 1:
				Uri filePath = Uri.parse(file);
				Uri filePath2 = Uri.parse("file://" + file);
				eMailIntent.putExtra(Intent.EXTRA_STREAM, filePath2);
				startActivity(Intent.createChooser(eMailIntent,
				"Mail versenden"));
				break;
			}
	}
	private void createFile(String file)
		{
			try {
				OutputStreamWriter writer =
				new OutputStreamWriter(
				openFileOutput( file, MODE_PRIVATE));
				writer.write("Dies ist das Haus vom Nikolaus");
				writer.close();
			} catch (Exception e) {
				Log.d("TAG", e.toString());
		}
		}
	

	protected void call(String number) {
		// TODO Auto-generated method stub
		Intent callIntent = new Intent(Intent.ACTION_CALL,
				Uri.parse("tel:" + number));
				startActivity(callIntent);
	}

	protected void sendMail(String[] adresses) {
		Intent eMailIntent = new Intent(Intent.ACTION_SEND);
		eMailIntent.setType("text/plain");
		eMailIntent.putExtra(Intent.EXTRA_EMAIL, adresses);
		eMailIntent.putExtra(Intent.EXTRA_SUBJECT,
		"Test-Mail aus AND08C_Lektion2");
		eMailIntent.putExtra(Intent.EXTRA_TEXT,
		"Textinhalt der Mail.\nmfG");
		startActivity(Intent.createChooser(eMailIntent,
		"Mail versenden"));
		}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
