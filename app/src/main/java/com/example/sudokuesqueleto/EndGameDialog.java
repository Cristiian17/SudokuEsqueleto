package com.example.sudokuesqueleto;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;


import androidx.fragment.app.DialogFragment;

public class EndGameDialog extends DialogFragment {
    private EndGameListener listener;
    private String texto;
    private String titulo;
    public EndGameDialog(String titulo, String texto){
        this.texto = texto;
        this.titulo = titulo;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(titulo);
        builder.setMessage(texto);
        builder.setPositiveButton("Reiniciar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.resset(EndGameDialog.this);
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener  = (EndGameListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }
}
