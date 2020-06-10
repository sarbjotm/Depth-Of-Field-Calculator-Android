package ca.sfu.cmpt276a2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ca.sfu.cmpt276a2.Model.DepthOfFieldCalculator;
import ca.sfu.cmpt276a2.Model.Lens;

public class DoFCalculatorActivity extends AppCompatActivity {

    private DepthOfFieldCalculator depthOfFieldCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_f_calculator);
        this.setTitle("Calculate DoF");
        calculateButtonFunction();

    }

    private void calculateButtonFunction(){
        Button btn = (Button) findViewById(R.id.calculateButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                EditText editCircleofConfusion = (EditText) findViewById(R.id.editcircleOfConfusion);
                String circleOfConfusion = editCircleofConfusion.getText().toString().trim();

                EditText editDistance = (EditText) findViewById(R.id.editDistance);
                String distance = editDistance.getText().toString().trim();

                EditText editApertureInDoF = (EditText) findViewById(R.id.editApertureInDoF);
                String aperture = editApertureInDoF.getText().toString().trim();

                if (circleOfConfusion.isEmpty()){
                    editCircleofConfusion.setError("Field can't be empty");
                }

                else if(Double.parseDouble(circleOfConfusion) <= 0 ){
                    editCircleofConfusion.setError("Must be greater than 0");
                }

                else if (distance.isEmpty()){
                    editDistance.setError("Field can't be empty");
                }

                else if (Double.parseDouble(distance) <= 0){
                    editDistance.setError("Distance must be greater than 0");
                }

                else if (aperture.isEmpty()){
                    editApertureInDoF.setError("Field can't be empty");
                }

                else if (Double.parseDouble(aperture) < 1.4){
                    editApertureInDoF.setError("Aperture must be greater than or equal to 1.4");
                }

                else{
                    intent.putExtra("calculateCircleOfConfusion", circleOfConfusion);
                    intent.putExtra("calculateDistance", distance);
                    intent.putExtra("Aperture", aperture);
                    finish();
                }
            }

        });
    }



    public static Intent makeIntent(Context context){
        return new Intent(context, DoFCalculatorActivity.class);
    }

}