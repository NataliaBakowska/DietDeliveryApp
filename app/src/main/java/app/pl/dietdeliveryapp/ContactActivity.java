package app.pl.dietdeliveryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etTitle;
    EditText etEmail;
    EditText etMessage;
    Button bSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        etTitle = findViewById(R.id.etTitle);
        etTitle.setOnClickListener(this);

        etEmail = findViewById(R.id.etEmail);
        etEmail.setOnClickListener(this);

        etMessage = findViewById(R.id.etMessage);
        etMessage.setOnClickListener(this);

        bSubmit = findViewById(R.id.bSubmit);
        bSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this , DietActivity.class );
        startActivity(intent);
    }
}
