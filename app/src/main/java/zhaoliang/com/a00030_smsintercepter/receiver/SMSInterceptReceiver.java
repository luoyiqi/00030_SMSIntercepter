package zhaoliang.com.a00030_smsintercepter.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSInterceptReceiver extends BroadcastReceiver {
    public SMSInterceptReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // 解析短信
        Bundle extras = intent.getExtras();
        Object[] pdus = (Object[]) extras.get("pdus");
        for (Object pdu : pdus) {
            SmsMessage message = SmsMessage.createFromPdu((byte[]) pdu);
            System.out.println(message.getOriginatingAddress());
            System.out.println(message.getMessageBody());
        }
        // 中断短信广播
        abortBroadcast();
    }
}
