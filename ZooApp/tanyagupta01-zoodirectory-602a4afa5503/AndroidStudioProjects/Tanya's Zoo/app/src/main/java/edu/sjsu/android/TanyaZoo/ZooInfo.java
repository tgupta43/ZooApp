package edu.sjsu.android.TanyaZoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ZooInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_info);
        Button callButton = findViewById(R.id.button);

        callButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String myPhoneNumberUri ="tel:+8888888";
                Intent activity2= new Intent(Intent.ACTION_DIAL, Uri.parse(myPhoneNumberUri));
                startActivity(activity2);

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {// Inflate the menu;
        // this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        Intent intent;

        if (id == R.id.action_info)
        {
            intent = new Intent(this, ZooInfo.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_uninstall)
        {
            Uri packageURI = Uri.parse("package:edu.sjsu.android.animallist");
            Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
            startActivity(uninstallIntent);

            return true;
        }
        return super.onOptionsItemSelected(item);}
}