package edu.aku.hassannaqvi.tmkmid_hhlisting_app.activities.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import edu.aku.hassannaqvi.tmkmid_hhlisting_app.R;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.core.MainApp;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.databinding.ActivityFamilyListingBinding;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.databinding.MemberDeathLayoutBinding;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.otherClasses.models.Members;

import static edu.aku.hassannaqvi.tmkmid_hhlisting_app.core.MainApp.appInfo;
import static edu.aku.hassannaqvi.tmkmid_hhlisting_app.core.MainApp.lc;

public class FamilyListingActivity extends AppCompatActivity {

    public static String TAG = FamilyListingActivity.class.getName();
    static Boolean familyFlag = false;
    ActivityFamilyListingBinding bi;
    private List<View> hh19MainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_family_listing);
        bi.setCallback(this);
        Members.txtTeamNoWithFam.set(String.format("%04d", MainApp.hh03txt) + "-" + String.format("%03d", Integer.valueOf(MainApp.hh07txt)));

        setupButtons();
        hh19MainList = new ArrayList<>();

        bi.hhIsNewFam.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                bi.btnAddNewHousehold.setVisibility(View.VISIBLE);
                bi.btnAddHousehold.setVisibility(View.GONE);
                if (MainApp.hh07txt.equals("1")) {
                    MainApp.hh07txt = "1";
                }
            } else {
                bi.btnAddNewHousehold.setVisibility(View.GONE);
                setupButtons();
                if (MainApp.fTotal == 0) {
                    if (MainApp.hh07txt.equals("1")) {
                        MainApp.hh07txt = "1";
                    }
                }
            }
            Members.txtTeamNoWithFam.set("S" + String.format(Locale.getDefault(), "%04d", MainApp.hh03txt)
                    + "-H" + String.format(Locale.getDefault(), "%03d", Integer.valueOf(MainApp.hh07txt)));
        });

        bi.deleteHH.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                Clear.clearAllFields(bi.fldGrpSecB01, false);
            } else {
                Clear.clearAllFields(bi.fldGrpSecB01, true);
            }
        });

        bi.hh17.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.hh17b.getId()) {
                Clear.clearAllFields(bi.hh18cv);
            }
        });

        bi.hh20.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.hh20b.getId()) {
                Clear.clearAllFields(bi.hh21cv);
            }
        });

    }

    public void onTextChangedHH14(CharSequence s, int start, int before, int count) {
        if (Objects.requireNonNull(bi.hh14.getText()).toString().trim().isEmpty()) return;
        bi.hh11.setMaxvalue(Float.parseFloat(bi.hh14.getText().toString()) - 1);
        bi.hh12.setMaxvalue(Float.parseFloat(bi.hh14.getText().toString()));
        bi.hh13.setMaxvalue(Float.parseFloat(bi.hh14.getText().toString()));
    }

    public void onTextChangedHH18(CharSequence s, int start, int before, int count) {
        bi.ll19Items.removeAllViews();
        hh19MainList.clear();
        if (Objects.requireNonNull(bi.hh18.getText()).toString().trim().isEmpty()) return;

        for (byte i = 0; i < Integer.parseInt(bi.hh18.getText().toString()); i++) {
            runOnUiThread(this::addViewInHH19);
        }
    }

    private void addViewInHH19() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.member_death_layout, null);
        bi.ll19Items.addView(rowView);
        hh19MainList.add(rowView);
    }

    public void setupButtons() {
        if (MainApp.fCount < MainApp.fTotal) {
            bi.btnAddFamily.setVisibility(View.VISIBLE);
            bi.btnAddHousehold.setVisibility(View.GONE);
            bi.hhIsNewFam.setVisibility(View.GONE);
        } else {
            bi.btnAddFamily.setVisibility(View.GONE);
            bi.btnAddHousehold.setVisibility(View.VISIBLE);
            bi.hhIsNewFam.setVisibility(View.VISIBLE);
            bi.deleteHH.setVisibility(View.VISIBLE);
        }
    }

    private void saveDraft() throws JSONException {
        lc.setHh07(MainApp.hh07txt);
        lc.setHh15(bi.deleteHH.isChecked() ? "1" : "-1"); //Delete Family
        lc.setIsNewHH(bi.hhIsNewFam.isChecked() ? "1" : "2"); //New Family Add
        lc.setHh08(bi.hh08.getText().toString().isEmpty() ? "-1" : bi.hh08.getText().toString()); //HH Name
        lc.setHh09(bi.hh09.getText().toString().isEmpty() ? "-1" : bi.hh09.getText().toString()); //Father Name
        lc.setHh16(bi.hh16.getText().toString().isEmpty() ? "-1" : bi.hh16.getText().toString()); //Cast
        lc.setHh14(bi.hh14.getText().toString().isEmpty() ? "-1" : bi.hh14.getText().toString()); //Total Members
        lc.setHh10(bi.hh10a.isChecked() ? "1" : bi.hh10b.isChecked() ? "2" : "-1");
        lc.setHh11(bi.hh11.getText().toString().isEmpty() ? "-1" : bi.hh11.getText().toString());
        lc.setHh12(bi.hh12.getText().toString().isEmpty() ? "-1" : bi.hh12.getText().toString());
        lc.setHh13(bi.hh13.getText().toString().isEmpty() ? "-1" : bi.hh13.getText().toString());
        lc.setHh17(bi.hh17a.isChecked() ? "1" : bi.hh17b.isChecked() ? "2" : "-1");
        lc.setHh18(bi.hh18.getText().toString().isEmpty() ? "-1" : bi.hh18.getText().toString());

        JSONObject SF = new JSONObject();

//        SF.put("hh1801",);

        int counter19 = 1;
        for (View view : hh19MainList) {
            MemberDeathLayoutBinding hh19Binding = DataBindingUtil.bind(view);
            SF.put(String.format(Locale.getDefault(), "hh19%02d" + "a", counter19), hh19Binding.hh1901a.isChecked() ? "1" : hh19Binding.hh1901b.isChecked() ? "2" : "-1");
            SF.put(String.format(Locale.getDefault(), "hh19%02d" + "bdd", counter19), hh19Binding.hh1902dd.getText().toString());
            SF.put(String.format(Locale.getDefault(), "hh19%02d" + "bmm", counter19), hh19Binding.hh1902mm.getText().toString());
            SF.put(String.format(Locale.getDefault(), "hh19%02d" + "byy", counter19), hh19Binding.hh1902yy.getText().toString());
            SF.put(String.format(Locale.getDefault(), "hh19%02d" + "cdd", counter19), hh19Binding.hh1903dd.getText().toString());
            SF.put(String.format(Locale.getDefault(), "hh19%02d" + "cmm", counter19), hh19Binding.hh1903mm.getText().toString());
            SF.put(String.format(Locale.getDefault(), "hh19%02d" + "cyy", counter19), hh19Binding.hh1903yy.getText().toString());

            counter19++;
        }

        lc.setHh19(String.valueOf(SF));
        lc.setHh20(bi.hh20a.isChecked() ? "1" : bi.hh20b.isChecked() ? "2" : "-1");
        lc.setHh21(bi.hh21.getText().toString().isEmpty() ? "-1" : bi.hh21.getText().toString());
    }

    private boolean formValidation() {
        if (!Validator.emptyCheckingContainer(this, bi.fldGrpSecB01)) return false;
        if (bi.deleteHH.isChecked()) return true;

        int hh11 = bi.hh11.getText().toString().isEmpty() ? 0 : Integer.parseInt(bi.hh11.getText().toString());
        int hh12 = Integer.parseInt(bi.hh12.getText().toString());
        int hh13 = Integer.parseInt(bi.hh13.getText().toString());

        if ((hh11 + hh12 + hh13) > Integer.parseInt(bi.hh14.getText().toString()))
            return Validator.emptyCustomTextBox(this, bi.hh14, "Total not matching!!");

        return true;
    }

    private boolean updateDB() {
        long updcount = appInfo.getDbHelper().addForm(lc);
        lc.setID(String.valueOf(updcount));
        if (updcount > 0) {
            lc.setUID((lc.getDeviceID() + lc.getID()));
            appInfo.getDbHelper().updateListingUID();
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void onBtnAddNewHouseHoldClick() {

        if (formValidation()) {
            try {
                saveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (updateDB()) {
                if (familyFlag)
                    MainApp.hh07txt = String.valueOf(Integer.parseInt(MainApp.hh07txt) + 1);
                else {
                    MainApp.hh07txt = String.valueOf(Integer.parseInt(MainApp.hh07txt) + 1);
                    familyFlag = true;
                }
                lc.setHh07(MainApp.hh07txt);
                MainApp.fCount++;
                finish();
                Intent fA = new Intent(this, FamilyListingActivity.class);
                startActivity(fA);
            }
        }

    }

    public void onBtnAddFamilyClick() {
        if (formValidation()) {

            try {
                saveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (updateDB()) {
                MainApp.hh07txt = String.valueOf(Integer.parseInt(MainApp.hh07txt) + 1);
                lc.setHh07(MainApp.hh07txt);
                MainApp.fCount++;

                finish();
                Intent fA = new Intent(this, FamilyListingActivity.class);
                startActivity(fA);
            }

        }

    }

    public void onBtnAddHouseholdClick() {
        if (formValidation()) {

            try {
                saveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (updateDB()) {
                MainApp.fCount = 0;
                MainApp.fTotal = 0;
                MainApp.cCount = 0;
                MainApp.cTotal = 0;
                familyFlag = false;
                finish();
                Intent fA = new Intent(this, SetupActivity.class);
                startActivity(fA);
            }
        }

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back Button NOT Allowed!", Toast.LENGTH_SHORT).show();

    }
}
