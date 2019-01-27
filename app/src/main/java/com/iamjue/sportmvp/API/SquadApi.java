package com.iamjue.sportmvp.API;

import com.iamjue.sportmvp.BuildConfig;

public class SquadApi {
    public String getSquad(String string) {
        String squadUrl = "searchplayers.php?t=";
        String URL = BuildConfig.SERVER + squadUrl + string;

        return URL;
    }
}
