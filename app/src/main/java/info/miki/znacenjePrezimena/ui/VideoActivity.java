package info.miki.znacenjePrezimena.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import info.miki.znacenjePrezimena.R;

public class VideoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
    }

    public void open1(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=kbJQ5SFoSYk")));

    }

    public void open2(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=kSjt2naug64")));
    }

    public void open3(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Sr6_fhN5tRI")));

    }

    public void open4(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=oF9lLFJxP6E")));
    }

    public void open5(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=SF7eGkHOFaw")));

    }

    public void open6(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=fK8HFoxC_yU")));
    }

}

