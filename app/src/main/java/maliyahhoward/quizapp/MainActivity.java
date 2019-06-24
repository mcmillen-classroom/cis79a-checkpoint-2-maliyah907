package maliyahhoward.quizapp;

import android.view.Gravity;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mTrueButton;
    private Button mFalseButton;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
        {
        TextView myTextView =(TextView)view;
        Toast myToast = Toast.makeText(this,"You just clicked " + myTextView.getText(),Toast.LENGTH_SHORT);
        myToast.setGravity(Gravity.TOP,10,10);
        myToast.show();
        }
}
