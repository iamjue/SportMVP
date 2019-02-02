package com.iamjue.sportmvp.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.iamjue.sportmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailTeamActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.img_teamFanart)
    ImageView imgTeamFanart;
    @BindView(R.id.img_banner)
    ImageView imgBanner;
    @BindView(R.id.img_jerseyTeam)
    ImageView imgJerseyTeam;
    @BindView(R.id.img_teamStadion)
    ImageView imgTeamStadion;
    @BindView(R.id.img_youtube)
    ImageView strYoutube;
    @BindView(R.id.img_fb)
    ImageView strFacebook;
    @BindView(R.id.img_twiter)
    ImageView strTwitter;
    @BindView(R.id.img_ig)
    ImageView strInstagram;
    @BindView(R.id.img_web)
    ImageView strWebsite;
    @BindView(R.id.img_teamBadgeDetail)
    CircleImageView imgBadge;
    @BindView(R.id.tv_teamNameDetail)
    TextView strTeam;
    @BindView(R.id.tv_teamManager)
    TextView strManager;
    @BindView(R.id.tv_nameStadionTeam)
    TextView strStadium;
    @BindView(R.id.tv_stadiumDesc)
    TextView strStadiumDescription;
    @BindView(R.id.tv_stadiumLocation)
    TextView strStadiumLocation;
    @BindView(R.id.tv_stadiumCapacity)
    TextView intStadiumCapacity;
    @BindView(R.id.tv_teamDesc)
    TextView strDescriptionEN;
    @BindView(R.id.tv_notBanner)
    TextView tvNoBanner;
    @BindView(R.id.tv_notStadium)
    TextView tvNoStadium;
    String youtube, ig, web, fb, twitter, banner, stadium;
    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_MANAGER = "extra_manager";
    public static String EXTRA_STADIUM_NAME = "extra_stadium_name";
    public static String EXTRA_STADIUM_DESC = "extra_stadium_desc";
    public static String EXTRA_STADIUM_LOCATION = "extra_stadium_location";
    public static String EXTRA_STADIUM_CAPACITY = "extra_stadium_capacity";
    public static String EXTRA_DESC = "extra_desc";
    public static String EXTRA_BADGE = "extra_badge";
    public static String EXTRA_JERSEY = "extra_jersey";
    public static String EXTRA_BANNER = "extra_banner";
    public static String EXTRA_STADIUM_THUMB = "extra_stadium_thumb";
    public static String EXTRA_FB = "extra_fb";
    public static String EXTRA_IG = "extra_ig";
    public static String EXTRA_TW = "extra_tw";
    public static String EXTRA_YOUTUBE = "extra_youtubec";
    public static String EXTRA_WEBSITE = "extra_website";
    public static String EXTRA_FANART = "extra_fanart";
    public static String EXTRA_COUNTRY = "extra_country";
    public final String noData = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail_team );
        ButterKnife.bind( this );

        strFacebook.setOnClickListener( this );
        strInstagram.setOnClickListener( this );
        strTwitter.setOnClickListener( this );
        strYoutube.setOnClickListener( this );
        strWebsite.setOnClickListener( this );

        Glide.with( this )
                .load( getIntent().getStringExtra( EXTRA_BADGE ) )
                .into( imgBadge );

        banner = getIntent().getStringExtra( EXTRA_BANNER );
        Glide.with( this ).load( banner ).into( imgBanner );
        if (banner.equals( noData )) {
            imgBanner.setVisibility( View.INVISIBLE );
            tvNoBanner.setVisibility( View.VISIBLE );
        }

        Glide.with( this )
                .load( getIntent().getStringExtra( EXTRA_JERSEY ) )
                .into( imgJerseyTeam );

        Glide.with( this )
                .load( getIntent().getStringExtra( EXTRA_FANART ) )
                .into( imgTeamFanart );

        stadium = getIntent().getStringExtra( EXTRA_STADIUM_THUMB );
        Glide.with( this ).load( stadium ).into( imgTeamStadion );
        if (stadium.equals( noData )) {
            imgTeamStadion.setVisibility( View.INVISIBLE );
            tvNoStadium.setVisibility( View.VISIBLE );
        }

        String title = getIntent().getStringExtra( EXTRA_NAME ) + " - " + getIntent().getStringExtra( EXTRA_COUNTRY );
        getSupportActionBar().setTitle( title );

        strTeam.setText( getIntent().getStringExtra( EXTRA_NAME ) );
        strManager.setText( getIntent().getStringExtra( EXTRA_MANAGER ) );
        strStadium.setText( getIntent().getStringExtra( EXTRA_STADIUM_NAME ) );
        strStadiumDescription.setText( getIntent().getStringExtra( EXTRA_STADIUM_DESC ) );
        strStadiumLocation.setText( getIntent().getStringExtra( EXTRA_STADIUM_LOCATION ) );
        intStadiumCapacity.setText( getIntent().getStringExtra( EXTRA_STADIUM_CAPACITY ) + " person" );
        strDescriptionEN.setText( getIntent().getStringExtra( EXTRA_DESC ) );

        fb = getIntent().getStringExtra( EXTRA_FB );
        if (fb.isEmpty()) {
            strFacebook.setVisibility( View.INVISIBLE );
        }

        twitter = getIntent().getStringExtra( EXTRA_TW );
        if (twitter.isEmpty()) {
            strTwitter.setVisibility( View.INVISIBLE );
        }

        ig = getIntent().getStringExtra( EXTRA_IG );

        if (ig.isEmpty()) {
            strInstagram.setVisibility( View.INVISIBLE );
        }

        youtube = getIntent().getStringExtra( EXTRA_YOUTUBE );
        if (youtube.isEmpty()) {
            strYoutube.setVisibility( View.INVISIBLE );
        }

        web = getIntent().getStringExtra( EXTRA_WEBSITE );
        if (web.isEmpty()) {
            strWebsite.setVisibility( View.INVISIBLE );
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_web:
                Intent intentWeb = new Intent( Intent.ACTION_VIEW, Uri.parse( "https://" + web ) );
                startActivity( intentWeb );
                Toast.makeText( this, web, Toast.LENGTH_SHORT ).show();

                break;
            case R.id.img_ig:
                Intent intentIg = new Intent( Intent.ACTION_VIEW, Uri.parse( "https://" + ig ) );
                startActivity( intentIg );
                Toast.makeText( this, ig, Toast.LENGTH_SHORT ).show();
                break;
            case R.id.img_fb:
                Intent intentFb = new Intent( Intent.ACTION_VIEW, Uri.parse( "https://" + fb ) );
                startActivity( intentFb );
                Toast.makeText( this, fb, Toast.LENGTH_SHORT ).show();
                break;
            case R.id.img_twiter:
                Intent intentTwitter = new Intent( Intent.ACTION_VIEW, Uri.parse( "https://" + twitter ) );
                startActivity( intentTwitter );
                Toast.makeText( this, twitter, Toast.LENGTH_SHORT ).show();
                break;
            case R.id.img_youtube:
                Intent intentYoutube = new Intent( Intent.ACTION_VIEW, Uri.parse( "https://" + youtube ) );
                startActivity( intentYoutube );
                Toast.makeText( this, youtube, Toast.LENGTH_SHORT ).show();
                break;
        }
    }
}
