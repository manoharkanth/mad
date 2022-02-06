import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp1;
    TextView res_tv;
    Button bt_conv;
    EditText val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1 = (Spinner)findViewById(R.id.sp1);
        bt_conv = (Button)findViewById(R.id.bt_conv);
        res_tv = (TextView)findViewById(R.id.res_tv);
        val = (EditText) findViewById(R.id.val);
        bt_conv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = sp1.getSelectedItemPosition();
                String a = val.getText().toString();
                float n = Float.parseFloat(a);
                float res;

                if(pos == 1)
                {
                    res = n*73;

                    res_tv.setText("Result ="+res);

                }
                else if(pos == 2)
                {
                    res = n/73;

                    res_tv.setText("Result ="+res);

                }
                else if(pos == 3)
                {
                    res = n*95;

                    res_tv.setText("Result ="+res);

                }
                else if(pos == 4)
                {
                    res = n/95;

                    res_tv.setText("Result ="+res);

                }
                else
                {

                    Toast.makeText(getApplicationContext(),"Please select option",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}