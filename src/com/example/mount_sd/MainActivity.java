package com.example.mount_sd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void MountSD(View view) {
		Process process = null;
		try {
			final Runtime runtime = Runtime.getRuntime();
			String[] str = { "su", "-c",
					"mount -r -t vfat /dev/block/vold/179:1 /mnt/sdcard" };
			process = runtime.exec(str);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			int read;
			char[] buffer = new char[4096];
			StringBuffer output = new StringBuffer();

			while ((read = reader.read(buffer)) > 0) {
				output.append(buffer, 0, read);
				reader.close();
				process.waitFor();
				//((EditText) findViewById(R.id.output)).setText(output);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//((EditText) findViewById(R.id.output)).setText(e.getStackTrace()
			//		.toString());
		}

	}

	public void UMountSD(View view) {
		Process process = null;
		try {
			final Runtime runtime = Runtime.getRuntime();
			String[] str = { "su", "-c", "umount /mnt/sdcard" };
			process = runtime.exec(str);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			int read;
			char[] buffer = new char[4096];
			StringBuffer output = new StringBuffer();

			while ((read = reader.read(buffer)) > 0) {
				output.append(buffer, 0, read);
				reader.close();
				process.waitFor();
			//	((EditText) findViewById(R.id.output)).setText(output);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//((EditText) findViewById(R.id.output)).setText(e.getStackTrace()
			//		.toString());
		}

	}

	public void ReadSD(View view) {//failed
		Process process = null;
		try {
			final Runtime runtime = Runtime.getRuntime();
			String[] str = { "su", "-c", "ls /mnt/sdcard" };
			process = runtime.exec(str);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			int read;
			char[] buffer = new char[4096];
			StringBuffer output = new StringBuffer();

			while ((read = reader.read(buffer)) > 0) {
				output.append(buffer, 0, read);
				reader.close();
				process.waitFor();
				//((EditText) findViewById(R.id.output)).setText(output);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//((EditText) findViewById(R.id.output)).setText(e.getStackTrace()
			//		.toString());
		}

	}
}
