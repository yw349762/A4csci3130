package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class CreateContactAcitivity extends Activity {

    private Button createButton;
    private EditText nameField, emailField,businessNumberField,primaryBusinessField,addressField,provinceField;
    private MyApplicationData appState;
    private String theId;
    private ListView thelist;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        createButton = (Button) findViewById(R.id.createButton);
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        businessNumberField=(EditText) findViewById(R.id.businessnumber);
        primaryBusinessField=(EditText) findViewById(R.id.primarybusiness);
        addressField=(EditText) findViewById(R.id.address);
        provinceField=(EditText) findViewById(R.id.province);
        thelist= (ListView) findViewById(R.id.listView);



        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitInfoButton(v);

            }
        });

    }

    public void submitInfoButton(View v) {



        //each entry needs a unique ID
        final String personID = appState.firebaseReference.push().getKey();
        theId=personID;
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        int businessNumber = Integer.parseInt(businessNumberField.getText().toString());
        String primaryBusiness = primaryBusinessField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        Contact person = new Contact(personID, name, email,businessNumber,primaryBusiness,address,province);

        appState.firebaseReference.child(personID).setValue(person);


        finish();

    }
}
