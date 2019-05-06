package com.daniele.fisiohome;

import android.content.Context;
import android.app.Application;

import com.daniele.fisiohome.model.Disponibilidade;
import com.daniele.fisiohome.model.Fisioterapeuta;

public class FisioHome extends Application {

    private static Context context;
    private static Fisioterapeuta fisioterapeutaAtual;
    private static Disponibilidade disponibilidadeAtual;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        FisioHome.context = context;
    }

    public static Fisioterapeuta getFisioterapeutaAtual() {
        return fisioterapeutaAtual;
    }

    public static void setFisioterapeutaAtual(Fisioterapeuta fisioterapeutaAtual) {
        FisioHome.fisioterapeutaAtual = fisioterapeutaAtual;
    }

    public static Disponibilidade getDisponibilidadeAtual() {
        return disponibilidadeAtual;
    }

    public static void setDisponibilidadeAtual(Disponibilidade disponibilidadeAtual) {
        FisioHome.disponibilidadeAtual = disponibilidadeAtual;
    }
}
