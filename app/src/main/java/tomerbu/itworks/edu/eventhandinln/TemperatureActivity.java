package tomerbu.itworks.edu.eventhandinln;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TemperatureActivity extends AppCompatActivity {

    FloatingActionButton btnConvert;
    EditText etTemperature;
    TextView tvResult;
    RadioGroup rgTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initLayout();
        handleEvents();
    }

    private void handleEvents() {
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcTemp();
            }
        });

        rgTemperature.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                calcTemp();
            }
        });
    }

    private void calcTemp() {
        try {
            Double input = Double.valueOf(etTemperature.getText().toString());
            if (rgTemperature.getCheckedRadioButtonId() == R.id.toCelsius) {
                String result = (5.0 / 9.0) * (input - 32) + "";
                tvResult.setText(result);
            } else {
                String result = (9.0 / 5.0) * (input) + 32 + "";
                tvResult.setText(result);
            }
        } catch (Exception e) {
            Toast.makeText(TemperatureActivity.this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }


    private void initLayout() {
        btnConvert = (FloatingActionButton) findViewById(R.id.btnConvert);
        etTemperature = (EditText) findViewById(R.id.etTemperature);
        tvResult = (TextView) findViewById(R.id.tvResult);
        rgTemperature = (RadioGroup) findViewById(R.id.rgTemp);
    }

}
