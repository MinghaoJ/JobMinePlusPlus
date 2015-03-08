package ca.uwaterloo.jobmine.fragments;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ca.uwaterloo.jobmine.R;
import ca.uwaterloo.jobmine.activities.MainActivity;

public class SettingsFragment extends PreferenceFragment {

    private static final int SECTION_NUMBER = 10;
    private static boolean AUTO_LOGIN;
    private static CheckBoxPreference checkBoxPreference;

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SettingsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);

        checkBoxPreference = (CheckBoxPreference)findPreference("checkbox_preference");

        loadData();
        checkBoxPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                saveData();
                return true;
            }
        });

    }


        @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(SECTION_NUMBER);
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getActivity().getPreferences(0);
        AUTO_LOGIN = sharedPreferences.getBoolean("auto_login", false);
        checkBoxPreference.setChecked(AUTO_LOGIN);
    }
    private void saveData() {
        SharedPreferences sharedPreferences = getActivity().getPreferences(0);
        AUTO_LOGIN = checkBoxPreference.isChecked();
        sharedPreferences.edit().putBoolean("auto_login", AUTO_LOGIN).commit();
    }

}
