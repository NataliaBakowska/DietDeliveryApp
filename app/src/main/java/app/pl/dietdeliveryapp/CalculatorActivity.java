package app.pl.dietdeliveryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
//        spinner.setOnItemClickListener(this);

        cbLoss = findViewById(R.id.cbLoss);
        cbLoss.setOnClickListener(this);

        bSubmit = findViewById(R.id.bSubmit);
        bSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String age = etAge.getText().toString();
        String height = etHeight.getText().toString();
        String weight = etWeight.getText().toString();
        String gender = spinner.getSelectedItem().toString();
        boolean ifWeightLoss = cbLoss.isChecked();

    }
}
