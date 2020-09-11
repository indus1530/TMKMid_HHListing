package edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class UsersContract {

    private static final String TAG = "Users_CONTRACT";
    private Long _ID;
    private String ROW_USERNAME;
    private String ROW_PASSWORD;
    private String ROW_FULL_NAME;

    public UsersContract() {
        // Default Constructor
    }

    public String getUserName() {
        return this.ROW_USERNAME;
    }

    public void setUserName(String username) {
        this.ROW_USERNAME = username;
    }

    public String getPassword() {
        return this.ROW_PASSWORD;
    }

    public void setPassword(String password) {
        this.ROW_PASSWORD = password;
    }

    public String getFullName() {
        return ROW_FULL_NAME;
    }

    public void setROW_FULL_NAME(String ROW_FULL_NAME) {
        this.ROW_FULL_NAME = ROW_FULL_NAME;
    }

    public UsersContract Sync(JSONObject jsonObject) throws JSONException {
        this.ROW_USERNAME = jsonObject.getString(UsersTable.ROW_USERNAME);
        this.ROW_PASSWORD = jsonObject.getString(UsersTable.ROW_PASSWORD);
        this.ROW_FULL_NAME = jsonObject.getString(UsersTable.ROW_FULL_NAME);
        return this;

    }

    public UsersContract Hydrate(Cursor cursor) {
        this._ID = cursor.getLong(cursor.getColumnIndex(UsersTable._ID));
        this.ROW_USERNAME = cursor.getString(cursor.getColumnIndex(UsersTable.ROW_USERNAME));
        this.ROW_PASSWORD = cursor.getString(cursor.getColumnIndex(UsersTable.ROW_PASSWORD));
        this.ROW_FULL_NAME = cursor.getString(cursor.getColumnIndex(UsersTable.ROW_FULL_NAME));
        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(UsersTable._ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(UsersTable.ROW_USERNAME, this.ROW_USERNAME == null ? JSONObject.NULL : this.ROW_USERNAME);
        json.put(UsersTable.ROW_PASSWORD, this.ROW_PASSWORD == null ? JSONObject.NULL : this.ROW_PASSWORD);
        json.put(UsersTable.ROW_FULL_NAME, this.ROW_FULL_NAME == null ? JSONObject.NULL : this.ROW_FULL_NAME);
        return json;
    }

    public static abstract class UsersTable implements BaseColumns {

        public static final String TABLE_NAME = "users";
        public static final String _ID = "id";
        public static final String ROW_USERNAME = "username";
        public static final String ROW_PASSWORD = "password";
        public static final String ROW_FULL_NAME = "full_name";
    }
}