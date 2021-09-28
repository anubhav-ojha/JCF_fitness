package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Models.Exercise_Model;
import learning.techmaze.project.R;

public class Excercise_Adapter extends RecyclerView.Adapter<Excercise_Adapter.viewHolder>{

    ArrayList<Exercise_Model> list ;
    Context context ;

    public Excercise_Adapter(ArrayList<Exercise_Model> lists, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_view, parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

       Exercise_Model model = list.get(position) ;
       holder.rv_imageView.setImageResource(model.getPic());
       holder.rv_textView.setText(model.getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

      ImageView rv_imageView ;
      TextView rv_textView ;
      public viewHolder(@NonNull View itemView) {
          super(itemView);
          rv_imageView =  itemView.findViewById(R.id.rv_imageView);
          rv_textView = itemView.findViewById(R.id.rv_textView);
      }
  }
}
