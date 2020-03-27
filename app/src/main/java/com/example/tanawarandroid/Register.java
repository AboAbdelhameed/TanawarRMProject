package com.example.tanawarandroid;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import helper_methods.TanawarAlertDialog;
import interfaces.InitializeComponents;

public class Register extends AppCompatActivity implements InitializeComponents {
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private ImageView datePickerIcon;
    private TextView dateField;
    private boolean isbirthdayChoosen = false;
    private Calendar birthday;
    private Spinner accountType;
    private ArrayAdapter<String> account_typeAdapter;
    private String account_type_choice;
    private EditText fname;
    private EditText lname;
    private EditText email;
    private EditText password;
    private EditText verifyPassword;
    private EditText phonenumber;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initializeActivityComponents();
        initializeComponentsListeners();
        initializeDatePickerListener();

    }
    @Override
    public void initializeActivityComponents() {
        datePickerIcon = findViewById(R.id.birthdayIMG);
        dateField = findViewById(R.id.date_field);
        accountType = findViewById(R.id.accountTypeSpinner);
        account_typeAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.account_type_spinner));
        account_typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountType.setAdapter(account_typeAdapter);
        fname = findViewById(R.id.edtfirstname);
        lname = findViewById(R.id.edtLastname);
        email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.edtPassword);
        verifyPassword = findViewById(R.id.edtVerfiyPassword);
        phonenumber = findViewById(R.id.edtPhoneNumber);
        submit = findViewById(R.id.btnSubmit);
    }
    @Override
    public void initializeComponentsListeners() {
        this.dateField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        datePickerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        this.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account_type_choice = accountType.getSelectedItem().toString();
                if(emptyFieldsTest() && emailIsValid() && passwordIsValid() && phoneIsValid()){
                    // go to Firebase and sign up
                    //if successfully go to login and pass username and password

                }

            }
        });
    }
    /**
     *
     * @return
     */
    private boolean phoneIsValid() {
        boolean res = Patterns.PHONE.matcher(this.phonenumber.getText().toString()).matches();
        if(!res){
            new TanawarAlertDialog().showSimpleDialog(getResources().getString(R.string.wrong_value),
                    getResources().getString(R.string.phone_incorrect),
                    Register.this).show();
        }
        return res;
    }
    /**
     *
     * @return
     */
    private boolean passwordIsValid() {
        String password = this.password.getText().toString();
        String[] password_messages = getResources().getStringArray(R.array.password_invalid);
        // check if password contains Upper Case
        boolean x = isContainsUpperCase(password);
        // check if password contains Lower Case
        boolean y = isContainsLowerCase(password);
        // check if password contains Numbers
        boolean z = isContainsDigit(password);
        if(!x){
            new TanawarAlertDialog().showSimpleDialog(password_messages[0] ,password_messages[1] ,
                    Register.this).show();
            return false;
        }
        if(!y){
            new TanawarAlertDialog().showSimpleDialog(password_messages[0] ,password_messages[2] ,
                    Register.this).show();
            return false;
        }
        if(!z){
            new TanawarAlertDialog().showSimpleDialog(password_messages[0] ,password_messages[3] ,
                    Register.this).show();
            return false;
        }
        // check password length.
        if(password.length()<8) {
            new TanawarAlertDialog().showSimpleDialog(password_messages[0] ,password_messages[4] ,
                    Register.this).show();
            return false;
        }
        // get the verify password .
        String verifyPass = verifyPassword.getText().toString();
        // the password is valid and correct .
        if(!password.equals(verifyPass)) {
            new TanawarAlertDialog().showSimpleDialog(password_messages[0] ,password_messages[5] ,
                    Register.this).show();
            return false;
        }
        return true;
    }
    /**
     *
     * @param password
     * @return
     */
    private boolean isContainsDigit(String password) {
        for (char ch : password.toCharArray()){
            if(Character.isDigit(ch))
                return true;
        }
        return false;
    }
    /**
     *
     * @param password
     * @return
     */
    private boolean isContainsLowerCase(String password) {
        for (char ch : password.toCharArray()){
            if(Character.isLowerCase(ch))
                return true;
        }
        return false;
    }
    /**
     *
     * @param password
     * @return
     */
    private boolean isContainsUpperCase(String password) {
        for (char ch : password.toCharArray()){
            if(Character.isUpperCase(ch))
                return true;
        }
        return false;
    }
    /**
     *
     * @return
     */
    private boolean emailIsValid() {
        boolean res = Patterns.EMAIL_ADDRESS.matcher(this.email.getText().toString()).matches();
        if(!res){
            new TanawarAlertDialog().showSimpleDialog(getResources().getString(R.string.wrong_value) ,
                    getResources().getString(R.string.email_incorrect),
                    Register.this).show();
        }
        return res;
    }
    /**
     *
     * @return
     */
    private boolean emptyFieldsTest() {
        String fname = this.fname.getText().toString();
        String[] messages = getResources().getStringArray(R.array.register_form_fields_dialog_emptyTest);
        if(fname.isEmpty()){
            showEmptyFieldAlertDialog(messages,0);
            return false;
        }
        String lname = this.lname.getText().toString();
        if(lname.isEmpty()){
            showEmptyFieldAlertDialog(messages,1);
            return false;
        }
        String email = this.email.getText().toString();
        if(email.isEmpty()){
            showEmptyFieldAlertDialog(messages,2);
            return false;
        }
        String password = this.password.getText().toString();
        if(password.isEmpty()){
            showEmptyFieldAlertDialog(messages,3);
            return false;
        }
        String verifyPassword = this.verifyPassword.getText().toString();
        if(verifyPassword.isEmpty()){
            showEmptyFieldAlertDialog(messages,4);
            return false;
        }
        if(!isbirthdayChoosen){
            showEmptyFieldAlertDialog(messages,5);
            return false;
        }
        if(account_type_choice.isEmpty()){
            showEmptyFieldAlertDialog(messages,6);
            return false;
        }
        String phone = this.phonenumber.getText().toString();
        if(phone.isEmpty()){
            showEmptyFieldAlertDialog(messages,7);
            return false;
        }
        return true;
    }
    /**
     *
     * @param messages
     * @param messageID
     */
    private void showEmptyFieldAlertDialog(String[] messages,int messageID){
        new TanawarAlertDialog().showSimpleDialog(getResources().getString(R.string.empty_field)
                , messages[messageID],this).show();
    }
    /**
     *
     */
    private void initializeDatePickerListener(){
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                setBirthday(year,month,dayOfMonth);
            }
        };
    }
    /**
     *
     * @param year
     * @param month
     * @param dayOfMonth
     */
    private void setBirthday(int year, int month, int dayOfMonth){
        this.birthday = Calendar.getInstance();
        this.birthday.set(year,month,dayOfMonth);
        this.dateField.setText(dayOfMonth+"-"+month+"-"+year);
        isbirthdayChoosen = true;
    }
    /**
     *
     */
    private void showDatePickerDialog(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(Register.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener,
                year, month , day);
        Calendar maximumDate = Calendar.getInstance();
        maximumDate.add(Calendar.DATE, -1);
        dialog.getDatePicker().setMaxDate(maximumDate.getTimeInMillis());
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}
