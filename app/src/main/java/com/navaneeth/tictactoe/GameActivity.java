package com.navaneeth.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private TextView one;
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView eight;
    private TextView nine;
    private Button playAgain;
    private Button computerPlayAgain;
    private TextView gameResult;
    private char[][] board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        String msg = intent.getStringExtra("key");

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        playAgain = findViewById(R.id.play_again);
        computerPlayAgain = findViewById(R.id.computer_play_again);
        gameResult = findViewById((R.id.GameResult));

        board = new char[3][3];
        initializeBoard(board);
        playAgain.setVisibility(View.INVISIBLE);
        gameResult.setVisibility(View.INVISIBLE);
        computerPlayAgain.setVisibility((View.INVISIBLE));

        if(msg.equals("true"))
            computerMove(board);
        one.setOnClickListener(view -> {
            TextView clicked = findViewById(view.getId());
            if (board[0][0] == 'X' || board[0][0] == 'O') {
                Toast.makeText(getApplicationContext(), "Position is not empty!", Toast.LENGTH_SHORT).show();
            } else {
                clicked.setText("X");
                board[0][0] = 'X';
                if (!checkCompletion(board))
                    computerMove(board);
            }
        });

        two.setOnClickListener(view -> {
            TextView clicked = findViewById(view.getId());
            if (board[0][1] == 'X' || board[0][1] == 'O') {
                Toast.makeText(getApplicationContext(), "Position is not empty!", Toast.LENGTH_SHORT).show();
            } else {
                clicked.setText("X");
                board[0][1] = 'X';
                if (!checkCompletion(board))
                    computerMove(board);
            }
        });

        three.setOnClickListener(view -> {
            TextView clicked = findViewById(view.getId());
            if (board[0][2] == 'X' || board[0][2] == 'O') {
                Toast.makeText(getApplicationContext(), "Position is not empty!", Toast.LENGTH_SHORT).show();
            } else {
                clicked.setText("X");
                board[0][2] = 'X';
                if (!checkCompletion(board))
                    computerMove(board);
            }
        });

        four.setOnClickListener(view -> {
            TextView clicked = findViewById(view.getId());
            if (board[1][0] == 'X' || board[1][0] == 'O') {
                Toast.makeText(getApplicationContext(), "Position is not empty!", Toast.LENGTH_SHORT).show();
            } else {
                clicked.setText("X");
                board[1][0] = 'X';
                if (!checkCompletion(board)) ;
                computerMove(board);
            }
        });

        five.setOnClickListener(view -> {
            TextView clicked = findViewById(view.getId());
            if (board[1][1] == 'X' || board[1][1] == 'O') {
                Toast.makeText(getApplicationContext(), "Position is not empty!", Toast.LENGTH_SHORT).show();
            } else {
                clicked.setText("X");
                board[1][1] = 'X';
                if (!checkCompletion(board)) ;
                computerMove(board);
            }
        });

        six.setOnClickListener(view -> {
            TextView clicked = findViewById(view.getId());
            if (board[1][2] == 'X' || board[1][2] == 'O') {
                Toast.makeText(getApplicationContext(), "Position is not empty!", Toast.LENGTH_SHORT).show();
            } else {
                clicked.setText("X");
                board[1][2] = 'X';
                if (!checkCompletion(board))
                    computerMove(board);
            }
        });

        seven.setOnClickListener(view -> {
            TextView clicked = findViewById(view.getId());
            if (board[2][0] == 'X' || board[2][0] == 'O') {
                Toast.makeText(getApplicationContext(), "Position is not empty!", Toast.LENGTH_SHORT).show();
            } else {
                clicked.setText("X");
                board[2][0] = 'X';
                if (!checkCompletion(board))
                    computerMove(board);
            }
        });

        eight.setOnClickListener(view -> {
            TextView clicked = findViewById(view.getId());
            if (board[2][1] == 'X' || board[2][1] == 'O') {
                Toast.makeText(getApplicationContext(), "Position is not empty!", Toast.LENGTH_SHORT).show();
            } else {
                clicked.setText("X");
                board[2][1] = 'X';
                if (!checkCompletion(board))
                    computerMove(board);
            }
        });

        nine.setOnClickListener(view -> {
            TextView clicked = findViewById(view.getId());
            if (board[2][2] == 'X' || board[2][2] == 'O') {
                Toast.makeText(getApplicationContext(), "Position is not empty!", Toast.LENGTH_SHORT).show();
            } else {
                clicked.setText("X");
                board[2][2] = 'X';
                if (!checkCompletion(board))
                    computerMove(board);
            }
        });

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetBoard(board);
                playAgain.setVisibility(View.INVISIBLE);
                computerPlayAgain.setVisibility(View.INVISIBLE);
                gameResult.setVisibility(View.INVISIBLE);
            }
        });

        computerPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetBoard(board);
                playAgain.setVisibility(View.INVISIBLE);
                computerPlayAgain.setVisibility(View.INVISIBLE);
                gameResult.setVisibility(View.INVISIBLE);
                computerMove(board);
            }
        });
    }

    void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    char isGameOver(char[][] board) {
        int i, j;
        for (i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')
                return board[i][0];
        }

        for (j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ')
                return board[0][j];
        }

        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) && board[1][1] != ' ')
            return board[1][1];

        if((board[0][2] == board[1][1] && board[1][1] == board[2][0]) && board[1][1] != ' ')
            return board[1][1];

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return 'N';
        }
        return 'D';
    }

    void computerMove(char[][] board) {
        int[] XY = bestMove(board);
        int x = XY[0], y = XY[1];
        board[x][y] = 'O';
        if (x == 0 && y == 0)
            one.setText("O");
        else if (x == 0 && y == 1)
            two.setText("O");
        else if (x == 0 && y == 2)
            three.setText("O");
        else if (x == 1 && y == 0)
            four.setText("O");
        else if (x == 1 && y == 1)
            five.setText("O");
        else if (x == 1 && y == 2)
            six.setText("O");
        else if (x == 2 && y == 0)
            seven.setText("O");
        else if (x == 2 && y == 1)
            eight.setText("O");
        else
            nine.setText("O");
        checkCompletion(board);
    }

    int[] bestMove(char[][] board) {
        int i, j, score, maxScore = -2147483647;
        int[] BestMove = {-1, -1};
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                    score = minimax(board, 0, false);
                    board[i][j] = ' ';
                    if (score > maxScore) {
                        BestMove[0] = i;
                        BestMove[1] = j;
                        maxScore = score;
                    }
                }
            }
        }
        return BestMove;
    }

    int minimax(char[][] board, int depth, boolean isMaximizing) {
        char winner = isGameOver(board);
        if (winner != 'N') {
            int gain;
            if (winner == 'X') {
                gain = -10 + depth;
            } else if (winner == 'O') {
                gain = 10 - depth;
            } else {
                gain = 0;
            }
            return gain;
        }

        if (isMaximizing) {
            int i, j, score = -2147483647;
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'O';
                        score = Math.max(score, minimax(board, depth + 1, false));
                        board[i][j] = ' ';
                    }
                }
            }
            return score;
        } else {
            int i, j, score = 2147483647;
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'X';
                        score = Math.min(score, minimax(board, depth + 1, true));
                        board[i][j] = ' ';
                    }
                }
            }
            return score;
        }
    }

    boolean checkCompletion(char[][] board) {
        int i, j;
        boolean winner = false;
        String status = "";
        for (i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                winner = true;
                status = "Winner is " + board[i][0];
                if (i == 0) {
                    one.setTextColor(Color.parseColor("#FF0000"));
                    two.setTextColor(Color.parseColor("#FF0000"));
                    three.setTextColor(Color.parseColor("#FF0000"));
                } else if (i == 1) {
                    four.setTextColor(Color.parseColor("#FF0000"));
                    five.setTextColor(Color.parseColor("#FF0000"));
                    six.setTextColor(Color.parseColor("#FF0000"));
                } else {
                    seven.setTextColor(Color.parseColor("#FF0000"));
                    eight.setTextColor(Color.parseColor("#FF0000"));
                    nine.setTextColor(Color.parseColor("#FF0000"));
                }
            }
        }

        for (j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
                winner = true;
                status = "Winner is " + board[0][j];
                if (j == 0) {
                    one.setTextColor(Color.parseColor("#FF0000"));
                    four.setTextColor(Color.parseColor("#FF0000"));
                    seven.setTextColor(Color.parseColor("#FF0000"));
                } else if (j == 1) {
                    two.setTextColor(Color.parseColor("#FF0000"));
                    five.setTextColor(Color.parseColor("#FF0000"));
                    eight.setTextColor(Color.parseColor("#FF0000"));
                } else {
                    three.setTextColor(Color.parseColor("#FF0000"));
                    six.setTextColor(Color.parseColor("#FF0000"));
                    nine.setTextColor(Color.parseColor("#FF0000"));
                }
            }
        }

        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) && board[1][1] != ' ') {
            winner = true;
            status = "Winner is " + board[1][1];
            one.setTextColor(Color.parseColor("#FF0000"));
            five.setTextColor(Color.parseColor("#FF0000"));
            nine.setTextColor(Color.parseColor("#FF0000"));
        }

        if ((board[0][2] == board[1][1] && board[1][1] == board[2][0]) && board[1][1] != ' ') {
            winner = true;
            status = "Winner is " + board[1][1];
            three.setTextColor(Color.parseColor("#FF0000"));
            five.setTextColor(Color.parseColor("#FF0000"));
            seven.setTextColor(Color.parseColor("#FF0000"));
        }
        if (winner) {
            playAgain.setVisibility(View.VISIBLE);
            gameResult.setVisibility(View.VISIBLE);
            computerPlayAgain.setVisibility(View.VISIBLE);
            gameResult.setText(status);

            one.setEnabled(false);
            two.setEnabled(false);
            three.setEnabled(false);
            four.setEnabled(false);
            five.setEnabled(false);
            six.setEnabled(false);
            seven.setEnabled(false);
            eight.setEnabled(false);
            nine.setEnabled(false);

            return true;
        }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        }
        status = "It's a Draw!";
        playAgain.setVisibility(View.VISIBLE);
        computerPlayAgain.setVisibility(View.VISIBLE);
        gameResult.setVisibility(View.VISIBLE);
        gameResult.setText(status);
        return true;
    }

    void ResetBoard(char [][] board){
        initializeBoard(board);

        one.setText("");
        two.setText("");
        three.setText("");
        four.setText("");
        five.setText("");
        six.setText("");
        seven.setText("");
        eight.setText("");
        nine.setText("");

        one.setTextColor(Color.parseColor("#000000"));
        two.setTextColor(Color.parseColor("#000000"));
        three.setTextColor(Color.parseColor("#000000"));
        four.setTextColor(Color.parseColor("#000000"));
        five.setTextColor(Color.parseColor("#000000"));
        six.setTextColor(Color.parseColor("#000000"));
        seven.setTextColor(Color.parseColor("#000000"));
        eight.setTextColor(Color.parseColor("#000000"));
        nine.setTextColor(Color.parseColor("#000000"));

        one.setEnabled(true);
        two.setEnabled(true);
        three.setEnabled(true);
        four.setEnabled(true);
        five.setEnabled(true);
        six.setEnabled(true);
        seven.setEnabled(true);
        eight.setEnabled(true);
        nine.setEnabled(true);

    }
}