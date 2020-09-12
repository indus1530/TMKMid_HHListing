package edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 10/18/2016.
 */
public class ListingContract {

    private String ID;
    private String UID;
    private String hhDT;
    private String hhDT01;
    private String enumCode;
    private String areaCode;
    private String enumStr;
    private String hh01;
    private String hh02;
    private String hh03;
    private String hh04;
    private String hh05;
    private String hh06;
    private String hh07;
    private String hh08a1;
    private String hh08;
    private String hh09;
    private String hh09a1;
    private String hh10;
    private String hh11;
    private String hh12;
    private String hh13;
    private String hh14;
    private String hh15;
    private String hh16;
    private String hh17;
    private String hh18;
    private String hh19;
    private String isNewHH;
    private String counter;
    private String DeviceID;
    private String GPSLat;
    private String GPSLng;
    private String GPSTime;
    private String GPSAcc;
    private String GPSAlt;
    private String AppVer;
    private String tagId;
    private String isRandom;
    private String resCount;
    private String childCount;
    public String randCount;
    private String totalhh;
    private String username; // User Name

    public ListingContract() {
    }

    public ListingContract(String ID) {
        this.ID = ID;
    }

    public String getHh19() {
        return hh19;
    }

    public void setHh19(String hh19) {
        this.hh19 = hh19;
    }

    public String getTotalhh() {
        return totalhh;
    }

    public void setTotalhh(String totalhh) {
        this.totalhh = totalhh;
    }

    public String getRandCount() {
        return randCount;
    }

    public void setRandCount(String randCount) {
        this.randCount = randCount;
    }

    public String getIsRandom() {
        return isRandom;
    }

    public void setIsRandom(String isRandom) {
        this.isRandom = isRandom;
    }

    public String getResCount() {
        return resCount;
    }

    public void setResCount(String resCount) {
        this.resCount = resCount;
    }

    public String getChildCount() {
        return childCount;
    }

