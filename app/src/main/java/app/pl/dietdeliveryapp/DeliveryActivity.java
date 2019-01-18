package app.pl.dietdeliveryapp;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;


public class DeliveryActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        PolygonOptions rectOptions = new PolygonOptions()
                .add(new LatLng(52.188292, 20.855569),
                        new LatLng(52.105517, 20.983749),
                        new LatLng(52.090045, 21.084964),
                        new LatLng(52.146677, 21.255410),
                        new LatLng(52.266146, 21.256676),
                        new LatLng(52.289991, 21.177118),
                        new LatLng(52.278008, 21.106528),
                        new LatLng(52.368516, 21.077228),
                        new LatLng(52.367091, 20.935299),
                        new LatLng(52.279675, 20.868994))
                        .fillColor(0x7F00FF00);

        Polygon polygon = mMap.addPolygon(rectOptions);
        polygon.setStrokeWidth(1);
        polygon.setClickable(true);


        LatLng latLng = new LatLng(52.230237, 21.011884);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,9));
        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        mMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
            @Override
            public void onPolygonClick(Polygon polygon) {
                Intent intent  = new Intent(getApplicationContext(), MyDeliveryActivity.class);
                startActivity(intent);
            }
        });

    }
}
