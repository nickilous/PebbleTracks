package com.nickilous.broadcastreceivers.pebble;

import java.util.UUID;

import org.json.JSONException;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.getpebble.android.kit.util.PebbleDictionary;

public  class PebbleWatchBroadcastReceiver extends BroadcastReceiver {
	public PebbleWatchBroadcastReceiver() {
	}

	/**
     * Perform some work on the data received from the connected watch.
     *
     * @param context
     *         The BroadcastReceiver's context.
     * @param transactionId
     *         The transaction ID of the message in which the data was received. This is required when ACK/NACKing
     *         the received message.
     * @param data
     *         A dictionary of one-or-more key-value pairs received from the connected watch.
     */
    public  void receiveData(final Context context, final int transactionId, final PebbleDictionary data);

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReceive(final Context context, final Intent intent) {
        final UUID receivedUuid = (UUID) intent.getSerializableExtra(APP_UUID);

        // Pebble-enabled apps are expected to be good citizens and only inspect broadcasts containing their UUID
        if (!subscribedUuid.equals(receivedUuid)) {
            return;
        }

        final int transactionId = intent.getIntExtra(TRANSACTION_ID, -1);
        final String jsonData = intent.getStringExtra(MSG_DATA);
        if (jsonData == null || jsonData.isEmpty()) {
            return;
        }

        try {
            final PebbleDictionary data = PebbleDictionary.fromJson(jsonData);
            receiveData(context, transactionId, data);
        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }
    }
}



