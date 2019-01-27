package com.iamjue.sportmvp.ADAPTER;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iamjue.sportmvp.MODEL.TeamItem;
import com.iamjue.sportmvp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    private ArrayList<TeamItem> teamItemArrayList;
    private Context context;

    public TeamAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<TeamItem> getTeamItemArrayList() {
        return teamItemArrayList;
    }

    public void setTeamItemArrayList(ArrayList<TeamItem> teamItemArrayList) {
        this.teamItemArrayList = teamItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.row_team, viewGroup, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with( context ).load( getTeamItemArrayList().get(i).getStrTeamBadge() ).into( viewHolder.imgTeamBadge );
        viewHolder.tvStrteam.setText( getTeamItemArrayList().get( i ).getStrTeam() );

    }

    @Override
    public int getItemCount() {
        return getTeamItemArrayList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView( R.id.img_TeamBadge )
        CircleImageView imgTeamBadge;
        @BindView( R.id.tv_strTeam )
        TextView tvStrteam;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            ButterKnife.bind(this,itemView);
        }
    }
}
