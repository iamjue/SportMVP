package com.iamjue.sportmvp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.iamjue.sportmvp.ADAPTER.SquadAdapter;
import com.iamjue.sportmvp.API.ApiTheSportDb;
import com.iamjue.sportmvp.MODEL.LeagueItem;
import com.iamjue.sportmvp.MODEL.SquadItem;
import com.iamjue.sportmvp.MODEL.TeamItem;
import com.iamjue.sportmvp.OnclickLibrary.ItemClickSupport;
import com.iamjue.sportmvp.PRESENTER.SquadPresenter;
import com.iamjue.sportmvp.R;
import com.iamjue.sportmvp.VIEW.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class TeamActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.tv_nameTeam)
    TextView tvTeam;
    @BindView(R.id.img_teamLogo)
    CircleImageView imgTeamLogo;
    @BindView(R.id.rv_squad)
    RecyclerView rvSquad;

    SquadPresenter squadPresenter;
    SquadAdapter squadAdapter;
    ApiTheSportDb apiTheSportDb;

    String strTeam, strManager, strStadium, strStadiumDescription, strStadiumLocation, intStadiumCapacity, strDescriptionEN,
            strTeamBadge, strTeamJersey, strTeamBanner, strStadiumThumb, strFacebook, strTwitter, strInstagram, strYoutube, strTeamFanart1,
            strWebsite, country;
    public static String EXTRA_TITLE_COUNTRY = "extra_title_country";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_team );
        ButterKnife.bind( this );

        tvTeam = findViewById( R.id.tv_nameTeam );
        imgTeamLogo = findViewById( R.id.img_teamLogo );

        TeamItem teamItem = getIntent().getParcelableExtra( "teamData" );

        strTeam = teamItem.getStrTeam();
        strManager = teamItem.getStrManager();
        strStadium = teamItem.getStrStadium();
        strStadiumDescription = teamItem.getStrStadiumDescription();
        strStadiumLocation = teamItem.getStrStadiumLocation();
        intStadiumCapacity = teamItem.getIntStadiumCapacity();
        strDescriptionEN = teamItem.getStrDescriptionEN();
        strTeamBadge = teamItem.getStrTeamBadge();
        strTeamJersey = teamItem.getStrTeamJersey();
        strTeamBanner = teamItem.getStrTeamBanner();
        strStadiumThumb = teamItem.getStrStadiumThumb();
        strFacebook = teamItem.getStrFacebook();
        strTwitter = teamItem.getStrTwitter();
        strInstagram = teamItem.getStrInstagram();
        strYoutube = teamItem.getStrYoutube();
        strTeamFanart1 = teamItem.getStrTeamFanart1();
        strWebsite = teamItem.getStrWebsite();
        country = getIntent().getStringExtra( EXTRA_TITLE_COUNTRY );

        //actionBar
        getSupportActionBar().setTitle( teamItem.getStrTeam() );

        tvTeam.setText( teamItem.getStrTeam() );
        Glide.with( this ).load( teamItem.getStrTeamBadge() ).into( imgTeamLogo );


        squadAdapter = new SquadAdapter( this );
        apiTheSportDb = new ApiTheSportDb();
        rvSquad.setLayoutManager( new LinearLayoutManager( this ) );
        squadPresenter = new SquadPresenter( this, apiTheSportDb, this );
        squadPresenter.LoadSquad( teamItem.getStrTeam() );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_team, menu );
        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_team_detail:
                Intent intent = new Intent( this, DetailTeamActivity.class );
                //yang di inisialisai di atas di panggil di sini, untuk di bawa ke activity lain
                intent.putExtra( DetailTeamActivity.EXTRA_NAME, strTeam );
                intent.putExtra( DetailTeamActivity.EXTRA_MANAGER, strManager );
                intent.putExtra( DetailTeamActivity.EXTRA_STADIUM_NAME, strStadium );
                intent.putExtra( DetailTeamActivity.EXTRA_STADIUM_CAPACITY, intStadiumCapacity );
                intent.putExtra( DetailTeamActivity.EXTRA_STADIUM_LOCATION, strStadiumLocation );
                intent.putExtra( DetailTeamActivity.EXTRA_STADIUM_DESC, strStadiumDescription );
                intent.putExtra( DetailTeamActivity.EXTRA_STADIUM_THUMB, strStadiumThumb );
                intent.putExtra( DetailTeamActivity.EXTRA_DESC, strDescriptionEN );
                intent.putExtra( DetailTeamActivity.EXTRA_JERSEY, strTeamJersey );
                intent.putExtra( DetailTeamActivity.EXTRA_BADGE, strTeamBadge );
                intent.putExtra( DetailTeamActivity.EXTRA_BANNER, strTeamBanner );
                intent.putExtra( DetailTeamActivity.EXTRA_FB, strFacebook );
                intent.putExtra( DetailTeamActivity.EXTRA_IG, strInstagram );
                intent.putExtra( DetailTeamActivity.EXTRA_YOUTUBE, strYoutube );
                intent.putExtra( DetailTeamActivity.EXTRA_TW, strTwitter );
                intent.putExtra( DetailTeamActivity.EXTRA_WEBSITE, strWebsite );
                intent.putExtra( DetailTeamActivity.EXTRA_FANART, strTeamFanart1 );
                intent.putExtra( DetailTeamActivity.EXTRA_COUNTRY, country );
                startActivity( intent );
                Toast.makeText( this, strTeam + " description", Toast.LENGTH_SHORT ).show();
                break;
        }
        return super.onOptionsItemSelected( item );
    }

    @Override
    public void showLeague(ArrayList<LeagueItem> leagueItem) {

    }

    @Override
    public void showTeam(ArrayList<TeamItem> teamItem) {

    }

    @Override
    public void showSquad(final ArrayList<SquadItem> squadItem) {
        squadAdapter.setSquadItemArrayList( squadItem );
        rvSquad.setAdapter( squadAdapter );
        squadAdapter.notifyDataSetChanged();
        ItemClickSupport.addTo( rvSquad ).setOnItemClickListener( new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intentSquad = new Intent (TeamActivity.this, DetailSquadActivity.class);
                intentSquad.putExtra( DetailSquadActivity.EXTRA_FANART, strTeamFanart1 );
                SquadItem squadData = new SquadItem( squadItem.get( position ).getStrNationality(),
                        squadItem.get( position ).getStrPlayer(),
                        squadItem.get( position ).getStrTeam(),
                        squadItem.get( position ).getDateBorn(),
                        squadItem.get( position ).getDateSigned(),
                        squadItem.get( position ).getStrSigning(),
                        squadItem.get( position ).getStrBirthLocation(),
                        squadItem.get( position ).getStrDescriptionEN(),
                        squadItem.get( position ).getStrPosition(),
                        squadItem.get( position ).getStrHeight(),
                        squadItem.get( position ).getStrWeight(),
                        squadItem.get( position ).getStrThumb(),
                        squadItem.get( position ).getStrCutout(),
                        squadItem.get( position ).getStrWage() ,
                        squadItem.get( position ).getStrFacebook(),
                        squadItem.get( position ).getStrTwitter(),
                        squadItem.get( position ).getStrInstagram() );
                intentSquad.putExtra( "squadData",squadData );
                startActivity( intentSquad );
            }
        } );


    }
}
