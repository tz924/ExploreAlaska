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

public class WildlifeFragment extends Fragment {

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

    RecyclerView rvWildlifeList = rootView.findViewById(R.id.list);

    // Initialize wildlife list
    final List<Item> wildlifeList = new ArrayList<>();
    wildlifeList.add(new Item(R.drawable.caribou, getString(R.string.caribou)));
    wildlifeList.add(new Item(R.drawable.grizzly_bear, getString(R.string.grizzly_bear)));
    wildlifeList.add(new Item(R.drawable.dall_sheep, getString(R.string.dall_sheep)));
    wildlifeList.add(new Item(R.drawable.polar_bear, getString(R.string.polar_bear)));
    wildlifeList.add(new Item(R.drawable.moose, getString(R.string.moose)));

    // Set up adapter
    ItemAdapter adapter = new ItemAdapter(wildlifeList);
    rvWildlifeList.setAdapter(adapter);

    // Set up horizontal scroll
    rvWildlifeList.setLayoutManager(new LinearLayoutManager(this.getContext(),
        LinearLayoutManager.VERTICAL, false));

    // Leveraging ItemClickSupport decorator to handle clicks on items in our recyclerView
    ItemClickSupport.addTo(rvWildlifeList).setOnItemClickListener(
        (recyclerView, position, v) -> {
          if (position == RecyclerView.NO_POSITION) {
            System.err.println("Position is invalid");
            System.exit(1);
          }

          Item wildlife = wildlifeList.get(position);
          Context context = v.getContext();
          assert context != null;
          Intent intent = new Intent(context, WildlifeActivity.class);
          intent.putExtra("HEADER", wildlife.getImageResourceId());
          intent.putExtra("INTRO_TITLE", wildlife.getCaption());
          intent.putExtra("INTRO_TEXT", getString(R.string.wildlife_intro_moose_text));
          intent.putExtra("WHERE_TITLE", getString(R.string.wildlife_where_title));
          intent.putExtra("WHERE_IMAGE_1", R.drawable.where_image_1);
          intent.putExtra("WHERE_TEXT_1", getString(R.string.wildlife_where_text_1));
          intent.putExtra("WHERE_IMAGE_2", R.drawable.where_image_2);
          intent.putExtra("WHERE_TEXT_2", getString(R.string.wildlife_where_text_2));
          intent.putExtra("WHERE_IMAGE_3", R.drawable.where_image_3);
          intent.putExtra("WHERE_TEXT_3", getString(R.string.wildlife_where_text_3));
          intent.putExtra("TIPS_TITLE", getString(R.string.wildlife_tips_title));
          intent.putExtra("TIPS_TEXT_1", getString(R.string.wildlife_tips_text_1));
          intent.putExtra("TIPS_TEXT_2", getString(R.string.wildlife_tips_text_2));
          intent.putExtra("TIPS_TEXT_3", getString(R.string.wildlife_tips_text_3));
          context.startActivity(intent);
        }
    );

    return rootView;
  }
}
