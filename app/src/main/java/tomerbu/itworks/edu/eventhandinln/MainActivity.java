package tomerbu.itworks.edu.eventhandinln;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnLeft, btnRight;
    ImageView ivGallery;
    ArrayList<Integer> images = new ArrayList<>();
    int currentImageIdx = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initLayout();
       initImages();
    }

    private void initImages() {
        images.add(R.drawable.landscape1);
        images.add(R.drawable.landscape2);
        images.add(R.drawable.landscape3);
        images.add(R.drawable.landscape4);
        images.add(R.drawable.pokemon_ic);
        changeImage();
    }

    private void initLayout() {
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRight);
        ivGallery = (ImageView) findViewById(R.id.ivGallery);
    }

    void changeImage(){
        ivGallery.setImageResource(images.get(currentImageIdx));
        Toast.makeText(this, String.valueOf(currentImageIdx), Toast.LENGTH_SHORT).show();
    }

    public void leftImage(View view) {
        currentImageIdx--;
        if (currentImageIdx<0)
            currentImageIdx = images.size()-1;
        changeImage();
    }

    public void rightImage(View view) {
        currentImageIdx++;
        if (currentImageIdx>=images.size())
            currentImageIdx = 0;
        changeImage();
    }
}
