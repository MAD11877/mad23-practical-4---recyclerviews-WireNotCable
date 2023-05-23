package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView clickImage = findViewById(R.id.image3);
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
        });
    }
}