package app.test.zp.state_city;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DataBaseCity ada=new DataBaseCity(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.row_spn, ada.getOstan());
        adapter.setDropDownViewResource(R.layout.row_spn_dropdown);

        final Spinner spn_label = (Spinner)findViewById(R.id.spinner_ostan);
        spn_label.setAdapter(adapter);

        ArrayAdapter<String> adaptercity = new ArrayAdapter<>(MainActivity.this, R.layout.row_spn, ada.getcity(1));
        adaptercity.setDropDownViewResource(R.layout.row_spn_dropdown);

        final Spinner spn_city = (Spinner)findViewById(R.id.spinner_city);
        spn_city.setAdapter(adaptercity);
        spn_label.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ArrayAdapter<String> adaptercity = new ArrayAdapter<>(MainActivity.this, R.layout.row_spn, ada.getcity(position + 1));
                adaptercity.setDropDownViewResource(R.layout.row_spn_dropdown);

                spn_city.setAdapter(adaptercity);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
