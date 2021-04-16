package com.example.explorealaska;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExperienceFragment extends Fragment {
    final List<Experience> experienceList = new ArrayList<>();

    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null. This will be called between
     * {@link #onCreate(Bundle)} and {@link #onActivityCreated(Bundle)}.
     * <p>A default View can be returned by calling #Fragment(int) in your
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
        View rootView = inflater.inflate(R.layout.experience_list, container, false);
        RecyclerView rvExperienceList = rootView.findViewById(R.id.experience_list);

        // Create a list of experiences
        experienceList.add(new Experience(R.drawable.aurora));
        experienceList.add(new Experience(R.drawable.hot_spring));
        experienceList.add(new Experience(R.drawable.seafood));
        experienceList.add(new Experience(R.drawable.roadtrip));
        experienceList.add(new Experience(R.drawable.glacier));
        experienceList.add(new Experience(R.drawable.glacier));
        experienceList.add(new Experience(R.drawable.glacier));
        experienceList.add(new Experience(R.drawable.glacier));
        experienceList.add(new Experience(R.drawable.glacier));
        // TODO PLACEHOLDER

        // Set up adapter
        ExperienceAdapter adapter = new ExperienceAdapter(experienceList);
        rvExperienceList.setAdapter(adapter);

        rvExperienceList.setLayoutManager(new GridLayoutManager(this.getContext(), 3,
            GridLayoutManager.HORIZONTAL,
                false));

        return rootView;
    }
}
