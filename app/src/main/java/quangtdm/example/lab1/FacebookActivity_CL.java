package quangtdm.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FacebookActivity_CL extends AppCompatActivity {
    private final String USER_NAME = "quangtdm";
    //private final String PASSWORD = "123";
    private EditText etEmailOrPhone;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_facebook_cl);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // turn off action bar
        getSupportActionBar().hide();

        // Mapping
        mapping();

        btnLogin.setOnClickListener(v -> login(etEmailOrPhone, etPassword));
    }

    private void mapping() {
        etEmailOrPhone = findViewById(R.id.etEmailOrPhone);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void login(EditText etEmailOrPhone, EditText etPassword) {
        String userName = etEmailOrPhone.getText().toString();
        String password = etPassword.getText().toString();
        if (userName.equalsIgnoreCase(USER_NAME)) {
            showToast("Login success");
            Intent homeIntent = new Intent(this, HomeActivity.class);
            homeIntent.putExtra("USER_NAME", USER_NAME);
            startActivity(homeIntent);
        } else {
            showToast("Login failed");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        etEmailOrPhone.setText("");
        etPassword.setText("");
    }
}