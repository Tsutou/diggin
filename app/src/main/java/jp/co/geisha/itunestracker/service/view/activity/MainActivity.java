package jp.co.geisha.itunestracker.service.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import jp.co.geisha.itunestracker.R;
import jp.co.geisha.itunestracker.service.model.Artist;
import jp.co.geisha.itunestracker.service.util.FragmentUtils;
import jp.co.geisha.itunestracker.service.view.fragment.ArtistListFragment;
import jp.co.geisha.itunestracker.service.view.fragment.ArtistTabsFragment;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            ArtistTabsFragment fragment = new ArtistTabsFragment();

            FragmentUtils.insertFragmentToActivity(
                    R.id.fragment_container,
                    getSupportFragmentManager(),
                    fragment,
                    ArtistTabsFragment.Companion.getARTIST_TABS_TAG());
        }

    }

    //VideoView画面への遷移
    public void show(Artist artist) {
        if (!isEmpty(artist.previewUrl)) {
            Intent i = new Intent(getApplicationContext(), VideoViewActivity.class);
            i.putExtra(URL, artist.previewUrl);
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "This Video has not Preview", Toast.LENGTH_SHORT).show();
        }
    }

}