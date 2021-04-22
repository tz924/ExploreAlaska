package com.example.explorealaska;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * Specify the custom ViewHolder which gives us access to our views
 */
public class InsItemAdapter extends ItemAdapter {

  public InsItemAdapter(List<Item> items) {
    super(items);
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    LayoutInflater inflater = LayoutInflater.from(context);
    // Inflate custom layout
    View itemView = inflater.inflate(R.layout.list_item_ins, parent, false);

    return new ViewHolder(context, itemView);
  }
}
