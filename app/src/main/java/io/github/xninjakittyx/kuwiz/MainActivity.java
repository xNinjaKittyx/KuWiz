package io.github.xninjakittyx.kuwiz;

import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Question> quesList; // List that stores all the questions

    int score=0;
    int qid=0;

    Question currentQ;
    TextView question;
    Button opt1, opt2, opt3, opt4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Grabs the database
        DBHelper db=new DBHelper(this);

        // Grabs the list of questions
        quesList=db.getAllQuestions();

        // Grabs the current question
        currentQ=quesList.get(qid);

        question=(TextView)findViewById(R.id.textView);
        opt1=(Button)findViewById(R.id.button);
        opt2=(Button)findViewById(R.id.button2);
        opt3=(Button)findViewById(R.id.button3);
        opt4=(Button)findViewById(R.id.button4);
        setQuestionView();
    }

    private void setQuestionView()
    {
        question.setText(currentQ.getQUESTION());
        opt1.setText(currentQ.getOPTA());
        opt2.setText(currentQ.getOPTB());
        opt3.setText(currentQ.getOPTC());
        qid++;
    }

    public void checkAnswer(View v) {
        if (currentQ.getANSWER() == "A" && findViewById(v.getId()) == opt1) {
            Snackbar snackbar = Snackbar
                    .make(v, "Correct!", Snackbar.LENGTH_LONG);

            snackbar.show();
            score++;
        }
        else if (currentQ.getANSWER() == "B" && findViewById(v.getId()) == opt2) {
            Snackbar snackbar = Snackbar
                    .make(v, "Correct!", Snackbar.LENGTH_LONG);

            snackbar.show();
            score++;

        }
        else if (currentQ.getANSWER() == "C" && findViewById(v.getId()) == opt3) {
            Snackbar snackbar = Snackbar
                    .make(v, "Correct!", Snackbar.LENGTH_LONG);

            snackbar.show();
            score++;

        }
        else if (currentQ.getANSWER() == "D" && findViewById(v.getId()) == opt4) {
            Snackbar snackbar = Snackbar
                    .make(v, "Correct!", Snackbar.LENGTH_LONG);

            snackbar.show();
            score++;

        }
        else {

            Snackbar snackbar = Snackbar
                    .make(v, "The correct answer was " + currentQ.getANSWER() + "!", Snackbar.LENGTH_LONG);

            snackbar.show();
        }

        currentQ=quesList.get(qid);
        setQuestionView();
    }
}
