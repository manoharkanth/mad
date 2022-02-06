import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user="abc";
                String pass="123";
                username=findViewById(R.id.username);
                password=findViewById(R.id.password);
                if(username.getText().toString().equals(user) && password.getText().toString().equals(pass)){
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(MainActivity.this,welcome.class);
                    i.putExtra("p",user);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid Username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}