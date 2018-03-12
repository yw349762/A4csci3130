package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField,businessNumberField,primaryBusinessField,addressField,provinceField;
    Contact receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.nameDetail);
        emailField = (EditText) findViewById(R.id.emailDetail);
        businessNumberField=(EditText) findViewById(R.id.businessNumberDetail);
        primaryBusinessField=(EditText) findViewById(R.id.primaryBusinessDetail);
        addressField=(EditText) findViewById(R.id.addressDetail);
        provinceField=(EditText) findViewById(R.id.provinceDetail);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            emailField.setText(receivedPersonInfo.email);
            businessNumberField.setText(Integer.toString(receivedPersonInfo.businessNumber));
            primaryBusinessField.setText(receivedPersonInfo.primaryBusiness);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
    }
}
