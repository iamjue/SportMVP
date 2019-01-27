package com.iamjue.sportmvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.iamjue.sportmvp.ADAPTER.LeagueAdapter;
import com.iamjue.sportmvp.API.LeagueApi;
import com.iamjue.sportmvp.MODEL.LeagueItem;
import com.iamjue.sportmvp.MODEL.SquadItem;
import com.iamjue.sportmvp.MODEL.TeamItem;
import com.iamjue.sportmvp.OnclickLibrary.ItemClickSupport;
import com.iamjue.sportmvp.PRESENTER.LeaguePresenter;
import com.iamjue.sportmvp.VIEW.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView( R.id.recyclerView )
    RecyclerView recyclerView;

    LeaguePresenter leaguePresenter;
    LeagueAdapter leagueAdapter;
    LeagueApi leagueApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ButterKnife.bind( this );

        leagueAdapter = new LeagueAdapter( this );
        leagueApi = new LeagueApi();
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        leaguePresenter = new LeaguePresenter( this, this, leagueApi );
        leaguePresenter.Load( "soccer" );

    }

    @Override
    public void showLeague(final ArrayList<LeagueItem> leagueItem) {
        leagueAdapter.setLeagueItems( leagueItem );
        recyclerView.setAdapter( leagueAdapter );
        leagueAdapter.notifyDataSetChanged();
        ItemClickSupport.addTo( recyclerView ).setOnItemClickListener( new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intentleague = new Intent( MainActivity.this, LeagueActivity.class );
                LeagueItem leagueData = new LeagueItem(leagueItem.get( position ).getStrLeague(),
                        leagueItem.get( position ).getStrLogo(),
                        leagueItem.get( position ).getStrCountry(),
                        leagueItem.get( position ).getStrDescriptionEN(),
                        leagueItem.get( position ).getStrPoster(),
                        leagueItem.get( position ).getStrTrophy(),
                        leagueItem.get( position ).getStrFanart1(),
                        leagueItem.get(position).getStrBadge());

                intentleague.putExtra( "League", leagueData );
                startActivity( intentleague );
            }
        } );
    }

    @Override
    public void showTeam(ArrayList<TeamItem> teamItem) {

    }

    @Override
    public void showSquad(ArrayList<SquadItem> squadItem) {

    }
}
