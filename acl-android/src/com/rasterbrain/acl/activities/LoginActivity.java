package com.rasterbrain.acl.activities;

import com.rasterbrain.acl.R;
import com.rasterbrain.acl.services.UserService;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	ProgressDialog diag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		findViewById(R.id.signinButton).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				EditText usernameBox = (EditText) findViewById(R.id.loginUsername);
				EditText passwordBox = (EditText) findViewById(R.id.loginPassword);
				String username = usernameBox.getText().toString();
				String password = passwordBox.getText().toString();
				
				
				if(username.equals("")){
					usernameBox.setError("Please enter username");
				}
				if(password.equals("")){
					passwordBox.setError("Please enter password");
				}
				if(!username.equals("")&&!password.equals("")){
					
					new LoginTask().execute(username,password);
				}
				
			}
		});
	}
	class LoginTask extends AsyncTask<String, Integer, String>{

		ProgressDialog diag;
		@Override
		protected String doInBackground(String... params) {
			UserService ser = new UserService();
			return ser.checkLogin(params[0], params[1]);
			
		}
		@Override
		protected void onPreExecute() {
			diag = new ProgressDialog(LoginActivity.this);
			diag.setMessage("Loading...!");
			diag.setCanceledOnTouchOutside(false);
			// dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			// dialog.setMax(100);
			diag.show();

		}

		// @Override
		// protected void onProgressUpdate(Integer... values) {
		// // TODO Auto-generated method stub
		// dialog.setProgress(values[0]);
		// }
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			diag.dismiss();
			super.onPostExecute(result);
			if(result.equals("error"))
				Toast.makeText(getBaseContext(), "Network error", Toast.LENGTH_LONG).show();
			else if(result.equals("true")){
				Toast.makeText(getBaseContext(), "Logged in successfully", Toast.LENGTH_SHORT).show();
				// forward tRegisterTasko mainPage
				Intent i = new Intent(LoginActivity.this, HomeActivity.class);
				startActivity(i);
			}
			else{
				Toast.makeText(getBaseContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
			}
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
