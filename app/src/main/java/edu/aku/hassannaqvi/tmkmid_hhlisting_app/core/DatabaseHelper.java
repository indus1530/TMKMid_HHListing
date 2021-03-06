package edu.aku.hassannaqvi.tmkmid_hhlisting_app.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.BLRandomContract.SingleRandomHH;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.ListingContract;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.ListingContract.ListingEntry;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.SignupContract;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.SignupContract.SignUpTable;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.TeamsContract;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.TeamsContract.SingleTaluka;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.UCContract;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.UCContract.UCTable;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.UsersContract;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.UsersContract.UsersTable;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.VersionAppContract;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.VersionAppContract.VersionAppTable;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.VerticesContract;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.VerticesContract.SingleVertices;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.VillageContract;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.VillageContract.VillageTable;


/**
 * Created by hassan.naqvi on 10/18/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "tmkmid-hhl.db";
    public static final String PROJECT_NAME = "tmkmid-hhl-2019";
    public static final String DB_NAME = DATABASE_NAME.replace(".db", "-copy.db");
    private static final int DATABASE_VERSION = 1;
    // The name of database.
    // Change this when you change the database schema.
    private static final String SQL_CREATE_BL_RANDOM = "CREATE TABLE " + SingleRandomHH.TABLE_NAME + "("
            + SingleRandomHH.COLUMN_ID + "  INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SingleRandomHH.COLUMN_CLUSTER_BLOCK_CODE + " TEXT,"
            + SingleRandomHH.COLUMN_LUID + " TEXT,"
            + SingleRandomHH.COLUMN_STRUCTURE_NO + " TEXT,"
            + SingleRandomHH.COLUMN_FAMILY_EXT_CODE + " TEXT,"
            + SingleRandomHH.COLUMN_HH_HEAD + " TEXT,"
            + SingleRandomHH.COLUMN_CONTACT + " TEXT,"
            + SingleRandomHH.COLUMN_HH_SELECTED_STRUCT + " TEXT,"
            + SingleRandomHH.COLUMN_RANDOMDT + " TEXT );";
    private static String TAG = DatabaseHelper.class.getName();
    private static final String SQL_CREATE_SIGNUP = "CREATE TABLE " + SignUpTable.TABLE_NAME + "("
            + SignUpTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SignUpTable.FULLNAME + " TEXT,"
            + SignUpTable.USERNAME + " TEXT,"
            + SignUpTable.DESIGNATION + " TEXT,"
            + SignUpTable.PASSWORD + " TEXT,"
            + SignUpTable.COUNTRY_ID + " TEXT, "
            + SignUpTable.COLUMN_DEVICEID + " TEXT, "
            + SignUpTable.COLUMN_FORMDATE + " TEXT, "
            + SignUpTable.COLUMN_SYNCED + " TEXT, "
            + SignUpTable.COLUMN_SYNCED_DATE + " TEXT " +
            ");";
    final String SQL_CREATE_LISTING_TABLE = "CREATE TABLE " + ListingEntry.TABLE_NAME + " (" +
            ListingEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ListingEntry.COLUMN_NAME_UID + " TEXT, " +
            ListingEntry.COLUMN_NAME_HHDATETIME + " TEXT, " +
            ListingEntry.COLUMN_NAME_HHDATETIME01 + " TEXT, " +
            ListingEntry.COLUMN_NAME_ENUMCODE + " TEXT, " +
            ListingEntry.COLUMN_NAME_AREACODE + " TEXT, " +
            ListingEntry.COLUMN_NAME_ENUMSTR + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH01 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH02 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH03 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH04 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH19 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH05 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH06 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH07 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH08 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH08A1 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH09 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH09A1 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH10 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH11 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH12 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH13 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH14 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH15 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH16 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH17 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH18 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH20 + " TEXT, " +
            ListingEntry.COLUMN_NAME_HH21 + " TEXT, " +
            ListingEntry.COLUMN_ISNEWHH + " TEXT, " +
            ListingEntry.COLUMN_COUNTER + " TEXT, " +
            ListingEntry.COLUMN_USERNAME + " TEXT, " +
            ListingEntry.COLUMN_NAME_DEVICEID + " TEXT, " +
            ListingEntry.COLUMN_TAGID + " TEXT, " +
            ListingEntry.COLUMN_NAME_GPSLat + " TEXT, " +
            ListingEntry.COLUMN_NAME_GPSLng + " TEXT, " +
            ListingEntry.COLUMN_NAME_GPSTime + " TEXT, " +
            ListingEntry.COLUMN_APPVER + " TEXT, " +
            ListingEntry.COLUMN_NAME_GPSAccuracy + " TEXT, " +
            ListingEntry.COLUMN_NAME_GPSAltitude + " TEXT, " +
            ListingEntry.COLUMN_RANDOMIZED + " TEXT, " +
            ListingEntry.COLUMN_SYNCED + " TEXT, " +
            ListingEntry.COLUMN_SYNCED_DATE + " TEXT );";
    final String SQL_CREATE_DISTRICT_TABLE = "CREATE TABLE " + SingleTaluka.TABLE_NAME + " (" +
            SingleTaluka._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            SingleTaluka.COLUMN_TEAM_NO + " TEXT " + ");";
    final String SQL_CREATE_PSU_TABLE = "CREATE TABLE " + VillageTable.TABLE_NAME + " (" +
            VillageTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VillageTable.COLUMN_VILLAGE_CODE + " TEXT, " +
            VillageTable.COLUMN_VILLAGE_NAME + " TEXT, " +
            VillageTable.COLUMN_AREA_CODE + " TEXT, " +
            VillageTable.COLUMN_CLUSTER_CODE + " TEXT );";
    final String SQL_CREATE_VERTICES_TABLE = "CREATE TABLE " + SingleVertices.TABLE_NAME + " (" +
            SingleVertices._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            SingleVertices.COLUMN_CLUSTER_CODE + " TEXT," +
            SingleVertices.COLUMN_POLY_LAT + " TEXT, " +
            SingleVertices.COLUMN_POLY_LANG + " TEXT, " +
            SingleVertices.COLUMN_POLY_SEQ + " TEXT );";
    final String SQL_CREATE_VERSIONAPP = "CREATE TABLE " + VersionAppTable.TABLE_NAME + " (" +
            VersionAppTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VersionAppTable.COLUMN_VERSION_CODE + " TEXT, " +
            VersionAppTable.COLUMN_VERSION_NAME + " TEXT, " +
            VersionAppTable.COLUMN_PATH_NAME + " TEXT );";
    final String SQL_CREATE_USERS = "CREATE TABLE " + UsersTable.TABLE_NAME + "("
            + UsersTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersTable.ROW_USERNAME + " TEXT,"
            + UsersTable.ROW_PASSWORD + " TEXT,"
            + UsersTable.ROW_FULL_NAME + " TEXT );";
    final String SQL_CREATE_DISTRICTS = "CREATE TABLE " + UCTable.TABLE_NAME + "("
            + UCTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UCTable.COLUMN_UC_CODE + " TEXT,"
            + UCTable.COLUMN_UC_NAME + " TEXT,"
            + UCTable.COLUMN_TALUKA_CODE + " TEXT );";
    final String SQL_COUNT_LISTINGS = "SELECT count(*) as ttlisting from " + ListingEntry.TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Do the creating of the databases.
        db.execSQL(SQL_CREATE_LISTING_TABLE);
        db.execSQL(SQL_CREATE_DISTRICT_TABLE);
        db.execSQL(SQL_CREATE_PSU_TABLE);
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_BL_RANDOM);
        db.execSQL(SQL_CREATE_VERTICES_TABLE);
        db.execSQL(SQL_CREATE_SIGNUP);
        db.execSQL(SQL_CREATE_VERSIONAPP);
        db.execSQL(SQL_CREATE_DISTRICTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Simply discard all old data and start over when upgrading.
        /*db.execSQL("DROP TABLE IF EXISTS " + ListingEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SingleTaluka.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + EnumBlockTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + UsersTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SingleVertices.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + VersionAppTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SignUpTable.TABLE_NAME);
        onCreate(db);*/
    }

    public boolean Login(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + UsersContract.UsersTable.TABLE_NAME + " WHERE " + UsersContract.UsersTable.ROW_USERNAME + "=? AND " + UsersContract.UsersTable.ROW_PASSWORD + "=?", new String[]{username, password});
        if (mCursor != null) {

            if (mCursor.getCount() > 0) {

                if (mCursor.moveToFirst()) {
//                    MainApp.DIST_ID = mCursor.getString(mCursor.getColumnIndex(UsersContract.UsersTable.DIST_ID));
                    mCursor.close();
                }
                return true;
            }
        }
        return false;
    }

    //Addition Functionality
    public Long addSignUpForm(SignupContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(SignupContract.SignUpTable.FULLNAME, fc.getFullName());
        values.put(SignupContract.SignUpTable.DESIGNATION, fc.getDesignation());
        values.put(SignupContract.SignUpTable.USERNAME, fc.getUserName());
        values.put(SignupContract.SignUpTable.PASSWORD, fc.getPassword());
        values.put(SignupContract.SignUpTable.COUNTRY_ID, fc.getCountryId());
        values.put(SignUpTable.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(SignUpTable.COLUMN_FORMDATE, fc.getFormDate());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                SignupContract.SignUpTable.TABLE_NAME,
                null,
                values);
        return newRowId;
    }

    public Long addForm(ListingContract lc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ListingEntry.COLUMN_NAME_UID, lc.getUID());
        values.put(ListingEntry.COLUMN_NAME_HHDATETIME, lc.getHhDT());

        values.put(ListingEntry.COLUMN_NAME_ENUMCODE, lc.getEnumCode());
        values.put(ListingEntry.COLUMN_NAME_AREACODE, lc.getAreaCode());
        values.put(ListingEntry.COLUMN_NAME_ENUMSTR, lc.getEnumStr());

        values.put(ListingEntry.COLUMN_NAME_HH01, lc.getHh01());
        values.put(ListingEntry.COLUMN_NAME_HH02, lc.getHh02());
        values.put(ListingEntry.COLUMN_NAME_HH03, lc.getHh03());

        MainApp.updatePSU(lc.getEnumCode(), lc.getHh03());
        Log.d(TAG, "PSUExist (Test): " + MainApp.sharedPref.getString(lc.getHh02(), "0"));

        values.put(ListingEntry.COLUMN_NAME_HH04, lc.getHh04());
        values.put(ListingEntry.COLUMN_NAME_HH19, lc.getHh19());
        values.put(ListingEntry.COLUMN_NAME_HH05, lc.getHh05());
        values.put(ListingEntry.COLUMN_NAME_HH06, lc.getHh06());
        values.put(ListingEntry.COLUMN_NAME_HH07, lc.getHh07());
        values.put(ListingEntry.COLUMN_NAME_HH18, lc.getHh18());
        values.put(ListingEntry.COLUMN_NAME_HH08, lc.getHh08());
        values.put(ListingEntry.COLUMN_NAME_HH09, lc.getHh09());
        values.put(ListingEntry.COLUMN_NAME_HH08A1, lc.getHh08a1());
        values.put(ListingEntry.COLUMN_NAME_HH09A1, lc.getHh09a1());
        values.put(ListingEntry.COLUMN_NAME_HH10, lc.getHh10());
        values.put(ListingEntry.COLUMN_NAME_HH11, lc.getHh11());
        values.put(ListingEntry.COLUMN_NAME_HH12, lc.getHh12());
        values.put(ListingEntry.COLUMN_NAME_HH13, lc.getHh13());
        values.put(ListingEntry.COLUMN_NAME_HH14, lc.getHh14());
        values.put(ListingEntry.COLUMN_NAME_HH15, lc.getHh15());
        values.put(ListingEntry.COLUMN_NAME_HH16, lc.getHh16());
        values.put(ListingEntry.COLUMN_ISNEWHH, lc.getIsNewHH());
        values.put(ListingEntry.COLUMN_NAME_HH17, lc.getHh17());
        values.put(ListingEntry.COLUMN_NAME_HH20, lc.getHh20());
        values.put(ListingEntry.COLUMN_NAME_HH21, lc.getHh21());
        values.put(ListingEntry.COLUMN_COUNTER, lc.getCounter());
        values.put(ListingEntry.COLUMN_NAME_DEVICEID, lc.getDeviceID());
        values.put(ListingEntry.COLUMN_USERNAME, lc.getUsername());
        values.put(ListingEntry.COLUMN_NAME_GPSLat, lc.getGPSLat());
        values.put(ListingEntry.COLUMN_NAME_GPSLng, lc.getGPSLng());
        values.put(ListingEntry.COLUMN_NAME_GPSTime, lc.getGPSTime());
        values.put(ListingEntry.COLUMN_NAME_GPSAccuracy, lc.getGPSAcc());
        values.put(ListingEntry.COLUMN_NAME_GPSAltitude, lc.getGPSAlt());
        values.put(ListingEntry.COLUMN_APPVER, lc.getAppVer());
        values.put(ListingEntry.COLUMN_RANDOMIZED, lc.getIsRandom());
        values.put(ListingEntry.COLUMN_TAGID, lc.getTagId());

        long newRowId;
        newRowId = db.insert(
                ListingEntry.TABLE_NAME,
                ListingEntry.COLUMN_NAME_NULLABLE,
                values);

        return newRowId;
    }

    public void addBLRandom(ListingContract lc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(SingleRandomHH.COLUMN_LUID, lc.getUID());
        values.put(SingleRandomHH.COLUMN_RANDOMDT, lc.getHhDT());
        values.put(SingleRandomHH.COLUMN_CLUSTER_BLOCK_CODE, lc.getAreaCode());
        values.put(SingleRandomHH.COLUMN_STRUCTURE_NO, lc.getHh03());
        values.put(SingleRandomHH.COLUMN_FAMILY_EXT_CODE, lc.getHh07());
        values.put(SingleRandomHH.COLUMN_HH_HEAD, lc.getHh08());
        values.put(SingleRandomHH.COLUMN_CONTACT, lc.getHh09());

        values.put(SingleRandomHH.COLUMN_HH_SELECTED_STRUCT, lc.getHh10().equals("1") ? "1" : "2");

        long newRowId;
        newRowId = db.insert(
                SingleRandomHH.TABLE_NAME,
                null,
                values);

    }


    //Updation Functionality
    public void updateListingUID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ListingEntry.COLUMN_NAME_UID, MainApp.lc.getUID());

