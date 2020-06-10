package ca.sfu.cmpt276a2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import ca.sfu.cmpt276a2.MainActivity;
import ca.sfu.cmpt276a2.Model.DepthOfFieldCalculator;
import ca.sfu.cmpt276a2.Model.Lens;
import ca.sfu.cmpt276a2.Model.LensManager;
import ca.sfu.cmpt276a2.R;

public class DoFCalculatorActivity extends AppCompatActivity {

    private DepthOfFieldCalculator depthOfFieldCalculator;
    private LensManager lensManager;
    private Lens chosenLens;

    private String distance;
    private String aperture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_f_calculator);
        this.setTitle("Calculate DoF");

        lensManager = LensManager.getInstance();
        chosenLens = lensManager.getLensByID(lensManager.getPosition());
        TextView editLenses = (TextView) findViewById(R.id.lensTag);
        editLenses.setText(chosenLens.toString());

        calculateButtonFunction();
        editFunctionButton();
        deleteFunctionButton();
    }

    public static Intent makeDoFCalculatorIntent(Context context){
        return new Intent(context, DoFCalculatorActivity.class);
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
                distance = editDistance.getText().toString().trim();

                EditText editApertureInDoF = (EditText) findViewById(R.id.editApertureInDoF);
                aperture = editApertureInDoF.getText().toString().trim();

                //Error cases
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
                else if (Double.parseDouble(aperture) < chosenLens.getMaxAperture()){
                    editApertureInDoF.setError("Aperture must be greater than or equal to lens max aperture");
                }
                //code block after authentication
                else{
                    intent.putExtra("calculateCircleOfConfusion", circleOfConfusion);
                    intent.putExtra("calculateDistance", distance);
                    intent.putExtra("Aperture", aperture);
                    updateUI();
                }

            }

        });
    }

    private void deleteFunctionButton(){
        Button button = (Button) findViewById(R.id.deleteButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lensManager.delete(chosenLens);//safely delete chosenLens from Lens list
                Intent intent = MainActivity.makeMainIntent(DoFCalculatorActivity.this);
                startActivity(intent);
                finish();
            }
        });
    }

    private void editFunctionButton(){
        Button button = (Button) findViewById(R.id.editButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = EditLensesActivity.makeEditLensesIntent(DoFCalculatorActivity.this);
                startActivity(intent);
                finish();
            }
        });
    }

    private void updateUI(){
        //parse string entries
        double distanceParse = Double.parseDouble(distance);
        double apertureParse = Double.parseDouble(aperture);

        //initialize DoF function
        depthOfFieldCalculator = new DepthOfFieldCalculator(chosenLens,
                distanceParse, apertureParse);

        //Retrieve and edit TextView boxes to show values
        TextView editFFdistance = (TextView) findViewById(R.id.FarFocalDistanceValue);
        TextView editNFdistance = (TextView) findViewById(R.id.NearFocalDistanceValue);
        TextView editDoF = (TextView) findViewById(R.id.DepthOfFieldValues);
        TextView editHFdistance = (TextView) findViewById(R.id.HyperFocalDistanceValue);

        editFFdistance.setText(formatM(depthOfFieldCalculator.getFarFocalPoint()) + "m");
        editNFdistance.setText(formatM(depthOfFieldCalculator.getNearFocalPoint()) + "m");
        editDoF.setText(formatM(depthOfFieldCalculator.getDepthOfField()) + "m");
        editHFdistance.setText(formatM(depthOfFieldCalculator.getHyperFocalDistance()) + "m");
    }

    //Derived from sample code provided by Dr. Jack Thomas in Assignment 1
    private String formatM(double distanceInM) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM);
    }

}