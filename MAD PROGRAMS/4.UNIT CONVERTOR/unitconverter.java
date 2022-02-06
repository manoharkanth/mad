import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText val, res;
    Button conv_bt;
    RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val = (EditText) findViewById(R.id.val);
        res = (EditText) findViewById(R.id.res);
        conv_bt = (Button) findViewById(R.id.conv_bt);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        conv_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = val.getText().toString();
                float n = Float.parseFloat(a);
                float c;
                if (rb1.isChecked()) {
                    c = n / 100;

                    res.setText("Result =" + c);

                } else if (rb2.isChecked()) {
                    c = n * 100;

                    res.setText("Result =" + c);

                } else if (rb3.isChecked()) {
                    c = n * 12;

                    res.setText("Result =" + c);

                } else if (rb4.isChecked()) {
                    c = n / 12;

                    res.setText("Result =" + c);

                }
            }
        });

    }
}