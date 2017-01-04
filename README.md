# 短信拦截器

### 短信拦截广播 关键代码
```xml 
<uses-permission android:name="android.permission.RECEIVE_SMS"/>
  
<intent-filter android:priority="1000">
      <action android:name="android.provider.Telephony.SMS_RECEIVED"/>
</intent-filter>
```
```java
ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, 1);
```
```java
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
```

### 效果图
![](https://github.com/BruceAnda/00030_SMSIntercepter/blob/master/screenshot/pic.png)
![](https://github.com/BruceAnda/00030_SMSIntercepter/blob/master/screenshot/pic2.png)
