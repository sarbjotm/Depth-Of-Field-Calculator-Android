package ca.sfu.cmpt276a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ca.sfu.cmpt276a2.Model.Lens;
import ca.sfu.cmpt276a2.Model.LensManager;

public class MainActivity extends AppCompatActivity {

    private LensManager lensManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lensManager = LensManager.getInstance();
        populateLensView();
        FloatingActionButton  btn = (FloatingActionButton) findViewById(R.id.bthAddLenses);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,addingLens.class);
                startActivity(intent);
            }
        });

    }


    private void populateLensView(){

        //store lens strings
        List<String> lensStrings = new ArrayList<>();
        for(Lens lens : lensManager.getLenses()){
            lensStrings.add(lens.toString());
        }

        for(String string : lensStrings){
            System.out.println(string);
        }

        //Build array adapter
        ArrayAdapter<String> lensAdapter = new ArrayAdapter<String>(
                this,                   //Activity context
                R.layout.lensmanager_items,     //Layout to use (create)
                lensStrings);                   //Items to display

        //Configure ListView
        ListView listView = (ListView) findViewById(R.id.LensView);
        listView.setAdapter(lensAdapter);
    }


}
