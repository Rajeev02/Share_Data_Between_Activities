package com.rajeev.passdatabetweenactivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText user_id, user_name, user_email;
    Button button_intent, button_shared_preference, button_serializable, button_serializable_list,
            button_parcelable, button_parcelable_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_id = findViewById(R.id.user_id);
        user_name = findViewById(R.id.user_name);
        user_email = findViewById(R.id.user_email);

        button_intent = findViewById(R.id.button_intent);
        button_shared_preference = findViewById(R.id.button_shared_preference);
        button_serializable = findViewById(R.id.button_serializable);
        button_serializable_list = findViewById(R.id.button_serializable_list);
        button_parcelable = findViewById(R.id.button_parcelable);
        button_parcelable_list = findViewById(R.id.button_parcelable_list);



        button_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAnyEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all info", Toast.LENGTH_SHORT).show();
                } else {
                    passDataUsingIntetBetweenActivities();
                }
            }
        });

        button_shared_preference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAnyEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all info", Toast.LENGTH_SHORT).show();
                } else {
                    passDataUsingSharedPreferencesBetweenActivities();
                }
            }
        });

        button_serializable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAnyEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all info", Toast.LENGTH_SHORT).show();
                } else {
                    passDataUsingSerializableBetweenActivities();
                }
            }
        });

        button_serializable_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAnyEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all info", Toast.LENGTH_SHORT).show();
                } else {
                    passDataListUsingSerializableBetweenActivities();
                }
            }
        });
        button_parcelable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAnyEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all info", Toast.LENGTH_SHORT).show();
                } else {
                    passDataUsingParcelableBetweenActivities();
                }
            }
        });

        button_parcelable_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAnyEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all info", Toast.LENGTH_SHORT).show();
                } else {
                    passDataListUsingParcelableBetweenActivities();
                }
            }
        });





    }

    private void passDataUsingSerializableBetweenActivities() {
        String id = user_id.getText().toString().trim();
        String name = user_name.getText().toString().trim();
        String email = user_email.getText().toString().trim();
        User mUser = new User(id, name, email);
        Bundle bundle = new Bundle();
        bundle.putSerializable("mUser" , mUser);
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);


    }

    private void passDataListUsingSerializableBetweenActivities() {
        String id = user_id.getText().toString().trim();
        String name = user_name.getText().toString().trim();
        String email = user_email.getText().toString().trim();
        ArrayList<User> userList  = new ArrayList<>();
        userList.add(new User(id+"-1", name+"-1", email+"-1"));
        userList.add(new User(id+"-2", name+"-2", email+"-2"));
        userList.add(new User(id+"-3", name+"-3", email+"-3"));
        userList.add(new User(id+"-4", name+"-4", email+"-4"));
        Bundle bundle = new Bundle();
        bundle.putSerializable("userList" , userList);
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);


    }

    private void passDataUsingParcelableBetweenActivities() {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        UserParcelable userParcelable = new UserParcelable(user_id.getText().toString(), user_name.getText().toString(), user_email.getText().toString());
        intent.putExtra("userParcelable", userParcelable);
        startActivity(intent);
    }

    private void passDataListUsingParcelableBetweenActivities() {
        String id = user_id.getText().toString().trim();
        String name = user_name.getText().toString().trim();
        String email = user_email.getText().toString().trim();
        ArrayList<UserParcelable> userList  = new ArrayList<>();
        userList.add(new UserParcelable(id+"-1", name+"-1", email+"-1"));
        userList.add(new UserParcelable(id+"-2", name+"-2", email+"-2"));
        userList.add(new UserParcelable(id+"-3", name+"-3", email+"-3"));
        userList.add(new UserParcelable(id+"-4", name+"-4", email+"-4"));

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putParcelableArrayListExtra("userParcelableList", userList);
        startActivity(intent);

    }






    private void passDataUsingSharedPreferencesBetweenActivities() {

        SharedPreferences sharedPref = getSharedPreferences("myPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("id", ""+user_id.getText().toString());
        editor.putString("name", ""+user_name.getText().toString());
        editor.putString("email", ""+user_email.getText().toString());
        editor.apply();


        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        startActivity(intent);


    }

    private void passDataUsingIntetBetweenActivities() {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("id", ""+user_id.getText().toString());
        intent.putExtra("name", ""+user_name.getText().toString());
        intent.putExtra("email", ""+user_email.getText().toString());
        startActivity(intent);
    }

    boolean isAnyEmpty() {
        if (user_email.getText().toString().equalsIgnoreCase("")) {
            return true;
        }
        if (user_name.getText().toString().equalsIgnoreCase("")) {
            return true;
        }
        return user_id.getText().toString().equalsIgnoreCase("");

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getSharedPreferences("myPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("id", "");
        editor.putString("name", "");
        editor.putString("email", "");
        editor.apply();
    }
}
