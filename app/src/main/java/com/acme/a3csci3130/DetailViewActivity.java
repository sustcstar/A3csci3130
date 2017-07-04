package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class displays the detailed view of a contacts info.
 * @author Juliano Franz, Scott Martell
 */
public class DetailViewActivity extends Activity {

    private Button updateContact, eraseContact;
    private EditText nameField, numField, businessField, addressField, territoryField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    /**
     * This method  creates the user inferface for the DetailViewActivity class.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        numField = (EditText) findViewById(R.id.number);
        businessField = (EditText) findViewById(R.id.business);
        addressField = (EditText) findViewById(R.id.address);
        territoryField = (EditText) findViewById(R.id.territory);

        updateContact = (Button) findViewById(R.id.updateButton);
        eraseContact = (Button) findViewById(R.id.deleteButton);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            numField.setText(receivedPersonInfo.number);
            businessField.setText(receivedPersonInfo.business);
            addressField.setText(receivedPersonInfo.address);
            territoryField.setText(receivedPersonInfo.territory);
        }
    }

    /**
     * This method updates contact info when a button is pressed.
     * @param v View object.
     */
    public void updateContact(View v){
        receivedPersonInfo.name = nameField.getText().toString();
        receivedPersonInfo.number = numField.getText().toString();
        receivedPersonInfo.business = businessField.getText().toString();
        receivedPersonInfo.address = addressField.getText().toString();
        receivedPersonInfo.territory = territoryField.getText().toString();
        appState.firebaseReference.child(receivedPersonInfo.uid).setValue(receivedPersonInfo);

        finish();
    }

    /**
     * This method erases a contact from the db when a button is pressed.
     * @param v View object.
     */
    public void eraseContact(View v) {
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();

        finish();
    }
}
