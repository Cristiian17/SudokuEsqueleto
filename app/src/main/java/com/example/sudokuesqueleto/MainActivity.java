package com.example.sudokuesqueleto;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, DificultadDialogListener {

    private GameBoard board;

    private int[][] sudokuSolved;
    private ActionBar actionBar;
    private final int FACIL = 40;;
    private final int MEDIO = 50;;
    private final int DIFICIL = 60;;
    private int selectedDificult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board = findViewById(R.id.gameBoard);
        board.setFragmentManager(getSupportFragmentManager());
        selectedDificult = 0;
        sudokuSolved = board.getSudokuResolv();
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1d2323")));
        generarBotones();
    }
    public void generarBotones() {
        GridLayout layout = findViewById(R.id.mi_grid);
        Button btn;

        for (int i = 1; i < 10; i++) {
            btn = new Button(this);
            // Configurar márgenes en el botón
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.setMargins(10,10, 10,10 );
            btn.setLayoutParams(params);
            btn.setText("" + i);
            btn.setId(View.generateViewId());
            btn.setOnClickListener(this);
            //Clase para dar estilo a los botones
            GradientDrawable gradientDrawable = new GradientDrawable();
            //Con esto le pone el borderRadius
            gradientDrawable.setCornerRadius(50f);
            gradientDrawable.setColor(Color.parseColor("#1d2323"));
            btn.setBackground(gradientDrawable);
            btn.setTextColor(Color.WHITE);
            layout.addView(btn);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mi_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.comoJugar:
                JuegoDialog dialog = new JuegoDialog();
                dialog.show(getSupportFragmentManager(),"¿Como jugar?");
                return true;
            case R.id.dificultad:
                DificultadDialog dialog1 = new DificultadDialog(selectedDificult);
                dialog1.show(getSupportFragmentManager(),"Dificultad");
                return true;
            case R.id.nuevaPartida:
                board.resetBoard(selectedDificult == 0 ? FACIL : selectedDificult == 1 ? MEDIO : DIFICIL);
                return true;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view.getClass().getSimpleName().equals("Button")){
            Button b = (Button) view;
            board.setInputNumber(Integer.parseInt((String) b.getText()));

        }
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialogFragment) {
        String dificult = "";
        switch (selectedDificult){
            case 0 :
                dificult = "Facil";
                break;
            case 1 :
                dificult = "Normal";
                break;
            case 2 :
                dificult = "Dificil";
                break;
        }
        Toast.makeText(this, "Nivel de dificultad: " + dificult, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setDificult(DialogFragment dialogFragment, int dificult) {
        switch (dificult){
            case 0:
                selectedDificult = 0;
                board.resetBoard(FACIL);
                break;
            case 1:
                selectedDificult = 1;
                board.resetBoard(MEDIO);
                break;
            case 2:
                selectedDificult = 2;
                board.resetBoard(DIFICIL);
                break;
        }
    }
}