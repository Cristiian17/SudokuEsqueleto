package com.example.sudokuesqueleto;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class JuegoDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("¿Como jugar?");
        builder.setMessage("Cada fila, columna y cuadrado (9 espacios cada uno) debe completarse con los número" +
                "del 1 al 9, sin repetir ningún número de la fila, columna o cuadrado");

        return builder.create();
    }
}
