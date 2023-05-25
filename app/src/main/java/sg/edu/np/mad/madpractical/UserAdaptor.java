package sg.edu.np.mad.madpractical;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class UserAdaptor extends RecyclerView.Adapter<UserViewHolder>{
    private ArrayList<User> list_objects;
    public UserAdaptor(ArrayList<User> list_objects){
        this.list_objects = list_objects;
    }
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customactivitylist, parent, false);
        UserViewHolder holder = new UserViewHolder(view);
        Context context = view.getContext();
        holder.image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Profile");
                builder.setMessage(String.valueOf(holder.txt1.getText()));
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        //send data to main activity
                        Intent profile = new Intent(context, MainActivity.class);
                        profile.putExtra("name", holder.txt1.getText());
                        profile.putExtra("desc", holder.txt2.getText());
                        context.startActivity(profile);
                    }
                });
                builder.setNegativeButton("Close", null);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        return holder;
    }
    public void onBindViewHolder(UserViewHolder holder, int position){
        User list_items = list_objects.get(position);
        holder.txt1.setText(list_items.getMyName());
        holder.txt2.setText(list_items.getMyDesc());


    }

    public int getItemCount(){
        return list_objects.size();
    }

}

