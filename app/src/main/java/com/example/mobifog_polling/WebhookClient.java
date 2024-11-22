package com.example.mobifog_polling;

import android.content.Context;
import android.util.Log;

import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

public class WebhookClient {

    private static final String TAG = "WebhookClient"; //Tag per il log
    private final Context context; // Contesto dell'applicazione



    /* Costruttore della classe, recupera il context, assegna l'URL e instanzia un client HTTP  */

    public WebhookClient(Context context) {
        this.context = context;
    }


    //Metodo per inviare una richiesta HTTP POST all'orchestratore per registrare gli eventi
    public void registerWebhook() {

        WorkRequest registerWebhookWorkRequest = new OneTimeWorkRequest.Builder(RegisterWebhookWorker.class)
                .setConstraints(new Constraints.Builder() // Vincolo di connessione a internet
                .setRequiredNetworkType(NetworkType.CONNECTED).build())
                .build();

        WorkManager.getInstance(context).enqueue(registerWebhookWorkRequest);

    }


    // Metodo per chiamare periodicamente PollingWorker in modo da attiavre il polling
    public void startPeriodicPolling() {
        WorkRequest pollingWorkRequest = new OneTimeWorkRequest.Builder(PollingWorker.class) //Creazione delle richieste ogni minuto
                .setConstraints(new Constraints.Builder() // Vincolo di connessione a internet
                .setRequiredNetworkType(NetworkType.CONNECTED).build())
                .build();

        WorkManager.getInstance(context).enqueue(pollingWorkRequest);
        Log.d(TAG, "Polling periodico avviato.");
    }

    // Metdo per fermare il polling
    public static void stopPeriodicPolling(Context context) {
        WorkManager.getInstance(context).cancelUniqueWork("PollingWork");
        Log.d(TAG, "Polling periodico fermato.");
    }
}