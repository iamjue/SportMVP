package com.iamjue.sportmvp.PRESENTER;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.iamjue.sportmvp.API.LeagueApi;
import com.iamjue.sportmvp.MODEL.LeagueItem;
import com.iamjue.sportmvp.VIEW.MainView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class LeaguePresenter {
    MainView view;
    StringRequest stringRequest;
    LeagueApi leagueApi;
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

    public LeagueApi getLeagueApi() {
        return leagueApi;
    }

    public void setLeagueApi(LeagueApi leagueApi) {
        this.leagueApi = leagueApi;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public LeaguePresenter(Context context, MainView view, LeagueApi leagueApi) {
        this.view = view;
        this.leagueApi = leagueApi;
        this.context = context;
    }

    public void Load (String string){
        String URL = leagueApi.getLeague( string );
        final ArrayList<LeagueItem>leagueItems = new ArrayList<>(  );

        StringRequest stringRequest = new StringRequest( Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject( response );
                    JSONArray leagueArray = object.getJSONArray( "countrys" );
                    for (int i = 0; i < leagueArray.length(); i++){
                        JSONObject leagueObject = leagueArray.getJSONObject( i );
                        LeagueItem leagueItem = new LeagueItem( leagueObject.getString( "strLeague" ),
                                leagueObject.getString( "strLogo" ),
                                leagueObject.getString( "strCountry" ),
                                leagueObject.getString( "strDescriptionEN" ),
                                leagueObject.getString( "strPoster" ),
                                leagueObject.getString( "strTrophy" ),
                                leagueObject.getString( "strFanart1" ),
                                leagueObject.getString( "strBadge" ));

                        leagueItems.add( leagueItem );

                    }


                    view.showLeague( leagueItems );

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        } );
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
