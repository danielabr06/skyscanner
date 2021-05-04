package com.baldovino.skyscanner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login extends AppCompatActivity {
    TextView email,pass;
    Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.editText_emailL);
        pass=findViewById(R.id.editText_PasswordL);

        close=findViewById(R.id.buttonClose);

        close.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrarDialogo();
            }
        });
    }

    private void mostrarDialogo() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.close_title)
                .setMessage(R.string.close_message)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("Message","Hola");
                    }
                })
                .show();
    }


    public boolean checkCamp(){
        String camp1, camp2;
        boolean returnn=true;

        camp1=email.getText().toString();
        camp2=pass.getText().toString();
        if(camp1.isEmpty()){
            email.setError(getString(R.string.write_email));
            returnn= false;
        }
        if(camp2.isEmpty()){
            pass.setError(getString(R.string.write_pass));
            returnn= false;
        }
        return returnn;

    }

    public void newRegister(View view) {
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }

    public void login(View view) {
        if(checkCamp()){
            Intent intent = new Intent(this, Explore.class);
            startActivity(intent);
        }
    }


}