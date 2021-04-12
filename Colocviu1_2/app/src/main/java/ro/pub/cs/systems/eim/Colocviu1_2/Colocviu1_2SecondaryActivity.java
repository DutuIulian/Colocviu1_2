package ro.pub.cs.systems.eim.Colocviu1_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Colocviu1_2SecondaryActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int sum = 0;

        if (intent != null) {
            ArrayList<Integer> list = intent.getIntegerArrayListExtra("ro.pub.cs.systems.eim.Colocviu1_2.NUMBER_LIST_KEY");
            if (list != null) {

                for (int a : list) {
                    sum += a;
                }
            }
        }

        Intent returnIntent = new Intent();
        returnIntent.putExtra("ro.pub.cs.systems.eim.Colocviu1_2.SUM_KEY", sum);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}