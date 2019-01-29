package com.iamjue.sportmvp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.iamjue.sportmvp.ADAPTER.TeamAdapter;
import com.iamjue.sportmvp.API.ApiTheSportDb;
import com.iamjue.sportmvp.MODEL.LeagueItem;
import com.iamjue.sportmvp.MODEL.SquadItem;
import com.iamjue.sportmvp.MODEL.TeamItem;
import com.iamjue.sportmvp.OnclickLibrary.ItemClickSupport;
import com.iamjue.sportmvp.PRESENTER.TeamPresenter;
import com.iamjue.sportmvp.R;
import com.iamjue.sportmvp.VIEW.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeagueActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.img_strBadge)
    ImageView imgBadge;
    @BindView(R.id.tv_strLeague)
    TextView tvLeague;
    @BindView(R.id.rv_Team)
    RecyclerView rvTeam;

    String nameLeague, fanart, logo, trophy, desc;

    TeamPresenter teamPresenter;
    TeamAdapter teamAdapter;
    ApiTheSportDb apiTheSportDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_league );
        ButterKnife.bind( this );

        imgBadge = findViewById( R.id.img_strBadge );
        tvLeague = findViewById( R.id.tv_strLeague );


        LeagueItem leagueItem = getIntent().getParcelableExtra( "League" );
        getSupportActionBar().setTitle( leagueItem.getStrCountry() );
        //inisialisai untkuk membawa data ke detail league activity
        nameLeague = leagueItem.getStrLeague();
        fanart = leagueItem.getStrFanart1();
        logo = leagueItem.getStrLogo();
        trophy = leagueItem.getStrTrophy();
        desc = leagueItem.getStrDescriptionEN();

        Glide.with( this ).load( leagueItem.getStrBadge() ).into( imgBadge );
        tvLeague.setText( leagueItem.getStrLeague() );

        teamAdapter = new TeamAdapter( this );
        apiTheSportDb = new ApiTheSportDb();
        rvTeam.setLayoutManager( new LinearLayoutManager( this ) );
        teamPresenter = new TeamPresenter( this, apiTheSportDb, this );
        teamPresenter.LoadTeam( leagueItem.getStrLeague() );


    }

    @Override
    public void showLeague(ArrayList<LeagueItem> leagueItem) {

    }

    @Override
    public void showTeam(final ArrayList<TeamItem> teamItem) {
        teamAdapter.setTeamItemArrayList( teamItem );
        rvTeam.setAdapter( teamAdapter );
        teamAdapter.notifyDataSetChanged();
        ItemClickSupport.addTo( rvTeam ).setOnItemClickListener( new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intentSquad = new Intent( LeagueActivity.this, TeamActivity.class );
                TeamItem teamData = new TeamItem( teamItem.get( position ).getStrTeam(),
                        teamItem.get( position ).getStrLeague(),
                        teamItem.get( position ).getStrManager(),
                        teamItem.get( position ).getStrStadium(),
                        teamItem.get( position ).getStrStadiumDescription(),
                        teamItem.get( position ).getStrStadiumLocation(),
                        teamItem.get( position ).getIntStadiumCapacity(),
                        teamItem.get( position ).getStrDescriptionEN(),
                        teamItem.get( position ).getStrTeamBadge(),
                        teamItem.get( position ).getStrTeamJersey(),
                        teamItem.get( position ).getStrTeamLogo(),
                        teamItem.get( position ).getStrTeamBanner(),
                        teamItem.get( position ).getStrAlternate() );
                intentSquad.putExtra( "teamData", teamData );
                startActivity( intentSquad );

            }
        } );
    }

    @Override
    public void showSquad(ArrayList<SquadItem> squadItem) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_league, menu );
        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_league_detail:
                Intent intentDetail = new Intent( this, DetailLeagueActivity.class );
                //yang di inisialisai di atas di panggil di sini, untuk di bawa ke activity lain
                intentDetail.putExtra( DetailLeagueActivity.EXTRA_NAME, nameLeague );
                intentDetail.putExtra( DetailLeagueActivity.EXTRA_FANART, fanart );
                intentDetail.putExtra( DetailLeagueActivity.EXTRA_LOGO, logo );
                intentDetail.putExtra( DetailLeagueActivity.EXTRA_TROPHY, trophy );
                intentDetail.putExtra( DetailLeagueActivity.EXTRA_DESC, desc );
                startActivity( intentDetail );
                Toast.makeText( this, nameLeague + " Description", Toast.LENGTH_SHORT ).show();
                break;
        }
        return super.onOptionsItemSelected( item );
    }
}
