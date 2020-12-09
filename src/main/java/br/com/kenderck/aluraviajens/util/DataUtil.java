package br.com.kenderck.aluraviajens.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_MES = "dd/MM";

    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();//paga o dia de hoje
        Calendar dataVolta = Calendar.getInstance();

        dataVolta.add(Calendar.DATE, dias);//campo que quer add, dias ou mes ou ano, DATE para adicionar data

        SimpleDateFormat formatoBrasileiroData = new SimpleDateFormat(DIA_MES);//formata uma data para esse formato
        String dataFormatadaIda = formatoBrasileiroData.format(dataIda.getTime());//formata essa data para o formato dd/MM
        String dataFormatadaVolta = formatoBrasileiroData.format(dataVolta.getTime());//formata essa data para o formato dd/MM

        return dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataVolta.get(Calendar.YEAR);
    }
}
