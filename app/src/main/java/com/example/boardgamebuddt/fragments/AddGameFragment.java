package com.example.boardgamebuddt.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.boardgamebuddt.MainActivity;
import com.example.boardgamebuddt.R;
import com.example.boardgamebuddt.models.Game;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class AddGameFragment extends Fragment {
    private TextInputEditText etName, etMinPlayer, etMaxPlayer, etBestPlayer, etAvgTime, etDifficulty, etRulesNote;
    private ChipGroup cgCategories;
    private SwitchMaterial swAlreadyPlayed;
    private Button btAddGame;
    public AddGameFragment() {super(R.layout.fragment_add_game);}
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etName = view.findViewById(R.id.etAddGameName);
        etMinPlayer = view.findViewById(R.id.etAddMinPlayers);
        etMaxPlayer = view.findViewById(R.id.etAddMaxPlayers);
        etBestPlayer = view.findViewById(R.id.etAddBestPlayers);
        etAvgTime = view.findViewById(R.id.etAddAvgTime);
        etDifficulty = view.findViewById(R.id.etAddDifficulty);
        etRulesNote = view.findViewById(R.id.etAddRulesNote);
        cgCategories = view.findViewById(R.id.cgCategories);
        swAlreadyPlayed = view.findViewById(R.id.swAlreadyPlayed);//bool
        btAddGame = view.findViewById(R.id.btnAddGameSave);
        btAddGame.setOnClickListener(v -> saveGame());
    }

    private void saveGame() {
        String name = etName.getText().toString().trim();
        String minPlayers = etMinPlayer.getText().toString().trim();
        String maxPlayers = etMaxPlayer.getText().toString().trim();
        String bestPlayers = etBestPlayer.getText().toString().trim();
        String avgTime = etAvgTime.getText().toString().trim();
        String difficulty = etDifficulty.getText().toString().trim();
        String rulesNote = etRulesNote.getText().toString().trim();
        if(name.isEmpty()||minPlayers.isEmpty()||maxPlayers.isEmpty()||avgTime.isEmpty()||difficulty.isEmpty()){
            Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
        int min = Integer.parseInt(minPlayers);
        int max = Integer.parseInt(maxPlayers);
        int best = bestPlayers.isEmpty() ? min : Integer.parseInt(bestPlayers);
        int avg = Integer.parseInt(avgTime);
        int diff = Integer.parseInt(difficulty);
        List<String> selectedCategories = new ArrayList<>();
        for (int i = 0; i<cgCategories.getChildCount(); i++) {
            Chip chip = (Chip) cgCategories.getChildAt(i);
            if(chip.isChecked()){
                selectedCategories.add(chip.getText().toString());
            }
        }
        if (selectedCategories.isEmpty()){
            Toast.makeText(getContext(), "Please select at least one category", Toast.LENGTH_SHORT).show();
            return;
        }
        Game game = new Game(null, name, min, max, best, avg, diff, selectedCategories, swAlreadyPlayed.isChecked(), rulesNote);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.addGameToDB(game);
    }
}