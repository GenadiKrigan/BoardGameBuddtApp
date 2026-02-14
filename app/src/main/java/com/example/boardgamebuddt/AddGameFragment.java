package com.example.boardgamebuddt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.chip.ChipGroup;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;

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
        swAlreadyPlayed = view.findViewById(R.id.swAlreadyPlayed);
        btAddGame = view.findViewById(R.id.btnAddGameSave);
        btAddGame.setOnClickListener(v -> saveGame());
    }

    private void saveGame() {
        String name = etName.getText().toString().trim();

    }
}