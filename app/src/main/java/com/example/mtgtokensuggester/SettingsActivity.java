package com.example.mtgtokensuggester;

import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        if (item.getItemId () == android.R.id.home) {
            finish ();
            return true;
        } else
            return super.onOptionsItemSelected (item);
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
            setEditTextPrefsInputTypeToDecimal();
        }

        private void setEditTextPrefsInputTypeToDecimal()
        {
            String numberOfTokensXKey = "numberOfTokensX";
            String numberOfTokensTriggerKey = "numberOfTokensTrigger";
            EditTextPreference xPreference = findPreference (numberOfTokensXKey);
            EditTextPreference triggerPreference = findPreference (numberOfTokensTriggerKey);
            if (xPreference != null && triggerPreference != null) {
                EditTextPreference.OnBindEditTextListener listener = getNewDecimalListener ();
                xPreference.setOnBindEditTextListener (listener);
                triggerPreference.setOnBindEditTextListener (listener);
            }
        }

        private EditTextPreference.OnBindEditTextListener getNewDecimalListener()
        {
            return new EditTextPreference.OnBindEditTextListener()
            {
                @Override public void onBindEditText (@NonNull EditText editText)
                {
                    editText.setInputType (
                            InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                }
            };
        }
    }
}