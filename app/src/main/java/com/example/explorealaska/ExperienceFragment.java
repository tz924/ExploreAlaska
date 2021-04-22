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

public class ExperienceFragment extends Fragment {


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
   *                           can be used to generate the LayoutPaams of the view.
   * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous
   *                           saved state as given here.
   * @return Return the View for the fragment's UI, or null.
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.list, container, false);

    RecyclerView rvExperiences = rootView.findViewById(R.id.list);

    // Initialize wildlife list
    final List<Item> experiences = new ArrayList<>();
    experiences.add(new Item(R.drawable.roadtrip, getString(R.string.road_trip)));
    experiences.add(new Item(R.drawable.seafood, getString(R.string.seafood)));
    experiences.add(new Item(R.drawable.aurora, getString(R.string.aurora)));
    experiences.add(new Item(R.drawable.glacier, getString(R.string.glacier)));
    experiences.add(new Item(R.drawable.hot_spring, getString(R.string.hot_spring)));

    // Set up adapter
    ItemAdapter adapter = new ItemAdapter(experiences);
    rvExperiences.setAdapter(adapter);

    // Set up horizontal scroll
    rvExperiences.setLayoutManager(new LinearLayoutManager(this.getContext(),
        LinearLayoutManager.VERTICAL, false));

    // Leveraging ItemClickSupport decorator to handle clicks on items in our recyclerView
    ItemClickSupport.addTo(rvExperiences).setOnItemClickListener(
        (recyclerView, position, v) -> {
          if (position == RecyclerView.NO_POSITION) {
            System.err.println("Position is invalid");
            System.exit(1);
          }

          Item experience = experiences.get(position);
          Context context = v.getContext();
          assert context != null;
          Intent intent = new Intent(context, ExperienceActivity.class);
          intent.putExtra("HEADER", experience.getImageResourceId());
          intent.putExtra("INTRO_TITLE", experience.getCaption());
          intent.putExtra("INTRO_TEXT", getString(R.string.experience_intro_glacier_text));
          intent.putExtra("EXPERIENCE_TITLE", getString(R.string.experience_title));
          intent.putExtra("EXPERIENCE_TEXT_1", getString(R.string.experience_text_1));
          intent.putExtra("EXPERIENCE_TEXT_2", getString(R.string.experience_text_2));
          intent.putExtra("EXPERIENCE_IMAGE", R.drawable.glacier_image);
          context.startActivity(intent);
        }
    );

    return rootView;
  }
}
