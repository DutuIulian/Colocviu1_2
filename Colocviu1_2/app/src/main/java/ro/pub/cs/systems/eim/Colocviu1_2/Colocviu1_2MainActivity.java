package ro.pub.cs.systems.eim.Colocviu1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Colocviu1_2MainActivity extends AppCompatActivity {

    private List<Integer> terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);
        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new AddListener());

        terms = new ArrayList();
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
}