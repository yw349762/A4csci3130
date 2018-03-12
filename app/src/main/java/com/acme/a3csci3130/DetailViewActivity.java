package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField,businessNumberField,primaryBusinessField,addressField,provinceField;
    private Contact receivedPersonInfo;
    private DatabaseReference myRef;
    private FirebaseDatabase database;

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

        database=FirebaseDatabase.getInstance();
        myRef=database.getReference();

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
        String uid=receivedPersonInfo.uid;
        String newname=nameField.getText().toString();
        String newemail=emailField.getText().toString();
        int newbusinessNumber=Integer.parseInt(businessNumberField.getText().toString());
        String newprimaryBusiness=primaryBusinessField.getText().toString();
        String newaddress=addressField.getText().toString();
        String newprovince=provinceField.getText().toString();

        Contact newInfo=new Contact(uid,newname,newemail,newbusinessNumber,newprimaryBusiness,newaddress,newprovince);



        myRef.child(receivedPersonInfo.uid).setValue(newInfo);


    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
    }
}
