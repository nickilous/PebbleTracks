package com.nickilous.broadcastreceivers.pebble;

import java.util.UUID;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * A special-purpose BroadcastReceiver that makes it easy to handle 'RECEIVE_ACK' intents broadcast from pebble
 * .apk.
 */
public class PebbleAckBroadcastReceiver extends BroadcastReceiver {
    private final UUID subscribedUuid;

    protected PebbleAckBroadcastReceiver(final UUID subscribedUuid) {
        this.subscribedUuid = subscribedUuid;
    }

    /**
     * Handle the ACK received from the connected watch.
     *
     * @param context
     *         The BroadcastReceiver's context.
     * @param transactionId
     *         The transaction ID of the message for which the ACK was received. This indicates which message was
     *         successfully received.
     */
    //public abstract void receiveAck(final Context context, final int transactionId);

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReceive(final Context context, final Intent intent) {
        final int transactionId = intent.getIntExtra(TRANSACTION_ID, -1);
        //receiveAck(context, transactionId);

    }
}
