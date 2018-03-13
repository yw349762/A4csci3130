package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField,businessNumberField,primaryBusinessField,addressField,provinceField;
    private Contact receivedPersonInfo;
    private DatabaseReference myRef;
    private FirebaseDatabase database;

    private Button updateBtn,deleteBtn;

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
        updateBtn= (Button) findViewById(R.id.updateButton);
        deleteBtn= (Button) findViewById(R.id.deleteButton);

        database=FirebaseDatabase.getInstance();
        myRef=database.getReference();

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContact(v);


                Toast.makeText(DetailViewActivity.this, "Updated!",
                        Toast.LENGTH_LONG).show();

            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eraseContact(v);
                String uid=receivedPersonInfo.uid;

                Toast.makeText(DetailViewActivity.this, uid,
                        Toast.LENGTH_LONG).show();
            }
        });





        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            emailField.setText(receivedPersonInfo.email);
            businessNumberField.setText(Integer.toString(receivedPersonInfo.businessnumber));
            primaryBusinessField.setText(receivedPersonInfo.primarybusiness);
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
        myRef.child("contacts").child(uid).setValue(newInfo);
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("Contact", v);
        startActivity(intent);


    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        String uid=receivedPersonInfo.uid;
        myRef.child("contacts").child(uid).removeValue();
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("Contact", v);
        startActivity(intent);



    }
}
