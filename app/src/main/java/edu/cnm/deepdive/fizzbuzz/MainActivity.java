package edu.cnm.deepdive.fizzbuzz;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
  private int value;
  private TextView valueDisplay;
  private Timer timer;
  private boolean running;

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.d("Trace", "Entering onReStart");
    Log.d("Trace,", "Leaving onStart");
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d("Trace", "Entering onStart");
    Log.d("Trace", "Entering onStart");

  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    Log.d("Trace", "Entering onRestoreInstanceState");
    Log.d("Trace", "Entering onRestoreInstanceState");
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d("Trace", "Entering onCreate");
    setContentView(R.layout.activity_main);;
    valueDisplay = findViewById(R.id.value_display);
    Log.d("Trace,", "Leaving onCreate");

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    Log.d("Trace", "Entering onCreateOptionsMenu");
    getMenuInflater().inflate(R.menu.options,menu);
    Log.d("Trace,", "Leaving onCreate");
    return true;
  }

  @Override
  protected void onResume() {
    Log.d("Trace", "Entering onResume");
    super.onResume();

    Log.d("Trace,", "Leaving onResume");
  }

  @Override
  protected void onPause() {
    Log.d("Trace", "Entering onPause");
    super.onPause();

  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d("Trace", "Entering onStop");
    Log.d("Trace,", "Leaving onStop");
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    Log.d("Trace", "Entering onSaveInstanceState");
    Log.d("Trace,", "Leaving onSaveInstanceState");

  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d("Trace", "Entering onDestroy");
    Log.d("Trace,", "Leaving onDestroy");
  }

  @Override
  public boolean onPrepareOptionsMenu(Menu menu) {
    MenuItem play = menu.findItem(R.id.play);
    MenuItem pause = menu.findItem(R.id.pause);
    play.setEnabled(!running);
    play.setVisible(!running);
    pause.setEnabled(running);
    pause.setVisible(running);
    return true;

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    Log.d("Trace", "Entering onCreateOptionsMenu");
    boolean handled = true;
    switch (item.getItemId()) {
      case R.id.play:
        resumegame();
        break;
      case R.id.pause:
        pausegame();
        break;
      case R.id.settings:
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
        break;
      default:
        handled = super.onOptionsItemSelected(item);
        break;

    }
    Log.d("Trace", "Leaving onOptionsItemSelected");

            return handled;

  }
  private void pausegame() {
    running = false;
    if (timer != null) {
      timer.cancel();
      timer = null;
      Log.d("Trace,", "Leaving onResume");
    }
    // Todo Update any necessary fields, timer, & menu.
    invalidateOptionsMenu();
  }
  private void resumegame() {
    running = true;
    timer = new Timer();
    timer.schedule(new RandomValueTask(), 0, 3000); //FIXME This should read preferences.
    // // Todo Update any necessary fields, timer, & menu.
    invalidateOptionsMenu();
  }
  private class RandomValueTask extends TimerTask{

    private Random rng = new Random();

    @Override
    public void run() {
      Log.d("Trace", "Entering run");
      value = rng.nextInt(100);
      runOnUiThread(() ->valueDisplay.setText(Integer.toString(value)));
      Log.d("Trace", "Leaving run");
    }
  }
  }


