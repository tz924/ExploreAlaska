package com.example.explorealaska;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Specify the custom ViewHolder which gives us access to our views
 */
public class WildlifeAdapter extends RecyclerView.Adapter<WildlifeAdapter.ViewHolder> {
    private final List<Wildlife> mWildlifeList;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView mWildlifeImageView;
        private final Context mContext;

        public ViewHolder(Context context, @NonNull View itemView) {
            super(itemView);

            this.mWildlifeImageView = itemView.findViewById(R.id.wildlife_image);

            // On click support
            this.mContext = context;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                // TODO
                Wildlife wildlife = mWildlifeList.get(position);
                Toast.makeText(mContext, "Position " + position, Toast.LENGTH_SHORT).show();
            }
        }
    }


    public WildlifeAdapter(List<Wildlife> wildlifeList) {
        mWildlifeList = wildlifeList;
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override {@link #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull WildlifeAdapter.ViewHolder holder, int position) {
        Wildlife wildlife = mWildlifeList.get(position);
        ImageView wildlifeImageView = holder.mWildlifeImageView;
        wildlifeImageView.setImageResource(wildlife.getImageResourceId());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mWildlifeList.size();
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate custom layout
        View wildlifeView = inflater.inflate(R.layout.wildlife_item, parent, false);

        return new ViewHolder(context, wildlifeView);
    }
}
