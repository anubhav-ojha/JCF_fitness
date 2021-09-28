package learning.techmaze.project;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    TextView register  ;
    EditText login_email ;
    EditText login_password ;
    Button btn_signIN ;
    //FirebaseAuth firebaseAuth;
    TextView tv_forget_password ;
    private FirebaseAuth mAuth ;
    ProgressDialog mLoadingBar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = findViewById(R.id.tv_register_user);
        login_email = findViewById(R.id.enter_emailToResetPassword);
        login_password = findViewById(R.id.login_password);
        btn_signIN = findViewById(R.id.btn_ResetPassword);
        tv_forget_password = findViewById(R.id.tv_forget_password);
        mAuth = FirebaseAuth.getInstance() ;
        mLoadingBar = new ProgressDialog(LoginActivity.this);

        btn_signIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
            }
        });

        tv_forget_password.setOnClickListener(new View.OnClickListener() {   //Reset Password Dialog
            @Override
            public void onClick(View v) {

                final EditText resetMail = new EditText(v.getContext()) ;
                final AlertDialog.Builder passwordRestDialog = new AlertDialog.Builder(v.getContext()) ;
                passwordRestDialog.setTitle("Reset Password ?");
                passwordRestDialog.setMessage("Enter your email to get reset password link.") ;
                passwordRestDialog.setView(resetMail);

                passwordRestDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // generate link to reset password using firebase auth
                        String mail = resetMail.getText().toString() ;
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(LoginActivity.this, "Reset link has sent on your email", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this, "Error ! Link has not set"+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
                passwordRestDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // this will redirect to login activity
                    }
                });
                passwordRestDialog.create().show();
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
            mLoadingBar.setTitle("Login");
            mLoadingBar.setMessage("Please wait");
            mLoadingBar.setCanceledOnTouchOutside(false);
            mLoadingBar.show();

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        mLoadingBar.dismiss();
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Error ! Please check your internet connection", Toast.LENGTH_SHORT).show();
                        mLoadingBar.dismiss();
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