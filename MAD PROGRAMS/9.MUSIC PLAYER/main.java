import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    private Button bt_start,bt_stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_start = (Button)findViewById(R.id.bt_start);
        bt_stop = (Button)findViewById(R.id.bt_stop);
        bt_start.setOnClickListener((View.OnClickListener) this);
        bt_stop.setOnClickListener((View.OnClickListener) this);
    }
    @Override
    public void onClick(View view) {
        if (view == bt_start) {
//starting service
            startService(new Intent(this, MediaService.class));
        }
        else if (view == bt_stop) {
// stopping service
            stopService(new Intent(this, MediaService.class));
        }
    }
}