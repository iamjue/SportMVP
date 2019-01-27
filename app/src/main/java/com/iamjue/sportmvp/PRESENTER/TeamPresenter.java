package com.iamjue.sportmvp.PRESENTER;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.iamjue.sportmvp.ADAPTER.TeamAdapter;
import com.iamjue.sportmvp.API.TeamApi;
import com.iamjue.sportmvp.MODEL.TeamItem;
import com.iamjue.sportmvp.VIEW.MainView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TeamPresenter {
    MainView view;
    StringRequest stringRequest;
    TeamApi teamApi;
    Context context;

    public MainView getView() {
        return view;
    }

    public void setView(MainView view) {
        this.view = view;
    }

    public StringRequest getStringRequest() {
        return stringRequest;
    }

    public void setStringRequest(StringRequest stringRequest) {
        this.stringRequest = stringRequest;
    }

    public TeamApi getTeamApi() {
        return teamApi;
    }

    public void setTeamApi(TeamApi teamApi) {
        this.teamApi = teamApi;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public TeamPresenter(MainView view, TeamApi teamApi, Context context) {
        this.view = view;
        this.teamApi = teamApi;
        this.context = context;
    }

    public void LoadTeam(String string) {
        String URL = teamApi.getTeam( string );

        final ArrayList<TeamItem> teamItemArrayList = new ArrayList<>();

        StringRequest stringRequest = new StringRequest( Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject( response );
                    JSONArray teamArray = object.getJSONArray( "teams" );
                    for (int i = 0; i < teamArray.length(); i++) {
                        JSONObject teamObject = teamArray.getJSONObject( i );
                        TeamItem teamItem = new TeamItem( teamObject.getString( "strTeam" ),
                                teamObject.getString( "strLeague" ),
                                teamObject.getString( "strManager" ),
                                teamObject.getString( "strStadium" ),
                                teamObject.getString( "strStadiumDescription" ),
                                teamObject.getString( "strStadiumLocation" ),
                                teamObject.getString( "intStadiumCapacity" ),
                                teamObject.getString( "strDescriptionEN" ),
                                teamObject.getString( "strTeamBadge" ),
                                teamObject.getString( "strTeamJersey" ),
                                teamObject.getString( "strTeamLogo" ),
                                teamObject.getString( "strTeamBanner" ),
                                teamObject.getString( "strAlternate" ));

                        teamItemArrayList.add( teamItem );

                    }
                    view.showTeam( teamItemArrayList );


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText( context, "Error", Toast.LENGTH_SHORT ).show();
            }
        } );
        RequestQueue requestQueue = Volley.newRequestQueue( context );
        requestQueue.add( stringRequest );

    }
}
