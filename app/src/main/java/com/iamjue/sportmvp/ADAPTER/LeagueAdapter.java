package com.iamjue.sportmvp.ADAPTER;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iamjue.sportmvp.MODEL.LeagueItem;
import com.iamjue.sportmvp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.ViewHolder> {
    private ArrayList<LeagueItem> leagueItems;
    private Context context;

    public LeagueAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<LeagueItem> getLeagueItems() {
        return leagueItems;
    }

    public void setLeagueItems(ArrayList<LeagueItem> leagueItems) {
        this.leagueItems = leagueItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.row_league, viewGroup, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with( context ).load( getLeagueItems().get( i ).getStrLogo() ).into( viewHolder.imgPhotoLeague );
        viewHolder.tvNameLeague.setText( getLeagueItems().get( i ).getStrLeague() );
        String haveData = getLeagueItems().get( i ).getStrLogo();
        String noData = "null";
        if (haveData == noData) {
            viewHolder.tvNameLeague.setVisibility( View.VISIBLE );
            viewHolder.imgPhotoLeague.setVisibility( View.INVISIBLE );
        } else if (haveData != noData) {
            viewHolder.tvNameLeague.setVisibility( View.INVISIBLE );
            viewHolder.imgPhotoLeague.setVisibility( View.VISIBLE );
        }


    }

    @Override
    public int getItemCount() {
        return getLeagueItems().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_photoLeague)
        ImageView imgPhotoLeague;
        @BindView(R.id.tv_nameLeague)
        TextView tvNameLeague;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            ButterKnife.bind( this, itemView );
        }
    }
}
