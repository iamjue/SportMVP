package com.iamjue.sportmvp.API;

import com.iamjue.sportmvp.BuildConfig;

public class LeagueApi {
    public String getLeague(String string){
        String leagueUrl ="search_all_leagues.php?s=";
        String URL = BuildConfig.SERVER+leagueUrl+string;

        return URL;
    }
}
