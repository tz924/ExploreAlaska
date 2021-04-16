package com.example.explorealaska;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WildlifeFragment extends Fragment {
    final List<Wildlife> wildlifeList = new ArrayList<>();
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
        View rootView = inflater.inflate(R.layout.wildlife_list, container, false);

        RecyclerView rvWildlifeList = rootView.findViewById(R.id.wildlife_list);

        // Initialize wildlife list
        wildlifeList.add(new Wildlife(R.drawable.caribou));
        wildlifeList.add(new Wildlife(R.drawable.grizzly));
        wildlifeList.add(new Wildlife(R.drawable.dall_sheep));
        wildlifeList.add(new Wildlife(R.drawable.polar_bear));
        wildlifeList.add(new Wildlife(R.drawable.walrus));

        // Set up adapter
        WildlifeAdapter adapter = new WildlifeAdapter(wildlifeList);
        rvWildlifeList.setAdapter(adapter);

        rvWildlifeList.setLayoutManager(new LinearLayoutManager(this.getContext(),
            LinearLayoutManager.HORIZONTAL, false));

        return rootView;
    }
}
