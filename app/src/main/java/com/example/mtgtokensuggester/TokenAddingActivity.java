package com.example.mtgtokensuggester;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableRow;

import com.example.mtgtokensuggester.TokenStructure.Token.ArtifactInfo;
import com.example.mtgtokensuggester.TokenStructure.Token.Color;
import com.example.mtgtokensuggester.TokenStructure.Token.CreatureInfo;
import com.example.mtgtokensuggester.TokenStructure.Token.EnchantmentInfo;
import com.example.mtgtokensuggester.TokenStructure.Token.Token;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TokenAddingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token_adding);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        CheckBox creatureCheckBox = findViewById(R.id.cb_creature);
        savedInstanceState.putBoolean("creatureCheckBox", creatureCheckBox.isChecked());

        CheckBox artifactCheckBox = findViewById(R.id.cb_artifact);
        savedInstanceState.putBoolean("artifactCheckBox", artifactCheckBox.isChecked());

        CheckBox enchantmentCheckBox = findViewById(R.id.cb_enchantment);
        savedInstanceState.putBoolean("enchantmentCheckBox", enchantmentCheckBox.isChecked());


        CheckBox whiteCheckBox = findViewById(R.id.cb_white);
        savedInstanceState.putBoolean("whiteCheckBox", whiteCheckBox.isChecked());

        CheckBox blueCheckBox = findViewById(R.id.cb_blue);
        savedInstanceState.putBoolean("blueCheckBox", blueCheckBox.isChecked());

        CheckBox blackCheckBox = findViewById(R.id.cb_black);
        savedInstanceState.putBoolean("blackCheckBox", blackCheckBox.isChecked());

        CheckBox redCheckBox = findViewById(R.id.cb_red);
        savedInstanceState.putBoolean("redCheckBox", redCheckBox.isChecked());

        CheckBox greenCheckBox = findViewById(R.id.cb_green);
        savedInstanceState.putBoolean("greenCheckBox", greenCheckBox.isChecked());


        EditText powerText = findViewById(R.id.et_power);
        savedInstanceState.putString("power", powerText.getText().toString());

        EditText toughnessText = findViewById(R.id.et_toughness);
        savedInstanceState.putString("toughness", toughnessText.getText().toString());

        EditText abilityText = findViewById(R.id.et_ability);
        savedInstanceState.putString("ability", abilityText.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);


        CheckBox creatureCheckBox = findViewById(R.id.cb_creature);
        creatureCheckBox.setChecked(savedInstanceState.getBoolean("creatureCheckBox"));

        CheckBox artifactCheckBox = findViewById(R.id.cb_artifact);
        artifactCheckBox.setChecked(savedInstanceState.getBoolean("artifactCheckBox"));

        CheckBox enchantmentCheckBox = findViewById(R.id.cb_enchantment);
        enchantmentCheckBox.setChecked(savedInstanceState.getBoolean("enchantmentCheckBox"));


        CheckBox whiteCheckBox = findViewById(R.id.cb_white);
        whiteCheckBox.setChecked(savedInstanceState.getBoolean("whiteCheckBox"));

        CheckBox blueCheckBox = findViewById(R.id.cb_blue);
        blueCheckBox.setChecked(savedInstanceState.getBoolean("blueCheckBox"));

        CheckBox blackCheckBox = findViewById(R.id.cb_black);
        blackCheckBox.setChecked(savedInstanceState.getBoolean("blackCheckBox"));

        CheckBox redCheckBox = findViewById(R.id.cb_red);
        redCheckBox.setChecked(savedInstanceState.getBoolean("redCheckBox"));

        CheckBox greenCheckBox = findViewById(R.id.cb_green);
        greenCheckBox.setChecked(savedInstanceState.getBoolean("greenCheckBox"));


        EditText powerText = findViewById(R.id.et_power);
        powerText.setText(savedInstanceState.getString("power"));

        EditText toughnessText = findViewById(R.id.et_toughness);
        toughnessText.setText(savedInstanceState.getString("toughness"));

        EditText abilityText = findViewById(R.id.et_ability);
        abilityText.setText(savedInstanceState.getString("ability"));

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void addToken(View view) {

        CheckBox creatureCheckBox = findViewById(R.id.cb_creature);
        CheckBox artifactCheckBox = findViewById(R.id.cb_artifact);
        CheckBox enchantmentCheckBox = findViewById(R.id.cb_enchantment);
        EditText abilityText = findViewById(R.id.et_ability);

        CheckBox whiteCheckBox = findViewById(R.id.cb_white);
        CheckBox blueCheckBox = findViewById(R.id.cb_blue);
        CheckBox blackCheckBox = findViewById(R.id.cb_black);
        CheckBox redCheckBox = findViewById(R.id.cb_red);
        CheckBox greenCheckBox = findViewById(R.id.cb_green);


        CreatureInfo creatureInfo = null;

        if (creatureCheckBox.isChecked()){

            EditText powerText = findViewById(R.id.et_power);
            EditText toughnessText = findViewById(R.id.et_toughness);

            creatureInfo = new CreatureInfo(powerText.getText().toString(), toughnessText.getText().toString());
        }

        ArtifactInfo artifactInfo = null;
        if (artifactCheckBox.isChecked()){
            artifactInfo = new ArtifactInfo();
        }

        EnchantmentInfo enchantmentInfo = null;
        if (enchantmentCheckBox.isChecked()){
            enchantmentInfo = new EnchantmentInfo();
        }

        ArrayList<Color> colors = new ArrayList<>();

        if (whiteCheckBox.isChecked()){
            colors.add(Color.WHITE);
        }

        if (blueCheckBox.isChecked()){
            colors.add(Color.BLUE);
        }

        if (blackCheckBox.isChecked()){
            colors.add(Color.BLACK);
        }

        if (redCheckBox.isChecked()){
            colors.add(Color.RED);
        }

        if (greenCheckBox.isChecked()){
            colors.add(Color.GREEN);
        }

        String ability = abilityText.getText().toString();

        Token newToken = new Token(colors, ability, artifactInfo, creatureInfo, enchantmentInfo);

        String filename = "TokenListActivity";
        String fileContents = newToken.toString();
        try (FileOutputStream fos = getApplicationContext().openFileOutput(filename, Context.MODE_PRIVATE)) {
            fos.write(fileContents.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
