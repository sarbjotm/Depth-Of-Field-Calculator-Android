package ca.sfu.cmpt276a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
