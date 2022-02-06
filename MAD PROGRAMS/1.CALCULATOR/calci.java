import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    EditText num1,num2,res;
    Button add_bt,sub_bt,mul_bt,div_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        res = (EditText) findViewById(R.id.res);
        add_bt = (Button) findViewById(R.id.add_bt);
        sub_bt = (Button) findViewById(R.id.sub_bt);
        mul_bt = (Button) findViewById(R.id.mul_bt);
        div_bt = (Button) findViewById(R.id.div_bt);
        add_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v1 = num1.getText().toString();
                String v2 = num2.getText().toString();
                int a = Integer.parseInt(v1);
                int b = Integer.parseInt(v2);
                int c = a+b;
                res.setText(""+c);
            }
        });
        sub_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v1 = num1.getText().toString();
                String v2 = num2.getText().toString();
                int a = Integer.parseInt(v1);
                int b = Integer.parseInt(v2);
                int c = a-b;
                res.setText(""+c);
            }

        });
        mul_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v1 = num1.getText().toString();
                String v2 = num2.getText().toString();
                int a = Integer.parseInt(v1);
                int b = Integer.parseInt(v2);
                int c = a*b;
                res.setText(""+c);
            }
        });
        div_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v1 = num1.getText().toString();
                String v2 = num2.getText().toString();
                int a = Integer.parseInt(v1);
                int b = Integer.parseInt(v2);
                int c = a/b;
                res.setText(""+c);
            }
        });
    }
}