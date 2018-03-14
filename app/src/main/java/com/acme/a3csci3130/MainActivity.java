package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends Activity {
    private Button updateButtonMain,deleteButtonMain,createButtonMain;
    private LinearLayout linearLayoutMain;
    private TextView infoText;


    private ListView contactListView;
    private FirebaseListAdapter<Contact> firebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayoutMain= (LinearLayout) findViewById(R.id.MainLin1);

        deleteButtonMain= (Button) findViewById(R.id.deleteButtonMain);
        updateButtonMain= (Button) findViewById(R.id.updateButtonMain);
        createButtonMain= (Button) findViewById(R.id.createButtonMain);
        infoText= (TextView) findViewById(R.id.infoText);

        createButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoText.setText("Create user");
                createContactButton(v);
            }
        });
        updateButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoText.setText("Please select a user from list");

            }
        });

        deleteButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoText.setText("Please select a user from list");

            }
        });





        //Get the app wide shared variables
        MyApplicationData appData = (MyApplicationData)getApplication();


        //Set-up Firebase
        appData.firebaseDBInstance = FirebaseDatabase.getInstance();
        appData.firebaseReference = appData.firebaseDBInstance.getReference("contacts");

        //Get the reference to the UI contents
        contactListView = (ListView) findViewById(R.id.listView);

        //Set up the List View
       firebaseAdapter = new FirebaseListAdapter<Contact>(this, Contact.class,
                android.R.layout.simple_list_item_1, appData.firebaseReference) {
            @Override
            protected void populateView(View v, Contact model, int position) {
                TextView contactName = (TextView)v.findViewById(android.R.id.text1);
                contactName.setText(model.name);
            }
        };
        contactListView.setAdapter(firebaseAdapter);
        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // onItemClick method is called everytime a user clicks an item on the list
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact person = (Contact) firebaseAdapter.getItem(position);
                showDetailView(person);
            }
        });
    }

    public void createContactButton(View v)

    {

        Intent intent=new Intent(this, CreateContactAcitivity.class);
        startActivity(intent);

    }

    private void showDetailView(Contact person)
    {
        Intent intent = new Intent(this, DetailViewActivity.class);
        intent.putExtra("Contact", person);
        startActivity(intent);
    }



}
