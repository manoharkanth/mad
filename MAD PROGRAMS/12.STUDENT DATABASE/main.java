import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText et_usn;
    EditText et_name;
    EditText et_sem;
    Button bt_save;
    Button bt_report;
    TextView tv_op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        et_usn = (EditText)findViewById(R.id.et_usn);
        et_name = (EditText)findViewById(R.id.et_name);
        et_sem = (EditText)findViewById(R.id.et_sem);
        bt_save = (Button)findViewById(R.id.bt_save);
        bt_report = (Button)findViewById(R.id.bt_report);
        tv_op = (TextView)findViewById(R.id.tv_op);
    }
    public void inserti (View view) {
        boolean status = db.insert(
                et_usn.getText().toString(),
                et_name.getText().toString(),
                et_sem.getText().toString());
    }
    public void report(View view) {
        Cursor c = db.select();
        if (c.getCount() ==0)
            return;
        StringBuffer buf = new StringBuffer();
        while (c.moveToNext()) {
            buf.append (" USN: "+c.getString(1));
            buf.append (" Student Name: "+c.getString(2));
            buf.append (" Semester: "+c.getString(3));
            buf.append("\n");
        }
        tv_op.setText(buf);
    }
    public void cleartext (View view) {
        et_usn.setText("");
        et_name.setText("");
        et_sem.setText("");
    }
}