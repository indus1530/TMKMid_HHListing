package edu.aku.hassannaqvi.tmkmid_hhlisting_app.activities.sync;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.tmkmid_hhlisting_app.CONSTANTS;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.R;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.adapters.SyncListAdapter;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.adapters.UploadListAdapter;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.contracts.ListingContract;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.core.DatabaseHelper;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.core.MainApp;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.databinding.ActivitySyncBinding;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.getClasses.GetAllData;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.otherClasses.SyncModel;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.syncClasses.SyncAllData;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.syncClasses.SyncDevice;

import static edu.aku.hassannaqvi.tmkmid_hhlisting_app.repository.UtilsKt.dbBackup;

public class SyncActivity extends AppCompatActivity implements SyncDevice.SyncDevicInterface {
    SharedPreferences.Editor editor;
    SharedPreferences sharedPref;
    DatabaseHelper db;
    SyncListAdapter syncListAdapter;
    UploadListAdapter uploadListAdapter;
    ActivitySyncBinding bi;
    SyncModel model;
    SyncModel uploadmodel;
    List<SyncModel> list;
    List<SyncModel> uploadlist;
    Boolean listActivityCreated;
    Boolean uploadlistActivityCreated;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    private boolean sync_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_sync);
        bi.setCallback(this);
        list = new ArrayList<>();
        uploadlist = new ArrayList<>();
        bi.noItem.setVisibility(View.VISIBLE);
        bi.noDataItem.setVisibility(View.VISIBLE);
        listActivityCreated = true;
        uploadlistActivityCreated = true;
        db = new DatabaseHelper(this);
        sharedPref = getSharedPreferences("listingHHTpvics", MODE_PRIVATE);
        editor = sharedPref.edit();
        dbBackup(this);

        sync_flag = getIntent().getBooleanExtra(CONSTANTS.SYNC_LOGIN, false);

        bi.btnSync.setOnClickListener(v -> onSyncDataClick());
        bi.btnUpload.setOnClickListener(v -> syncServer());
        setAdapter();
        setUploadAdapter();
    }

    public void onSyncDataClick() {

        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            bi.lbls.setText("DOWNLOADING DATA FROM SERVER");
            /*if (sync_flag) new SyncData(SyncActivity.this, MainApp.DIST_ID).execute(true);
            else new SyncDevice(SyncActivity.this, true).execute();*/
            new SyncData(SyncActivity.this).execute(true);
        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }
    }

    void setAdapter() {
        syncListAdapter = new SyncListAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        bi.rvSyncList.setLayoutManager(mLayoutManager);
        bi.rvSyncList.setItemAnimator(new DefaultItemAnimator());
        bi.rvSyncList.setAdapter(syncListAdapter);
        syncListAdapter.notifyDataSetChanged();
        if (syncListAdapter.getItemCount() > 0) {
            bi.noItem.setVisibility(View.GONE);
        } else {
            bi.noItem.setVisibility(View.VISIBLE);
        }
    }

    void setUploadAdapter() {
        uploadListAdapter = new UploadListAdapter(uploadlist);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        bi.rvUploadList.setLayoutManager(mLayoutManager2);
        bi.rvUploadList.setItemAnimator(new DefaultItemAnimator());
        bi.rvUploadList.setAdapter(uploadListAdapter);
        uploadListAdapter.notifyDataSetChanged();
        if (uploadListAdapter.getItemCount() > 0) {
            bi.noDataItem.setVisibility(View.GONE);
        } else {
            bi.noDataItem.setVisibility(View.VISIBLE);
        }
    }

    public void syncServer() {
        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            bi.lbls.setText("UPLOADING DATA TO SERVER");

            new SyncDevice(this, false).execute();
//  *******************************************************Forms*********************************
            Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Forms",
                    "updateSyncedForms",
                    ListingContract.class,
                    MainApp._HOST_URL + ListingContract.ListingEntry._URL,
                    ListingContract.ListingEntry.TABLE_NAME,
                    db.getUnsyncedListings(), 0, uploadListAdapter, uploadlist
            ).execute();

            bi.noDataItem.setVisibility(View.GONE);

            uploadlistActivityCreated = false;

            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastUpSyncServer", dtToday);

            editor.apply();

        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void processFinish(boolean flag) {
        if (flag) {
            new SyncData(SyncActivity.this).execute(true);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_OK);
        finish();
    }

    private class SyncData extends AsyncTask<Boolean, String, String> {

        private Context mContext;

        private SyncData(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(Boolean... booleans) {
            runOnUiThread(() -> {
                new SyncDevice(SyncActivity.this, false).execute();

//                  getting Users!!
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "User", syncListAdapter, list).execute();

//                    Getting App Version
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "VersionApp", syncListAdapter, list).execute();

//                    Getting UCs!!
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "UCs", syncListAdapter, list).execute();

//                    Getting Villages
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "Villages", syncListAdapter, list).execute();
                bi.noItem.setVisibility(View.GONE);

                listActivityCreated = false;
            });

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            new Handler().postDelayed(() -> {

                editor.putBoolean("flag", true);
                editor.commit();

                dbBackup(mContext);

            }, 1200);
        }
    }
}
