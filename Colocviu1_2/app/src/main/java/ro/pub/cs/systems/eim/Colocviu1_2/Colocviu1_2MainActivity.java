package ro.pub.cs.systems.eim.Colocviu1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Colocviu1_2MainActivity extends AppCompatActivity {

    private ArrayList<Integer> terms;
    private int LAUNCH_SECOND_ACTIVITY = 1;
    private int sum = 0;
    private String lastTerms = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);
        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new AddListener());

        Button computeButton = (Button) findViewById(R.id.computeButton);
        computeButton.setOnClickListener(new ComputeListener());

        terms = new ArrayList();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if(resultCode == Activity.RESULT_OK){
                sum = data.getIntExtra("ro.pub.cs.systems.eim.Colocviu1_2.SUM_KEY", -1);
                Toast.makeText(this, Integer.toString(sum), Toast.LENGTH_LONG).show();

                TextView allTerms = (TextView) findViewById(R.id.allTerms);
                lastTerms = allTerms.getText().toString();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Canceled!", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "No result!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("sum", sum);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        sum = savedInstanceState.getInt("sum");
    }

    class AddListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            try {
                EditText nextTermEdit = (EditText) findViewById(R.id.nextTerm);
                String nextTerm = nextTermEdit.getText().toString();
                int nextTermInt = Integer.parseInt(nextTerm);
                terms.add(nextTermInt);

                String str = "";
                for(int i = 0; i < terms.size() - 1; i++) {
                    str += Integer.toString(terms.get(i));
                    str += "+";
                }
                str += Integer.toString(terms.get(terms.size() - 1));

                TextView allTerms = (TextView) findViewById(R.id.allTerms);
                allTerms.setText(str);
            } catch(Exception e) {

            }
        }
    }

    class ComputeListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            TextView allTerms = (TextView) findViewById(R.id.allTerms);
            if(lastTerms.equals(allTerms.getText().toString()))
            {
                Toast.makeText(Colocviu1_2MainActivity.this, "Old value: " + Integer.toString(sum), Toast.LENGTH_LONG).show();
            }
            else
            {
                Intent i = new Intent(Colocviu1_2MainActivity.this, Colocviu1_2SecondaryActivity.class);
                i.putIntegerArrayListExtra("ro.pub.cs.systems.eim.Colocviu1_2.NUMBER_LIST_KEY", terms);
                startActivityForResult(i, LAUNCH_SECOND_ACTIVITY);
            }
        }
    }
}