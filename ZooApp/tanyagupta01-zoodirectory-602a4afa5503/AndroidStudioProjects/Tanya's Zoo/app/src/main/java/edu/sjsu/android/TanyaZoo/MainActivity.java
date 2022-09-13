package edu.sjsu.android.TanyaZoo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private final int[] images={R.drawable.cat,R.drawable.lion,R.drawable.seal, R.drawable.wolf, R.drawable.pigeon};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<String> input= new ArrayList<>();
         int[] anImage=new int[5];
        for (int i=0;i<5;i++)
        {
            if(i==0)
            {
                input.add("Cat");
            }
            if(i==1)
            {
                input.add("Lion");
            }
            if(i==2)
            {
                input.add("Seal");
            }

            if(i==3)
            {
                input.add("Wolf");
            }
            if(i==4)
            {
                input.add("Pigeon");
            }
            anImage[i]=images[i];

        }
        // define an adapter
        mAdapter=new MyAdapter(input,images);
        recyclerView.setAdapter(mAdapter);

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