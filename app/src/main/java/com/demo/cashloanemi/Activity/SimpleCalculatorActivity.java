package com.demo.cashloanemi.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.exifinterface.media.ExifInterface;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.Modal.Model;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.ads.AdsCommon;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class SimpleCalculatorActivity extends AppCompatActivity {
    LinearLayout ac;
    LinearLayout ans;
    ArrayList<String> ansList;
    LinearLayout delete;
    LinearLayout division;
    boolean dotUsed = true;
    TextView input;
    LinearLayout minus;
    LinearLayout multiplication;
    LinearLayout n0;
    LinearLayout n00;
    LinearLayout n1;
    LinearLayout n2;
    LinearLayout n3;
    LinearLayout n4;
    LinearLayout n5;
    LinearLayout n6;
    LinearLayout n7;
    LinearLayout n8;
    LinearLayout n9;
    LinearLayout npo;
    TextView output;
    LinearLayout percent;
    LinearLayout plus;
    PrefManager prefManager;
    HorizontalScrollView scrollView;
    Toolbar toolbar;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_simple_calculator);


        AdsCommon.InterstitialAdsOnly(this);

        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        FrameLayout qureka = (FrameLayout) findViewById(R.id.qureka);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer, qureka);


        this.ansList = new ArrayList<>();
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        PrefManager prefManager2 = new PrefManager(this);
        this.prefManager = prefManager2;
        this.n1 = (LinearLayout) findViewById(R.id.n1);
        this.n2 = (LinearLayout) findViewById(R.id.n2);
        this.n3 = (LinearLayout) findViewById(R.id.n3);
        this.n4 = (LinearLayout) findViewById(R.id.n4);
        this.n5 = (LinearLayout) findViewById(R.id.n5);
        this.n6 = (LinearLayout) findViewById(R.id.n6);
        this.n7 = (LinearLayout) findViewById(R.id.n7);
        this.n8 = (LinearLayout) findViewById(R.id.n8);
        this.n9 = (LinearLayout) findViewById(R.id.n9);
        this.n0 = (LinearLayout) findViewById(R.id.n0);
        this.n00 = (LinearLayout) findViewById(R.id.n00);
        this.input = (TextView) findViewById(R.id.input);
        this.output = (TextView) findViewById(R.id.output);
        this.percent = (LinearLayout) findViewById(R.id.percent);
        this.ac = (LinearLayout) findViewById(R.id.ac);
        this.plus = (LinearLayout) findViewById(R.id.plus);
        this.minus = (LinearLayout) findViewById(R.id.minus);
        this.multiplication = (LinearLayout) findViewById(R.id.multiplication);
        this.division = (LinearLayout) findViewById(R.id.division);
        this.delete = (LinearLayout) findViewById(R.id.delete);
        this.ans = (LinearLayout) findViewById(R.id.ans);
        this.npo = (LinearLayout) findViewById(R.id.npo);
        this.scrollView = (HorizontalScrollView) findViewById(R.id.scrollView);
        this.ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleCalculatorActivity.this.input.setText("");
                SimpleCalculatorActivity.this.output.setText("");
                SimpleCalculatorActivity.this.dotUsed = true;
            }
        });
        this.n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (charSequence.isEmpty()) {
                    TextView textView = SimpleCalculatorActivity.this.input;
                    textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "1");
                } else if (charSequence.substring(charSequence.length() - 1, charSequence.length()).equals("%")) {
                    TextView textView2 = SimpleCalculatorActivity.this.input;
                    textView2.setText(SimpleCalculatorActivity.this.input.getText().toString() + "x1");
                } else {
                    TextView textView3 = SimpleCalculatorActivity.this.input;
                    textView3.setText(SimpleCalculatorActivity.this.input.getText().toString() + "1");
                }
                TextView textView4 = SimpleCalculatorActivity.this.output;
                SimpleCalculatorActivity simpleCalculatorActivity = SimpleCalculatorActivity.this;
                textView4.setText(simpleCalculatorActivity.calculated(simpleCalculatorActivity.input.getText().toString()));
            }
        });
        this.n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (charSequence.isEmpty()) {
                    TextView textView = SimpleCalculatorActivity.this.input;
                    textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + ExifInterface.GPS_MEASUREMENT_2D);
                } else if (charSequence.substring(charSequence.length() - 1, charSequence.length()).equals("%")) {
                    TextView textView2 = SimpleCalculatorActivity.this.input;
                    textView2.setText(SimpleCalculatorActivity.this.input.getText().toString() + "x2");
                } else {
                    TextView textView3 = SimpleCalculatorActivity.this.input;
                    textView3.setText(SimpleCalculatorActivity.this.input.getText().toString() + ExifInterface.GPS_MEASUREMENT_2D);
                }
                TextView textView4 = SimpleCalculatorActivity.this.output;
                SimpleCalculatorActivity simpleCalculatorActivity = SimpleCalculatorActivity.this;
                textView4.setText(simpleCalculatorActivity.calculated(simpleCalculatorActivity.input.getText().toString()));
            }
        });
        this.n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (charSequence.isEmpty()) {
                    TextView textView = SimpleCalculatorActivity.this.input;
                    textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + ExifInterface.GPS_MEASUREMENT_3D);
                } else if (charSequence.substring(charSequence.length() - 1, charSequence.length()).equals("%")) {
                    TextView textView2 = SimpleCalculatorActivity.this.input;
                    textView2.setText(SimpleCalculatorActivity.this.input.getText().toString() + "x3");
                } else {
                    TextView textView3 = SimpleCalculatorActivity.this.input;
                    textView3.setText(SimpleCalculatorActivity.this.input.getText().toString() + ExifInterface.GPS_MEASUREMENT_3D);
                }
                TextView textView4 = SimpleCalculatorActivity.this.output;
                SimpleCalculatorActivity simpleCalculatorActivity = SimpleCalculatorActivity.this;
                textView4.setText(simpleCalculatorActivity.calculated(simpleCalculatorActivity.input.getText().toString()));
            }
        });
        this.n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (charSequence.isEmpty()) {
                    TextView textView = SimpleCalculatorActivity.this.input;
                    textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "4");
                } else if (charSequence.substring(charSequence.length() - 1, charSequence.length()).equals("%")) {
                    TextView textView2 = SimpleCalculatorActivity.this.input;
                    textView2.setText(SimpleCalculatorActivity.this.input.getText().toString() + "x4");
                } else {
                    TextView textView3 = SimpleCalculatorActivity.this.input;
                    textView3.setText(SimpleCalculatorActivity.this.input.getText().toString() + "4");
                }
                TextView textView4 = SimpleCalculatorActivity.this.output;
                SimpleCalculatorActivity simpleCalculatorActivity = SimpleCalculatorActivity.this;
                textView4.setText(simpleCalculatorActivity.calculated(simpleCalculatorActivity.input.getText().toString()));
            }
        });
        this.n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (charSequence.isEmpty()) {
                    TextView textView = SimpleCalculatorActivity.this.input;
                    textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "5");
                } else if (charSequence.substring(charSequence.length() - 1, charSequence.length()).equals("%")) {
                    TextView textView2 = SimpleCalculatorActivity.this.input;
                    textView2.setText(SimpleCalculatorActivity.this.input.getText().toString() + "x5");
                } else {
                    TextView textView3 = SimpleCalculatorActivity.this.input;
                    textView3.setText(SimpleCalculatorActivity.this.input.getText().toString() + "5");
                }
                TextView textView4 = SimpleCalculatorActivity.this.output;
                SimpleCalculatorActivity simpleCalculatorActivity = SimpleCalculatorActivity.this;
                textView4.setText(simpleCalculatorActivity.calculated(simpleCalculatorActivity.input.getText().toString()));
            }
        });
        this.n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (charSequence.isEmpty()) {
                    TextView textView = SimpleCalculatorActivity.this.input;
                    textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "6");
                } else if (charSequence.substring(charSequence.length() - 1, charSequence.length()).equals("%")) {
                    TextView textView2 = SimpleCalculatorActivity.this.input;
                    textView2.setText(SimpleCalculatorActivity.this.input.getText().toString() + "x6");
                } else {
                    TextView textView3 = SimpleCalculatorActivity.this.input;
                    textView3.setText(SimpleCalculatorActivity.this.input.getText().toString() + "6");
                }
                TextView textView4 = SimpleCalculatorActivity.this.output;
                SimpleCalculatorActivity simpleCalculatorActivity = SimpleCalculatorActivity.this;
                textView4.setText(simpleCalculatorActivity.calculated(simpleCalculatorActivity.input.getText().toString()));
            }
        });
        this.n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (charSequence.isEmpty()) {
                    TextView textView = SimpleCalculatorActivity.this.input;
                    textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "7");
                } else if (charSequence.substring(charSequence.length() - 1, charSequence.length()).equals("%")) {
                    TextView textView2 = SimpleCalculatorActivity.this.input;
                    textView2.setText(SimpleCalculatorActivity.this.input.getText().toString() + "x7");
                } else {
                    TextView textView3 = SimpleCalculatorActivity.this.input;
                    textView3.setText(SimpleCalculatorActivity.this.input.getText().toString() + "7");
                }
                TextView textView4 = SimpleCalculatorActivity.this.output;
                SimpleCalculatorActivity simpleCalculatorActivity = SimpleCalculatorActivity.this;
                textView4.setText(simpleCalculatorActivity.calculated(simpleCalculatorActivity.input.getText().toString()));
            }
        });
        this.n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (charSequence.isEmpty()) {
                    TextView textView = SimpleCalculatorActivity.this.input;
                    textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "8");
                } else if (charSequence.substring(charSequence.length() - 1, charSequence.length()).equals("%")) {
                    TextView textView2 = SimpleCalculatorActivity.this.input;
                    textView2.setText(SimpleCalculatorActivity.this.input.getText().toString() + "x8");
                } else {
                    TextView textView3 = SimpleCalculatorActivity.this.input;
                    textView3.setText(SimpleCalculatorActivity.this.input.getText().toString() + "8");
                }
                TextView textView4 = SimpleCalculatorActivity.this.output;
                SimpleCalculatorActivity simpleCalculatorActivity = SimpleCalculatorActivity.this;
                textView4.setText(simpleCalculatorActivity.calculated(simpleCalculatorActivity.input.getText().toString()));
            }
        });
        this.n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (charSequence.isEmpty()) {
                    TextView textView = SimpleCalculatorActivity.this.input;
                    textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "9");
                } else if (charSequence.substring(charSequence.length() - 1, charSequence.length()).equals("%")) {
                    TextView textView2 = SimpleCalculatorActivity.this.input;
                    textView2.setText(SimpleCalculatorActivity.this.input.getText().toString() + "x9");
                } else {
                    TextView textView3 = SimpleCalculatorActivity.this.input;
                    textView3.setText(SimpleCalculatorActivity.this.input.getText().toString() + "9");
                }
                TextView textView4 = SimpleCalculatorActivity.this.output;
                SimpleCalculatorActivity simpleCalculatorActivity = SimpleCalculatorActivity.this;
                textView4.setText(simpleCalculatorActivity.calculated(simpleCalculatorActivity.input.getText().toString()));
            }
        });
        this.n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (charSequence.isEmpty()) {
                    TextView textView = SimpleCalculatorActivity.this.input;
                    textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "0");
                } else if (charSequence.substring(charSequence.length() - 1, charSequence.length()).equals("%")) {
                    TextView textView2 = SimpleCalculatorActivity.this.input;
                    textView2.setText(SimpleCalculatorActivity.this.input.getText().toString() + "x0");
                } else {
                    TextView textView3 = SimpleCalculatorActivity.this.input;
                    textView3.setText(SimpleCalculatorActivity.this.input.getText().toString() + "0");
                }
                TextView textView4 = SimpleCalculatorActivity.this.output;
                SimpleCalculatorActivity simpleCalculatorActivity = SimpleCalculatorActivity.this;
                textView4.setText(simpleCalculatorActivity.calculated(simpleCalculatorActivity.input.getText().toString()));
            }
        });
        this.n00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (charSequence.isEmpty()) {
                    TextView textView = SimpleCalculatorActivity.this.input;
                    textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "00");
                } else if (charSequence.substring(charSequence.length() - 1, charSequence.length()).equals("%")) {
                    TextView textView2 = SimpleCalculatorActivity.this.input;
                    textView2.setText(SimpleCalculatorActivity.this.input.getText().toString() + "x00");
                } else {
                    TextView textView3 = SimpleCalculatorActivity.this.input;
                    textView3.setText(SimpleCalculatorActivity.this.input.getText().toString() + "00");
                }
                TextView textView4 = SimpleCalculatorActivity.this.output;
                SimpleCalculatorActivity simpleCalculatorActivity = SimpleCalculatorActivity.this;
                textView4.setText(simpleCalculatorActivity.calculated(simpleCalculatorActivity.input.getText().toString()));
            }
        });
        this.npo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (charSequence.isEmpty()) {
                    TextView textView = SimpleCalculatorActivity.this.input;
                    textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "0.");
                } else if (SimpleCalculatorActivity.this.dotUsed) {
                    if (charSequence.substring(charSequence.length() - 1, charSequence.length()).matches("[0-9]+")) {
                        TextView textView2 = SimpleCalculatorActivity.this.input;
                        textView2.setText(SimpleCalculatorActivity.this.input.getText().toString() + ".");
                    } else if (charSequence.substring(charSequence.length() - 1, charSequence.length()).equals("%")) {
                        TextView textView3 = SimpleCalculatorActivity.this.input;
                        textView3.setText(SimpleCalculatorActivity.this.input.getText().toString() + "x0.");
                    } else {
                        TextView textView4 = SimpleCalculatorActivity.this.input;
                        textView4.setText(SimpleCalculatorActivity.this.input.getText().toString() + "0.");
                    }
                    SimpleCalculatorActivity.this.dotUsed = false;
                }
                TextView textView5 = SimpleCalculatorActivity.this.output;
                SimpleCalculatorActivity simpleCalculatorActivity = SimpleCalculatorActivity.this;
                textView5.setText(simpleCalculatorActivity.calculated(simpleCalculatorActivity.input.getText().toString()));
            }
        });
        this.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (!charSequence.isEmpty()) {
                    String substring = charSequence.substring(charSequence.length() - 1, charSequence.length());
                    String substring2 = charSequence.substring(0, charSequence.length() - 1);
                    if (substring.matches("[0-9]+") || substring.equals("%")) {
                        TextView textView = SimpleCalculatorActivity.this.input;
                        textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "+");
                    } else {
                        TextView textView2 = SimpleCalculatorActivity.this.input;
                        textView2.setText(substring2 + "+");
                    }
                }
                SimpleCalculatorActivity.this.dotUsed = true;
            }
        });
        this.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (!charSequence.isEmpty()) {
                    String substring = charSequence.substring(charSequence.length() - 1, charSequence.length());
                    String substring2 = charSequence.substring(0, charSequence.length() - 1);
                    if (substring.matches("[0-9]+") || substring.equals("%")) {
                        TextView textView = SimpleCalculatorActivity.this.input;
                        textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "-");
                    } else {
                        TextView textView2 = SimpleCalculatorActivity.this.input;
                        textView2.setText(substring2 + "-");
                    }
                }
                SimpleCalculatorActivity.this.dotUsed = true;
            }
        });
        this.multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (!charSequence.isEmpty()) {
                    String substring = charSequence.substring(charSequence.length() - 1, charSequence.length());
                    String substring2 = charSequence.substring(0, charSequence.length() - 1);
                    if (substring.matches("[0-9]+") || substring.equals("%")) {
                        TextView textView = SimpleCalculatorActivity.this.input;
                        textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "x");
                    } else {
                        TextView textView2 = SimpleCalculatorActivity.this.input;
                        textView2.setText(substring2 + "x");
                    }
                }
                SimpleCalculatorActivity.this.dotUsed = true;
            }
        });
        this.division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (!charSequence.isEmpty()) {
                    String substring = charSequence.substring(charSequence.length() - 1, charSequence.length());
                    String substring2 = charSequence.substring(0, charSequence.length() - 1);
                    if (substring.matches("[0-9]+") || substring.equals("%")) {
                        TextView textView = SimpleCalculatorActivity.this.input;
                        textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "÷");
                    } else {
                        TextView textView2 = SimpleCalculatorActivity.this.input;
                        textView2.setText(substring2 + "÷");
                    }
                }
                SimpleCalculatorActivity.this.dotUsed = true;
            }
        });
        this.percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (!charSequence.isEmpty()) {
                    String substring = charSequence.substring(charSequence.length() - 1, charSequence.length());
                    String substring2 = charSequence.substring(0, charSequence.length() - 1);
                    if (substring.matches("[0-9]+")) {
                        TextView textView = SimpleCalculatorActivity.this.input;
                        textView.setText(SimpleCalculatorActivity.this.input.getText().toString() + "%");
                    } else {
                        TextView textView2 = SimpleCalculatorActivity.this.input;
                        textView2.setText(substring2 + "%");
                    }
                }
                SimpleCalculatorActivity.this.dotUsed = true;
                TextView textView3 = SimpleCalculatorActivity.this.output;
                SimpleCalculatorActivity simpleCalculatorActivity = SimpleCalculatorActivity.this;
                textView3.setText(simpleCalculatorActivity.calculated(simpleCalculatorActivity.input.getText().toString()));
            }
        });
        this.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charSequence = SimpleCalculatorActivity.this.input.getText().toString();
                if (charSequence.length() != 0) {
                    SimpleCalculatorActivity.this.input.setText(charSequence.substring(0, charSequence.length() - 1));
                }
                TextView textView = SimpleCalculatorActivity.this.output;
                SimpleCalculatorActivity simpleCalculatorActivity = SimpleCalculatorActivity.this;
                textView.setText(simpleCalculatorActivity.calculated(simpleCalculatorActivity.input.getText().toString()));
            }
        });
        this.ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleCalculatorActivity.this.input.setText(SimpleCalculatorActivity.this.output.getText().toString());
                SimpleCalculatorActivity.this.output.setText("");
            }
        });
    }

    

    public String calculated(String str) {
        String str2;
        this.scrollView.post(new Runnable() {
            public void run() {
                SimpleCalculatorActivity.this.scrollView.fullScroll(66);
            }
        });
        if (str.length() != 0) {
            str2 = str.substring(str.length() - 1, str.length());
        } else {
            str2 = "";
        }
        if (!str2.matches("[0-9]+") && !str2.equals("%")) {
            return "";
        }
        if (str.contains("%")) {
            this.ansList.clear();
            replacement(str);
            String str3 = "";
            for (int i = 0; i < this.ansList.size(); i++) {
                str3 = str3 + this.ansList.get(i);
            }
            if (str3.isEmpty()) {
                return "";
            }
            return new DecimalFormat("0.########").format(Double.parseDouble(new BigDecimal("" + eval("(" + str3.replaceAll(Pattern.quote("÷"), "/").replaceAll(Pattern.quote("x"), "*").replaceAll(Pattern.quote("+"), "+").replaceAll(Pattern.quote("-"), "-"))).setScale(8, RoundingMode.HALF_UP).toPlainString()));
        }
        String replaceAll = str.replaceAll("%", "/100");
        String str4 = "(" + replaceAll.replaceAll(Pattern.quote("÷"), ")/(").replaceAll(Pattern.quote("x"), ")*(").replaceAll(Pattern.quote("+"), ")+(").replaceAll(Pattern.quote("-"), ")-(");
        if (!str4.contains("/") && !str4.contains("*") && !str4.contains("+") && !str4.contains("-") && !str4.contains("/100")) {
            return "";
        }
        return new DecimalFormat("0.########").format(Double.parseDouble(new BigDecimal(String.valueOf(eval(str4))).setScale(8, RoundingMode.HALF_UP).toPlainString()));
    }

    public static double eval(final String str) {
        return new Object() {
            int ch;
            int pos = -1;

            
            public void nextChar() {
                int i = this.pos + 1;
                this.pos = i;
                this.ch = i < str.length() ? str.charAt(this.pos) : 65535;
            }

            
            public boolean eat(int i) {
                int i2;
                while (true) {
                    i2 = this.ch;
                    if (i2 != 32) {
                        break;
                    }
                    nextChar();
                }
                if (i2 != i) {
                    return false;
                }
                nextChar();
                return true;
            }

            
            public double parse() {
                nextChar();
                double parseExpression = parseExpression();
                if (this.pos >= str.length()) {
                    return parseExpression;
                }
                throw new RuntimeException("Unexpected: " + ((char) this.ch));
            }

            
            public double parseExpression() {
                double parseTerm = parseTerm();
                while (true) {
                    if (eat(43)) {
                        parseTerm += parseTerm();
                    } else if (!eat(45)) {
                        return parseTerm;
                    } else {
                        parseTerm -= parseTerm();
                    }
                }
            }

            
            public double parseTerm() {
                double parseFactor = parseFactor();
                while (true) {
                    if (eat(42)) {
                        parseFactor *= parseFactor();
                    } else if (!eat(47)) {
                        return parseFactor;
                    } else {
                        parseFactor /= parseFactor();
                    }
                }
            }

            
            public double parseFactor() {
                double d;
                if (eat(43)) {
                    return parseFactor();
                }
                if (eat(45)) {
                    return -parseFactor();
                }
                int i = this.pos;
                if (eat(40)) {
                    d = parseExpression();
                    eat(41);
                } else {
                    int i2 = this.ch;
                    if ((i2 >= 48 && i2 <= 57) || i2 == 46) {
                        while (true) {
                            int i3 = this.ch;
                            if ((i3 < 48 || i3 > 57) && i3 != 46) {
                                break;
                            }
                            nextChar();
                        }
                        d = Double.parseDouble(str.substring(i, this.pos));
                    } else if (i2 < 97 || i2 > 122) {
                        throw new RuntimeException("Unexpected: " + ((char) this.ch));
                    } else {
                        while (true) {
                            int i4 = this.ch;
                            if (i4 < 97 || i4 > 122) {
                                String substring = str.substring(i, this.pos);
                                double parseFactor = parseFactor();
                            } else {
                                nextChar();
                            }
                        }
                        /*String substring2 = str.substring(i, this.pos);
                        double parseFactor2 = parseFactor();
                        if (substring2.equals("sqrt")) {
                            d = Math.sqrt(parseFactor2);
                        } else if (substring2.equals("sin")) {
                            d = Math.sin(Math.toRadians(parseFactor2));
                        } else if (substring2.equals("cos")) {
                            d = Math.cos(Math.toRadians(parseFactor2));
                        } else if (substring2.equals("tan")) {
                            d = Math.tan(Math.toRadians(parseFactor2));
                        } else if (substring2.equals("log")) {
                            d = Math.log10(parseFactor2);
                        } else if (substring2.equals("ln")) {
                            d = Math.log(parseFactor2);
                        } else {
                            throw new RuntimeException("Unknown function: " + substring2);
                        }*/
                    }
                }
                return eat(94) ? Math.pow(d, parseFactor()) : d;
            }
        }.parse();
    }

    public void replacement(String str) {
        String[] split = str.split("%");
        int i = 0;
        if (str.substring(str.length() - 1, str.length()).equals("%")) {
            while (i < split.length) {
                prCal(split[i] + "%");
                i++;
            }
            return;
        }
        while (i < split.length) {
            if (i == split.length - 1) {
                this.ansList.add(split[i].replaceAll(Pattern.quote("÷"), ")/(").replaceAll(Pattern.quote("x"), ")*(").replaceAll(Pattern.quote("+"), ")+(").replaceAll(Pattern.quote("-"), ")-("));
            } else {
                prCal(split[i] + "%");
            }
            i++;
        }
    }

    private void prCal(String str) {
        char c;
        ArrayList arrayList;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = str;
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            c = '%';
            if (i3 >= str.length()) {
                break;
            }
            if (str6.charAt(i3) == '+' || str6.charAt(i3) == '-' || str6.charAt(i3) == 247 || str6.charAt(i3) == 'x' || str6.charAt(i3) == '%') {
                Model model = new Model();
                model.setPo(i3);
                model.setSymbol(str6.charAt(i3));
                arrayList2.add(model);
            }
            i3++;
        }
        int i4 = 0;
        String str7 = "";
        while (i4 < arrayList2.size()) {
            if (((Model) arrayList2.get(i4)).getSymbol() == c) {
                String str8 = "/100";
                if (((Model) arrayList2.get(i2)).getSymbol() != c) {
                    int i5 = i4 - 1;
                    if (((Model) arrayList2.get(i5)).getSymbol() == 'x' || ((Model) arrayList2.get(i5)).getSymbol() == 247) {
                        String substring = str6.substring(0, 1);
                        if (substring.matches("[0-9]+")) {
                            str3 = "(" + str6;
                            substring = "";
                        } else {
                            str3 = "(" + str6.substring(1, str6.length());
                        }
                        String replaceAll = str6.replaceAll(Pattern.quote("%"), str8).replaceAll(Pattern.quote("÷"), ")/(").replaceAll(Pattern.quote("x"), ")*(").replaceAll(Pattern.quote("+"), ")+(").replaceAll(Pattern.quote("-"), ")-(");
                        str7 = str7 + substring + "" + eval(replaceAll);
                    } else if (((Model) arrayList2.get(i5)).getSymbol() == '+' || ((Model) arrayList2.get(i5)).getSymbol() == '-') {
                        String substring2 = str6.substring(0, 1);
                        if (substring2.matches("[0-9]+")) {
                            str6 = "(" + str6;
                            str5 = str6.substring(((Model) arrayList2.get(i5)).getPo() + 2, str6.length() - 1);
                            str4 = str6.substring(0, ((Model) arrayList2.get(i5)).getPo() + 1);
                            substring2 = "";
                        } else {
                            str6 = "(" + str6.substring(1, str6.length());
                            str5 = str6.substring(((Model) arrayList2.get(i5)).getPo() + 1, str6.length() - 1);
                            str4 = str6.substring(0, ((Model) arrayList2.get(i5)).getPo());
                        }
                        String replaceAll2 = str4.replaceAll(Pattern.quote("÷"), ")/(").replaceAll(Pattern.quote("x"), ")*(").replaceAll(Pattern.quote("+"), ")+(").replaceAll(Pattern.quote("-"), ")-(");
                        if (!replaceAll2.isEmpty()) {
                            double eval = eval(replaceAll2);
                            double eval2 = eval(eval + "" + ((Model) arrayList2.get(i5)).getSymbol() + "" + ((Double.parseDouble(str5) * eval) / 100.0d));
                            StringBuilder sb = new StringBuilder();
                            sb.append(str7);
                            sb.append(substring2);
                            sb.append(eval2);
                            str7 = sb.toString();
                        }
                    }
                    arrayList = arrayList2;
                    i = 0;
                } else {
                    String str9 = str8;
                    arrayList = arrayList2;
                    i = 0;
                    String substring3 = str6.substring(0, 1);
                    if (substring3.matches("[0-9]+")) {
                        str2 = "(" + str6;
                        substring3 = "";
                    } else {
                        str2 = "(" + str6.substring(1, str6.length());
                    }
                    String replaceAll3 = str6.replaceAll(Pattern.quote("%"), str9).replaceAll(Pattern.quote("÷"), ")/(").replaceAll(Pattern.quote("x"), ")*(").replaceAll(Pattern.quote("+"), ")+(").replaceAll(Pattern.quote("-"), ")-(");
                    str7 = str7 + substring3 + "" + eval(replaceAll3);
                }
            } else {
                arrayList = arrayList2;
                i = i2;
            }
            i4++;
            i2 = i;
            arrayList2 = arrayList;
            c = '%';
        }
        this.ansList.add(str7);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
