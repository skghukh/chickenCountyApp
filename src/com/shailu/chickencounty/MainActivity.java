package com.shailu.chickencounty;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Window window = this.getWindow();
		int statusBarColor = Color.parseColor("#F55E3D");

		if (statusBarColor == Color.BLACK
				&& window.getNavigationBarColor() == Color.BLACK) {
			window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		} else {
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		}
		window.setStatusBarColor(statusBarColor);

		Spinner outletSelector = (Spinner) findViewById(R.id.outlet_selector_spinner);
		ArrayAdapter<CharSequence> outletArrayAdapter = ArrayAdapter
				.createFromResource(this, R.array.outlet_list,
						android.R.layout.simple_spinner_dropdown_item);
		outletSelector.setAdapter(outletArrayAdapter);
	}

	public void goButtonClick(View v) {

		Log.i("CC", "Go Button Clicked");
		ImageView iv = (ImageView) findViewById(R.id.goButton);
		if (iv != null) {
			Animation sgAnimation = AnimationUtils.loadAnimation(
					getApplicationContext(), R.anim.shrink_grow);
			iv.startAnimation(sgAnimation);
			iv.startAnimation(sgAnimation);
			iv.playSoundEffect(android.view.SoundEffectConstants.CLICK);
		}

		Intent go_intent = new Intent(this,
				com.shailu.chickencounty.MenuActivity.class);
		startActivity(go_intent);
	}
}
