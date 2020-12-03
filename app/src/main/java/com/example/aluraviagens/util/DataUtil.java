package com.example.aluraviagens.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    public static String conveterPeriodoEmTexto(int dias) {
        Calendar dataDeIda = Calendar.getInstance();
        Calendar dataDeVota = Calendar.getInstance();
        dataDeVota.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat(DIA_E_MES);
        String dataFormatadaDeida = formatoBrasileiro.format(dataDeIda.getTime());
        String dataFormatadaDeVolta = formatoBrasileiro.format(dataDeVota.getTime());
        return dataFormatadaDeida + " - " + dataFormatadaDeVolta + " de " + dataDeVota.get(Calendar.YEAR);
    }
}
