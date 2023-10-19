package com.example.sudokuesqueleto;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DificultadDialog extends DialogFragment {

    DificultadDialogListener listener;
    private int dificultad;

    public DificultadDialog(int dificultad) {
        this.dificultad = dificultad;
    }

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Dificultad");
        String[] arrayDificultad = new String[3];
        arrayDificultad[0] = "Facil";
        arrayDificultad[1] = "Normal";
        arrayDificultad[2] = "Dificil";
        builder.setSingleChoiceItems(arrayDificultad, this.dificultad, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.setDificult(DificultadDialog.this,i);
            }
        }).setPositiveButton("Volver", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogPositiveClick(DificultadDialog.this);
                dismiss();
            }

        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener  = (DificultadDialogListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }
}
