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

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailTeamActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgTeamFanart, imgBanner, imgJerseyTeam, imgTeamStadion, strYoutube, strFacebook, strTwitter, strInstagram, strWebsite;
    CircleImageView imgBadge;
    TextView strTeam, strManager, strStadium, strStadiumDescription, strStadiumLocation, intStadiumCapacity, strDescriptionEN, tvNoBanner;
    String youtube, ig, web, fb, twitter, banner;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail_team );
        imgBadge = findViewById( R.id.img_teamBadgeDetail );
        imgBanner = findViewById( R.id.img_banner );
        imgJerseyTeam = findViewById( R.id.img_jerseyTeam );
        imgTeamFanart = findViewById( R.id.img_teamFanart );
        imgTeamStadion = findViewById( R.id.img_teamStadion );

        strTeam = findViewById( R.id.tv_teamNameDetail );
        strManager = findViewById( R.id.tv_teamManager );
        strStadium = findViewById( R.id.tv_nameStadionTeam );
        strStadiumDescription = findViewById( R.id.tv_stadiumDesc );
        strStadiumLocation = findViewById( R.id.tv_stadiumLocation );
        intStadiumCapacity = findViewById( R.id.tv_stadiumCapacity );
        strDescriptionEN = findViewById( R.id.tv_teamDesc );
        tvNoBanner =  findViewById( R.id.tv_notBanner);
        strFacebook = findViewById( R.id.img_fb );
        strFacebook.setOnClickListener( this );
        strInstagram = findViewById( R.id.img_ig );
        strInstagram.setOnClickListener( this );
        strTwitter = findViewById( R.id.img_twiter );
        strTwitter.setOnClickListener( this );
        strYoutube = findViewById( R.id.img_youtube );
        strYoutube.setOnClickListener( this );
        strWebsite = findViewById( R.id.img_web );
        strWebsite.setOnClickListener( this );

        Glide.with( this )
                .load( getIntent().getStringExtra( EXTRA_BADGE ) )
                .into( imgBadge );
        Glide.with( this )
                .load(getIntent().getStringExtra( EXTRA_BANNER) )
                .into( imgBanner );
        Glide.with( this )
                .load( getIntent().getStringExtra( EXTRA_JERSEY ) )
                .into( imgJerseyTeam );
        Glide.with( this )
                .load( getIntent().getStringExtra( EXTRA_FANART ) )
                .into( imgTeamFanart );
        Glide.with( this )
                .load( getIntent().getStringExtra( EXTRA_STADIUM_THUMB ) )
                .into( imgTeamStadion );
        String title = getIntent().getStringExtra( EXTRA_NAME ) + " - " + getIntent().getStringExtra( EXTRA_COUNTRY );
        getSupportActionBar().setTitle( title);
        strTeam.setText( getIntent().getStringExtra( EXTRA_NAME ) );
        strManager.setText( getIntent().getStringExtra( EXTRA_MANAGER ) );
        strStadium.setText( getIntent().getStringExtra( EXTRA_STADIUM_NAME ) );
        strStadiumDescription.setText( getIntent().getStringExtra( EXTRA_STADIUM_DESC ) );
        strStadiumLocation.setText("Stadium Location :\n"+ getIntent().getStringExtra( EXTRA_STADIUM_LOCATION ) );
        intStadiumCapacity.setText( "Stadium Capacity :\n"+getIntent().getStringExtra( EXTRA_STADIUM_CAPACITY ) );
        strDescriptionEN.setText( getIntent().getStringExtra( EXTRA_DESC ) );

        fb = getIntent().getStringExtra( EXTRA_FB );
        twitter = getIntent().getStringExtra( EXTRA_TW );
        ig = getIntent().getStringExtra( EXTRA_IG );
        youtube = getIntent().getStringExtra( EXTRA_YOUTUBE );
        web = getIntent().getStringExtra( EXTRA_WEBSITE );

        if (fb.isEmpty()) {
            strFacebook.setVisibility( View.INVISIBLE );
        }
        if (twitter.isEmpty()){
            strTwitter.setVisibility( View.INVISIBLE );
        }
        if (ig.isEmpty()){
            strInstagram.setVisibility( View.INVISIBLE );
        }
        if (youtube.isEmpty()){
            strYoutube.setVisibility( View.INVISIBLE );
        }
        if (web.isEmpty()){
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
