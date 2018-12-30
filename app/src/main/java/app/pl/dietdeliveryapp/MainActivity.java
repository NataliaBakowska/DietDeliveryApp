package app.pl.dietdeliveryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button bOrder;
    protected Button bDelivery;
    protected Button button3;
    protected Button bContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bOrder = findViewById(R.id.bOrder);
        bOrder.setOnClickListener(this);

        bDelivery = findViewById(R.id.bDelivery);
        bDelivery.setOnClickListener(this);

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        bContact = findViewById(R.id.bContact);
        bContact.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch ( id ) {
            case R.id.bOrder:
                Intent intent1 = new Intent(this , CalculatorActivity.class );
                startActivity(intent1);
                break;

            case R.id.bDelivery:
                Intent intent2 = new Intent(this , DeliveryActivity.class );
                startActivity(intent2);
                break;

            case R.id.button3:
                Intent intent3 = new Intent(this , WelcomeActivity.class );
                startActivity(intent3);
                break;

            case R.id.bContact:
                Intent intent4 = new Intent(this , ContactActivity.class );
                startActivity(intent4);
                break;
        }
    }
}
