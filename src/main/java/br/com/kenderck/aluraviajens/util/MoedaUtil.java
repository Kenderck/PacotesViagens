package br.com.kenderck.aluraviajens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String LANGUAGE = "pt";
    public static final String COUNTRY = "br";
    public static final String CRIFRAO = "R$";
    public static final String CIFRAO_COM_ESPACO = "R$ ";

    public static String formataMoeda(BigDecimal precoPacote) {
        NumberFormat formatoBr = DecimalFormat.getCurrencyInstance(new Locale(LANGUAGE, COUNTRY));//pega o formato de moeeda dependeod do local
        return formatoBr.format(precoPacote).replace(CRIFRAO, CIFRAO_COM_ESPACO);
    }
}
