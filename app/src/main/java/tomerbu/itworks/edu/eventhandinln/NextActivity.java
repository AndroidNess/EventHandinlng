package tomerbu.itworks.edu.eventhandinln;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

    TextView tvHelloUser;
    EditText etUserName;
    RadioGroup rgColors;
    RadioButton rbRed, rbAzure, rbPink;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initLayout();
        initEvents();
    }

    private void initEvents() {
        rgColors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int color = 0x00;
                switch (checkedId){
                    case R.id.rbRed:
                        color = Color.RED;
                        break;
                    case R.id.rbPink:
                        color = 0xFFFFABED;
                        break;
                    case R.id.rbAzure:
                        color = 0xFF22FFFB;
                        break;
                }
                group.setBackgroundColor(color);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String greet = "Hello, " + etUserName.getText();
                tvHelloUser.setText(greet);
                Toast.makeText(NextActivity.this, greet, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initLayout() {
        tvHelloUser = (TextView) findViewById(R.id.tvHello);
        etUserName = (EditText) findViewById(R.id.etUSerName);
        rgColors = (RadioGroup) findViewById(R.id.rgColor);
        rbRed = (RadioButton) findViewById(R.id.rbRed);
        rbAzure = (RadioButton) findViewById(R.id.rbAzure);
        rbPink = (RadioButton) findViewById(R.id.rbPink);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
    }

}
