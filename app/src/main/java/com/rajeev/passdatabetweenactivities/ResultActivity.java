package com.rajeev.passdatabetweenactivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    TextView textView;
    String id = "";
    String name = "";
    String email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView = findViewById(R.id.textView);


        //using intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            //Using Intent
            id = bundle.getString("id", "");
            name = bundle.getString("name", "");
            email = bundle.getString("email", "");
            if (!id.equalsIgnoreCase("") && !name.equalsIgnoreCase("") && !email.equalsIgnoreCase("")) {
                textView.setText("Send data from one activity to another in Android using intent\nid: " + id + "\nname : " + name + "\nemail : " + email);
            } else {


                //Using Serializable Single object
                textView.setText("pass large data between activities in Android using Serializable interface");
                User mUser = (User) bundle.getSerializable("mUser");
                if (mUser != null && !mUser.getId().equalsIgnoreCase("")) {
                    id = mUser.getId();
                    name = mUser.getName();
                    email = mUser.getEmail();
                    textView.setText("" + textView.getText().toString() + "\n" + "\nid: " + id + "\nname : " + name + "\nemail : " + email);
                }


                //Using Serializable userList
                ArrayList<User> userList = (ArrayList<User>) bundle.getSerializable("userList");
                if (userList != null) {

                    for (User user : userList) {
                        id = user.getId();
                        name = user.getName();
                        email = user.getEmail();
                        textView.setText("" + textView.getText().toString() + "\n" + "\nid: " + id + "\nname : " + name + "\nemail : " + email);

                    }

                }


            }

        }


        //using shared prefrences
        SharedPreferences sharedPreferences = getSharedPreferences("myPreferences", MODE_PRIVATE);
        if (sharedPreferences != null) {
            id = sharedPreferences.getString("id", "");
            name = sharedPreferences.getString("name", "");
            email = sharedPreferences.getString("email", "");
            if (!id.equalsIgnoreCase("") && !name.equalsIgnoreCase("") && !email.equalsIgnoreCase("")) {
                textView.setText("Send data from one activity to another in Android using SharedPreferences\nid: " + id + "\nname : " + name + "\nemail : " + email);

            }
        }


        //Using parcelable
        Intent intent = getIntent();
        UserParcelable userParcelable = intent.getParcelableExtra("userParcelable");

        if (userParcelable != null) {

            id = userParcelable.getId();
            name = userParcelable.getName();
            email = userParcelable.getEmail();
            if (!id.equalsIgnoreCase("") && !name.equalsIgnoreCase("") && !email.equalsIgnoreCase("")) {
                textView.setText("Send data from one activity to another in Android using Parcelable interface\nid: " + id + "\nname : " + name + "\nemail : " + email);

            }
        }

        //Using parcelable with list data
        ArrayList<UserParcelable> userParcelableList = getIntent().getParcelableArrayListExtra("userParcelableList");
        if (userParcelableList != null) {
            textView.setText("Send data List from one activity to another in Android using Parcelable interface  using intent \n");
            for (UserParcelable user : userParcelableList) {
                id = user.getId();
                name = user.getName();
                email = user.getEmail();
                textView.setText("" + textView.getText().toString() + "\n" + "\nid: " + id + "\nname : " + name + "\nemail : " + email);

            }

        }


    }
}
