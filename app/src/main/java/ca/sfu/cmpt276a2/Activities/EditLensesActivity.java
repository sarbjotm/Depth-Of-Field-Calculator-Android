package ca.sfu.cmpt276a2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ca.sfu.cmpt276a2.MainActivity;
import ca.sfu.cmpt276a2.Model.Lens;
import ca.sfu.cmpt276a2.Model.LensManager;
import ca.sfu.cmpt276a2.R;

public class EditLensesActivity extends AppCompatActivity {

    private LensManager lensManager;
    private Lens chosenLens;

    private String make;
    private String focalLength;
    private String apertureLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_lenses);
        this.setTitle("Edit Chosen Lens");
        lensManager = LensManager.getInstance();
        chosenLens = lensManager.getLensByID(lensManager.getPosition());

        editCancelBtn();
        editSaveBtn();
    }

    public static Intent makeEditLensesIntent(Context context){
        return new Intent(context, EditLensesActivity.class);
    }

    private void editCancelBtn(){
        Button btn = (Button) findViewById(R.id.editCancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //terminates current activity and returns to previous
            }
        });
    }

    private void editSaveBtn(){
        Button btn = (Button) findViewById(R.id.editSave);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editMake = (EditText) findViewById(R.id.editMakeValue);
                make = editMake.getText().toString().trim();

                EditText editFocalLength = (EditText) findViewById(R.id.editFF);
                focalLength = editFocalLength.getText().toString().trim();

                EditText editAperture = (EditText) findViewById(R.id.editApertureValue);
                apertureLength = editAperture.getText().toString().trim();

                if (make.isEmpty()){
                    editMake.setError("Field can't be empty");
                }

                else if (focalLength.isEmpty()){
                    editFocalLength.setError("Field can't be empty");
                }

                else if(Double.parseDouble(focalLength) <= 0){
                    editFocalLength.setError("Focal Length must be greater than 0");
                }

                else if (apertureLength.isEmpty()){
                    editAperture.setError("Field can't be empty");
                }

                else if (Double.parseDouble(apertureLength) <= 1.4){
                    editAperture.setError("Aperture must be greater than or equal to 1.4");
                }

                else{
                    lensManager.editLens(chosenLens, make,
                            Double.parseDouble(apertureLength), Double.parseDouble(focalLength) );
                    Intent intent = MainActivity.makeMainIntent(EditLensesActivity.this);
                    startActivity(intent);
                    finish();
                }

            }

        });
    }
}