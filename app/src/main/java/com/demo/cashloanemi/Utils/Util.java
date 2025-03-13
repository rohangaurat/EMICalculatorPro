package com.demo.cashloanemi.Utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.demo.cashloanemi.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static ArrayList<Integer> backingCalculatorIconList;
    public static ArrayList<String> backingCalculatorNameList;
    public static ArrayList<Integer> businessCalculatorIconList;
    public static ArrayList<String> businessCalculatorList;
    public static List<String> currencyCode = new ArrayList();
    public static ArrayList<Integer> loanCalculatorIconList;
    public static ArrayList<String> loanCalculatorNameList;
    public static ArrayList<Integer> sipCalculatorIconList;
    public static ArrayList<String> sipCalculatorList;

    public static List<String> getCurrencyCode() {
        currencyCode.clear();
        currencyCode.add("AED");
        currencyCode.add("AFN");
        currencyCode.add("ALL");
        currencyCode.add("AMD");
        currencyCode.add("ANG");
        currencyCode.add("AOA");
        currencyCode.add("ARS");
        currencyCode.add("AUD");
        currencyCode.add("AWG");
        currencyCode.add("AZN");
        currencyCode.add("BAM");
        currencyCode.add("BBD");
        currencyCode.add("BDT");
        currencyCode.add("BGN");
        currencyCode.add("BHD");
        currencyCode.add("BIF");
        currencyCode.add("BMD");
        currencyCode.add("BND");
        currencyCode.add("BOB");
        currencyCode.add("BRL");
        currencyCode.add("BSD");
        currencyCode.add("BTN");
        currencyCode.add("BWP");
        currencyCode.add("BZD");
        currencyCode.add("CAD");
        currencyCode.add("CDF");
        currencyCode.add("CHF");
        currencyCode.add("CLF");
        currencyCode.add("CLP");
        currencyCode.add("CNH");
        currencyCode.add("CNY");
        currencyCode.add("COP");
        currencyCode.add("CUP");
        currencyCode.add("CVE");
        currencyCode.add("CZK");
        currencyCode.add("DJF");
        currencyCode.add("DKK");
        currencyCode.add("DOP");
        currencyCode.add("DZD");
        currencyCode.add("EGP");
        currencyCode.add("ERN");
        currencyCode.add("ETB");
        currencyCode.add("EUR");
        currencyCode.add("FJD");
        currencyCode.add("FKP");
        currencyCode.add("GBP");
        currencyCode.add("GEL");
        currencyCode.add("GHS");
        currencyCode.add("GIP");
        currencyCode.add("GMD");
        currencyCode.add("GNF");
        currencyCode.add("GTQ");
        currencyCode.add("GYD");
        currencyCode.add("HKD");
        currencyCode.add("HNL");
        currencyCode.add("HRK");
        currencyCode.add("HTG");
        currencyCode.add("HUF");
        currencyCode.add("IDR");
        currencyCode.add("ILS");
        currencyCode.add("INR");
        currencyCode.add("IQD");
        currencyCode.add("IRR");
        currencyCode.add("ISK");
        currencyCode.add("JMD");
        currencyCode.add("JOD");
        currencyCode.add("JPY");
        currencyCode.add("KES");
        currencyCode.add("KGS");
        currencyCode.add("KHR");
        currencyCode.add("KMF");
        currencyCode.add("KPW");
        currencyCode.add("KRW");
        currencyCode.add("KWD");
        currencyCode.add("KYD");
        currencyCode.add("KZT");
        currencyCode.add("LAK");
        currencyCode.add("LBP");
        currencyCode.add("LKR");
        currencyCode.add("LRD");
        currencyCode.add("LSL");
        currencyCode.add("LYD");
        currencyCode.add("MAD");
        currencyCode.add("MDL");
        currencyCode.add("MGA");
        currencyCode.add("MKD");
        currencyCode.add("MMK");
        currencyCode.add("MNT");
        currencyCode.add("MOP");
        currencyCode.add("MRU");
        currencyCode.add("MUR");
        currencyCode.add("MVR");
        currencyCode.add("MWK");
        currencyCode.add("MXN");
        currencyCode.add("MYR");
        currencyCode.add("MZN");
        currencyCode.add("NAD");
        currencyCode.add("NGN");
        currencyCode.add("NOK");
        currencyCode.add("NPR");
        currencyCode.add("NZD");
        currencyCode.add("OMR");
        currencyCode.add("PAB");
        currencyCode.add("PEN");
        currencyCode.add("PGK");
        currencyCode.add("PHP");
        currencyCode.add("PKR");
        currencyCode.add("PLN");
        currencyCode.add("PYG");
        currencyCode.add("QAR");
        currencyCode.add("RON");
        currencyCode.add("RSD");
        currencyCode.add("RUB");
        currencyCode.add("RWF");
        currencyCode.add("SAR");
        currencyCode.add("SCR");
        currencyCode.add("SDG");
        currencyCode.add("SEK");
        currencyCode.add("SGD");
        currencyCode.add("SHP");
        currencyCode.add("SLL");
        currencyCode.add("SOS");
        currencyCode.add("SRD");
        currencyCode.add("SYP");
        currencyCode.add("SZL");
        currencyCode.add("THB");
        currencyCode.add("TJS");
        currencyCode.add("TMT");
        currencyCode.add("TND");
        currencyCode.add("TOP");
        currencyCode.add("TRY");
        currencyCode.add("TTD");
        currencyCode.add("TWD");
        currencyCode.add("TZS");
        currencyCode.add("UAH");
        currencyCode.add("UGX");
        currencyCode.add("USD");
        currencyCode.add("UYU");
        currencyCode.add("UZS");
        currencyCode.add("VND");
        currencyCode.add("VUV");
        currencyCode.add("WST");
        currencyCode.add("XAF");
        currencyCode.add("XCD");
        currencyCode.add("XDR");
        currencyCode.add("XOF");
        currencyCode.add("XPF");
        currencyCode.add("YER");
        currencyCode.add("ZAR");
        currencyCode.add("ZMW");
        return currencyCode;
    }

    public static ArrayList<String> getLoanCalculatorNameList() {
        ArrayList<String> arrayList = new ArrayList<>();
        loanCalculatorNameList = arrayList;
        arrayList.add("Eligibility");
        loanCalculatorNameList.add("Compare");
        loanCalculatorNameList.add("Tip");
        return loanCalculatorNameList;
    }

    public static ArrayList<String> getBackingCalculatorNameList() {
        ArrayList<String> arrayList = new ArrayList<>();
        backingCalculatorNameList = arrayList;
        arrayList.add("Simple\nInterest");
        backingCalculatorNameList.add("Compound\nInterest ");
        backingCalculatorNameList.add(" Fixed\nDeposit");
        backingCalculatorNameList.add("Recurring\nDeposit");
        backingCalculatorNameList.add("PPF\nCalculator");
        backingCalculatorNameList.add("ROI\nCalculator ");
        backingCalculatorNameList.add("TVM\nCalculator");
        return backingCalculatorNameList;
    }

    public static ArrayList<String> getBusinessCalculatorList() {
        ArrayList<String> arrayList = new ArrayList<>();
        businessCalculatorList = arrayList;
        arrayList.add("GST\nCalculator");
        businessCalculatorList.add("Margin\nCalculator");
        businessCalculatorList.add("Operating\nMargin");
        businessCalculatorList.add("Margin\nWith Sales");
        businessCalculatorList.add("Sales Tax\nCalculator");
        businessCalculatorList.add("Break Event\nPoint");
        businessCalculatorList.add("VAT\nCalculator");
        businessCalculatorList.add("Cumulative\nGrowth");
        businessCalculatorList.add("Price\nCalculator");
        businessCalculatorList.add("Inflation\nCalculator");
        businessCalculatorList.add("Gross Profit\nCalculator");
        businessCalculatorList.add("Markup\nCalculator");
        businessCalculatorList.add("Tax\nCalculator");
        businessCalculatorList.add("Discount\nCalculator");
        return businessCalculatorList;
    }

    public static ArrayList<String> getSipCalculatorList() {
        ArrayList<String> arrayList = new ArrayList<>();
        sipCalculatorList = arrayList;
        arrayList.add("SIP\nCalculator");
        sipCalculatorList.add("SIP Plan\nCalculator");
        sipCalculatorList.add("STP\nCalculator");
        sipCalculatorList.add("SWP\nCalculator");
        sipCalculatorList.add("Add\nInvestment");
        return sipCalculatorList;
    }

    public static ArrayList<Integer> getLoanCalculatorIconList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        loanCalculatorIconList = arrayList;
        arrayList.add(Integer.valueOf(R.drawable.frame_5));
        loanCalculatorIconList.add(Integer.valueOf(R.drawable.frame_4));
        loanCalculatorIconList.add(Integer.valueOf(R.drawable.frame_2));
        return loanCalculatorIconList;
    }

    public static ArrayList<Integer> getBackingCalculatorIconList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        backingCalculatorIconList = arrayList;
        arrayList.add(Integer.valueOf(R.drawable.ic_simple_interest));
        backingCalculatorIconList.add(Integer.valueOf(R.drawable.ic_compound_interest_calculator));
        backingCalculatorIconList.add(Integer.valueOf(R.drawable.ic_fix_deposit_calculator));
        backingCalculatorIconList.add(Integer.valueOf(R.drawable.ic_recurring_deposit_));
        backingCalculatorIconList.add(Integer.valueOf(R.drawable.ic_public_provident_fund__ppf__calculator));
        backingCalculatorIconList.add(Integer.valueOf(R.drawable.ic_return_on_investment__roi__calculator));
        backingCalculatorIconList.add(Integer.valueOf(R.drawable.ic_time_value_of_money__tvm__calculator));
        return backingCalculatorIconList;
    }

    public static ArrayList<Integer> getBusinessCalculatorIconList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        businessCalculatorIconList = arrayList;
        arrayList.add(Integer.valueOf(R.drawable.ic_gst_calculator));
        businessCalculatorIconList.add(Integer.valueOf(R.drawable.ic_margin_calculator));
        businessCalculatorIconList.add(Integer.valueOf(R.drawable.ic_operating_margin));
        businessCalculatorIconList.add(Integer.valueOf(R.drawable.ic_margin_with_sales_calculator));
        businessCalculatorIconList.add(Integer.valueOf(R.drawable.ic_sales_tax_calculator));
        businessCalculatorIconList.add(Integer.valueOf(R.drawable.ic_break_event_point_calculator));
        businessCalculatorIconList.add(Integer.valueOf(R.drawable.ic_vat_calculator));
        businessCalculatorIconList.add(Integer.valueOf(R.drawable.ic_cumulative_growth_calculator));
        businessCalculatorIconList.add(Integer.valueOf(R.drawable.ic_price_calculator));
        businessCalculatorIconList.add(Integer.valueOf(R.drawable.ic_inflation_calculator));
        businessCalculatorIconList.add(Integer.valueOf(R.drawable.ic_gross_profit_calculator));
        businessCalculatorIconList.add(Integer.valueOf(R.drawable.ic_markup_calculator));
        businessCalculatorIconList.add(Integer.valueOf(R.drawable.ic_tax_calculator));
        businessCalculatorIconList.add(Integer.valueOf(R.drawable.ic_discount_calculator));
        return businessCalculatorIconList;
    }

    public static ArrayList<Integer> getSipCalculatorIconList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        sipCalculatorIconList = arrayList;
        arrayList.add(Integer.valueOf(R.drawable.ic_sip_calculator));
        sipCalculatorIconList.add(Integer.valueOf(R.drawable.ic_sip_plan_calculator));
        sipCalculatorIconList.add(Integer.valueOf(R.drawable.ic_stp_calculator));
        sipCalculatorIconList.add(Integer.valueOf(R.drawable.ic_swp_calculator));
        sipCalculatorIconList.add(Integer.valueOf(R.drawable.ic_add_investment_calculator));
        return sipCalculatorIconList;
    }

    public static double emiOfLoan(double d, double d2, double d3) {
        double d4 = d2 / 1200.0d;
        double d5 = d * d4;
        double d6 = d4 + 1.0d;
        return Double.parseDouble(new DecimalFormat("####0.00").format(Double.valueOf((d5 * Math.pow(d6, d3)) / (Math.pow(d6, d3) - 1.0d))));
    }

    public static double round(double d, int i) {
        if (i >= 0) {
            double pow = (double) ((long) Math.pow(10.0d, (double) i));
            return ((double) Math.round(d * pow)) / pow;
        }
        throw new IllegalArgumentException();
    }

    public static boolean checkPercentage100(String str, EditText editText) {
        if (Double.parseDouble(str) <= 100.0d) {
            return true;
        }
        editText.setError("Max 100");
        return false;
    }

    public static boolean checkPercentage50(String str, EditText editText) {
        if (Double.parseDouble(str) <= 50.0d) {
            return true;
        }
        editText.setError("Max 50");
        return false;
    }

    public static boolean checkPeriod30(double d, EditText editText) {
        if (d <= 30.0d) {
            return true;
        }
        editText.setError("Max 30");
        return false;
    }

    public static boolean checkPeriod360(double d, EditText editText) {
        if (d <= 360.0d) {
            return true;
        }
        editText.setError("Max 360 Months");
        return false;
    }

    public static boolean checkEmpty(String str, EditText editText) {
        if (!str.isEmpty()) {
            return true;
        }
        editText.setError("Empty Value");
        return false;
    }

    public static boolean checkAmount(String str, EditText editText) {
        if (((long) Double.parseDouble(str)) <= 10000000) {
            return true;
        }
        editText.setError("Max 10000000");
        return false;
    }

    public static boolean checkAmount(String str, TextInputLayout textInputLayout) {
        if (((long) Double.parseDouble(str)) <= 10000000) {
            textInputLayout.setError((CharSequence) null);
            return true;
        }
        textInputLayout.setError("Max 10000000");
        return false;
    }

    public static boolean checkPercentage50(String str, TextInputLayout textInputLayout) {
        if (Double.parseDouble(str) <= 50.0d) {
            textInputLayout.setError((CharSequence) null);
            return true;
        }
        textInputLayout.setError("Max 50");
        return false;
    }

    public static boolean checkPeriod360(double d, TextInputLayout textInputLayout) {
        if (d <= 360.0d) {
            textInputLayout.setError((CharSequence) null);
            return true;
        }
        textInputLayout.setError("Max 360 Months");
        return false;
    }

    public static boolean checkPercentage100(String str, TextInputLayout textInputLayout) {
        if (Double.parseDouble(str) <= 100.0d) {
            textInputLayout.setError((CharSequence) null);
            return true;
        }
        textInputLayout.setError("Max 100");
        return false;
    }

    public static boolean checkEmpty(String str, TextInputLayout textInputLayout) {
        if (!str.isEmpty()) {
            textInputLayout.setError((CharSequence) null);
            return true;
        }
        textInputLayout.setError("Empty Value");
        return false;
    }

    public static boolean checkPeriod30(double d, TextInputLayout textInputLayout) {
        if (d <= 30.0d) {
            textInputLayout.setError((CharSequence) null);
            return true;
        }
        textInputLayout.setError("Max 30");
        return false;
    }

    public static void textChangedListener(final EditText editText, final ImageView imageView, final LinearLayout linearLayout) {
        editText.getText().toString();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                linearLayout.setBackgroundResource(R.drawable.borders_green);
                imageView.setVisibility(View.VISIBLE);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                linearLayout.setBackgroundResource(R.drawable.background_basic_cal_gray);
                imageView.setVisibility(View.GONE);
                editText.setError((CharSequence) null);
            }
        });
    }

    public static boolean checkAmount(String str, EditText editText, LinearLayout linearLayout) {
        if (((long) Double.parseDouble(str)) <= 10000000) {
            return true;
        }
        editText.setError("Max 10000000");
        linearLayout.setBackgroundResource(R.drawable.borders_red);
        return false;
    }

    public static boolean checkPercentage50(String str, EditText editText, LinearLayout linearLayout) {
        if (Double.parseDouble(str) <= 50.0d) {
            return true;
        }
        editText.setError("Max 50");
        linearLayout.setBackgroundResource(R.drawable.borders_red);
        return false;
    }

    public static boolean checkPeriod360(double d, EditText editText, LinearLayout linearLayout) {
        if (d <= 360.0d) {
            return true;
        }
        editText.setError("Max 360 Months");
        linearLayout.setBackgroundResource(R.drawable.borders_red);
        return false;
    }
}
