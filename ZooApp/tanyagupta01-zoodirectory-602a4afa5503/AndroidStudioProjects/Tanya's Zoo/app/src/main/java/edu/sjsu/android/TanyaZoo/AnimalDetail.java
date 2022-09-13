package edu.sjsu.android.TanyaZoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalDetail extends AppCompatActivity {
    private TextView desc;
    private TextView name;
    private ImageView anim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);
        desc = findViewById(R.id.textView2);
        name = findViewById(R.id.textView);
        anim = findViewById(R.id.imageView);
        if (this.getIntent().getExtras() != null) {
            Intent getInt = getIntent();
            Bundle x = getInt.getExtras();
            String animalName = getIntent().getExtras().getString("animal");
            String descr = getIntent().getExtras().getString("description");
            int pix = getIntent().getExtras().getInt("pic");


            name.setText(animalName);
            desc.setText(descr);
            anim.setImageResource(pix);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {// Inflate the menu;
        // this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;

        if (id == R.id.action_info)
        {
            intent = new Intent(this, ZooInfo.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_uninstall)
        {
        Uri packageURI = Uri.parse("package:edu.sjsu.android.animallist");
        Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
        startActivity(uninstallIntent);

        return true;
        }
        return super.onOptionsItemSelected(item);}
    }
