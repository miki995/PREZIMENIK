package info.miki.znacenjePrezimena.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import info.miki.znacenjePrezimena.R;
import info.miki.znacenjePrezimena.data.BookAssets;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        if (savedInstanceState == null) {

            // Retrieve list index values that were sent through an intent; use them to display the desired Android-Me body part image
            // Use setListindex(int index) to set the list index for all BodyPartFragments

            // Create a new head BodyPartFragment
            DetailFragment detailFragment = new DetailFragment();

            // Set the list of image id's for the head fragment and set the position to the second image in the list
            detailFragment.setImageIds(BookAssets.getBooks());

            // Get the correct index to access in the array of head images from the intent
            // Set the default value to 0
            int bookIndex = getIntent().getIntExtra("bookIndex", 0);
            detailFragment.setListIndex(bookIndex);

            // Add the fragment to its container using a FragmentManager and a Transaction
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.book_container, detailFragment)
                    .commit();

        }

    }
}
