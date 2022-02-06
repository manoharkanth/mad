import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class MainActivity extends AppCompatActivity {
    EditText cat_et, price_et, res_et;
    Button btn_save, btn_load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cat_et = (EditText)findViewById(R.id.cat_et);
        price_et = (EditText)findViewById(R.id.price_et);
        res_et = (EditText)findViewById(R.id.res_et);
        btn_save = (Button)findViewById(R.id.btn_save);
        btn_load = (Button)findViewById(R.id.btn_load);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = cat_et.getText().toString();
                String s2 = s1 + " " +
                        price_et.getText().toString()+"\n";
                try {
                    FileOutputStream fos =
                            openFileOutput("file1.txt",MODE_APPEND);
                    fos.write(s2.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_load.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try{
                    FileInputStream fis = openFileInput("file1.txt");
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();

                    String text;
                    while((text=br.readLine())!=null)
                    {

                        sb.append(text);
                        sb.append("\n");

                    }

                    res_et.setText(sb.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}