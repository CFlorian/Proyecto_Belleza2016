package intecap.gt.proyecto_belleza2016.utilidades;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;


public class Alert {


    public static void alert(Context context, String title, String cuerpo, final OnAction action){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title).setMessage(cuerpo).setNeutralButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                action.onAction();
            }
        });
        AlertDialog alerta = builder.create();
        builder.show();
    }

    public static void alert(Context context, AlertAdapter data, final OnAction action){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(data.getBody())
                .setTitle(data.getTitle()).setCancelable(data.isCancel())
                .setIcon(data.getDrawable());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    action.onAction();
                }
            }
        });
        AlertDialog alerta = builder.create();
        try{
            builder.show();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static class AlertAdapter{
        private String title;
        private String body;
        private Drawable d;
        private boolean cancel = false;

        public AlertAdapter(String title, String body, boolean cancel, Drawable drawable){
            this.title = title;
            this.body = body;
            this.cancel = cancel;
            d = drawable;
        }

        public String getTitle() {
            return title;
        }

        public String getBody() {
            return body;
        }

        public boolean isCancel() {
            return cancel;
        }

        public Drawable getDrawable() {
            return d;
        }
    }
}
