package ir.sadeqsalehi.workwithdialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    int selectedItemIndex = 0;
    TextView tvResultIDE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        tvResultIDE = findViewById(R.id.tvResult);
    }

    public void showAlertDialogOnClick(View view) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Exit")
                .setMessage("Are you Sure ?")
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .setNeutralButton("Cancel", null);
        alertBuilder.show();
    }

    public void showAlertDialogOnClick2(View view) {
        String[] options = new String[]{"Eclipse", "Visual Studio Code", "NetBeans", "Android Studio"};
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Select your favorite IDE please.")
                .setCancelable(false)
                .setSingleChoiceItems(options, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedItemIndex = which;
                    }
                })
                .setPositiveButton("Select", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvResultIDE.setText(whichIDE(selectedItemIndex));
                    }
                })
        ;
        alertBuilder.show();
    }

    public void showAlertDialogOnClick3(View view) {
        String[] options = new String[]{"Eclipse", "Visual Studio Code", "NetBeans", "Android Studio"};
        final boolean[] checkedItems = new boolean[]{false, true, false, false};
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Select your favorite IDEs please.")
                .setCancelable(true)
                .setMultiChoiceItems(options, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedItems[which] = isChecked;
                    }
                })
                .setPositiveButton("Select", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder allCheckedItems = new StringBuilder();
                        for (int i = 0; i < checkedItems.length; i++) {
                            if (checkedItems[i])
                                allCheckedItems.append(whichIDE(i)).append("\n");
                        }
                        tvResultIDE.setText(allCheckedItems.toString());
                    }
                });
        alertBuilder.show();
    }

    public String whichIDE(int index) {
        String result = "Not Set";
        switch (index) {
            case 0:
                result = "Eclipse";
                break;
            case 1:
                result = "Visual Studio Code";
                break;
            case 2:
                result = "NetBeans";
                break;
            case 3:
                result = "Android Studio";
                break;
            default:
                break;
        }
        return result;
    }

    public void showCustomAlertDialogOnClick(View view) {
        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.simple_layout_dialog);
        dialog.show();
    }
}