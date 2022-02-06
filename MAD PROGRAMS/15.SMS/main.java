import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.app.PendingIntent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText et_mob,et_mess;
    Button bt_send;
    PendingIntent sentPI, deliveredPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_mob = (EditText)findViewById(R.id.et_mob);
        et_mess = (EditText)findViewById(R.id.et_mess);
        bt_send = (Button)findViewById(R.id.bt_send);
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = et_mess.getText().toString();
                String telNr = et_mob.getText().toString();
                if(telNr.length()==10)
                {
                    if (ContextCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
                    {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.SEND_SMS}, 1);
                        Toast.makeText(getApplicationContext(), "SMS not sent!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        SmsManager sms = SmsManager.getDefault();
                        sms.sendTextMessage(telNr, null, message, sentPI, deliveredPI);
                        Toast.makeText(getApplicationContext(), "SMS sent successfully!", Toast.LENGTH_SHORT).show();
                    }
                } else
                { Toast.makeText(getApplicationContext(), "SMS not sent !", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Enter 10 digit number !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}