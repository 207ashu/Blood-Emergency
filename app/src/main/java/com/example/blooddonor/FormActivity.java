package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class    FormActivity extends AppCompatActivity {

    private EditText inputEmail;
    private EditText inputName;
    private Spinner inputGender;
    private EditText inputContact;
    private Spinner inputBloodGroup;
    private Button btnSave;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Intent intent = getIntent();

        String username = intent.getStringExtra("Username");
        String email = intent.getStringExtra("Email");

        mDatabase = FirebaseDatabase.getInstance().getReference("donor");

        inputEmail = findViewById(R.id.Donor_email);
        inputName = findViewById(R.id.Donor_name);
        inputGender = findViewById(R.id.Gender);
        inputContact = findViewById(R.id.Donor_number);
        inputBloodGroup = findViewById(R.id.bloodGroup);
        btnSave = findViewById(R.id.btn_save);

        inputEmail.setText(email);
        inputName.setText(username);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDonor();
            }
        });
    }
    private void AddDonor(){
        String name = inputName.getText().toString();
        String email = inputEmail.getText().toString();
        String gender = inputGender.getSelectedItem().toString();
        String bloodgroup = inputBloodGroup.getSelectedItem().toString();
        String contact = inputContact.getText().toString();

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(contact) && !TextUtils.isEmpty(bloodgroup) && !TextUtils.isEmpty(gender)) {
            String id = mDatabase.push().getKey();

            Donor donor = new Donor(name,email,gender,bloodgroup, contact);

            if(id.length() != 0 )
                mDatabase.child(id).setValue(donor);

            Toast.makeText(this, "Donor Added", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Fill the form first", Toast.LENGTH_LONG).show();
        }
    }

}