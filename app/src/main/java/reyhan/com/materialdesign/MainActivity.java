package reyhan.com.materialdesign;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    String username, password;
    TextInputLayout txtInputUsername, txtInputPassword;
    TextInputEditText etUsername, etPassword;
    MaterialButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = "Reyhandev";
        password = "kingmax123";

        txtInputPassword = findViewById(R.id.name_text_input_password);
        txtInputUsername = findViewById(R.id.name_text_input_username);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (etUsername.getText().toString().length() != 0) {
                    txtInputUsername.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (etPassword.getText().toString().length() != 0) {
                    txtInputPassword.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etUsername.getText().toString() == null || etUsername.getText().toString().length() == 0) {
                    txtInputUsername.setError("Isi Username");
                } else if (etPassword.getText().toString() == null || etPassword.getText().toString().length() == 0) {
                    txtInputPassword.setError("Isi Password");
                } else if (!etUsername.getText().toString().equals(username)) {
                    Toasty.error(MainActivity.this, "Username Salah", Toasty.LENGTH_SHORT).show();
                } else if (!etPassword.getText().toString().equals(password)) {
                    Toasty.error(MainActivity.this, "Password Salah", Toasty.LENGTH_SHORT).show();

                } else {
                    Toasty.success(MainActivity.this, "Login Succes", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
