package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class displayes the create contact user interface.
 * @author Juliano Franz, Scott Martell
 */
public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, numField, businessField, addressField, territoryField;
    private MyApplicationData appState;

    /**
     * This method creates the user interface for the CreateContactActivity class.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.createButton);
        nameField = (EditText) findViewById(R.id.name);
        numField = (EditText) findViewById(R.id.number);
        businessField = (EditText) findViewById(R.id.business);
        addressField = (EditText) findViewById(R.id.address);
        territoryField = (EditText) findViewById(R.id.territory);
    }

    /**
     * This method submits the contact info to the database when a button is pressed.
     * @param v View object.
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String number = numField.getText().toString();
        String business = businessField.getText().toString();
        String address = addressField.getText().toString();
        String territory = territoryField.getText().toString();
        Contact person = new Contact(personID, name, number, business, address, territory);

        appState.firebaseReference.child(personID).setValue(person);

        finish();
    }
}
