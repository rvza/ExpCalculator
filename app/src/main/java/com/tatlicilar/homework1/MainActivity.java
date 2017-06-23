package com.tatlicilar.homework1;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

///////http://www.objecthunter.net/exp4j/
public class MainActivity extends AppCompatActivity {
    TextView txtCalculation;
    Button equal ;
    Button delete;
    private int[] numericBtns = {R.id.number0, R.id.number1, R.id.number2, R.id.number3,
            R.id.number4, R.id.number5, R.id.number6, R.id.number7, R.id.number8, R.id.number9,R.id.equal,R.id.addition,
            R.id.multiplication, R.id.subtraction, R.id.division,R.id.delete};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCalculation = (TextView) findViewById(R.id.txtCalculation);
        equal= (Button)findViewById(R.id.equal);
        delete=(Button)findViewById(R.id.delete);
        setNumericBtns();
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Equall();
            }
        });
    }
    // checked the equals
    private  void Equall()
      {
        try {
            // Read the expression
            String txt = txtCalculation.getText().toString();
            // Create an Expression (A class from exp4j library)
            // build.gradle add exp4j
            Expression expression = new ExpressionBuilder(txt).build();

                // Calculate the result and display
                double result = expression.evaluate();
                txtCalculation.setText(Double.toString(result));
            } catch (ArithmeticException ex) {
                txtCalculation.setText("Error");
            }
        }

    private void setNumericBtns() {
        Log.w("Application","setNumericBtns");
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                txtCalculation.append(button.getText());
            }
        };
       // I check the clicking of the buttons I have defined above
        for (int id : numericBtns) {
            findViewById(id).setOnClickListener(listener);
        }
    }
}



