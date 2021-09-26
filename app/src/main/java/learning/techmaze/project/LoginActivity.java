package learning.techmaze.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class LoginActivity extends AppCompatActivity {

    TextView register ;
    EditText login_email ;
    EditText login_password ;
    Button btn_signIN ;
    //FirebaseAuth firebaseAuth;
    TextView tv_forget_password ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = findViewById(R.id.tv_register_user);
        login_email = findViewById(R.id.enter_emailToResetPassword);
        login_password = findViewById(R.id.login_password);
        btn_signIN = findViewById(R.id.btn_ResetPassword);
        tv_forget_password = findViewById(R.id.tv_forget_password);

        btn_signIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
            }
        });

        tv_forget_password.setOnClickListener(new View.OnClickListener() {   //switch to reset password activity
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,Forgot_Password.class));
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));

            }
        });
    }

    private void checkCredentials() {


        String email= login_email.getText().toString() ;
        String password = login_password.getText().toString() ;



        if (email.isEmpty() || !email.contains("@gmail"))
        {
            showError(login_email,"Please Enter a Valid Email");
        }
        else if( password.isEmpty() || password.length() < 6)
        {
            showError(login_password,"Please enter a valid password");
        }
        else
        {
            Toast.makeText(this, "Call Login Method", Toast.LENGTH_SHORT).show();
        }

    }

    private void showError(EditText input, String s) {


        input.setError(s);
        input.requestFocus() ;

    }
}