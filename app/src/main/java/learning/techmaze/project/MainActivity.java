package learning.techmaze.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

  //  private RecyclerView recyclerView ;
  //  RecyclerView.LayoutManager layoutManager ;
  //  RecyclerViewAdapter recyclerViewAdapter ;

 //   private TextView register ;  // register text view which is on login screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // register = findViewById(R.id.tv_register_user) ;
      //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);

        //register.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  startActivity(new Intent(MainActivity.this,RegisterActivity.class));

           // }
        //});


       // recyclerView = findViewById(R.id.rv_navigation);
        //layoutManager = new GridLayoutManager( this,2) ;
        //recyclerView.setLayoutManager(layoutManager);
    }
}