package interfaces;

import android.app.Activity;
import android.app.AlertDialog;

public interface CustomAlertDialog {

    AlertDialog showSimpleDialog(String title, String message, Activity activity);
}
