package app.pl.dietdeliveryapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PriceActivity extends AppCompatActivity {

    protected TextView tvConfirm;
    protected TextView tvConfirm2;
    private long _splashTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);

        tvConfirm = findViewById(R.id.tvConfirm);
        tvConfirm.setText("Dziękujemy za złożenie zamówienia. Skontatuj się, aby potwierdzić wolne terminy");

        tvConfirm2 = findViewById(R.id.tvConfirm2);
        tvConfirm2.setText("Cena za jeden dzień diety wynosi 47 zł.");


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
                Intent i = new Intent(PriceActivity.this, MainActivity.class);
                startActivity(i);
            }
        }, _splashTime);
    }
}
