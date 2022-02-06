import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText et_name;
    EditText et_age;
    EditText et_hb;
    EditText et_sugar;
    Button bt_save;
    Button bt_report;
    TextView tv_op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        et_name = (EditText)findViewById(R.id.et_name);
        et_age = (EditText)findViewById(R.id.et_age);
        et_hb = (EditText)findViewById(R.id.et_hb);
        et_sugar = (EditText)findViewById(R.id.et_sugar);
        bt_save = (Button)findViewById(R.id.bt_save);
        bt_report = (Button)findViewById(R.id.bt_report);
        tv_op = (TextView)findViewById(R.id.tv_op);
    }
    public void inserti (View view) {
        boolean status = db.insert(
                et_name.getText().toString(),
                Integer.parseInt(et_age.getText().toString()),
                Integer.parseInt(et_hb.getText().toString()),
                Integer.parseInt(et_sugar.getText().toString()));
    }
    public void report(View view) {
        Cursor c = db.select();
        if (c.getCount() ==0)
            return;
        StringBuffer buf = new StringBuffer();
        while (c.moveToNext()) {
            buf.append ("Name: "+c.getString(1));
            buf.append (" Age: "+c.getString(2));
            buf.append (" Hemoglobin: "+c.getString(3));
            buf.append (" Sugar: "+c.getString(4));
            buf.append("\n");
        }
        tv_op.setText(buf);
    }
    public void cleartext (View view) {
        et_name.setText("");
        et_age.setText("");
        et_hb.setText("");
        et_sugar.setText("");
    }
}