package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format.
 * @author Juliano Franz, Soctt Martell
 */
public class Contact implements Serializable {

    public String uid;
    public String name;
    public String number;
    public String business;
    public String address;
    public String territory;

    /**
     * Default constructor required for calls to DataSnapshot.getValue.
     */
    public Contact() {
        //Default constructor.
    }

    /**
     * Constructor for Contact object.
     * @param uid db user id.
     * @param name name of business.
     * @param number id number of business.
     * @param business type of business.
     * @param address address of the business.
     * @param territory territory of the business.
     */
    public Contact(String uid, String name, String number, String business, String address, String territory){
        this.uid = uid;
        this.name = name;
        this.number = number;
        this.business = business;
        this.address = address;
        this.territory = territory;
    }

    /**
     * Hashmap of stored data for the Contact object.
     * @return result.
     */
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("number", number);
        result.put("business", business);
        result.put("address", address);
        result.put("territory", territory);

        return result;
    }

}
