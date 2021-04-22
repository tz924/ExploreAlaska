package com.example.explorealaska;

import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Text;

public class InsPostFragment extends Fragment {


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
  @RequiresApi(api = VERSION_CODES.M)
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.list, container, false);

    RecyclerView rvParks = rootView.findViewById(R.id.list);

    // Initialize wildlife list
    final List<Item> insPosts = new ArrayList<>();
    insPosts.add(new Item(R.drawable.ins_cave, getString(R.string.ins_cave)));
    insPosts.add(new Item(R.drawable.ins_aurora, getString(R.string.ins_aurora)));
    insPosts.add(new Item(R.drawable.ins_polar, getString(R.string.ins_polar)));
    insPosts.add(new Item(R.drawable.ins_beer, getString(R.string.ins_beer)));
    insPosts.add(new Item(R.drawable.ins_mountain, getString(R.string.ins_mountain)));

    // Set up adapter
    ItemAdapter adapter = new InsItemAdapter(insPosts);
    rvParks.setAdapter(adapter);

    // Set up horizontal scroll
    rvParks.setLayoutManager(new LinearLayoutManager(this.getContext(),
        LinearLayoutManager.VERTICAL, false));

    return rootView;
  }
}
