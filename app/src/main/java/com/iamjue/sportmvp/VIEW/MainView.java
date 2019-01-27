package com.iamjue.sportmvp.VIEW;

import com.iamjue.sportmvp.MODEL.LeagueItem;
import com.iamjue.sportmvp.MODEL.TeamItem;

import java.util.ArrayList;

public interface MainView {
    void showLeague(ArrayList<LeagueItem> leagueItem);
    void showTeam(ArrayList<TeamItem> teamItem);
}