    public void setChildCount(String childCount) {
        this.childCount = childCount;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHhDT() {
        return hhDT;
    }

    public void setHhDT(String hhDT) {
        this.hhDT = hhDT;
    }


    public String getEnumCode() {
        return enumCode;
    }

    public void setEnumCode(String enumCode) {
        this.enumCode = enumCode;
    }


    public String getEnumStr() {
        return enumStr;
    }

    public void setEnumStr(String enumStr) {
        this.enumStr = enumStr;
    }


    public String getHh01() {
        return hh01;
    }

    public void setHh01(String hh01) {
        this.hh01 = hh01;
    }

    public String getHh02() {
        return hh02;
    }

    public void setHh02(String hh02) {
        this.hh02 = hh02;
    }

    public String getHh03() {
        return hh03;
    }

    public void setHh03(String hh03) {
        this.hh03 = hh03;
    }

    public String getHh04() {
        return hh04;
    }

    public void setHh04(String hh04) {
        this.hh04 = hh04;
    }

    public String getHh14() {
        return hh14;
    }

    public void setHh14(String hh14) {
        this.hh14 = hh14;
    }


    public String getHh15() {
        return hh15;
    }

    public void setHh15(String hh15) {
        this.hh15 = hh15;
    }


    public String getHh05() {
        return hh05;
    }

    public void setHh05(String hh05) {
        this.hh05 = hh05;
    }

    public String getHh06() {
        return hh06;
    }

    public void setHh06(String hh06) {
        this.hh06 = hh06;
    }

    public String getHh07() {
        return hh07;
    }

    public void setHh07(String hh07) {
        this.hh07 = hh07;
    }

    public String getHh18() {
        return hh18;
    }

    public void setHh18(String hh18) {
        this.hh18 = hh18;
    }

    public String getHh08() {
        return hh08;
    }

    public void setHh08(String hh08) {
        this.hh08 = hh08;
    }

    public String getHh09() {
        return hh09;
    }

    public void setHh09(String hh09) {
        this.hh09 = hh09;
    }

    public String getHh09a1() {
        return hh09a1;
    }

    public void setHh09a1(String hh09a1) {
        this.hh09a1 = hh09a1;
    }

    public String getHh10() {
        return hh10;
    }

    public void setHh10(String hh10) {
        this.hh10 = hh10;
    }

    public String getHh11() {
        return hh11;
    }

    public void setHh11(String hh11) {
        this.hh11 = hh11;
    }

    public String getHh12() {
        return hh12;
    }

    public void setHh12(String hh12) {
        this.hh12 = hh12;
    }

    public String getHh13() {
        return hh13;
    }

    public void setHh13(String hh13) {
        this.hh13 = hh13;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getHh17() {
        return hh17;
    }

    public void setHh17(String hh17) {
        this.hh17 = hh17;
    }

    public String getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(String deviceID) {
        DeviceID = deviceID;
    }

    public String getGPSLat() {
        return GPSLat;
    }

    public void setGPSLat(String GPSLat) {
        this.GPSLat = GPSLat;
    }

    public String getGPSLng() {
        return GPSLng;
    }

    public void setGPSLng(String GPSLng) {
        this.GPSLng = GPSLng;
    }

    public String getGPSTime() {
        return GPSTime;
    }

    public void setGPSTime(String GPSTime) {
        this.GPSTime = GPSTime;
    }

    public String getGPSAcc() {
        return GPSAcc;
    }

    public void setGPSAcc(String GPSAcc) {
        this.GPSAcc = GPSAcc;
    }

    public String getAppVer() {
        return AppVer;
    }

    public void setAppVer(String appVer) {
        AppVer = appVer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getGPSAlt() {
        return GPSAlt;
    }

    public void setGPSAlt(String GPSAlt) {
        this.GPSAlt = GPSAlt;
    }

    public String getHh16() {
        return hh16;
    }

    public void setHh16(String hh16) {
        this.hh16 = hh16;
    }

    public String getIsNewHH() {
        return isNewHH;
    }

    public void setIsNewHH(String isNewHH) {
        this.isNewHH = isNewHH;
    }

    public String getHh08a1() {
        return hh08a1;
    }

    public void setHh08a1(String hh08a1) {
        this.hh08a1 = hh08a1;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public String getHhDT01() {
        return hhDT01;
    }

    public void setHhDT01(String hhDT02) {
        this.hhDT01 = hhDT02;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("projectname", "TMKEND-LINELISTING");
        json.put(ListingEntry._ID, this.ID);
        json.put(ListingEntry.COLUMN_NAME_UID, this.UID);
        json.put(ListingEntry.COLUMN_NAME_HHDATETIME, this.hhDT);
        json.put(ListingEntry.COLUMN_NAME_HHDATETIME01, this.hhDT01);
        json.put(ListingEntry.COLUMN_NAME_ENUMCODE, this.enumCode);
        json.put(ListingEntry.COLUMN_NAME_AREACODE, this.areaCode);
        json.put(ListingEntry.COLUMN_NAME_ENUMSTR, this.enumStr);
        json.put(ListingEntry.COLUMN_NAME_HH01, this.hh01);
        json.put(ListingEntry.COLUMN_NAME_HH02, this.hh02);
        json.put(ListingEntry.COLUMN_NAME_HH03, this.hh03);
        json.put(ListingEntry.COLUMN_NAME_HH04, this.hh04);
        json.put(ListingEntry.COLUMN_NAME_HH05, this.hh05);
        json.put(ListingEntry.COLUMN_NAME_HH06, this.hh06);
        json.put(ListingEntry.COLUMN_NAME_HH07, this.hh07);
        json.put(ListingEntry.COLUMN_NAME_HH18, this.hh18);
        json.put(ListingEntry.COLUMN_NAME_HH08, this.hh08);
        json.put(ListingEntry.COLUMN_NAME_HH09, this.hh09);
        json.put(ListingEntry.COLUMN_NAME_HH09A1, this.hh09a1);
        json.put(ListingEntry.COLUMN_NAME_HH08A1, this.hh08a1);
        json.put(ListingEntry.COLUMN_NAME_HH10, this.hh10);
        json.put(ListingEntry.COLUMN_NAME_HH11, this.hh11);
        json.put(ListingEntry.COLUMN_NAME_HH12, this.hh12);
        json.put(ListingEntry.COLUMN_NAME_HH13, this.hh13);
        json.put(ListingEntry.COLUMN_NAME_HH14, this.hh14);
        json.put(ListingEntry.COLUMN_NAME_HH15, this.hh15);
        json.put(ListingEntry.COLUMN_NAME_HH16, this.hh16);
        json.put(ListingEntry.COLUMN_NAME_HH17, this.hh17);
        json.put(ListingEntry.COLUMN_NAME_DEVICEID, this.DeviceID);
        json.put(ListingEntry.COLUMN_NAME_GPSLat, this.GPSLat);
        json.put(ListingEntry.COLUMN_NAME_GPSLng, this.GPSLng);
        json.put(ListingEntry.COLUMN_NAME_GPSTime, this.GPSTime);
        json.put(ListingEntry.COLUMN_NAME_GPSAccuracy, this.GPSAcc);
        json.put(ListingEntry.COLUMN_NAME_GPSAltitude, this.GPSAlt);
        json.put(ListingEntry.COLUMN_APPVER, this.AppVer);
        json.put(ListingEntry.COLUMN_USERNAME, this.username);
        json.put(ListingEntry.COLUMN_TAGID, this.tagId);
        json.put(ListingEntry.COLUMN_ISNEWHH, this.isNewHH);
        json.put(ListingEntry.COLUMN_RANDOMIZED, this.isRandom);
        if (!this.counter.equals("")) {
            json.put(ListingEntry.COLUMN_COUNTER, new JSONObject(this.counter));
        }
        if (this.hh19 != null && !this.hh19.equals("null"))
            json.put(ListingEntry.COLUMN_NAME_HH19, new JSONObject(this.hh19));

        return json;
    }

    public ListingContract hydrate(Cursor c, int type) {
        ListingContract lc = new ListingContract(c.getString(c.getColumnIndex(ListingEntry._ID)));
        lc.setUID(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_UID))));
        lc.setHhDT(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HHDATETIME))));
        lc.setHhDT01(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HHDATETIME01))));
        lc.setEnumCode(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_ENUMCODE))));
        lc.setAreaCode(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_AREACODE))));
        lc.setEnumStr(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_ENUMSTR))));
        lc.setHh01(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH01))));
        lc.setHh02(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH02))));
        lc.setHh03(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH03))));
        lc.setHh04(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH04))));
        lc.setHh05(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH05))));
        lc.setHh06(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH06))));
        lc.setHh07(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH07))));
        lc.setHh08(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH08))));
        lc.setHh09(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH09))));
        lc.setHh09a1(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH09A1))));
        lc.setHh08a1(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH08A1))));
        lc.setHh10(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH10))));
        lc.setHh11(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH11))));
        lc.setHh12(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH12))));
        lc.setHh13(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH13))));
        lc.setHh14(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH14))));
        lc.setHh15(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH15))));
        lc.setHh16(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH16))));
        lc.setHh17(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH17))));
        lc.setHh18(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH18))));
        lc.setHh19(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_HH19))));
        lc.setDeviceID(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_DEVICEID))));
        lc.setGPSLat(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_GPSLat))));
        lc.setGPSLng(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_GPSLng))));
        lc.setGPSTime(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_GPSTime))));
        lc.setGPSAcc(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_GPSAccuracy))));
        lc.setGPSAlt(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_NAME_GPSAltitude))));
        lc.setAppVer(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_APPVER))));
        lc.setTagId(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_TAGID))));
        lc.setUsername(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_USERNAME))));
        lc.setIsNewHH(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_ISNEWHH))));
        lc.setIsRandom(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_RANDOMIZED))));
        lc.setCounter(String.valueOf(c.getString(c.getColumnIndex(ListingEntry.COLUMN_COUNTER)) != null ?
                c.getString(c.getColumnIndex(ListingEntry.COLUMN_COUNTER)) : ""));
        if (type == 1) {
            lc.setResCount(String.valueOf(c.getString(c.getColumnIndex("RESCOUNTER"))));
            lc.setChildCount(String.valueOf(c.getString(c.getColumnIndex("CHILDCOUNTER"))));
            lc.setRandCount(String.valueOf(c.getString(c.getColumnIndex("RANDCOUNTER"))));
            lc.setTotalhh(String.valueOf(c.getString(c.getColumnIndex("TOTALHH"))));
        }

        return lc;
    }

    public ListingContract Sync(JSONObject jsonObject) throws JSONException {

        this.ID = jsonObject.getString(ListingEntry._ID);
        this.UID = jsonObject.getString(ListingEntry.COLUMN_NAME_UID);
        this.hhDT = jsonObject.getString(ListingEntry.COLUMN_NAME_HHDATETIME);
        this.enumCode = jsonObject.getString(ListingEntry.COLUMN_NAME_ENUMCODE);
        this.areaCode = jsonObject.getString(ListingEntry.COLUMN_NAME_AREACODE);
        this.enumStr = jsonObject.getString(ListingEntry.COLUMN_NAME_ENUMSTR);
        this.hh01 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH01);
        this.hh02 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH02);
        this.hh03 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH03);
        this.hh04 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH04);
        this.hh19 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH19);
        this.hh05 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH05);
        this.hh06 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH06);
        this.hh07 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH07);
        this.hh18 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH18);
        this.hh08a1 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH08A1);
        this.hh08 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH08);
        this.hh09 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH09);
        this.hh09a1 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH09A1);
        this.hh10 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH10);
        this.hh11 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH11);
        this.hh12 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH12);
        this.hh13 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH13);
        this.hh14 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH14);
        this.hh15 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH15);
        this.hh16 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH16);
        this.hh17 = jsonObject.getString(ListingEntry.COLUMN_NAME_HH17);
        this.isNewHH = jsonObject.getString(ListingEntry.COLUMN_ISNEWHH);
        this.DeviceID = jsonObject.getString(ListingEntry.COLUMN_NAME_DEVICEID);
        this.GPSLat = jsonObject.getString(ListingEntry.COLUMN_NAME_GPSLat);
        this.GPSLng = jsonObject.getString(ListingEntry.COLUMN_NAME_GPSLng);
        this.GPSTime = jsonObject.getString(ListingEntry.COLUMN_NAME_GPSTime);
        this.GPSAcc = jsonObject.getString(ListingEntry.COLUMN_NAME_GPSAccuracy);
        this.GPSAlt = jsonObject.getString(ListingEntry.COLUMN_NAME_GPSAltitude);
        this.AppVer = jsonObject.getString(ListingEntry.COLUMN_APPVER);
        this.tagId = jsonObject.getString(ListingEntry.COLUMN_TAGID);
        this.isRandom = jsonObject.getString(ListingEntry.COLUMN_RANDOMIZED);
        this.username = jsonObject.getString(ListingEntry.COLUMN_USERNAME);
        this.counter = jsonObject.getString(ListingEntry.COLUMN_COUNTER);

        return this;
    }

    public static abstract class ListingEntry implements BaseColumns {

        public static final String TABLE_NAME = "listings";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String _ID = "_id";
        public static final String COLUMN_NAME_UID = "uid";
        public static final String COLUMN_NAME_HHDATETIME = "sysdate";
        public static final String COLUMN_NAME_HHDATETIME01 = "formdate";
        public static final String COLUMN_NAME_ENUMCODE = "enumcode";
        public static final String COLUMN_NAME_AREACODE = "areacode";
        public static final String COLUMN_NAME_ENUMSTR = "enumstr";
        public static final String COLUMN_NAME_HH01 = "chkconfirm";
        public static final String COLUMN_NAME_HH02 = "hh02";
        public static final String COLUMN_NAME_HH03 = "hh03";
        public static final String COLUMN_NAME_HH04 = "hh04";
        public static final String COLUMN_NAME_HH05 = "hh05";
        public static final String COLUMN_NAME_HH06 = "hh06";
        public static final String COLUMN_NAME_HH07 = "hh07";
        public static final String COLUMN_NAME_HH08 = "hh08";
        public static final String COLUMN_NAME_HH09 = "hh09";
        public static final String COLUMN_NAME_HH08A1 = "hh08a1";
        public static final String COLUMN_NAME_HH09A1 = "hh09a1";
        public static final String COLUMN_NAME_HH10 = "hh10";
        public static final String COLUMN_NAME_HH11 = "hh11";
        public static final String COLUMN_NAME_HH12 = "hh12";
        public static final String COLUMN_NAME_HH13 = "hh13";
        public static final String COLUMN_NAME_HH14 = "hh14";
        public static final String COLUMN_NAME_HH15 = "hh15";
        public static final String COLUMN_NAME_HH16 = "hh16";
        public static final String COLUMN_NAME_HH17 = "hh17";
        public static final String COLUMN_NAME_HH18 = "hh18";
        public static final String COLUMN_NAME_HH19 = "hh19";
        public static final String COLUMN_ISNEWHH = "isnewhh";
        public static final String COLUMN_COUNTER = "counter";
        public static final String COLUMN_NAME_DEVICEID = "deviceid";
        public static final String COLUMN_NAME_GPSLat = "gpslat";
        public static final String COLUMN_NAME_GPSLng = "gpslng";
        public static final String COLUMN_NAME_GPSTime = "gpstime";
        public static final String COLUMN_NAME_GPSAccuracy = "gpsacc";
        public static final String COLUMN_NAME_GPSAltitude = "gpsalt";
        public static final String COLUMN_APPVER = "appver";
        public static final String COLUMN_TAGID = "tagId";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_RANDOMIZED = "tabNo";
        public static final String COLUMN_USERNAME = "username";
        public static final String _URL = "sync.php";
    }
}