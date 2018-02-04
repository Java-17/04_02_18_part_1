package com.sheygam.java_17_04_02_18;

import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startBtn;
    private TextView countTxt;
    private MyTask myTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MY_TAG", "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countTxt = findViewById(R.id.countTxt);
        startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(this);
        if (savedInstanceState != null){
            countTxt.setText(savedInstanceState.getString("DATA",""));
        }

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer,new MyFragment())
                    .commit();
        }

//        myTask = (MyTask) getLastCustomNonConfigurationInstance();
//        if(myTask == null){
//            myTask = new MyTask();
//            myTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//        }
//        myTask.bind(this);





    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("MY_TAG", "onRestoreInstanceState: ");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("DATA",countTxt.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return myTask;
    }

    @Override
    protected void onDestroy() {
//        myTask.unbind();
        myTask = null;
        Log.d("MY_TAG", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.startBtn){
//            countTxt.setText("Start");

        }
    }

    class MyTask extends AsyncTask<Void,String,Void>{

        private MainActivity activity;

        public void bind(MainActivity activity){
            this.activity = activity;
        }
        public void unbind(){
            activity = null;
        }
        @Override
        protected void onProgressUpdate(String... values) {
            if(activity != null) {
                activity.countTxt.setText(values[0]);
            }
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i < 10; i++) {
                Log.d("MY_TAG", "doInBackground: " + i);
                publishProgress(String.valueOf(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if(activity!= null) {
                activity.countTxt.setText("DONE");
            }
        }
    }
}
