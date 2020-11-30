package com.example.aluraviagens.util;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formatarEmTexto(int qtdeDias) {
        if (qtdeDias > 1) {
            return qtdeDias + PLURAL;
        }
        return qtdeDias + SINGULAR;
    }
}
