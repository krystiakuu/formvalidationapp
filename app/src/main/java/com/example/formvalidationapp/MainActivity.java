package com.example.formvalidationapp;

import
        android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextEmail;
    private EditText editPhoneNumber;
    private EditText editPassword;
    private EditText editCheckPassword;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextName = findViewById(R.id.editTextname);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextEmail = findViewById(R.id.editTextEmail);
        editPhoneNumber = findViewById(R.id.editPhonenumber);
        editPassword = findViewById(R.id.editPassword);
        editCheckPassword = findViewById(R.id.editCheckPassword);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editPhoneNumber.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                String checkpassword = editCheckPassword.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wprowadz Imie.", Toast.LENGTH_SHORT).show();
                } else if (surname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wprowadz Nazwisko.", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wprowadz Adres E-mail.", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Niepoprawny Adres E-mail.", Toast.LENGTH_SHORT).show();
                } else if (phone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wprowadz Numer Telefonu.", Toast.LENGTH_SHORT).show();
                } else if (phone.length() <9) {
                    Toast.makeText(MainActivity.this, "Niepoprawny Numer Telefonu.", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wprowadz Haslo.", Toast.LENGTH_SHORT).show();
                } else if (password.length() <6) {
                    Toast.makeText(MainActivity.this, "Wprowadzone Haslo Jest Za Krotkie Wprowadz Przynajmniej 6 Znakow.", Toast.LENGTH_SHORT).show();
                } else if (checkpassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wprowadz Ponownie Haslo.", Toast.LENGTH_SHORT).show();
                } else if (!checkpassword.matches(password)) {
                    Toast.makeText(MainActivity.this, "Hasla Nie Sa Takie Same.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Formularz Wyslany.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}