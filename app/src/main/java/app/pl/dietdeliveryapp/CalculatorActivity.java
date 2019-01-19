package app.pl.dietdeliveryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText etAge;
    protected EditText etHeight;
    protected EditText etWeight;
    protected Spinner spinner;
    protected CheckBox cbLoss;
    protected Button bSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        etAge = findViewById(R.id.etAge);
        etAge.setOnClickListener(this);

        etHeight = findViewById(R.id.etHeight);
        etHeight.setOnClickListener(this);

        etWeight = findViewById(R.id.etWeight);
        etWeight.setOnClickListener(this);

        spinner = findViewById(R.id.spinner);

        cbLoss = findViewById(R.id.cbLoss);
        cbLoss.setOnClickListener(this);

        bSubmit = findViewById(R.id.bSubmit);
        bSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            Integer age = Integer.parseInt(etAge.getText().toString());
            Double height = Double.parseDouble(etHeight.getText().toString());
            Double weight = Double.parseDouble(etWeight.getText().toString());
            String gender = spinner.getSelectedItem().toString();
            boolean ifWeightLoss = cbLoss.isChecked();

            int id = v.getId();
            switch (id) {
                case R.id.bSubmit:
                    int dietKcal = calculateDiet(age, height, weight, gender, ifWeightLoss);
                    Intent intent1 = new Intent(this, DietActivity.class);
                    intent1.putExtra("kcal", dietKcal);
                    startActivity(intent1);
            }
        } catch (Exception e) {
            e.getCause();
        }
    }

    private Integer calculateDiet(Integer age, Double height, Double weight, String gender, boolean ifWeightLoss ) {
        System.out.println(age + " " +height + " " + weight + " " + gender + " " + ifWeightLoss);
        int kcal = 0;

        if (gender.equals("Kobieta")) {
            kcal = (int) ((655 + (9.6 * weight) + (1.8 * height)) - (4.7 * age));
        } else if (gender.equals("Mężczyzna")) {
            kcal = (int) ((66 + (13.7 * weight) + (5 * height)) - (6.76 * age));
        }

        if (ifWeightLoss) {
            kcal = kcal - 300;
        }

        if (kcal <= 1400) {
            kcal = 1200;
        } else if (kcal <= 1800) {
            kcal = 1600;
        } else if (kcal <= 2200 ) {
            kcal = 2000;
        } else if (kcal <= 2600) {
            kcal = 2500;
        } else if (kcal <= 3000) {
            kcal = 3000;
        }
        return kcal;
    }

}
