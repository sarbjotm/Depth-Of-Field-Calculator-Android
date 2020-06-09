package ca.sfu.cmpt276a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import ca.sfu.cmpt276a2.Model.DepthOfFieldCalculator;
import ca.sfu.cmpt276a2.Model.Lens;

public class DoFCalculatorActivity extends AppCompatActivity {

    private DepthOfFieldCalculator depthOfFieldCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_f_calculator);
        this.setTitle("Calculate DoF");
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, DoFCalculatorActivity.class);
    }

}