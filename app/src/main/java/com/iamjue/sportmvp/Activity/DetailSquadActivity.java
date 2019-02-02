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
import com.iamjue.sportmvp.MODEL.SquadItem;
import com.iamjue.sportmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.biubiubiu.justifytext.library.JustifyTextView;

public class DetailSquadActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.img_playerTeam)
    ImageView imgPlayerTeam;
    @BindView(R.id.img_playerCutout)
    ImageView imgPlayerCutout;
    @BindView(R.id.img_playerThumb)
    ImageView imgPlayerThumb;
    @BindView(R.id.img_playerIg)
    ImageView imgPlayerIg;
    @BindView(R.id.img_playerTwiter)
    ImageView imgPlayerTwitter;
    @BindView(R.id.img_playerFb)
    ImageView imgPlayerFb;
    @BindView(R.id.tv_playerDesc)
    JustifyTextView tvPlayerDesc;
    @BindView(R.id.tv_playerName)
    TextView tvPlayerName;
    @BindView(R.id.tv_playerNameBio)
    TextView tvPlayerNameBio;
    @BindView(R.id.tv_playerPosition)
    TextView tvPlayerPosition;
    @BindView(R.id.tv_playerPositionBio)
    TextView tvPlayerPositionBio;
    @BindView(R.id.tv_playerNationality)
    TextView tvPlayerNationality;
    @BindView(R.id.tv_playerPlaceDateBirth)
    TextView tvPlayerPlaceDateBirth;
    @BindView(R.id.tv_playerHeightNWeight)
    TextView tvPlayerHeightNweight;
    @BindView(R.id.tv_playerDateSigned)
    TextView tvPlayerDateSigned;
    @BindView(R.id.tv_playerSigning)
    TextView tvPlayerSigning;
    @BindView(R.id.tv_playerWage)
    TextView tvPlayerWage;
    @BindView(R.id.tv_notPlayer)
    TextView tvNotPlayer;
    public static String EXTRA_FANART = "extra_fanart";
    String fb, twitter, ig, cutout, player;
    public final String noData = "null";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail_squad );
        ButterKnife.bind( this );

        imgPlayerIg.setOnClickListener( this );
        imgPlayerTwitter.setOnClickListener( this );
        imgPlayerFb.setOnClickListener( this );

        SquadItem squadItem = getIntent().getParcelableExtra( "squadData" );

        cutout = squadItem.getStrCutout();
        if (cutout.equals( noData )) {
            imgPlayerCutout.setImageResource( R.drawable.ic_person_white );
        } else {
            Glide.with( this ).load( cutout ).into( imgPlayerCutout );
        }

        player = squadItem.getStrThumb();
        Glide.with( this ).load( player ).into( imgPlayerThumb );
        if (player.equals( noData )) {
            imgPlayerThumb.setVisibility( View.INVISIBLE );
            tvNotPlayer.setVisibility( View.VISIBLE );
        }

        Glide.with( this )
                .load( getIntent().getStringExtra( EXTRA_FANART ) )
                .into( imgPlayerTeam );

        tvPlayerName.setText( squadItem.getStrPlayer() );
        tvPlayerPosition.setText( squadItem.getStrPosition() );
        tvPlayerNameBio.setText( squadItem.getStrPlayer() );
        tvPlayerPositionBio.setText( squadItem.getStrPosition() );
        tvPlayerNationality.setText( squadItem.getStrNationality() );
        tvPlayerPlaceDateBirth.setText( squadItem.getStrBirthLocation() + ", " + squadItem.getDateBorn() );
        tvPlayerHeightNweight.setText( squadItem.getStrHeight() + "m - " + squadItem.getStrWeight() + "kg" );
        tvPlayerDateSigned.setText( squadItem.getDateSigned() );
        tvPlayerSigning.setText( squadItem.getStrSigning() );
        tvPlayerWage.setText( squadItem.getStrWage() );
        tvPlayerDesc.setText( squadItem.getStrDescriptionEN() );

        getSupportActionBar().setTitle( squadItem.getStrTeam() );


        fb = squadItem.getStrFacebook();
        if (fb.isEmpty()) {
            imgPlayerFb.setVisibility( View.INVISIBLE );
        }

        twitter = squadItem.getStrTwitter();
        if (twitter.isEmpty()) {
            imgPlayerTwitter.setVisibility( View.INVISIBLE );
        }

        ig = squadItem.getStrInstagram();
        if (ig.isEmpty()) {
            imgPlayerIg.setVisibility( View.INVISIBLE );
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_playerIg:
                Intent intentIg = new Intent( Intent.ACTION_VIEW, Uri.parse( "https://" + ig ) );
                startActivity( intentIg );
                Toast.makeText( this, ig, Toast.LENGTH_SHORT ).show();
                break;
            case R.id.img_playerFb:
                Intent intentFb = new Intent( Intent.ACTION_VIEW, Uri.parse( "https://" + fb ) );
                startActivity( intentFb );
                Toast.makeText( this, fb, Toast.LENGTH_SHORT ).show();
                break;
            case R.id.img_playerTwiter:
                Intent intentTwitter = new Intent( Intent.ACTION_VIEW, Uri.parse( "https://" + twitter ) );
                startActivity( intentTwitter );
                Toast.makeText( this, twitter, Toast.LENGTH_SHORT ).show();
                break;
        }
    }
}
