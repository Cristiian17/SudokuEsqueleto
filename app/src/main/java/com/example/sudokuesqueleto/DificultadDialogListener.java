package com.example.sudokuesqueleto;

import androidx.fragment.app.DialogFragment;

public interface DificultadDialogListener {
    public void onDialogPositiveClick(DialogFragment dialogFragment);
    public void setDificult(DialogFragment dialogFragment, int dificult);
}
