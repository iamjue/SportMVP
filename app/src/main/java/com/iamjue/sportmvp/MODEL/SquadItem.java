package com.iamjue.sportmvp.MODEL;

import android.os.Parcel;
import android.os.Parcelable;

public class SquadItem implements Parcelable {
    String strNationality, strPlayer, strTeam, dateBorn, dateSigned, strSigning, strBirthLocation, strDescriptionEN, strPosition,
            strHeight, strWeight, strThumb, strCutout, strWage, strFacebook, strTwitter, strInstagram;

    public SquadItem(String strNationality, String strPlayer, String strTeam, String dateBorn, String dateSigned, String strSigning, String strBirthLocation, String strDescriptionEN, String strPosition, String strHeight, String strWeight, String strThumb, String strCutout, String strWage, String strFacebook, String strTwitter, String strInstagram) {
        this.strNationality = strNationality;
        this.strPlayer = strPlayer;
        this.strTeam = strTeam;
        this.dateBorn = dateBorn;
        this.dateSigned = dateSigned;
        this.strSigning = strSigning;
        this.strBirthLocation = strBirthLocation;
        this.strDescriptionEN = strDescriptionEN;
        this.strPosition = strPosition;
        this.strHeight = strHeight;
        this.strWeight = strWeight;
        this.strThumb = strThumb;
        this.strCutout = strCutout;
        this.strWage = strWage;
        this.strFacebook = strFacebook;
        this.strTwitter = strTwitter;
        this.strInstagram = strInstagram;

    }

    protected SquadItem(Parcel in) {
        strNationality = in.readString();
        strPlayer = in.readString();
        strTeam = in.readString();
        dateBorn = in.readString();
        dateSigned = in.readString();
        strSigning = in.readString();
        strBirthLocation = in.readString();
        strDescriptionEN = in.readString();
        strPosition = in.readString();
        strHeight = in.readString();
        strWeight = in.readString();
        strThumb = in.readString();
        strCutout = in.readString();
        strWage = in.readString();
        strFacebook = in.readString();
        strTwitter = in.readString();
        strInstagram = in.readString();
    }

    public static final Creator<SquadItem> CREATOR = new Creator<SquadItem>() {
        @Override
        public SquadItem createFromParcel(Parcel in) {
            return new SquadItem( in );
        }

        @Override
        public SquadItem[] newArray(int size) {
            return new SquadItem[size];
        }
    };

    public String getStrNationality() {
        return strNationality;
    }

    public void setStrNationality(String strNationality) {
        this.strNationality = strNationality;
    }

    public String getStrPlayer() {
        return strPlayer;
    }

    public void setStrPlayer(String strPlayer) {
        this.strPlayer = strPlayer;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(String dateSigned) {
        this.dateSigned = dateSigned;
    }

    public String getStrSigning() {
        return strSigning;
    }

    public void setStrSigning(String strSigning) {
        this.strSigning = strSigning;
    }

    public String getStrBirthLocation() {
        return strBirthLocation;
    }

    public void setStrBirthLocation(String strBirthLocation) {
        this.strBirthLocation = strBirthLocation;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrPosition() {
        return strPosition;
    }

    public void setStrPosition(String strPosition) {
        this.strPosition = strPosition;
    }

    public String getStrHeight() {
        return strHeight;
    }

    public void setStrHeight(String strHeight) {
        this.strHeight = strHeight;
    }

    public String getStrWeight() {
        return strWeight;
    }

    public void setStrWeight(String strWeight) {
        this.strWeight = strWeight;
    }

    public String getStrThumb() {
        return strThumb;
    }

    public void setStrThumb(String strThumb) {
        this.strThumb = strThumb;
    }

    public String getStrCutout() {
        return strCutout;
    }

    public void setStrCutout(String strCutout) {
        this.strCutout = strCutout;
    }

    public String getStrWage() {
        return strWage;
    }

    public void setStrWage(String strWage) {
        this.strWage = strWage;
    }

    public String getStrFacebook() {
        return strFacebook;
    }

    public void setStrFacebook(String strFacebook) {
        this.strFacebook = strFacebook;
    }

    public String getStrTwitter() {
        return strTwitter;
    }

    public void setStrTwitter(String strTwitter) {
        this.strTwitter = strTwitter;
    }

    public String getStrInstagram() {
        return strInstagram;
    }

    public void setStrInstagram(String strInstagram) {
        this.strInstagram = strInstagram;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString( strNationality );
        parcel.writeString( strPlayer );
        parcel.writeString( strTeam );
        parcel.writeString( dateBorn );
        parcel.writeString( dateSigned );
        parcel.writeString( strSigning );
        parcel.writeString( strBirthLocation );
        parcel.writeString( strDescriptionEN );
        parcel.writeString( strPosition );
        parcel.writeString( strHeight );
        parcel.writeString( strWeight );
        parcel.writeString( strThumb );
        parcel.writeString( strCutout );
        parcel.writeString( strWage );
        parcel.writeString( strFacebook );
        parcel.writeString( strTwitter );
        parcel.writeString( strInstagram );
    }
}
