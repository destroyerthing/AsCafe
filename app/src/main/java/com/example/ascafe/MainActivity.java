package com.example.ascafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPassword;

    private Button buttonSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextName.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (userName.isEmpty() || password.isEmpty()) {
                    Toast.makeText(
                            MainActivity.this, "Поля не заполнена", Toast.LENGTH_SHORT
                    ).show();
                } else {
                    launchNextScreen(userName);
                }
            }
        });
    }


    public void ShowHidePass(View view) {

        editTextPassword = (EditText) findViewById(R.id.edit_text_password);
        if (view.getId() == R.id.show_pass_btn) {
            if (editTextPassword.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                ((ImageView) view).setImageResource(R.drawable.textwatch);
                editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                ((ImageView) (view)).setImageResource(R.drawable.baseline_remove_red_eye_24);
                editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }


    private void launchNextScreen(String userName) {
        Intent intent = MakeOrderActivity.newIntent(this, userName);
        startActivity(intent);
    }

    private void initViews() {
        editTextName = findViewById(R.id.edit_text_name);
        editTextPassword = findViewById(R.id.edit_text_password);

        buttonSignIn = findViewById(R.id.btn_sign_in);
    }
}