package com.example.smarthomenote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Email;
    EditText Password;
    Button btnSignUP;
    Button Registration;

    FirebaseAuth firebaseAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        firebaseAuth = FirebaseAuth.getInstance();

        Email = findViewById(R.id.etEmail);
        Password = findViewById(R.id.etPassword);
        btnSignUP = findViewById(R.id.buttonSignUp);
        Registration = findViewById(R.id.ClickReg);

        btnSignUP.setOnClickListener(this);
        Registration.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btnSignUP) {
            userLogIn();

        }

        if (v == Registration) {
            finish();
            startActivity(new Intent(this, RegistrationActivity.class));
        }
    }

    private void userLogIn() {
        firebaseAuth.signInWithEmailAndPassword(Email.getText().toString(), Password.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LogInActivity.this, " " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
