package app.pl.dietdeliveryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class DietActivity extends AppCompatActivity implements View.OnClickListener {

    protected TextView tvKcal;
    protected Spinner sKcal;
    protected CheckBox cbGluten;
    protected CheckBox cbLactose;
    protected CheckBox cbVege;
    protected Button bSubmitOrder;
    protected TextView etOthers;
    protected Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        intent = getIntent();
        tvKcal = findViewById(R.id.tvKcal);
        String valueKcal = "Sugerowana kaloryczność to ".concat(intent
                .getSerializableExtra("kcal").toString());
        tvKcal.setText(valueKcal);

        sKcal = findViewById(R.id.sKcal);

        cbGluten = findViewById(R.id.cbGluten);
        cbGluten.setOnClickListener(this);
        cbLactose = findViewById(R.id.cbLactose);
        cbLactose.setOnClickListener(this);
        cbVege = findViewById(R.id.cbVege);
        cbVege.setOnClickListener(this);
        etOthers = findViewById(R.id.etOthers);
        etOthers.setOnClickListener(this);
        bSubmitOrder = findViewById(R.id.bSubmitOrder);
        bSubmitOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String finalKcal  = (String)(sKcal.getSelectedItem().equals("") ? intent.getSerializableExtra("kcal").toString() : sKcal.getSelectedItem());
        String otherMessage = etOthers.getText().toString();
        boolean ifGlutenFree = cbGluten.isChecked();
        boolean ifLactoseFree = cbLactose.isChecked();
        boolean ifVege = cbVege.isChecked();

        int id = v.getId();
        switch ( id ) {
            case R.id.bSubmitOrder:
                String confirmationMessage = formOrder(finalKcal, otherMessage, ifGlutenFree, ifLactoseFree, ifVege);
                Intent intent = new Intent(this, OrderPriceActivity.class);
                intent.putExtra("finalMessage", confirmationMessage);
                System.out.println(confirmationMessage);
                startActivity(intent);
        }
    }

    private String formOrder( String finalKcal, String otherMessage, boolean ifGlutenFree, boolean ifLactoseFree, boolean ifVege) {
        String init = "Zamawiasz dietę o kaloryczności " + finalKcal + "\n";
        String ifGluten = ifGlutenFree ? "- bez glutenu " + "\n" : "";
        String ifLactose = ifLactoseFree ? "- bez laktozy" + "\n" : "";
        String ifVege2 = ifVege ? "- wegetariańską" + "\n" : "";
        return  init + ifGluten + ifLactose + ifVege2;
    }
}
