package com.iamjue.sportmvp.ADAPTER;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iamjue.sportmvp.MODEL.SquadItem;
import com.iamjue.sportmvp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class SquadAdapter extends RecyclerView.Adapter<SquadAdapter.ViewHolder> {
    private ArrayList<SquadItem> squadItemArrayList;
    private Context context;

    public SquadAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<SquadItem> getSquadItemArrayList() {
        return squadItemArrayList;
    }

    public void setSquadItemArrayList(ArrayList<SquadItem> squadItemArrayList) {
        this.squadItemArrayList = squadItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.row_squad,viewGroup,false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with( context).load( getSquadItemArrayList().get( i ).getStrCutout() ).into( viewHolder.imgPlayer );
        viewHolder.tvPosition.setText( getSquadItemArrayList().get( i ).getStrPosition() );
        viewHolder.tvNamePlayer.setText( getSquadItemArrayList().get( i ).getStrPlayer() );
    }

    @Override
    public int getItemCount() {
        return getSquadItemArrayList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView( R.id.img_player )
        CircleImageView imgPlayer;
        @BindView( R.id.tv_position )
        TextView tvPosition;
        @BindView( R.id.tv_namePlayer )
        TextView tvNamePlayer;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            ButterKnife.bind( this,itemView );
        }
    }
}
