package com.example.filehandlingstudy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText edData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edData = (EditText) findViewById(R.id.ed1);
	}

	public void saveFile(View v) {
		String kahani = edData.getText().toString();

		try {
			String path = Environment.getExternalStorageDirectory().getName();

			path = path + "/story.txt";

			FileOutputStream fos = openFileOutput(path, MODE_APPEND);
			OutputStreamWriter osw = new OutputStreamWriter(fos);

			osw.write(kahani);

			osw.flush();

			Toast.makeText(getBaseContext(), " Data Saved ", Toast.LENGTH_SHORT)
					.show();

		} catch (FileNotFoundException e) {
			Toast.makeText(getBaseContext(),
					"File Not Found Exceotion : " + e.getMessage(),
					Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		} catch (IOException e) {
			Toast.makeText(getBaseContext(),
					"IO Exception : " + e.getMessage(), Toast.LENGTH_SHORT)
					.show();
			e.printStackTrace();
		}

	}

	public void readFile(View v) {
		try {
			FileInputStream fis = openFileInput("story.txt");
			InputStreamReader insr = new InputStreamReader(fis);

			String readString = " ";

			int i = 0;

			while ((i = insr.read()) != -1) {
				readString = readString + (char) i;
			}

			Toast.makeText(getBaseContext(), "Data Read : " + readString,
					Toast.LENGTH_SHORT).show();

		} catch (FileNotFoundException e) {
			Toast.makeText(getBaseContext(),
					"File Not Found Exceotion : " + e.getMessage(),
					Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		} catch (IOException e) {
			Toast.makeText(getBaseContext(),
					"IO Exception : " + e.getMessage(), Toast.LENGTH_SHORT)
					.show();
			e.printStackTrace();
		}

	}

}
