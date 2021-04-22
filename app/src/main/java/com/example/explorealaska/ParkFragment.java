package com.example.explorealaska;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ParkFragment extends Fragment {

  /**
   * Called to have the fragment instantiate its user interface view. This is optional, and
   * non-graphical fragments can return null. This will be called between {@link #onCreate(Bundle)}
   * and {@link #onActivityCreated(Bundle)}.
   * <p>A default View can be returned by calling #Fragment(int) in your
   * constructor. Otherwise, this method returns null.
   *
   * <p>It is recommended to <strong>only</strong> inflate the layout in this method and move
   * logic that operates on the returned View to {@link #onViewCreated(View, Bundle)}.
   *
   * <p>If you return a View from here, you will later be called in
   * {@link #onDestroyView} when the view is being released.
   *
   * @param inflater           The LayoutInflater object that can be used to inflate any views in
   *                           the fragment,
   * @param container          If non-null, this is the parent view that the fragment's UI should be
   *                           attached to.  The fragment should not add the view itself, but this
   *                           can be used to generate the LayoutParams of the view.
   * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous
   *                           saved state as given here.
   * @return Return the View for the fragment's UI, or null.
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.list, container, false);

    RecyclerView rvParks = rootView.findViewById(R.id.list);

    // Initialize wildlife list
    final List<Item> parks = new ArrayList<>();
    parks.add(new Item(R.drawable.glacier_bay, getString(R.string.glacier_bay)));
    parks.add(new Item(R.drawable.denali, getString(R.string.denali)));
    parks.add(new Item(R.drawable.wrangell_st_elias, getString(R.string.wrangell_st_elias)));
    parks.add(new Item(R.drawable.kenai_fjord, getString(R.string.kenai_fjord)));
    parks.add(new Item(R.drawable.lake_clark, getString(R.string.lake_clark)));

    // Set up adapter
    ItemAdapter adapter = new ItemAdapter(parks);
    rvParks.setAdapter(adapter);

    // Set up horizontal scroll
    rvParks.setLayoutManager(new LinearLayoutManager(this.getContext(),
        LinearLayoutManager.VERTICAL, false));

    // Leveraging ItemClickSupport decorator to handle clicks on items in our recyclerView
    ItemClickSupport.addTo(rvParks).setOnItemClickListener(
        (recyclerView, position, v) -> {
          if (position == RecyclerView.NO_POSITION) {
            System.err.println("Position is invalid");
            System.exit(1);
          }

          Item park = parks.get(position);
          Context context = v.getContext();
          assert context != null;
          Intent intent = new Intent(context, ParkActivity.class);
          intent.putExtra("HEADER", park.getImageResourceId());
          intent.putExtra("INTRO_TITLE", park.getCaption());
          intent.putExtra("INTRO_TEXT", getString(R.string.park_intro_text));
          intent.putExtra("DIRECTION_MAP", R.drawable.park_map);
          intent.putExtra("DIRECTION_LOCATION_TITLE", getString(R.string.direction_location_title));
          intent.putExtra("DIRECTION_LOCATION_TEXT", getString(R.string.direction_location_text));
          intent.putExtra("DIRECTION_ADDRESS_TITLE", getString(R.string.direction_address_title));
          intent.putExtra("DIRECTION_ADDRESS_TEXT", getString(R.string.direction_address_text));
          context.startActivity(intent);
        }
    );

    return rootView;
  }
}
