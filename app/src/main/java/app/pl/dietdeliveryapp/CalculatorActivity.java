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

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

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
        spinner.setOnItemClickListener(this);

        cbLoss = findViewById(R.id.cbLoss);
        cbLoss.setOnClickListener(this);

        bSubmit = findViewById(R.id.bSubmit);
        bSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Integer age = Integer.parseInt(etAge.getText().toString());
        Double height = Double.parseDouble(etHeight.getText().toString());
        Double weight = Double.parseDouble(etWeight.getText().toString());
        String gender = spinner.getSelectedItem().toString();
        boolean ifWeightLoss = cbLoss.isChecked();

        int id = v.getId();
        switch ( id ) {
            case R.id.bSubmit:
                int dietKcal = calculateDiet(age, height, weight, gender, ifWeightLoss);
                Intent intent1 = new Intent(this , DietActivity.class );
                intent1.putExtra("kcal", dietKcal);
                startActivity(intent1);
        }
    }

    private int calculateDiet(Integer age, Double height, Double weight, String gender, boolean ifWeightLoss ) {
        return 2000;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
