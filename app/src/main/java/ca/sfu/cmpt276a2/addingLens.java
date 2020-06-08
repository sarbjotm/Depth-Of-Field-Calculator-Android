package ca.sfu.cmpt276a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addingLens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_lens);

        setupEndAddingLensesBtn();
    }

    private void setupEndAddingLensesBtn(){
        Button btn = (Button) findViewById(R.id.btnCancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //terminates current activity and returns to previous
                }

        });
    }
    public static Intent makeIntent(Context context){
        return new Intent(context, addingLens.class);
    }
}