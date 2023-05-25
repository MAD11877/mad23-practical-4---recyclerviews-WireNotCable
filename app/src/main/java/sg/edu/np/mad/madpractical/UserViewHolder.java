package sg.edu.np.mad.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView txt1;
    TextView txt2;

    ImageView image;

    public UserViewHolder(View itemView){
        super(itemView);
        txt1 = itemView.findViewById(R.id.nameTextView);
        txt2 = itemView.findViewById(R.id.descTextView);
        image = itemView.findViewById(R.id.imageView2);
    }
}
