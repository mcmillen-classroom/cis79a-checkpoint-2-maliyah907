package maliyahhoward.quizapp;

import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView mTextView;

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPreviousButton;
    private Button mHintButton;
    private Question[] mQuestions;
    private int mIndex;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mPreviousButton = (ImageButton) findViewById(R.id.previous_button);
        mHintButton = (Button) findViewById(R.id.hint_button);

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mPreviousButton.setOnClickListener(this);
        mHintButton.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.text_view);

        //Initialize an array of questions.
        mQuestions = new Question[5];
        mIndex = 0;

        //Initialize each spot in the array.
        mQuestions[0] = new Question(R.string.question_1,  R.string.question_1_hint,true);
        mQuestions[1] = new Question(R.string.question_2, R.string.question_2_hint,false);
        mQuestions[2] = new Question(R.string.question_3, R.string.question_3_hint,false);
        mQuestions[3] = new Question(R.string.question_4, R.string.question_4_hint,true);
        mQuestions[4] = new Question(R.string.question_5, R.string.question_5_hint,false);

        mTextView.setText(mQuestions[mIndex].getTextResId());
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.true_button) {
           checkAnswer(true);
        }
        else if (view.getId() == R.id.false_button) {
            checkAnswer(false);
        }
        else if (view.getId() == R.id.next_button)
        {
            // Change to the next question...

            // Increment the index by one.
            mIndex++;

            if (mIndex >= mQuestions.length)
            {
                // quiz over
            }
            else
            {
                // Change text in view.
                mTextView.setText(mQuestions[mIndex].getTextResId());
            }
        }
        else if (view.getId() == R.id.previous_button)
        {
            // Change to the previous question

            //Increment the index by one
            mIndex--;

            //DO IF STATEMENT HERE;
            // If the mIndex is greater than or equal to mQuestions.length

            // Change text in view
            mTextView.setText(mQuestions[mIndex].getTextResId());
        }
        else if (view.getId() == R.id.hint_button)
        {
            //Give hint for each question
            Toast myToast = Toast.makeText(this, mQuestions[mIndex].getHintTextResId(), Toast.LENGTH_SHORT);
            myToast.show();

        }
    }
    public boolean checkAnswer(boolean userInput)
    {
        if (mQuestions[mIndex].getAnswer() == userInput)
        {
            Toast myToast = Toast.makeText(this, "You are correct! ", Toast.LENGTH_SHORT);
            myToast.show();
            return true;
        }
        else
        {
            Toast myToast = Toast.makeText(this, "You are incorrect! ", Toast.LENGTH_SHORT);
            myToast.show();
            return false;
        }
    }
}

