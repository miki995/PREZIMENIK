package info.miki.znacenjePrezimena.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import info.miki.znacenjePrezimena.R;

public class ContactActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void setCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:065528706"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void fb(View view) {
        try {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/349672008403968"));
            startActivity(intent);

        } catch (Exception e) {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/petaraskrabazagorski")));

        }
    }
}
