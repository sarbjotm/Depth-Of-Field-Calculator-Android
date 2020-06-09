package ca.sfu.cmpt276a2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ca.sfu.cmpt276a2.Model.Lens;
import ca.sfu.cmpt276a2.Model.LensManager;

public class MainActivity extends AppCompatActivity {

    private LensManager lensManager;

    public static final int REQUEST_CODE_GETMESSAGE = 1014;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lensManager = LensManager.getInstance();
        populateLensView();
        switchActivities();



    }

    private void switchActivities(){
        FloatingActionButton  btn = (FloatingActionButton) findViewById(R.id.bthAddLenses);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = addingLens.makeIntent(MainActivity.this);
                Intent intent = AddLensesActivity.makeIntent(MainActivity.this);

                startActivityForResult(intent, REQUEST_CODE_GETMESSAGE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case REQUEST_CODE_GETMESSAGE:
                if (resultCode == Activity.RESULT_OK){
                    String make = data.getStringExtra("modelMake");
                    String focal = data.getStringExtra("modelFocal");
                    String aperture = data.getStringExtra("modelAperture");
                    Lens lens = new Lens(make, Double.parseDouble(focal),Double.parseDouble(aperture));
                    lensManager.add(lens);
                    populateLensView();

                }

                else{
                    Log.i("MyApp","Failed!");
                }
        }
    }

    private void populateLensView(){

        //store lens strings
        List<String> lensStrings = new ArrayList<>();
        for(Lens lens : lensManager.getLenses()){
            lensStrings.add(lens.toString());
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
