package com.example.mailingsystem;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mailingsystem.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    //creating object for the three edittext.
    EditText edittextsubect ,edittextcontent, edittextmail;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnsend);
        edittextsubect = findViewById(R.id.subject);
        edittextcontent = findViewById(R.id.content);
        edittextmail = findViewById(R.id.to_email);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String subject,content,to_email;
                subject = edittextsubect.getText().toString();
                content = edittextsubect.getText().toString();
                to_email = edittextsubect.getText().toString();

                if(subject.equals("")&& content.equals("") && to_email.equals("")){
                    Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();


                }
                else{
                    sendingEmail( subject,content,to_email);
                }


            }
        });




    }

    public void sendingEmail( String subject ,String content ,String to_email ){
       Intent intent = new Intent(Intent.ACTION_SEND);
       intent.putExtra(Intent.EXTRA_EMAIL,new String[] {to_email});
       intent.putExtra(Intent.EXTRA_SUBJECT, subject);
       intent.putExtra(Intent.EXTRA_TEXT, content);
       intent.setType("message/rfc822");
       startActivity(Intent.createChooser(intent, "Choose email client"));

    }
}
