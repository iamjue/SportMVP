package com.iamjue.sportmvp.API;

import com.iamjue.sportmvp.BuildConfig;

public class TeamApi {
    public String getTeam(String string) {
        String TeamUrl = "search_all_teams.php?l=";
        String URL = BuildConfig.SERVER + TeamUrl + string;
        return URL;
    }
}
