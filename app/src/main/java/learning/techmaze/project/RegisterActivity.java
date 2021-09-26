package learning.techmaze.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class RegisterActivity extends AppCompatActivity {


     TextView sign_in ; // This textView is on signup activity which will redirect you to sing in activity

     private EditText inputUserName, input_email, input_password, input_confirmPassword ;
     Button btn_signUp ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);
        sign_in = findViewById(R.id.tv_signIn);
        inputUserName = findViewById(R.id.inputUserName);
        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        input_confirmPassword = findViewById(R.id.input_confirmPassword);

        btn_signUp =findViewById(R.id.btn_signUp);
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();

            }
        });




        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

            }
        });



    }

    private void checkCredentials() {

        String username=inputUserName.getText().toString() ;
        String email= input_email.getText().toString() ;
        String password = input_password.getText().toString() ;
        String confirmPassword = input_confirmPassword.getText().toString() ;

        if (username.isEmpty() || username.length() < 4)
        {
            showError(inputUserName , "You username is not Valid") ;
        }
        else if (email.isEmpty() || !email.contains("@gmail"))
        {
              showError(input_email,"Please Enter a Valid Email");
        }
        else if( password.isEmpty() || password.length() < 6)
        {
            showError(input_password,"Password must be 6 Character");
        }
        else if (confirmPassword.isEmpty() || !confirmPassword.equals(password))
        {
            showError(input_confirmPassword,"Password not matched");
        }
        else
        {
            Toast.makeText(this, "Call Registration Method", Toast.LENGTH_SHORT).show();
        }

    }

    private void showError(EditText input, String s) {


        input.setError(s);
        input.requestFocus() ;

    }
}