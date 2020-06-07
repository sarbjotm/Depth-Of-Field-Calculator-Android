package ca.sfu.cmpt276a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ca.sfu.cmpt276a2.Model.LensManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    LensManager lensManager = new LensManager();

}
