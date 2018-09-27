package edu.stlawu.cs450fall18_hw2_montyhall;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.stlawu.cs450fall18_hw2_montyhall.MainFragment.OnFragmentInteractionListener;

public class MainActivity
        extends AppCompatActivity
        implements OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
