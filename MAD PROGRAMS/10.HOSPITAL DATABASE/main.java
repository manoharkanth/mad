import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.inputStreamReader;


import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    EditText et1,et2,et3;
    TextView t5;
    String s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button) findViewById(R.id.button);
        btn2=(Button) findViewById(R.id.button2);
        t5=(TextView) findViewById(R.id.t5);
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        et3=(EditText) findViewById(R.id.et3);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(v);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load(v);
            }
        });
    }
    public void save(View view)
    {
        s1=et1.getText().toString();
        s2=et2.getText().toString();
        s3=s1+" "+s2+" " +et3.getText().toString()+"\n";

        try{
            FileOutputStream fos = openFileOutput("file1.txt",MODE_APPEND);
            fos.write(s3.getBytes());
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void load(View v)
    {
        try {
            FileInputStream fis = openFileInput("file1.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null)
            {
                sb.append(text);
                sb.append("\n");
            }

            t5.setText(sb.toString());
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}