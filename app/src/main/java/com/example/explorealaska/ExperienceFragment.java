package com.example.explorealaska;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExperienceFragment extends Fragment {
    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null. This will be called between
     * {@link #onCreate(Bundle)} and {@link #onActivityCreated(Bundle)}.
     * <p>A default View can be returned by calling {@link #Fragment(int)} in your
     * constructor. Otherwise, this method returns null.
     *
     * <p>It is recommended to <strong>only</strong> inflate the layout in this method and move
     * logic that operates on the returned View to {@link #onViewCreated(View, Bundle)}.
     *
     * <p>If you return a View from here, you will later be called in
     * {@link #onDestroyView} when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        // Create a list of experiences
        final List<Item> experiences = new ArrayList<>();
        experiences.add(new Item(R.drawable.aurora, Item.NO_CAPTION_PROVIDED));
        experiences.add(new Item(R.drawable.hot_spring, Item.NO_CAPTION_PROVIDED));
        experiences.add(new Item(R.drawable.seafood, Item.NO_CAPTION_PROVIDED));
        experiences.add(new Item(R.drawable.roadtrip, Item.NO_CAPTION_PROVIDED));
        experiences.add(new Item(R.drawable.glacier, Item.NO_CAPTION_PROVIDED));

        // Set up list view and adapter
        ItemAdapter itemAdapter = new ItemAdapter(Objects.requireNonNull(this.getActivity()), experiences);
        ListView listView = (ListView) rootView.findViewById(R.id.item_list);
        listView.setAdapter(itemAdapter);

        return rootView;
    }
}
