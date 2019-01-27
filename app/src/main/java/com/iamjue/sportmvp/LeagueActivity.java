package com.iamjue.sportmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.iamjue.sportmvp.ADAPTER.LeagueAdapter;
import com.iamjue.sportmvp.ADAPTER.TeamAdapter;
import com.iamjue.sportmvp.API.LeagueApi;
import com.iamjue.sportmvp.API.TeamApi;
import com.iamjue.sportmvp.MODEL.LeagueItem;
import com.iamjue.sportmvp.MODEL.TeamItem;
import com.iamjue.sportmvp.PRESENTER.LeaguePresenter;
import com.iamjue.sportmvp.PRESENTER.TeamPresenter;
import com.iamjue.sportmvp.VIEW.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeagueActivity extends AppCompatActivity implements MainView {
    @BindView( R.id.img_strBadge )
    ImageView imgBadge;
    @BindView( R.id.tv_strLeague )
    TextView tvLeague;
    @BindView( R.id.rv_Team )
    RecyclerView rvTeam;

    TeamPresenter teamPresenter;
    TeamAdapter teamAdapter;
    TeamApi teamApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_league );
        ButterKnife.bind( this );

        imgBadge = findViewById( R.id.img_strBadge );
        tvLeague = findViewById( R.id.tv_strLeague );


        LeagueItem leagueItem = getIntent().getParcelableExtra( "League" );
        getSupportActionBar().setTitle( leagueItem.getStrCountry() );
        Glide.with( this ).load( leagueItem.getStrBadge() ).into( imgBadge );


        tvLeague.setText( leagueItem.getStrLeague() );
        teamAdapter = new TeamAdapter( this );
        teamApi = new TeamApi();
        rvTeam.setLayoutManager( new LinearLayoutManager( this ) );
        teamPresenter = new TeamPresenter( this, teamApi ,this );
        teamPresenter.LoadTeam( leagueItem.getStrLeague() );


    }

    @Override
    public void showLeague(ArrayList<LeagueItem> leagueItem) {

    }

    @Override
    public void showTeam(ArrayList<TeamItem> teamItem) {
        teamAdapter.setTeamItemArrayList( teamItem );
        rvTeam.setAdapter( teamAdapter );
        teamAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_league,menu );
        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_league_detail:
                Toast.makeText( this, "Detail League", Toast.LENGTH_SHORT ).show();
                break;
        }
        return super.onOptionsItemSelected( item );
    }
}
