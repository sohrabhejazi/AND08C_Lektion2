package and08c.lektion2;


//import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MailDummy extends  Activity {

	private String newLine =
			System.getProperty("line.separator");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mail_dummy);
		Intent intent = this.getIntent();
		String action = intent.getAction();
		String MiMe = intent.getType();
		String emailAdd = intent.getExtras().getString(Intent.EXTRA_EMAIL);
		String Bet = intent.getExtras().getString(Intent.EXTRA_SUBJECT);
		String Tet = intent.getExtras().getString(Intent.EXTRA_TEXT);
		
		StringBuffer sb = new StringBuffer(500);
	    sb.append("Action= ");
		sb.append(action);
		sb.append(newLine);
		sb.append("mimeType= ");
		sb.append(MiMe);
		sb.append(newLine);
		sb.append("Adresse= ");
		sb.append(emailAdd);
		sb.append(newLine);
		sb.append("Betreff= ");
		sb.append(Bet);
		sb.append(newLine);
		sb.append("Text= ");
		sb.append(Tet);
		
		
		
		TextView info = (TextView) this.findViewById(R.id.tx_info);
		info.setText(sb);
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mail_dummy, menu);
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
