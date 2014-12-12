package com.rasterbrain.acl.activities;

import com.rasterbrain.acl.R;
import com.rasterbrain.acl.services.UserService;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	ProgressDialog diag = new ProgressDialog(
			RegisterActivity.this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		findViewById(R.id.RegisterAddress).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						EditText usernameBox = (EditText) findViewById(R.id.RegisterUsername);
						EditText passwordBox = (EditText) findViewById(R.id.RegisterPassword);
						String username = usernameBox.getText().toString();
						String password = passwordBox.getText().toString();
						
						diag.setTitle("Loading..");
						diag.setCanceledOnTouchOutside(false);

						if (username.equals("")) {
							usernameBox.setError("Please enter username");
						}
						if (password.equals("")) {
							passwordBox.setError("Please enter password");
						}
						if (!username.equals("") && !password.equals("")) {
							diag.show();
							new RegisterTask().execute(username, password);
						}

					}
				});
	}

	class RegisterTask extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... params) {
			UserService ser = new UserService();
			return ser.checkLogin(params[0], params[1]);

		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			diag.dismiss();
			super.onPostExecute(result);
			if (result.equals("error"))
				Toast.makeText(getBaseContext(), "Network error",
						Toast.LENGTH_LONG).show();
			else if (result.equals("true")) {
				Toast.makeText(getBaseContext(), "Registerd successfully",
						Toast.LENGTH_SHORT).show();
				// forward to mainPage
			} else {
				Toast.makeText(getBaseContext(),
						"Invalid data", Toast.LENGTH_LONG)
						.show();
			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

}
