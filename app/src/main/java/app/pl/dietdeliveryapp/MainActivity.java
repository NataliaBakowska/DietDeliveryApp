package app.pl.dietdeliveryapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button bOrder;
    protected Button bDelivery;
    protected Button bWeb;
    protected Button bContact;
    protected Button bCall;
    protected Button bOffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bOrder = findViewById(R.id.bOrder);
        bOrder.setOnClickListener(this);

        bDelivery = findViewById(R.id.bDelivery);
        bDelivery.setOnClickListener(this);

        bWeb = findViewById(R.id.bWeb);
        bWeb.setOnClickListener(this);

        bOffer = findViewById(R.id.bOffer);
        bOffer.setOnClickListener(this);

        bContact = findViewById(R.id.bContact);
        bContact.setOnClickListener(this);

        bCall = findViewById(R.id.bCall);
        bCall.setOnClickListener(this);
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

            case R.id.bWeb:
                Intent intent3 = new Intent(this , WebActivity.class );
                startActivity(intent3);
                break;

            case R.id.bContact:
                Intent intent4 = new Intent(this , ContactActivity.class );
                startActivity(intent4);
                break;

            case R.id.bOffer:
                Intent intent5 = new Intent(this , MenuActivity.class );
                startActivity(intent5);
                break;

            case R.id.bCall:
                onCall();
                break;
        }
    }

    public void onCall() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    123);
        } else {
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:510002252")));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case 123:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    onCall();
                } else {
                    Log.d("TAG", "Call Permission Not Granted");
                }
                break;

            default:
                break;
        }
    }
}
