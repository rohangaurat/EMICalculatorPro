package com.demo.cashloanemi.Activity;

import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Words {
    public static String convertToIndianCurrency(String str) {
        String str2;
        String str3;
        String str4;
        BigDecimal bigDecimal = new BigDecimal(str);
        bigDecimal.longValue();
        long longValue = bigDecimal.longValue();
        int doubleValue = (int) (bigDecimal.remainder(BigDecimal.ONE).doubleValue() * 100.0d);
        int length = String.valueOf(longValue).length();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        int i = 0;
        String str5 = "";
        hashMap.put(0, str5);
        hashMap.put(1, "One");
        int i2 = 2;
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        hashMap.put(4, "Four");
        hashMap.put(5, "Five");
        hashMap.put(6, "Six");
        hashMap.put(7, "Seven");
        hashMap.put(8, "Eight");
        hashMap.put(9, "Nine");
        int i3 = 10;
        hashMap.put(10, "Ten");
        hashMap.put(11, "Eleven");
        hashMap.put(12, "Twelve");
        hashMap.put(13, "Thirteen");
        hashMap.put(14, "Fourteen");
        hashMap.put(15, "Fifteen");
        hashMap.put(16, "Sixteen");
        hashMap.put(17, "Seventeen");
        hashMap.put(18, "Eighteen");
        hashMap.put(19, "Nineteen");
        hashMap.put(20, "Twenty");
        hashMap.put(30, "Thirty");
        hashMap.put(40, "Forty");
        hashMap.put(50, "Fifty");
        hashMap.put(60, "Sixty");
        hashMap.put(70, "Seventy");
        hashMap.put(80, "Eighty");
        hashMap.put(90, "Ninety");
        String[] strArr = {"", "Hundred", "Thousand", "Lakh", "Crore", "Arab", "Kharab", "Nil", "Padma", "Shankh"};
        while (i < length) {
            int i4 = i == i2 ? i3 : 100;
            long j = (long) i4;
            String str6 = str5;
            long j2 = longValue % j;
            longValue /= j;
            i += i4 == i3 ? 1 : i2;
            if (j2 > 0) {
                int size = arrayList.size();
                String str7 = (size <= 0 || j2 <= 9) ? str6 : "s";
                if (j2 < 21) {
                    str4 = ((String) hashMap.get(Integer.valueOf((int) j2))) + " " + strArr[size] + str7;
                } else {
                    StringBuilder sb = new StringBuilder();
                    i3 = 10;
                    sb.append((String) hashMap.get(Integer.valueOf(((int) Math.floor((double) (j2 / 10))) * 10)));
                    sb.append(" ");
                    sb.append((String) hashMap.get(Integer.valueOf((int) (j2 % 10))));
                    sb.append(" ");
                    sb.append(strArr[size]);
                    sb.append(str7);
                    str4 = sb.toString();
                }
                arrayList.add(str4);
                str3 = str6;
            } else {
                str3 = str6;
                arrayList.add(str3);
            }
            str5 = str3;
            i2 = 2;
        }
        String str8 = str5;
        Collections.reverse(arrayList);
        String trim = TextUtils.join(" ", arrayList).trim();
        if (doubleValue > 0) {
            StringBuilder sb2 = new StringBuilder(" And ");
            int i5 = doubleValue % 10;
            sb2.append((String) hashMap.get(Integer.valueOf(doubleValue - i5)));
            sb2.append(" ");
            sb2.append((String) hashMap.get(Integer.valueOf(i5)));
            str2 = sb2.toString();
        } else {
            str2 = str8;
        }
        if (!str2.isEmpty()) {
            str2 = str2.concat(" Paise");
        }
        return (trim + str2).replace("  ", " ").replace("   ", " ");
    }
}
