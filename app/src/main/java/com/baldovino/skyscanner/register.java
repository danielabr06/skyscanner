package com.baldovino.skyscanner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {

    TextView email,pass;
    Switch switch1;
    ImageView seePass;
    Button close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email=findViewById(R.id.editText_email);
        pass=findViewById(R.id.editText_pass);

        seePass=findViewById(R.id.imageViewSeePass);

        seePass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrarDialogo();
            }
        });

        switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    Toast.makeText(register.this,R.string.on,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(register.this,R.string.off,Toast.LENGTH_SHORT).show();
                }
            }
        });

        close=findViewById(R.id.buttonCloseR);

        close.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrarDialogoClose();
            }
        });

    }

    private void mostrarDialogo() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.see_password)
                .setMessage(R.string.show_password)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("Message","Hola");
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


    private void mostrarDialogoClose() {
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

    public void register(View view) {

        if(checkCamp()){
            Toast toast = Toast.makeText(this, R.string.regis_success,Toast.LENGTH_SHORT);
            toast.show();

            email.setText("");
            pass.setText("");

        }


    }
}