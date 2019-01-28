package com.iamjue.sportmvp.MODEL;

import android.os.Parcel;
import android.os.Parcelable;

public class LeagueItem implements Parcelable {
    String strLeague, strLogo, strCountry, strDescriptionEN, strPoster, strTrophy, strFanart1, strBadge;

    public LeagueItem(String strLeague, String strLogo, String strCountry, String strDescriptionEN, String strPoster, String strTrophy, String strFanart1, String strBadge) {
        this.strLeague = strLeague;
        this.strLogo = strLogo;
        this.strCountry = strCountry;
        this.strDescriptionEN = strDescriptionEN;
        this.strPoster = strPoster;
        this.strTrophy = strTrophy;
        this.strFanart1 = strFanart1;
        this.strBadge = strBadge;
    }

    protected LeagueItem(Parcel in) {
        strLeague = in.readString();
        strLogo = in.readString();
        strCountry = in.readString();
        strDescriptionEN = in.readString();
        strPoster = in.readString();
        strTrophy = in.readString();
        strFanart1 = in.readString();
        strBadge = in.readString();
    }

    public static final Creator<LeagueItem> CREATOR = new Creator<LeagueItem>() {
        @Override
        public LeagueItem createFromParcel(Parcel in) {
            return new LeagueItem( in );
        }

        @Override
        public LeagueItem[] newArray(int size) {
            return new LeagueItem[size];
        }
    };

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrLogo() {
        return strLogo;
    }

    public void setStrLogo(String strLogo) {
        this.strLogo = strLogo;
    }

    public String getStrCountry() {
        return strCountry;
    }

    public void setStrCountry(String strCountry) {
        this.strCountry = strCountry;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrPoster() {
        return strPoster;
    }

    public void setStrPoster(String strPoster) {
        this.strPoster = strPoster;
    }

    public String getStrTrophy() {
        return strTrophy;
    }

    public void setStrTrophy(String strTrophy) {
        this.strTrophy = strTrophy;
    }

    public String getStrFanart1() {
        return strFanart1;
    }

    public void setStrFanart1(String strFanart1) {
        this.strFanart1 = strFanart1;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public void setStrBadge(String strBadge) {
        this.strBadge = strBadge;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString( strLeague );
        parcel.writeString( strLogo );
        parcel.writeString( strCountry );
        parcel.writeString( strDescriptionEN );
        parcel.writeString( strPoster );
        parcel.writeString( strTrophy );
        parcel.writeString( strFanart1 );
        parcel.writeString( strBadge );
    }
}
