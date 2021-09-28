package learning.techmaze.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ProgressDialog mLoadingBar ;
     TextView sign_in ; // This textView is on signup activity which will redirect you to sing in activity
    private EditText inputUserName, input_email, input_password, input_confirmPassword ;
    Button btn_signUp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance(); // firebase mAuth to connect with firebase

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);
        sign_in = findViewById(R.id.tv_signIn);
        inputUserName = findViewById(R.id.inputUserName);
        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        input_confirmPassword = findViewById(R.id.input_confirmPassword);
        mLoadingBar = new ProgressDialog(RegisterActivity.this);

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
        else if (email.isEmpty() || !email.contains("@"))
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
           mLoadingBar.setTitle("Registration");
           mLoadingBar.setMessage("Please wait");
           mLoadingBar.setCanceledOnTouchOutside(false);
           mLoadingBar.show();

           mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       Toast.makeText(RegisterActivity.this, "Succefully Registered", Toast.LENGTH_SHORT).show();

                       mLoadingBar.dismiss();
                       Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                       intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                       startActivity(intent);
                   }
                   else
                   {
                       Toast.makeText(RegisterActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();

                   }
               }
           });
        }

    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus() ;

    }
}