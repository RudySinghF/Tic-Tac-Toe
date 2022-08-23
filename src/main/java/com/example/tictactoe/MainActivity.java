package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int player;
    int[] game_state = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] win_positions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    String outcome;
    boolean game_active = true;

    public void tap(View view) {
        ImageView img = (ImageView) view;
        int tapped_image = Integer.parseInt(img.getTag().toString());
        if (!game_active) {
            game_reset(view);
        }
        if (game_state[tapped_image] == 2) {
            game_state[tapped_image] = player;
            img.setTranslationY(-1000f);
            if (player == 0) {
                img.setImageResource(R.drawable.x_nobackg);
                player = 1;
                TextView status = findViewById(R.id.status);
                status.setText("Play O");
            } else {
                img.setImageResource(R.drawable.o);
                player = 0;
                TextView status = findViewById(R.id.status);
                status.setText("Play X");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for (int[] win_positions : win_positions) {
            if (game_state[win_positions[0]] == game_state[win_positions[1]] &&
                    game_state[win_positions[1]] == game_state[win_positions[2]] &&game_state[win_positions[0]] != 2) {
                        game_active = false;

                    if (game_state[win_positions[0]] == 0) {
                        outcome = "X has won";
                    } else if (game_state[win_positions[0]] == 1){
                        outcome = "O has won";

                    }

                    TextView status = findViewById(R.id.status);
                    status.setText(outcome);
                }
            else if (game_state[0]!=2 && game_state[1]!=2 && game_state[2]!=2  && game_state[3]!=2  &&game_state[4]!=2 &&
                    game_state[5]!=2 && game_state[6]!=2 && game_state[7]!=2 &&game_state[8]!=2 &&game_state[win_positions[0]] != game_state[win_positions[1]] &&
                    game_state[win_positions[1]] != game_state[win_positions[2]]){
                game_active = false;
                outcome = "Draw";
                TextView status = findViewById(R.id.status);
                status.setText(outcome);
            }

            }

            }


    public void game_reset(View view){
        game_active=true;
        for (int i = 0 ; i<game_state.length;i++){
            game_state[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView21)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView22)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView23)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView24)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView25)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView26)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView27)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView28)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView29)).setImageResource(0);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}