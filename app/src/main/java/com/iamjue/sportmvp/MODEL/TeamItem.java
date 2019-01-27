package com.iamjue.sportmvp.MODEL;

import android.os.Parcel;
import android.os.Parcelable;

public class TeamItem implements Parcelable {
    String strTeam, strLeague,strManager,strStadium,strStadiumDescription,strStadiumLocation,intStadiumCapacity,strDescriptionEN,
            strTeamBadge,strTeamJersey,strTeamLogo,strTeamBanner;

    public TeamItem(String strTeam, String strLeague, String strManager, String strStadium, String strStadiumDescription,
                    String strStadiumLocation, String intStadiumCapacity, String strDescriptionEN, String strTeamBadge,
                    String strTeamJersey, String strTeamLogo, String strTeamBanner) {
        this.strTeam = strTeam;
        this.strLeague = strLeague;
        this.strManager = strManager;
        this.strStadium = strStadium;
        this.strStadiumDescription = strStadiumDescription;
        this.strStadiumLocation = strStadiumLocation;
        this.intStadiumCapacity = intStadiumCapacity;
        this.strDescriptionEN = strDescriptionEN;
        this.strTeamBadge = strTeamBadge;
        this.strTeamJersey = strTeamJersey;
        this.strTeamLogo = strTeamLogo;
        this.strTeamBanner = strTeamBanner;
    }

    protected TeamItem(Parcel in) {
        strTeam = in.readString();
        strLeague = in.readString();
        strManager = in.readString();
        strStadium = in.readString();
        strStadiumDescription = in.readString();
        strStadiumLocation = in.readString();
        intStadiumCapacity = in.readString();
        strDescriptionEN = in.readString();
        strTeamBadge = in.readString();
        strTeamJersey = in.readString();
        strTeamLogo = in.readString();
        strTeamBanner = in.readString();
    }

    public static final Creator<TeamItem> CREATOR = new Creator<TeamItem>() {
        @Override
        public TeamItem createFromParcel(Parcel in) {
            return new TeamItem( in );
        }

        @Override
        public TeamItem[] newArray(int size) {
            return new TeamItem[size];
        }
    };

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrManager() {
        return strManager;
    }

    public void setStrManager(String strManager) {
        this.strManager = strManager;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrStadiumDescription() {
        return strStadiumDescription;
    }

    public void setStrStadiumDescription(String strStadiumDescription) {
        this.strStadiumDescription = strStadiumDescription;
    }

    public String getStrStadiumLocation() {
        return strStadiumLocation;
    }

    public void setStrStadiumLocation(String strStadiumLocation) {
        this.strStadiumLocation = strStadiumLocation;
    }

    public String getIntStadiumCapacity() {
        return intStadiumCapacity;
    }

    public void setIntStadiumCapacity(String intStadiumCapacity) {
        this.intStadiumCapacity = intStadiumCapacity;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrTeamJersey() {
        return strTeamJersey;
    }

    public void setStrTeamJersey(String strTeamJersey) {
        this.strTeamJersey = strTeamJersey;
    }

    public String getStrTeamLogo() {
        return strTeamLogo;
    }

    public void setStrTeamLogo(String strTeamLogo) {
        this.strTeamLogo = strTeamLogo;
    }

    public String getStrTeamBanner() {
        return strTeamBanner;
    }

    public void setStrTeamBanner(String strTeamBanner) {
        this.strTeamBanner = strTeamBanner;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString( strTeam );
        parcel.writeString( strLeague );
        parcel.writeString( strManager );
        parcel.writeString( strStadium );
        parcel.writeString( strStadiumDescription );
        parcel.writeString( strStadiumLocation );
        parcel.writeString( intStadiumCapacity );
        parcel.writeString( strDescriptionEN );
        parcel.writeString( strTeamBadge );
        parcel.writeString( strTeamJersey );
        parcel.writeString( strTeamLogo );
        parcel.writeString( strTeamBanner );
    }
}
