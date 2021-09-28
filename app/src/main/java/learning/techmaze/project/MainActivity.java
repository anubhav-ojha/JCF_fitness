package learning.techmaze.project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Adapters.Excercise_Adapter;
import Models.Exercise_Model;

public class MainActivity extends AppCompatActivity {

      RecyclerView recyclerView ;
  //  RecyclerView.LayoutManager layoutManager ;
  //  RecyclerViewAdapter recyclerViewAdapter ;

 //   private TextView register ;  // register text view which is on login screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_navigation);

       // register = findViewById(R.id.tv_register_user) ;
      //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);

        //register.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  startActivity(new Intent(MainActivity.this,RegisterActivity.class));

           // }//layoutManager = new GridLayoutManager( this,2) ;
        //        //recyclerView.setLayoutManager(layoutManager);
        //});



        ArrayList<Exercise_Model> list = new ArrayList<>() ;

        list.add(new Exercise_Model(R.drawable.chest1,"chest"));
        list.add(new Exercise_Model(R.drawable.gym1,"workout"));
        list.add(new Exercise_Model(R.drawable.gym2,"triceps"));
        list.add(new Exercise_Model(R.drawable.gym3,"chest"));
        list.add(new Exercise_Model(R.drawable.gym4,"shoulder"));
        list.add(new Exercise_Model(R.drawable.gym5,"chest"));
        list.add(new Exercise_Model(R.drawable.gym6,"legs"));
        list.add(new Exercise_Model(R.drawable.gym5,"chest"));
        list.add(new Exercise_Model(R.drawable.gym2,"body"));

      //  Excercise_Adapter excercise_adapter = new Excercise_Adapter(list,this);
   //     recyclerView.setAdapter(excercise_adapter);

    //    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
     //   recyclerView.setLayoutManager(layoutManager);

    }
}