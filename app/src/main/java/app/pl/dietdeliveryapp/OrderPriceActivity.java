package app.pl.dietdeliveryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderPriceActivity extends AppCompatActivity implements View.OnClickListener {

    protected TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_price);

        tvResult = findViewById(R.id.tvResult);

        Intent intent = getIntent();
        tvResult = findViewById(R.id.tvResult);
        String valueKcal = intent.getSerializableExtra("finalMessage").toString();
        tvResult.setText(valueKcal);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch ( id ) {
            case R.id.bConfirmOrder:
                Intent intent = new Intent(this, PriceActivity.class);
                startActivity(intent);
        }
    }
}
