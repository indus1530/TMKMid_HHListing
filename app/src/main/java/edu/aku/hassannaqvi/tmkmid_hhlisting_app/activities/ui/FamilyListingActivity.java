package edu.aku.hassannaqvi.tmkmid_hhlisting_app.activities.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;

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
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.repository.UtilsKt;
import edu.aku.hassannaqvi.tmkmid_hhlisting_app.repository.WarningActivityInterface;

import static edu.aku.hassannaqvi.tmkmid_hhlisting_app.core.MainApp.appInfo;
import static edu.aku.hassannaqvi.tmkmid_hhlisting_app.core.MainApp.lc;

public class FamilyListingActivity extends AppCompatActivity implements WarningActivityInterface {

    public static String TAG = FamilyListingActivity.class.getName();
    static Boolean familyFlag = false;
    ActivityFamilyListingBinding bi;
    private List<View> hh19MainList;
    private MutableLiveData<List<View>> hh19acvList;
    private boolean deathFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_family_listing);
        bi.setCallback(this);
        bi.setMember(new Members());
        Members.txtTeamNoWithFam.set("S" + String.format(Locale.getDefault(), "%04d", MainApp.hh03txt) + "-H" + String.format(Locale.getDefault(), "%03d", Integer.valueOf(MainApp.hh07txt)));
        setupButtons();
        bi.hhIsNewFam.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                bi.btnAddNewHousehold.setVisibility(View.VISIBLE);
                bi.btnAddHousehold.setVisibility(View.GONE);
            } else {
                bi.btnAddNewHousehold.setVisibility(View.GONE);
                setupButtons();
            }
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


        hh19MainList = new ArrayList<>();
        if (hh19acvList == null) {
            hh19acvList = new MutableLiveData<>();
            Members.txtCountCounter.set("Death: " + hh19MainList.size());
        }
        hh19acvList.observe(this, item -> Members.txtCountCounter.set("Death: " + item.size()));

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
        deathFlag = false;
        if (bi.hh1801.getText().toString().isEmpty() || bi.hh1802.getText().toString().isEmpty() || bi.hh1803.getText().toString().isEmpty() ||
                bi.hh1804.getText().toString().isEmpty() || bi.hh1805.getText().toString().isEmpty() || bi.hh1806.getText().toString().isEmpty() ||
                bi.hh1807.getText().toString().isEmpty()) return;
        int initialTotal = Integer.parseInt(bi.hh1801.getText().toString()) + Integer.parseInt(bi.hh1802.getText().toString()) + Integer.parseInt(bi.hh1803.getText().toString())
                + Integer.parseInt(bi.hh1804.getText().toString()) + Integer.parseInt(bi.hh1805.getText().toString()) + Integer.parseInt(bi.hh1806.getText().toString())
                + Integer.parseInt(bi.hh1807.getText().toString());

        bi.deathCount.setText(getResources().getString(R.string.death_heading).replace("%", String.valueOf(initialTotal)));

        if (initialTotal > 10 || initialTotal == 0) {
            deathFlag = true;
            UtilsKt.openWarningActivity(this, 1, "WARNING!", "Maximum deaths in five years needs to be 10 and minimum 01. Please recheck it.", "Re-Enter", "Cancel");
        } else {
            deathFlag = false;
            for (int i = 0; i < initialTotal; i++) {
                runOnUiThread(this::addViewInHH19);
            }
        }
    }

    private void addViewInHH19() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.member_death_layout, null);
        bi.ll19Items.addView(rowView);
        hh19MainList.add(rowView);
        hh19acvList.setValue(hh19MainList);
        MemberDeathLayoutBinding rs86acvBi = DataBindingUtil.bind(rowView);
        rs86acvBi.setLifecycleOwner(this);
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

        JSONObject SF = new JSONObject();

        SF.put("hh1801", bi.hh1801.getText().toString().isEmpty() ? "-1" : bi.hh1801.getText().toString());
        SF.put("hh1802", bi.hh1802.getText().toString().isEmpty() ? "-1" : bi.hh1802.getText().toString());
        SF.put("hh1803", bi.hh1803.getText().toString().isEmpty() ? "-1" : bi.hh1803.getText().toString());
        SF.put("hh1804", bi.hh1804.getText().toString().isEmpty() ? "-1" : bi.hh1804.getText().toString());
        SF.put("hh1805", bi.hh1805.getText().toString().isEmpty() ? "-1" : bi.hh1805.getText().toString());
        SF.put("hh1806", bi.hh1806.getText().toString().isEmpty() ? "-1" : bi.hh1806.getText().toString());
        SF.put("hh1807", bi.hh1807.getText().toString().isEmpty() ? "-1" : bi.hh1807.getText().toString());

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
            SF.put(String.format(Locale.getDefault(), "hh19%02d" + "d", counter19), hh19Binding.hh1904dd.getText().toString());

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

        if (deathFlag) {
            UtilsKt.openWarningActivity(this, 1, "WARNING!", "Maximum deaths in five years needs to be 10 and minimum 01. Please recheck it.", "Re-Enter", "Cancel");
            return false;
        }
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

    @Override
    public void callWarningActivity(int id) {
        bi.hh1801.requestFocus();
    }
}
