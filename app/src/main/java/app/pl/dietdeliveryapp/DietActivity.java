package app.pl.dietdeliveryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class DietActivity extends AppCompatActivity {

    TextView tvKcal;
    Spinner sKcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        Intent intent = getIntent();
        tvKcal = findViewById(R.id.tvKcal);
        String valueKcal = "Sugerowana kaloryczność to ".concat(intent
                .getSerializableExtra("kcal").toString());
        tvKcal.setText(valueKcal);

        sKcal = findViewById(R.id.sKcal);
    }
}