// Which row to update, based on the title
        String where = ListingEntry._ID + " = ?";
        String[] whereArgs = {MainApp.lc.getID()};

        int count = db.update(
                ListingEntry.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateListingRecord(String Clustercode) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ListingEntry.COLUMN_RANDOMIZED, "1");

// Which row to update, based on the title
        String where = ListingEntry.COLUMN_NAME_AREACODE + " = ?";
        String[] whereArgs = {Clustercode};

        int count = db.update(
                ListingEntry.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    //Get Functionality
    public int getListingCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SQL_COUNT_LISTINGS, null);
        int count = 0;

        while (cursor.moveToNext()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        return count;
    }

    public JSONArray getAllListingsJSON() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ListingEntry._ID,
                ListingEntry.COLUMN_NAME_UID,
                ListingEntry.COLUMN_NAME_HHDATETIME,
                ListingEntry.COLUMN_NAME_ENUMCODE,
                ListingEntry.COLUMN_NAME_AREACODE,
                ListingEntry.COLUMN_NAME_ENUMSTR,
                ListingEntry.COLUMN_NAME_HH01,
                ListingEntry.COLUMN_NAME_HH02,
                ListingEntry.COLUMN_NAME_HH03,
                ListingEntry.COLUMN_NAME_HH04,
                ListingEntry.COLUMN_NAME_HH19,
                ListingEntry.COLUMN_NAME_HH05,
                ListingEntry.COLUMN_NAME_HH06,
                ListingEntry.COLUMN_NAME_HH07,
                ListingEntry.COLUMN_NAME_HH18,
                ListingEntry.COLUMN_NAME_HH08,
                ListingEntry.COLUMN_NAME_HH09,
                ListingEntry.COLUMN_NAME_HH08A1,
                ListingEntry.COLUMN_NAME_HH09A1,
                ListingEntry.COLUMN_NAME_HH10,
                ListingEntry.COLUMN_NAME_HH11,
                ListingEntry.COLUMN_NAME_HH12,
                ListingEntry.COLUMN_NAME_HH13,
                ListingEntry.COLUMN_NAME_HH14,
                ListingEntry.COLUMN_NAME_HH15,
                ListingEntry.COLUMN_NAME_HH16,
                ListingEntry.COLUMN_NAME_HH17,
                ListingEntry.COLUMN_NAME_HH20,
                ListingEntry.COLUMN_NAME_HH21,
                ListingEntry.COLUMN_ISNEWHH,
                ListingEntry.COLUMN_COUNTER,
                ListingEntry.COLUMN_USERNAME,
                ListingEntry.COLUMN_NAME_DEVICEID,
                ListingEntry.COLUMN_TAGID,
                ListingEntry.COLUMN_NAME_GPSLat,
                ListingEntry.COLUMN_NAME_GPSLng,
                ListingEntry.COLUMN_NAME_GPSTime,
                ListingEntry.COLUMN_NAME_GPSAccuracy,
                ListingEntry.COLUMN_NAME_GPSAltitude,
                ListingEntry.COLUMN_APPVER,
                ListingEntry.COLUMN_RANDOMIZED
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                ListingEntry.COLUMN_NAME_AREACODE + " ASC";

        Collection<ListingContract> allLC = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();
        try {
            c = db.query(
                    ListingEntry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ListingContract listing = new ListingContract();
                allLC.add(listing.hydrate(c, 0));
            }
            for (ListingContract fc : allLC) {
                jsonArray.put(fc.toJSONObject());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return jsonArray;
    }

    public Collection<ListingContract> getUnsyncedListings() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ListingEntry._ID,
                ListingEntry.COLUMN_NAME_UID,
                ListingEntry.COLUMN_NAME_HHDATETIME,
                ListingEntry.COLUMN_NAME_HHDATETIME01,
                ListingEntry.COLUMN_NAME_ENUMCODE,
                ListingEntry.COLUMN_NAME_AREACODE,
                ListingEntry.COLUMN_NAME_ENUMSTR,
                ListingEntry.COLUMN_NAME_HH01,
                ListingEntry.COLUMN_NAME_HH02,
                ListingEntry.COLUMN_NAME_HH03,
                ListingEntry.COLUMN_NAME_HH04,
                ListingEntry.COLUMN_NAME_HH19,
                ListingEntry.COLUMN_NAME_HH05,
                ListingEntry.COLUMN_NAME_HH06,
                ListingEntry.COLUMN_NAME_HH07,
                ListingEntry.COLUMN_NAME_HH18,
                ListingEntry.COLUMN_NAME_HH08,
                ListingEntry.COLUMN_NAME_HH09,
                ListingEntry.COLUMN_NAME_HH08A1,
                ListingEntry.COLUMN_NAME_HH09A1,
                ListingEntry.COLUMN_NAME_HH10,
                ListingEntry.COLUMN_NAME_HH11,
                ListingEntry.COLUMN_NAME_HH12,
                ListingEntry.COLUMN_NAME_HH13,
                ListingEntry.COLUMN_NAME_HH14,
                ListingEntry.COLUMN_NAME_HH15,
                ListingEntry.COLUMN_NAME_HH16,
                ListingEntry.COLUMN_NAME_HH17,
                ListingEntry.COLUMN_NAME_HH20,
                ListingEntry.COLUMN_NAME_HH21,
                ListingEntry.COLUMN_ISNEWHH,
                ListingEntry.COLUMN_COUNTER,
                ListingEntry.COLUMN_USERNAME,
                ListingEntry.COLUMN_NAME_DEVICEID,
                ListingEntry.COLUMN_TAGID,
                ListingEntry.COLUMN_NAME_GPSLat,
                ListingEntry.COLUMN_NAME_GPSLng,
                ListingEntry.COLUMN_NAME_GPSTime,
                ListingEntry.COLUMN_NAME_GPSAccuracy,
                ListingEntry.COLUMN_NAME_GPSAltitude,
                ListingEntry.COLUMN_APPVER,
                ListingEntry.COLUMN_RANDOMIZED
        };

        String whereClause = ListingEntry.COLUMN_SYNCED + " is null";
        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = ListingEntry.COLUMN_NAME_AREACODE + " ASC";

        Collection<ListingContract> allLC = new ArrayList<ListingContract>();
        try {
            c = db.query(
                    ListingEntry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ListingContract listing = new ListingContract();
                allLC.add(listing.hydrate(c, 0));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allLC;
    }

    public Collection<SignupContract> getUnsyncedSignups() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                SignUpTable._ID,
                SignUpTable.FULLNAME,
                SignUpTable.DESIGNATION,
                SignUpTable.USERNAME,
                SignUpTable.PASSWORD,
                SignUpTable.COUNTRY_ID,
                SignUpTable.COLUMN_DEVICEID,
                SignUpTable.COLUMN_FORMDATE,
        };

        String whereClause = SignUpTable.COLUMN_SYNCED + " is null OR " + SignUpTable.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Collection<SignupContract> allLC = new ArrayList<>();
        try {
            c = db.query(
                    SignUpTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allLC.add(new SignupContract().Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allLC;
    }

    public Collection<ListingContract> getAllListingsForRandom() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ListingEntry._ID,
                ListingEntry.COLUMN_NAME_UID,
                ListingEntry.COLUMN_NAME_HHDATETIME,
                ListingEntry.COLUMN_NAME_ENUMCODE,
                ListingEntry.COLUMN_NAME_AREACODE,
                ListingEntry.COLUMN_NAME_ENUMSTR,
                ListingEntry.COLUMN_NAME_HH01,
                ListingEntry.COLUMN_NAME_HH02,
                ListingEntry.COLUMN_NAME_HH03,
                ListingEntry.COLUMN_NAME_HH04,
                ListingEntry.COLUMN_NAME_HH19,
                ListingEntry.COLUMN_NAME_HH05,
                ListingEntry.COLUMN_NAME_HH06,
                ListingEntry.COLUMN_NAME_HH07,
                ListingEntry.COLUMN_NAME_HH18,
                ListingEntry.COLUMN_NAME_HH08,
                ListingEntry.COLUMN_NAME_HH09,
                ListingEntry.COLUMN_NAME_HH08A1,
                ListingEntry.COLUMN_NAME_HH09A1,
                ListingEntry.COLUMN_NAME_HH10,
                ListingEntry.COLUMN_NAME_HH11,
                ListingEntry.COLUMN_NAME_HH12,
                ListingEntry.COLUMN_NAME_HH13,
                ListingEntry.COLUMN_NAME_HH14,
                ListingEntry.COLUMN_NAME_HH15,
                ListingEntry.COLUMN_NAME_HH16,
                ListingEntry.COLUMN_NAME_HH17,
                ListingEntry.COLUMN_NAME_HH20,
                ListingEntry.COLUMN_NAME_HH21,
                ListingEntry.COLUMN_ISNEWHH,
                ListingEntry.COLUMN_COUNTER,
                ListingEntry.COLUMN_USERNAME,
                ListingEntry.COLUMN_NAME_DEVICEID,
                ListingEntry.COLUMN_TAGID,
                ListingEntry.COLUMN_NAME_GPSLat,
                ListingEntry.COLUMN_NAME_GPSLng,
                ListingEntry.COLUMN_NAME_GPSTime,
                ListingEntry.COLUMN_NAME_GPSAccuracy,
                ListingEntry.COLUMN_NAME_GPSAltitude,
                ListingEntry.COLUMN_APPVER,
                ListingEntry.COLUMN_RANDOMIZED,
                "COUNT(*) as RESCOUNTER, " +
                        "COUNT(case " + ListingEntry.COLUMN_NAME_HH10 + " when '1' then 1 else null end) as CHILDCOUNTER," +
                        "COUNT(case " + ListingEntry.COLUMN_RANDOMIZED + " when '1' then 1 else null end) as RANDCOUNTER," +
                        "COUNT(*) as TOTALHH"
        };

        String whereClause = ListingEntry.COLUMN_NAME_HH08A1 + " =?";
        String[] whereArgs = {"1"};
        String groupBy = ListingEntry.COLUMN_NAME_AREACODE;
        String having = null;

        String orderBy = ListingEntry.COLUMN_NAME_AREACODE + " ASC";

        Collection<ListingContract> allLC = new ArrayList<>();
        try {
            c = db.query(
                    true,
                    ListingEntry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy,                    // The sort order
                    null

            );
            while (c.moveToNext()) {
                ListingContract listing = new ListingContract();
                allLC.add(listing.hydrate(c, 1));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allLC;
    }

    public JSONArray getListingsByCluster(String cluster) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ListingEntry._ID,
                ListingEntry.COLUMN_NAME_UID,
                ListingEntry.COLUMN_NAME_HHDATETIME,
                ListingEntry.COLUMN_NAME_ENUMCODE,
                ListingEntry.COLUMN_NAME_AREACODE,
                ListingEntry.COLUMN_NAME_ENUMSTR,
                ListingEntry.COLUMN_NAME_HH01,
                ListingEntry.COLUMN_NAME_HH02,
                ListingEntry.COLUMN_NAME_HH03,
                ListingEntry.COLUMN_NAME_HH04,
                ListingEntry.COLUMN_NAME_HH19,
                ListingEntry.COLUMN_NAME_HH05,
                ListingEntry.COLUMN_NAME_HH06,
                ListingEntry.COLUMN_NAME_HH07,
                ListingEntry.COLUMN_NAME_HH18,
                ListingEntry.COLUMN_NAME_HH08,
                ListingEntry.COLUMN_NAME_HH09,
                ListingEntry.COLUMN_NAME_HH08A1,
                ListingEntry.COLUMN_NAME_HH09A1,
                ListingEntry.COLUMN_NAME_HH10,
                ListingEntry.COLUMN_NAME_HH11,
                ListingEntry.COLUMN_NAME_HH12,
                ListingEntry.COLUMN_NAME_HH13,
                ListingEntry.COLUMN_NAME_HH14,
                ListingEntry.COLUMN_NAME_HH15,
                ListingEntry.COLUMN_NAME_HH16,
                ListingEntry.COLUMN_NAME_HH17,
                ListingEntry.COLUMN_NAME_HH20,
                ListingEntry.COLUMN_NAME_HH21,
                ListingEntry.COLUMN_ISNEWHH,
                ListingEntry.COLUMN_COUNTER,
                ListingEntry.COLUMN_USERNAME,
                ListingEntry.COLUMN_NAME_DEVICEID,
                ListingEntry.COLUMN_TAGID,
                ListingEntry.COLUMN_NAME_GPSLat,
                ListingEntry.COLUMN_NAME_GPSLng,
                ListingEntry.COLUMN_NAME_GPSTime,
                ListingEntry.COLUMN_NAME_GPSAccuracy,
                ListingEntry.COLUMN_NAME_GPSAltitude,
                ListingEntry.COLUMN_APPVER,
                ListingEntry.COLUMN_RANDOMIZED
        };

        String whereClause = ListingEntry.COLUMN_NAME_AREACODE + " = ?";
        String[] whereArgs = {cluster};
        String groupBy = null;
        String having = null;

        String orderBy =
                ListingEntry.COLUMN_NAME_AREACODE + " ASC";
        JSONArray jsonArray = new JSONArray();

        Collection<ListingContract> allLC = new ArrayList<ListingContract>();
        try {
            c = db.query(
                    ListingEntry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ListingContract listing = new ListingContract();
                allLC.add(listing.hydrate(c, 0));
            }

            for (ListingContract lc : allLC) {
                try {
                    jsonArray.put(lc.toJSONObject());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return jsonArray;
    }

    public ArrayList<ListingContract> getRandomListing(String clusterCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ListingEntry._ID,
                ListingEntry.COLUMN_NAME_UID,
                ListingEntry.COLUMN_NAME_HHDATETIME,
                ListingEntry.COLUMN_NAME_ENUMCODE,
                ListingEntry.COLUMN_NAME_AREACODE,
                ListingEntry.COLUMN_NAME_ENUMSTR,
                ListingEntry.COLUMN_NAME_HH01,
                ListingEntry.COLUMN_NAME_HH02,
                ListingEntry.COLUMN_NAME_HH03,
                ListingEntry.COLUMN_NAME_HH04,
                ListingEntry.COLUMN_NAME_HH19,
                ListingEntry.COLUMN_NAME_HH05,
                ListingEntry.COLUMN_NAME_HH06,
                ListingEntry.COLUMN_NAME_HH07,
                ListingEntry.COLUMN_NAME_HH18,
                ListingEntry.COLUMN_NAME_HH08,
                ListingEntry.COLUMN_NAME_HH09,
                ListingEntry.COLUMN_NAME_HH08A1,
                ListingEntry.COLUMN_NAME_HH09A1,
                ListingEntry.COLUMN_NAME_HH10,
                ListingEntry.COLUMN_NAME_HH11,
                ListingEntry.COLUMN_NAME_HH12,
                ListingEntry.COLUMN_NAME_HH13,
                ListingEntry.COLUMN_NAME_HH14,
                ListingEntry.COLUMN_NAME_HH15,
                ListingEntry.COLUMN_NAME_HH16,
                ListingEntry.COLUMN_NAME_HH17,
                ListingEntry.COLUMN_NAME_HH20,
                ListingEntry.COLUMN_NAME_HH21,
                ListingEntry.COLUMN_ISNEWHH,
                ListingEntry.COLUMN_COUNTER,
                ListingEntry.COLUMN_USERNAME,
                ListingEntry.COLUMN_NAME_DEVICEID,
                ListingEntry.COLUMN_TAGID,
                ListingEntry.COLUMN_NAME_GPSLat,
                ListingEntry.COLUMN_NAME_GPSLng,
                ListingEntry.COLUMN_NAME_GPSTime,
                ListingEntry.COLUMN_NAME_GPSAccuracy,
                ListingEntry.COLUMN_NAME_GPSAltitude,
                ListingEntry.COLUMN_APPVER,
                ListingEntry.COLUMN_RANDOMIZED
        };

        String whereClause = ListingEntry.COLUMN_NAME_HH08A1 + " =? AND "
                + ListingEntry.COLUMN_NAME_AREACODE + " =? AND "
                + ListingEntry.COLUMN_RANDOMIZED + " =?";
        String[] whereArgs = {"1", clusterCode, "2"};
        String groupBy = null;
        String having = null;

        String orderBy = null;

        ArrayList<ListingContract> allLC = new ArrayList<>();
        try {
            c = db.query(
                    ListingEntry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order

            );
            while (c.moveToNext()) {
                ListingContract listing = new ListingContract();
                allLC.add(listing.hydrate(c, 0));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allLC;
    }

    public Collection<TeamsContract> getAllTeams() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                SingleTaluka._ID,
                SingleTaluka.COLUMN_TEAM_NO
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                SingleTaluka.COLUMN_TEAM_NO + " ASC";

        Collection<TeamsContract> allDC = new ArrayList<TeamsContract>();
        try {
            c = db.query(
                    SingleTaluka.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                TeamsContract dc = new TeamsContract();
                allDC.add(dc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }

    public Collection<VerticesContract> getVerticesByCluster(String cluster_code) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                SingleVertices._ID,
                SingleVertices.COLUMN_CLUSTER_CODE,
                SingleVertices.COLUMN_POLY_LAT,
                SingleVertices.COLUMN_POLY_LANG,
                SingleVertices.COLUMN_POLY_SEQ
        };

        String whereClause = SingleVertices.COLUMN_CLUSTER_CODE + " = ?";
        String[] whereArgs = {cluster_code};
        String groupBy = null;
        String having = null;

        String orderBy =
                SingleVertices.COLUMN_POLY_SEQ + " ASC";

        Collection<VerticesContract> allVC = new ArrayList<>();
        try {
            c = db.query(
                    SingleVertices.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                VerticesContract vc = new VerticesContract();
                allVC.add(vc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allVC;
    }

    public VersionAppContract getVersionApp() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VersionAppTable._ID,
                VersionAppTable.COLUMN_VERSION_CODE,
                VersionAppTable.COLUMN_VERSION_NAME,
                VersionAppTable.COLUMN_PATH_NAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = VersionAppTable._ID + " ASC";

        VersionAppContract allVC = new VersionAppContract();
        try {
            c = db.query(
                    VersionAppTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allVC.Hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allVC;
    }

    public VillageContract getEnumBlock(String area_code, String village_code) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VillageTable._ID,
                VillageTable.COLUMN_VILLAGE_CODE,
                VillageTable.COLUMN_VILLAGE_NAME,
                VillageTable.COLUMN_AREA_CODE,
                VillageTable.COLUMN_CLUSTER_CODE
        };

        String whereClause = VillageTable.COLUMN_AREA_CODE + " =? AND " + VillageTable.COLUMN_VILLAGE_CODE + "=?";
        String[] whereArgs = new String[]{area_code, village_code};
        String groupBy = null;
        String having = null;

        String orderBy = VillageTable._ID + " ASC";

        VillageContract allEB = null;
        try {
            c = db.query(
                    VillageTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB = new VillageContract().HydrateEnum(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allEB;
    }

    public ArrayList<Cursor> getDBManagerData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"mesage"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }


    }


    //Sync Functionality
    public int syncUser(JSONArray userList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersContract.UsersTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < userList.length(); i++) {

                JSONObject jsonObjectUser = userList.getJSONObject(i);

                UsersContract user = new UsersContract();
                user.Sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersContract.UsersTable.ROW_USERNAME, user.getUserName());
                values.put(UsersContract.UsersTable.ROW_PASSWORD, user.getPassword());
                values.put(UsersContract.UsersTable.ROW_FULL_NAME, user.getFullName());
                long rowID = db.insert(UsersContract.UsersTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    public int syncUCs(JSONArray distList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UCTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < distList.length(); i++) {

                JSONObject jsonObjectUser = distList.getJSONObject(i);

                UCContract dist = new UCContract();
                dist.Sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UCTable.COLUMN_UC_CODE, dist.getUc_code());
                values.put(UCTable.COLUMN_UC_NAME, dist.getUc_name());
                values.put(UCTable.COLUMN_TALUKA_CODE, dist.getTaluka_code());
                long rowID = db.insert(UCTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncDist(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    public int syncVillages(JSONArray enumList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VillageTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < enumList.length(); i++) {
                JSONObject jsonObjectCC;
                try {
                    jsonObjectCC = enumList.getJSONObject(i);
                    VillageContract Vc = new VillageContract();
                    Vc.Sync(jsonObjectCC);

                    ContentValues values = new ContentValues();

                    values.put(VillageTable.COLUMN_VILLAGE_CODE, Vc.getVillage_code());
                    values.put(VillageTable.COLUMN_VILLAGE_NAME, Vc.getVillage_name());
                    values.put(VillageTable.COLUMN_AREA_CODE, Vc.getArea_code());
                    values.put(VillageTable.COLUMN_CLUSTER_CODE, Vc.getCluster_code());

                    long rowID = db.insert(VillageTable.TABLE_NAME, null, values);
                    if (rowID != -1) insertCount++;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            Log.d(TAG, "syncEnumBlocks(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    public int syncVersionApp(JSONObject VersionList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VersionAppContract.VersionAppTable.TABLE_NAME, null, null);
        long count = 0;
        try {
            JSONObject jsonObjectCC = ((JSONArray) VersionList.get(VersionAppContract.VersionAppTable.COLUMN_VERSION_PATH)).getJSONObject(0);
            VersionAppContract Vc = new VersionAppContract();
            Vc.Sync(jsonObjectCC);

            ContentValues values = new ContentValues();

            values.put(VersionAppContract.VersionAppTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            count = db.insert(VersionAppContract.VersionAppTable.TABLE_NAME, null, values);
            if (count > 0) count = 1;

        } catch (Exception ignored) {
        } finally {
            db.close();
        }

        return (int) count;
    }

    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ListingEntry.COLUMN_SYNCED, true);
        values.put(ListingEntry.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = ListingEntry._ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                ListingEntry.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedSignup(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(SignUpTable.COLUMN_SYNCED, true);
        values.put(SignUpTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = SignUpTable._ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                SignUpTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedBLRandom(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

    }

    public void syncTeams(JSONArray dcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SingleTaluka.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = dcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectDistrict = jsonArray.getJSONObject(i);

                TeamsContract dc = new TeamsContract();
                dc.sync(jsonObjectDistrict);

                ContentValues values = new ContentValues();

                values.put(SingleTaluka.COLUMN_TEAM_NO, dc.getTeamNo());

                db.insert(SingleTaluka.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }

    public void syncVertices(JSONArray vcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SingleVertices.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = vcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectVR = jsonArray.getJSONObject(i);

                VerticesContract vc = new VerticesContract();
                vc.sync(jsonObjectVR);

                ContentValues values = new ContentValues();

                values.put(SingleVertices.COLUMN_CLUSTER_CODE, vc.getCluster_code());
                values.put(SingleVertices.COLUMN_POLY_LAT, vc.getPoly_lat());
                values.put(SingleVertices.COLUMN_POLY_LANG, vc.getPoly_lng());
                values.put(SingleVertices.COLUMN_POLY_SEQ, vc.getPoly_seq());

                db.insert(SingleVertices.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }


    //Get All EnumBlock
    public List<VillageContract> getEnumBlock(String uc_id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VillageTable._ID,
                VillageTable.COLUMN_VILLAGE_CODE,
                VillageTable.COLUMN_VILLAGE_NAME,
                VillageTable.COLUMN_AREA_CODE,
                VillageTable.COLUMN_CLUSTER_CODE,
        };

        String whereClause = VillageTable.COLUMN_AREA_CODE + " LIKE ? ";
        String[] whereArgs = {"" + uc_id + "%"};
        String groupBy = null;
        String having = null;

        String orderBy = VillageTable._ID + " ASC";
        List<VillageContract> allEB = new ArrayList<>();
        try {
            c = db.query(
                    VillageTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB.add(new VillageContract().HydrateEnum(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allEB;
    }


    //Get All UC
    public List<UCContract> getUCs() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                UCTable._ID,
                UCTable.COLUMN_UC_CODE,
                UCTable.COLUMN_UC_NAME,
                UCTable.COLUMN_TALUKA_CODE
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = UCTable._ID + " ASC";
        List<UCContract> allEB = new ArrayList<>();
        try {
            c = db.query(
                    UCTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB.add(new UCContract().Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allEB;
    }
}