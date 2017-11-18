package info.miki.znacenjePrezimena.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import info.miki.znacenjePrezimena.R;


public class DetailFragment extends Fragment {

    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";


    // Variables to store a list of image resources and the index of the image that this fragment displays
    private List<Integer> mImageIds;
    private int mListIndex;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment
     */
    public DetailFragment() {
    }

    public void setImageIds(List<Integer> imageIds) {
        mImageIds = imageIds;
    }

    public void setListIndex(int index) {
        mListIndex = index;
    }


    /**
     * Save the current state of this fragment
     */
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Load the saved state (the list of images and list index) if there is one
        if (savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        // Inflate the Android-Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        // Get a reference to the ImageView in the fragment layout
        final ImageView imageView = rootView.findViewById(R.id.detail_image_view);
        final TextView titleTextView = rootView.findViewById(R.id.title_container);
        final TextView descTextView = rootView.findViewById(R.id.description_container);

        DescriptionData descriptionData = new DescriptionData();
        List<String> titleList = descriptionData.getTitles();
        List<String> descList = descriptionData.getDescripitons();

        // If a list of image ids exists, set the image resource to the correct item in that list
        // Otherwise, create a Log statement that indicates that the list was not found
        if (mImageIds != null) {
            // Set the image resource to the list item at the stored index
            imageView.setImageResource(mImageIds.get(mListIndex));
            titleTextView.setText(titleList.get(mListIndex));
            descTextView.setText(descList.get(mListIndex));

        }
        // Return the rootView
        return rootView;
    }

    public class DescriptionData {
        private final List<String> titles = new ArrayList<String>() {{
            add(getString(R.string.a1));
            add(getString(R.string.a2));
            add(getString(R.string.a3));
            add(getString(R.string.a4));
            add(getString(R.string.a5));
            add(getString(R.string.a6));
            add(getString(R.string.a7));
            add(getString(R.string.a8));
            add(getString(R.string.a9));
            add(getString(R.string.a10));
            add(getString(R.string.a11));
            add(getString(R.string.a12));
            add(getString(R.string.a13));
        }};

        private final List<String> descripitons = new ArrayList<String>() {{
            add(getString(R.string.b1));
            add(getString(R.string.b2));
            add(getString(R.string.b3));
            add(getString(R.string.b4));
            add(getString(R.string.b5));
            add(getString(R.string.b6));
            add(getString(R.string.b7));
            add(getString(R.string.b8));
            add(getString(R.string.b9));
            add(getString(R.string.b10));
            add(getString(R.string.b11));
            add(getString(R.string.b12));
            add(getString(R.string.b13));
        }};

        public List<String> getTitles() {
            return titles;
        }

        public List<String> getDescripitons() {
            return descripitons;
        }

    }

}
