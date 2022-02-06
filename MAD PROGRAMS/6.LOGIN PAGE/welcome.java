import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class welcome extends AppCompatActivity {
   TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent inte=getIntent();
        String s=inte.getStringExtra("p");
        welcome=findViewById(R.id.disp);
        welcome.setText("Hello "+s);
    }
}