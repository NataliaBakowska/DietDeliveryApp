package app.pl.dietdeliveryapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener{

    protected EditText etTitle;
    protected EditText etEmail;
    protected EditText etMessage;
    protected Button bSubmit;

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
        String email = "nbakowska5@gmail.com";
        String title = etTitle.toString();
        String message = etMessage.toString();

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, title);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
       //emailIntent.putExtra(Intent.EXTRA_HTML_TEXT, body); //If you are using HTML in your body text

        startActivity(Intent.createChooser(emailIntent, "Chooser Title"));
    }
}
