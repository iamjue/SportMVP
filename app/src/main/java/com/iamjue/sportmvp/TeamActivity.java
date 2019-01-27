package com.iamjue.sportmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.iamjue.sportmvp.ADAPTER.SquadAdapter;
import com.iamjue.sportmvp.ADAPTER.TeamAdapter;
import com.iamjue.sportmvp.API.SquadApi;
import com.iamjue.sportmvp.API.TeamApi;
import com.iamjue.sportmvp.MODEL.LeagueItem;
import com.iamjue.sportmvp.MODEL.SquadItem;
import com.iamjue.sportmvp.MODEL.TeamItem;
import com.iamjue.sportmvp.PRESENTER.SquadPresenter;
import com.iamjue.sportmvp.PRESENTER.TeamPresenter;
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
    SquadApi squadApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_team );
        ButterKnife.bind( this );

        tvTeam = findViewById( R.id.tv_nameTeam );
        imgTeamLogo = findViewById( R.id.img_teamLogo );

        TeamItem teamItem = getIntent().getParcelableExtra( "teamData" );

        getSupportActionBar().setTitle( teamItem.getStrTeam() );
        tvTeam.setText( teamItem.getStrTeam() );
        Glide.with( this ).load( teamItem.getStrTeamBadge() ).into( imgTeamLogo );


        squadAdapter = new SquadAdapter( this );
        squadApi = new SquadApi();
        rvSquad.setLayoutManager( new LinearLayoutManager( this ) );
        squadPresenter = new SquadPresenter( this, squadApi ,this );
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
                Toast.makeText( this, "detail team", Toast.LENGTH_SHORT ).show();
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
    public void showSquad(ArrayList<SquadItem> squadItem) {
        squadAdapter.setSquadItemArrayList( squadItem);
        rvSquad.setAdapter( squadAdapter );
        squadAdapter.notifyDataSetChanged();


    }
}
