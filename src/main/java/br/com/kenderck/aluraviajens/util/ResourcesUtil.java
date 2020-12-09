package br.com.kenderck.aluraviajens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourcesUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable devolveUmDrawable(Context context, String drawableEmTexto ) {

        Resources resources = context.getResources();//pegar os recursos do contexto
        Resources.Theme tema = context.getTheme();
        int idDoDrawable = resources.getIdentifier(drawableEmTexto, DRAWABLE, context.getPackageName());//pega um identificador
        return resources.getDrawable(idDoDrawable, tema);
    }
}
