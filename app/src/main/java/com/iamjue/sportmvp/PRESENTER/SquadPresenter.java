package com.iamjue.sportmvp.PRESENTER;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.iamjue.sportmvp.API.SquadApi;
import com.iamjue.sportmvp.MODEL.SquadItem;
import com.iamjue.sportmvp.VIEW.MainView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SquadPresenter {
    MainView view;
    StringRequest stringRequest;
    SquadApi squadApi;
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

    public SquadApi getSquadApi() {
        return squadApi;
    }

    public void setSquadApi(SquadApi squadApi) {
        this.squadApi = squadApi;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public SquadPresenter(MainView view, SquadApi squadApi, Context context) {
        this.view = view;
        this.squadApi = squadApi;
        this.context = context;
    }
    public void LoadSquad(String string){
        String URL = squadApi.getSquad( string );
        final ArrayList<SquadItem>squadItemArrayList = new ArrayList<>(  );

        StringRequest stringRequest = new StringRequest( Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject( response );
                    JSONArray squadArray = object.getJSONArray( "player" );
                    for (int i = 0; i < squadArray.length(); i++) {
                        JSONObject squadObject = squadArray.getJSONObject( i );
                        SquadItem squadItem = new SquadItem( squadObject.getString( "strNationality" ),
                                squadObject.getString( "strPlayer" ),
                                squadObject.getString( "strTeam" ),
                                squadObject.getString( "dateBorn" ),
                                squadObject.getString( "dateSigned" ),
                                squadObject.getString( "strSigning" ),
                                squadObject.getString( "strBirthLocation" ),
                                squadObject.getString( "strDescriptionEN" ),
                                squadObject.getString( "strPosition" ),
                                squadObject.getString( "strHeight" ),
                                squadObject.getString( "strWeight" ),
                                squadObject.getString( "strThumb" ),
                                squadObject.getString( "strCutout" ) );
                        squadItemArrayList.add( squadItem );
                    }
                    view.showSquad( squadItemArrayList );
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
