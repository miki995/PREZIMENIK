package info.miki.znacenjePrezimena.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import info.miki.znacenjePrezimena.R;
import info.miki.znacenjePrezimena.data.BookAssets;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Adding new Drawer from library https://github.com/mikepenz/MaterialDrawer
        new DrawerBuilder().withActivity(this).build();
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.about_section);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName(R.string.video_section);
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName(R.string.contact_section);

        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .addDrawerItems(
                        item1.withName(R.string.about_section),
                        new DividerDrawerItem(),
                        item1.withName(R.string.about_section).withIcon(GoogleMaterial.Icon.gmd_info),
                        new DividerDrawerItem(),
                        item2.withName(R.string.video_section).withIcon(GoogleMaterial.Icon.gmd_featured_video),
                        new DividerDrawerItem(),
                        item3.withName(R.string.contact_section).withIcon(GoogleMaterial.Icon.gmd_contacts)

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch (position) {
                            case 2:
                                sendTo(AboutActivity.class);
                                break;
                            case 4:
                                sendTo(VideoActivity.class);
                                break;
                            case 6:
                                sendTo(ContactActivity.class);
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                })
                .build();


        // Determine if you're creating a two-pane or single-pane display
        if (findViewById(R.id.divider_layout) != null) {
            // This divider will only initially exist in the two-pane tablet case
            mTwoPane = true;

            // Change the GridView to space out the images more on tablet
            GridView gridView = findViewById(R.id.images_grid_view);
            gridView.setNumColumns(1);


            if (savedInstanceState == null) {
                // In two-pane mode, add initial BodyPartFragments to the screen
                FragmentManager fragmentManager = getSupportFragmentManager();

                // Creating a new book fragment
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setImageIds(BookAssets.getBooks());
                // Add the fragment to its container using a transaction
                fragmentManager.beginTransaction()
                        .add(R.id.book_container, detailFragment)
                        .commit();

            }
        } else {
            // We're in single-pane mode and displaying fragments on a phone in separate activities
            mTwoPane = false;
        }

    }


    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        if (mTwoPane) {
            // Create two=pane interaction
            DetailFragment detailFragment = new DetailFragment();
            // Give the correct image resources to the new fragment
            detailFragment.setImageIds(BookAssets.getBooks());
            detailFragment.setListIndex(position);
            // Replace the old head fragment with a new one
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.book_container, detailFragment)
                    .commit();

            ImageView imageView = findViewById(R.id.detail_image_view);
            imageView.setMinimumHeight(400);
            TextView titleTextView = findViewById(R.id.title_container);
            titleTextView.setTextSize(30);
            TextView descriptionTextView = findViewById(R.id.description_container);
            descriptionTextView.setTextSize(30);
        } else {
            // Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
            // Attach the Bundle to an intent
            Bundle b = new Bundle();
            b.putInt("bookIndex", position);

            final Intent detailIntent = new Intent(this, DetailActivity.class);
            detailIntent.putExtras(b);
            startActivity(detailIntent);
        }

    }

    public void sendTo(Class destinationActivity) {
        Intent detailIntent = new Intent(this, destinationActivity);
        startActivity(detailIntent);
    }

}
