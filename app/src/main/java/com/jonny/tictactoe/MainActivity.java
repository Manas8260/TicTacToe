package com.jonny.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameActive = true;
    //player representation
    //0 = x
    //1 - o
    int activePlayer = 0 ;
    int [] gameState = {2,2,2,2,2,2,2,2,2};
    //state means
    // 0 = x
    // 1 = o
    // 2 = null
    int [][]winPos = {{0,1,2},{3,4,5},{6,7,8},
                     {0,3,6},{1,4,7},{2,5,8},
                     {0,4,8},{2,4,6}};

    public void playerTap(View view){
        ImageView img = (ImageView)view;
        int tappedImage =Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            finish(view);
        }
        if(gameState[tappedImage] == 2 ) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText(getResources().getString(R.string.playo));
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText(getResources().getString(R.string.Playx));
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }
        //check if any player has won
        for(int[] winPo : winPos) {

            if(gameState[winPo[0]] == gameState[winPo[1]] && gameState[winPo[1]] == gameState[winPo[2]] && gameState[winPo[0]] != 2){
                //Somebody Won - Find Out Who
                String winnerstr ;
                gameActive = false;
                if(gameState[winPo[0]] == 0 ) {
                    winnerstr = "    X has Won\n";
                }else{
                    winnerstr = "    O has won\n";
                }
                // update The status bar for announcement  of winner
                TextView status = findViewById(R.id.status);
                status.setText(winnerstr+"Click to restart");
            }
        }
        if(gameActive) {
            if ((gameState[0] == 0 || gameState[0] == 1) &&
               (gameState[1] == 0 || gameState[1] == 1) &&
               (gameState[2] == 0 || gameState[2] == 1) &&
               (gameState[3] == 0 || gameState[3] == 1) &&
               (gameState[4] == 0 || gameState[4] == 1) &&
               (gameState[5] == 0 || gameState[5] == 1) &&
               (gameState[6] == 0 || gameState[6] == 1) &&
               (gameState[7] == 0 || gameState[7] == 1) &&
               (gameState[8] == 0 || gameState[8] == 1)) {
                gameActive = false;
                String str = "      Match draw\n";
                TextView status = findViewById(R.id.status); 
                status.setText(str + "Go to restart Button");

            }
        }

    }
    public void gameReset(View view){

        gameActive = true;
        activePlayer = 0;
        int i=0;
        for(i = 0 ; i < gameState.length ; i++){
            gameState[i] = 2;
        }

        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText(getResources().getString(R.string.Playx));



    }
    public void finish(View view){
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


        }
    public void textAgain(){
            TextView restart_play = findViewById(R.id.restart_text2);
            restart_play.setText((getResources().getString(R.string.restart_play)));
            restart_play.setTranslationX(0f);
            restart_play.animate().translationX(-1000f).setDuration(5000);
        }
    public void restartGame(View view){
        gameReset(view);
        textAgain();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView restart_play = findViewById(R.id.restart_text2);
        restart_play.setText((getResources().getString(R.string.restart_sp)));
        restart_play.setTranslationX(0f);
        restart_play.animate().translationX(1000f).setDuration(5000);


        ConstraintLayout cons= findViewById(R.id.cons);
        AnimationDrawable anim=(AnimationDrawable) cons.getBackground();
        anim.setEnterFadeDuration(2500);
        anim.setExitFadeDuration(5000);
        anim.start();
    }
}