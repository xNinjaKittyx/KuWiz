package io.github.xninjakittyx.kuwiz;

import android.content.Intent;
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

    public void aAnswer(View v) {
        if (currentQ.getANSWER().equals(opt1.getText())) {
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

        if (qid < 5) {
            currentQ = quesList.get(qid);
            setQuestionView();
        }
        else {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            finish();
        }
    }

    public void bAnswer(View v) {

        if (currentQ.getANSWER().equals(opt2.getText())) {
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

        if (qid < 5) {
            currentQ = quesList.get(qid);
            setQuestionView();
        }
        else {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            finish();
        }
    }

    public void cAnswer(View v) {
        if (currentQ.getANSWER().equals(opt3.getText())) {
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

        if (qid < 5) {
            currentQ = quesList.get(qid);
            setQuestionView();
        }
        else {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            finish();
        }
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
        else {

            Snackbar snackbar = Snackbar
                    .make(v, "The correct answer was " + currentQ.getANSWER() + "!", Snackbar.LENGTH_LONG);

            snackbar.show();
        }
        if (qid < 5) {
            currentQ = quesList.get(qid);
            setQuestionView();
        }
        else {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            finish();
        }
    }
}
