package ir.sadeqsalehi.workwithdialogs;

import android.app.ProgressDialog;
//import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class ProgressDialogActivity extends AppCompatActivity {
    int progress = 0;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showProgressDialogOnClick(View view) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Operation in progress");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("Please Wait to Complete ...");
        //progressDialog.setIndeterminate(true);
        progressDialog.show();

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (progressDialog == null) return;
                if (progressDialog.getProgress() < progressDialog.getMax())
                    progressDialog.incrementProgressBy(1);
                else {
                    progressDialog.dismiss();
                    this.cancel();
                }
            }
        }, 0, 100);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (progressDialog == null) return;
                if (progressDialog.getSecondaryProgress() < progressDialog.getMax()) {
                    progressDialog.incrementSecondaryProgressBy(1);
                } else
                    this.cancel();
            }
        }, 0, 75);
/*
         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 progressDialog.dismiss();
             }
         }, 3000L);
*/

    }
}
