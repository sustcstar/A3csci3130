package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

/**
 * This class displays the main user interface for the application.
 * @author Juliano Franz, Scott Martell
 */
public class MainActivity extends Activity {

    private ListView contactListView;
    private FirebaseListAdapter<Contact> firebaseAdapter;

    /**
     * This method create the user interface for MainActivity.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the app wide shared variables
        MyApplicationData appData = (MyApplicationData)getApplication();

        //Set-up Firebase
        appData.firebaseDBInstance = FirebaseDatabase.getInstance();
        appData.firebaseReference = appData.firebaseDBInstance.getReference("contacts");

        //Get the reference to the UI contents
        contactListView = (ListView) findViewById(R.id.listView);

        //Set up the List View
       firebaseAdapter = new FirebaseListAdapter<Contact>(this, Contact.class, android.R.layout.simple_list_item_1, appData.firebaseReference) {
           /**
            * This method populates the list view with information gathered from firebase.
            * @param v View object.
            * @param model a contact object with all of the contact information.
            * @param position position in the list.
            */
            @Override
            protected void populateView(View v, Contact model, int position) {
                TextView contactName = (TextView)v.findViewById(android.R.id.text1);
                contactName.setText(model.name);
            }
        };
        contactListView.setAdapter(firebaseAdapter);
        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * onItemClick method is called everytime a user clicks an item on the list
             * @param parent parent in db hierarchy.
             * @param view View object.
             * @param position position in the list.
             * @param id firebase id.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact person = (Contact) firebaseAdapter.getItem(position);
                showDetailView(person);
            }
        });
    }

    /**
     * when create contact button is clicked, a user interface opens for creating a contact.
     * @param v View object.
     */
    public void createContactButton(View v) {
        Intent intent=new Intent(this, CreateContactAcitivity.class);
        startActivity(intent);
    }

    /**
     * When a user in the list view is clicked, an interface will open with a detail view of
     * the user's info.
     * @param person Contact object to be displayed.
     */
    private void showDetailView(Contact person) {
        Intent intent = new Intent(this, DetailViewActivity.class);
        intent.putExtra("Contact", person);
        startActivity(intent);
    }
}
