package com.rasterbrain.acl;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button login = (Button) findViewById(R.id.loginButton);
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// start new activity loginActivity
				Intent intent = new Intent(MainActivity.this,LoginActivity.class);
				startActivity(intent);
			}
		});
		Button register = (Button) findViewById(R.id.registerButton);
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// start Register activity
				Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
