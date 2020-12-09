package br.com.kenderck.aluraviajens.util;

public class DiasUtil {

    public static final String DIAS = " dias";
    public static final String DIA = " dia";

    public static String formataDiasEmTexto(int qtdDias) {

        if (qtdDias > 1) {
            return qtdDias + DIAS;
        }
        return qtdDias + DIA;

    }
}
