package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    ArrayList<User> myObject_List = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        for (int i = 0; i <= 20; i++){
            int name = new Random().nextInt();
            int desc = new Random().nextInt();
            Boolean follow = new Random().nextBoolean();

            User user = new User();
            user.setMyName("Name"+String.valueOf(name));
            user.setMyDesc("Description "+String.valueOf(desc));
            user.setMyFollow(follow);

            myObject_List.add(user);
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        UserAdaptor userAdaptor = new UserAdaptor(myObject_List);
        LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdaptor);



        /*
        ImageView clickImage = findViewById(R.id.imageView2);
        clickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        //send data to main activity
                        Intent sendNum = new Intent(ListActivity.this, MainActivity.class);
                        int num = new Random().nextInt();
                        sendNum.putExtra("num",num);
                        startActivity(sendNum);
                    }
                });
                builder.setNegativeButton("Close", null);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });*/
    }
}