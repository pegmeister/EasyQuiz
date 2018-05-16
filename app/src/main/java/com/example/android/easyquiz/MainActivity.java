package com.example.android.easyquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* declare the following as global variables */
    int totalPoints = 0;
    int q1Points = 0;
    int q2Points = 0;
    int q3Points = 0;
    int q4Points = 0;
    int q5Points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* user must select answer 2 to earn points for Quiz 1
    * using switch case method to validate if condition met */
    public void radioQ1(View view) {

        boolean selectedAns2 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.q1_a2:
                if (selectedAns2) {
                    q1Points = 20;
                    break;
                }
            case R.id.q1_a1:
                if (selectedAns2) {
                    q1Points = 0;
                    break;
                }
            case R.id.q1_a3:
                if (selectedAns2) {
                    q1Points = 0;
                    break;
                }
            case R.id.q1_a4:
                if (selectedAns2) {
                    q1Points = 0;
                    break;
                }
        }

    }

    /* user must select answer 1 to earn points for Quiz 2
    * using switch case method to validate if condition met*/
    public void radioQ2(View view) {

        boolean selected = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.q2_a1:
                if (selected) {
                    q2Points = 20;
                    break;
                }
            case R.id.q2_a2:
                if (selected) {
                    q2Points = 0;
                    break;
                }
            case R.id.q2_a3:
                if (selected) {
                    q2Points = 0;
                    break;
                }
            case R.id.q2_a4:
                if (selected) {
                    q2Points = 0;
                    break;
                }
        }
    }

    /* user must select answer 2 to earns point for Quiz 3
    * using if/else statement to validate if condition met*/
    public void radioQ3(View view) {
        RadioButton answer2 = findViewById(R.id.q3_a2);
        boolean correctAns = answer2.isChecked();

        if (correctAns) {
            q3Points = 20;
        } else {
            q3Points = 0;
        }
    }

    /*  Set String answer "japan" to myAnswer, cast editTextQ4 to answer and use if/else statement
    * to validate outcome*/
    public void editTextQ4() {
        String myAnswer = getString(R.string.quiz4answer);
        String answer = ((EditText) findViewById(R.id.editTextQ4)).getText().toString();

        if (myAnswer.equals(answer)) {
            q4Points = 20;
        } else {
            q4Points = 0;
        }
    }

    /* correct answers must be checked for both box 2 and 3 to earn points,
    other answers combinations will earn 0 points */
    public void checkBoxQ5(View view) {
        CheckBox answer1 = findViewById(R.id.q5_a1);
        boolean check1 = answer1.isChecked();
        CheckBox answer2 = findViewById(R.id.q5_a2);
        boolean check2 = answer2.isChecked();
        CheckBox answer3 = findViewById(R.id.q5_a3);
        boolean check3 = answer3.isChecked();
        CheckBox answer4 = findViewById(R.id.q5_a4);
        boolean check4 = answer4.isChecked();

        if (check2 && check3 && !check1 && !check4) {
            q5Points = 20;
            } else {
                q5Points = 0;
            }
        }

    /* to sum up total score earned for all 5 questions answered */
    public void scoreTotal(View view) {
        /* include editTextQ4 under scoreTotal method to avoid "method never used" error */
        editTextQ4();
        totalPoints = q1Points + q2Points + q3Points + q4Points + q5Points;
        Toast.makeText(this, ("You scored " + totalPoints + "." + "Keeping Learning!"), Toast.LENGTH_SHORT).show();
    }
}
