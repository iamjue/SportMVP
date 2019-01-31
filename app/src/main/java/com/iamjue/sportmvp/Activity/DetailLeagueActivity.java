package com.iamjue.sportmvp.Activity;

import android.graphics.drawable.Drawable;
import android.support.v4.app.SupportActivity.ExtraData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.iamjue.sportmvp.MODEL.LeagueItem;
import com.iamjue.sportmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.biubiubiu.justifytext.library.JustifyTextView;

public class DetailLeagueActivity extends AppCompatActivity {
    @BindView(R.id.tv_LeagueDesc)
    JustifyTextView tvLeagueDesc;
    @BindView(R.id.img_leagueFanart)
    ImageView imgLeagueFanart;
    @BindView(R.id.img_leagueLogo)
    ImageView imgLeagueLogo;
    @BindView(R.id.img_leagueTrophy)
    ImageView imgLeagueTrophy;

    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_FANART = "extra_fanart";
    public static String EXTRA_LOGO = "extra_logo";
    public static String EXTRA_TROPHY = "extra_trophy";
    public static String EXTRA_DESC = "extra_desc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_deatail_league );
        ButterKnife.bind( this );

        tvLeagueDesc = findViewById( R.id.tv_LeagueDesc );
        imgLeagueFanart = findViewById( R.id.img_leagueFanart );
        imgLeagueLogo = findViewById( R.id.img_leagueLogo );
        imgLeagueTrophy = findViewById( R.id.img_leagueTrophy );


        getSupportActionBar().setTitle( getIntent().getStringExtra( EXTRA_NAME ) );
        tvLeagueDesc.setText( getIntent().getStringExtra( EXTRA_DESC ) );
        Glide.with( this )
                .load( getIntent().getStringExtra( EXTRA_FANART ) )
                .into( imgLeagueFanart );
        Glide.with( this )
                .load( getIntent().getStringExtra( EXTRA_LOGO ) )
                .into( imgLeagueLogo );
        Glide.with( this )
                .load( getIntent().getStringExtra( EXTRA_TROPHY ) )
                .into( imgLeagueTrophy );
    }
}
