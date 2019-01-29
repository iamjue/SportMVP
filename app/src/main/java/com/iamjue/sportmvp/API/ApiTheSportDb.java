package com.iamjue.sportmvp.API;

import com.iamjue.sportmvp.BuildConfig;

public class ApiTheSportDb {
    public String getLeague(String string) {
        String leagueUrl = "search_all_leagues.php?s=";
        String League = BuildConfig.SERVER + leagueUrl + string;

        return League;
    }

    public String getTeam(String string) {
        String TeamUrl = "search_all_teams.php?l=";
        String Team = BuildConfig.SERVER + TeamUrl + string;
        return Team;
    }

    public String getSquad(String string) {
        String squadUrl = "searchplayers.php?t=";
        String Squad = BuildConfig.SERVER + squadUrl + string;

        return Squad;
    }
}
