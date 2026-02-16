package com.example.boardgamebuddt.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.boardgamebuddt.GameAdapter;
import com.example.boardgamebuddt.R;
import com.example.boardgamebuddt.models.Game;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class GameListFragment extends Fragment {

    private RecyclerView rvGameList;
    private GameAdapter adapter;
    private List<Game> gameList;
    private ProgressBar pbLoading;
    private DatabaseReference gamesRef;

    public GameListFragment() {
        super(R.layout.fragment_game_list);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. חיבור הרכיבים
        rvGameList = view.findViewById(R.id.rvGameList);
        pbLoading = view.findViewById(R.id.pbLoading);

        // 2. הגדרת ה-RecyclerView
        rvGameList.setLayoutManager(new LinearLayoutManager(getContext()));
        gameList = new ArrayList<>();
        adapter = new GameAdapter(gameList);
        rvGameList.setAdapter(adapter);

        // 3. הגדרת ההפניה ל-Firebase
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        gamesRef = FirebaseDatabase.getInstance().getReference("users").child(uid).child("games");

        // דואג שהנתונים יישארו מסונכרנים גם כאן
        gamesRef.keepSynced(true);

        fetchGamesFromDB();
    }

    private void fetchGamesFromDB() {
        pbLoading.setVisibility(View.VISIBLE);

        // שאילתה שמסדרת את המשחקים לפי שם בסדר אלפביתי
        gamesRef.orderByChild("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                gameList.clear();
                for (DataSnapshot gameSnapshot : snapshot.getChildren()) {
                    Game game = gameSnapshot.getValue(Game.class);
                    if (game != null) {
                        gameList.add(game);
                    }
                }
                adapter.notifyDataSetChanged();
                pbLoading.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                pbLoading.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}