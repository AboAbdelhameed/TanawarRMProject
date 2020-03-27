package helper_methods;

import android.app.Activity;
import android.app.AlertDialog;

import interfaces.CustomAlertDialog;

public class TanawarAlertDialog implements CustomAlertDialog {
    @Override
    public AlertDialog showSimpleDialog(String title, String message, Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(message).setTitle(title);
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
