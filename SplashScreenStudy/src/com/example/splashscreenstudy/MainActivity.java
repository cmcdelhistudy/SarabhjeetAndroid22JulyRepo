package com.example.splashscreenstudy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	ProgressBar pb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		pb = (ProgressBar) findViewById(R.id.progressBar1);

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <= 100; i++) {

					pb.setProgress(i);

					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}

				startActivity(new Intent(getBaseContext(), SecondActivity.class));
				finish();
			}
		}).start();
	}
}
