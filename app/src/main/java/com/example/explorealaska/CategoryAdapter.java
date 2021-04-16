package com.example.explorealaska;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Item} objects.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    private final Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context                is the context of the app
     * @param supportFragmentManager is the fragment manager that will keep each fragment's state in the adapter across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
        mContext = context;
    }

    /**
     * Return the Fragment associated with a specified position.
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new WildlifeFragment();
            case 1:
                return new ExperienceFragment();
            case 2:
                return new ParkFragment();
            default:
                return new ParkFragment();
        }
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 4;
    }

    /**
     * This method may be called by the ViewPager to obtain a title string
     * to describe the specified page. This method may return null
     * indicating no title for this page. The default implementation returns
     * null.
     *
     * @param position The position of the title requested
     * @return A title for the requested page
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.category_wildlife);
            case 1:
                return mContext.getString(R.string.category_experience);
            case 2:
                return mContext.getString(R.string.category_park);
            default:
                return mContext.getString(R.string.category_park);
        }
    }
}
