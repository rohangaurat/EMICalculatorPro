package com.demo.cashloanemi.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.demo.cashloanemi.Modal.AddInvestmentModel;
import com.demo.cashloanemi.Modal.CompoundInterestModel;
import com.demo.cashloanemi.Modal.ConverterHistoryModel;
import com.demo.cashloanemi.Modal.FDModel;
import com.demo.cashloanemi.Modal.PPFModel;
import com.demo.cashloanemi.Modal.RDModel;
import com.demo.cashloanemi.Modal.SimpleInterestModel;
import com.demo.cashloanemi.Modal.TVMModel;
import com.demo.cashloanemi.Modal.emiLoanModal;
import com.demo.cashloanemi.Modal.tipModal;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String ADD_INVESTMENT_ID = "add_investment_ID";
    public static final String ADD_INVESTMENT_MONTH = "add_investment_month";
    public static final String ADD_INVESTMENT_MONTHLY_PAYMENT = "add_investment_monthly_payment";
    public static final String ADD_INVESTMENT_RATE = "add_investment_rate";
    public static final String ADD_INVESTMENT_STARTING_PAYMENT = "add_investment_starting_payment";
    public static final String ADD_INVESTMENT_TITLE = "add_investment_title";
    public static final String ADD_INVESTMENT_TOTAL_BALANCE = "add_investment_total_Balance";
    public static final String ADD_INVESTMENT_TOTAL_INVESTMENT = "add_investment_total_investment";
    public static final String COMPOUND_INTEREST_ID = "compound_interest_ID";
    public static final String COMPOUND_INTEREST_INTEREST_RATE = "compound_interest_interest_rate";
    public static final String COMPOUND_INTEREST_LOAN_AMOUNT = "compound_interest_title_loan_amount";
    public static final String COMPOUND_INTEREST_TITLE = "compound_interest_title";
    public static final String COMPOUND_INTEREST_YEAR = "compound_interest_title_year";
    public static final String CONVERTER_FAVORITE_FORM_AMOUNT = "converter_favorite_form_amount";
    public static final String CONVERTER_FAVORITE_FORM_CODE = "converter_favorite_form_code";
    public static final String CONVERTER_FAVORITE_ID = "converter_favorite_id";
    public static final String CONVERTER_FAVORITE_TO_AMOUNT = "converter_favorite_to_amount";
    public static final String CONVERTER_FAVORITE_TO_CODE = "converter_favorite_to_code";
    public static final String CONVERTER_HISTORY_DATE_AND_TIME = "converter_history_date_and_time";
    public static final String CONVERTER_HISTORY_FORM_AMOUNT = "converter_history_form_amount";
    public static final String CONVERTER_HISTORY_FORM_CODE = "converter_history_form_code";
    public static final String CONVERTER_HISTORY_ID = "converter_history_id";
    public static final String CONVERTER_HISTORY_TO_AMOUNT = "converter_history_to_amount";
    public static final String CONVERTER_HISTORY_TO_CODE = "converter_history_to_code";
    public static final String CURRENCY_IS_FAVORITE = "converter_is_favorite";
    public static final String DB_NAME = "Calculator";
    public static final int DB_VERSION = 1;
    public static final String EMI_LOAN_AMOUNT = "EMI_loan_amount";
    public static final String EMI_LOAN_ID = "EMI_loan_ID";
    public static final String EMI_LOAN_RATE = "EMI_loan_rate";
    public static final String EMI_LOAN_TIME_PERIODS_MONTHS = "Months";
    public static final String EMI_LOAN_TITLE = "EMI_loan_title";
    public static final String FD_ID = "fd_ID";
    public static final String FD_INSTALLMENT = "fd_installment";
    public static final String FD_INTEREST_RATE = "fd_interest_rate";
    public static final String FD_INVESTMENT_AMOUNT = "fd_investment_amount";
    public static final String FD_TITLE = "fd_title";
    public static final String FD_YEAR = "fd_year";
    public static final String PPF_ID = "ppf_ID";
    public static final String PPF_INSTALLMENT = "ppf_installment";
    public static final String PPF_INTEREST_RATE = "ppf_interest_rate";
    public static final String PPF_INVESTMENT_AMOUNT = "ppf_investment_amount";
    public static final String PPF_MONTH = "ppf_month";
    public static final String PPF_TITLE = "ppf_title";
    public static final String RD_ID = "rd_ID";
    public static final String RD_INSTALLMENT = "rd_installment";
    public static final String RD_INTEREST_RATE = "rd_interest_rate";
    public static final String RD_INVESTMENT_AMOUNT = "rd_investment_amount";
    public static final String RD_TITLE = "rd_title";
    public static final String RD_YEAR = "rd_year";
    public static final String SIMPLE_INTEREST_ID = "simple_interest_ID";
    public static final String SIMPLE_INTEREST_INTEREST_RATE = "simple_interest_title_interest_rate";
    public static final String SIMPLE_INTEREST_LOAN_AMOUNT = "simple_interest_title_loan_amount";
    public static final String SIMPLE_INTEREST_TITLE = "simple_interest_title";
    public static final String SIMPLE_INTEREST_YEAR = "simple_interest_title_year";
    public static final String TABLE_ADD_INVESTMENT = "add_investment";
    public static final String TABLE_COMPOUND_INTEREST = "compound_interest";
    public static final String TABLE_CONVERTER_FAVORITE = "converter_favorite";
    public static final String TABLE_CONVERTER_HISTORY = "converter_history";
    public static final String TABLE_EMI_LOAN = "EMI_loan";
    public static final String TABLE_FD = "fd";
    public static final String TABLE_PPF = "ppf";
    public static final String TABLE_RD = "rd";
    public static final String TABLE_SIMPLE_INTEREST = "simple_interest";
    public static final String TABLE_TIP = "tip";
    public static final String TABLE_TVM = "tvm";
    public static final String TIP_BILL_AMOUNT = "tip_bill_amount";
    public static final String TIP_ID = "tip_ID";
    public static final String TIP_RATE = "tip_rate";
    public static final String TIP_SPLIT = "tip_split";
    public static final String TIP_TAX_RATE = "tip_tax_rate";
    public static final String TIP_TITLE = "tip_title";
    public static final String TVM_FUTURE_VALUE = "tvm_future_value";
    public static final String TVM_ID = "tvm_ID";
    public static final String TVM_INSTALLMENT = "tvm_installment";
    public static final String TVM_MODE = "tvm_mode";
    public static final String TVM_PAYMENT = "tvm_payment";
    public static final String TVM_PRESENT_VALUE = "tvm_present_value";
    public static final String TVM_RATE = "tvm_rate";
    public static final String TVM_SELECT = "tvm_select";
    public static final String TVM_TITLE = "tvm_title";
    public static final String TVM_YEAR = "tvm_year";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE EMI_loan (EMI_loan_ID INTEGER PRIMARY KEY AUTOINCREMENT, EMI_loan_title TEXT, EMI_loan_amount INTEGER, EMI_loan_rate INTEGER, Months INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE tip (tip_ID INTEGER PRIMARY KEY AUTOINCREMENT, tip_title TEXT, tip_bill_amount INTEGER, tip_rate INTEGER, tip_tax_rate INTEGER, tip_split INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE fd (fd_ID INTEGER PRIMARY KEY AUTOINCREMENT, fd_title TEXT, fd_investment_amount INTEGER, fd_interest_rate INTEGER, fd_year INTEGER, fd_installment INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE rd (rd_ID INTEGER PRIMARY KEY AUTOINCREMENT, rd_title TEXT, rd_investment_amount INTEGER, rd_interest_rate INTEGER, rd_year INTEGER, rd_installment INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE ppf (ppf_ID INTEGER PRIMARY KEY AUTOINCREMENT, ppf_title TEXT, ppf_investment_amount INTEGER, ppf_interest_rate INTEGER, ppf_month INTEGER, ppf_installment INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE simple_interest (simple_interest_ID INTEGER PRIMARY KEY AUTOINCREMENT, simple_interest_title TEXT, simple_interest_title_loan_amount INTEGER, simple_interest_title_interest_rate INTEGER, simple_interest_title_year INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE compound_interest (compound_interest_ID INTEGER PRIMARY KEY AUTOINCREMENT, compound_interest_title TEXT, compound_interest_title_loan_amount INTEGER, compound_interest_interest_rate INTEGER, compound_interest_title_year INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE tvm (tvm_ID INTEGER PRIMARY KEY AUTOINCREMENT, tvm_title TEXT, tvm_present_value INTEGER, tvm_payment INTEGER, tvm_future_value INTEGER, tvm_rate INTEGER, tvm_year INTEGER, tvm_installment INTEGER, tvm_mode INTEGER, tvm_select INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE add_investment (add_investment_ID INTEGER PRIMARY KEY AUTOINCREMENT, add_investment_title TEXT, add_investment_starting_payment INTEGER, add_investment_monthly_payment INTEGER, add_investment_rate INTEGER, add_investment_month INTEGER, add_investment_total_Balance INTEGER, add_investment_total_investment INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE converter_history (converter_history_id INTEGER PRIMARY KEY AUTOINCREMENT, converter_history_date_and_time TEXT, converter_history_form_code INTEGER, converter_history_to_code INTEGER, converter_history_form_amount INTEGER, converter_is_favorite INTEGER, converter_history_to_amount INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS EMI_loan");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tip");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS fd");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS rd");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ppf");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS simple_interest");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS compound_interest");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tvm");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS add_investment");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS converter_history");
        onCreate(sQLiteDatabase);
    }

    public void addEMILoanColumn(String str, double d, double d2, double d3) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EMI_LOAN_TITLE, str);
        contentValues.put(EMI_LOAN_AMOUNT, Double.valueOf(d));
        contentValues.put(EMI_LOAN_RATE, Double.valueOf(d2));
        contentValues.put(EMI_LOAN_TIME_PERIODS_MONTHS, Double.valueOf(d3));
        writableDatabase.insert(TABLE_EMI_LOAN, (String) null, contentValues);
        writableDatabase.close();
    }

    public List<emiLoanModal> getEMILoanList() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM EMI_loan", (String[]) null);
        while (rawQuery.moveToNext()) {
            emiLoanModal emiloanmodal = new emiLoanModal();
            emiloanmodal.setId(rawQuery.getInt(rawQuery.getColumnIndex(EMI_LOAN_ID)));
            emiloanmodal.setEmiLoanTitle(rawQuery.getString(rawQuery.getColumnIndex(EMI_LOAN_TITLE)));
            emiloanmodal.setEmiLoanAmount(rawQuery.getDouble(rawQuery.getColumnIndex(EMI_LOAN_AMOUNT)));
            emiloanmodal.setEmiLoanRate(rawQuery.getDouble(rawQuery.getColumnIndex(EMI_LOAN_RATE)));
            emiloanmodal.setEmiLoanMonths(rawQuery.getDouble(rawQuery.getColumnIndex(EMI_LOAN_TIME_PERIODS_MONTHS)));
            arrayList.add(emiloanmodal);
        }
        return arrayList;
    }

    public void addTipColumn(String str, double d, double d2, double d3, double d4) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TIP_TITLE, str);
        contentValues.put(TIP_BILL_AMOUNT, Double.valueOf(d));
        contentValues.put(TIP_RATE, Double.valueOf(d2));
        contentValues.put(TIP_TAX_RATE, Double.valueOf(d3));
        contentValues.put(TIP_SPLIT, Double.valueOf(d4));
        writableDatabase.insert(TABLE_TIP, (String) null, contentValues);
        writableDatabase.close();
    }

    public List<tipModal> getTipList() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM tip", (String[]) null);
        while (rawQuery.moveToNext()) {
            tipModal tipmodal = new tipModal();
            tipmodal.setId(rawQuery.getInt(rawQuery.getColumnIndex(TIP_ID)));
            tipmodal.setTitle(rawQuery.getString(rawQuery.getColumnIndex(TIP_TITLE)));
            tipmodal.setBillAmount(rawQuery.getDouble(rawQuery.getColumnIndex(TIP_BILL_AMOUNT)));
            tipmodal.setTaxRate(rawQuery.getDouble(rawQuery.getColumnIndex(TIP_TAX_RATE)));
            tipmodal.setTipRate(rawQuery.getDouble(rawQuery.getColumnIndex(TIP_RATE)));
            tipmodal.setSplit(rawQuery.getDouble(rawQuery.getColumnIndex(TIP_SPLIT)));
            arrayList.add(tipmodal);
        }
        return arrayList;
    }

    public void addFDColumn(String str, double d, double d2, double d3, double d4) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FD_TITLE, str);
        contentValues.put(FD_INVESTMENT_AMOUNT, Double.valueOf(d));
        contentValues.put(FD_INTEREST_RATE, Double.valueOf(d2));
        contentValues.put(FD_YEAR, Double.valueOf(d3));
        contentValues.put(FD_INSTALLMENT, Double.valueOf(d4));
        writableDatabase.insert(TABLE_FD, (String) null, contentValues);
        writableDatabase.close();
    }

    public List<FDModel> getFDList() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM fd", (String[]) null);
        while (rawQuery.moveToNext()) {
            FDModel fDModel = new FDModel();
            fDModel.setId(rawQuery.getInt(rawQuery.getColumnIndex(FD_ID)));
            fDModel.setTitle(rawQuery.getString(rawQuery.getColumnIndex(FD_TITLE)));
            fDModel.setInvestmentAmount(rawQuery.getDouble(rawQuery.getColumnIndex(FD_INVESTMENT_AMOUNT)));
            fDModel.setInterestRate(rawQuery.getDouble(rawQuery.getColumnIndex(FD_INTEREST_RATE)));
            fDModel.setInstallment(rawQuery.getDouble(rawQuery.getColumnIndex(FD_INSTALLMENT)));
            fDModel.setYear(rawQuery.getDouble(rawQuery.getColumnIndex(FD_YEAR)));
            arrayList.add(fDModel);
        }
        return arrayList;
    }

    public void addRDColumn(String str, double d, double d2, double d3, double d4) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RD_TITLE, str);
        contentValues.put(RD_INVESTMENT_AMOUNT, Double.valueOf(d));
        contentValues.put(RD_INTEREST_RATE, Double.valueOf(d2));
        contentValues.put(RD_YEAR, Double.valueOf(d3));
        contentValues.put(RD_INSTALLMENT, Double.valueOf(d4));
        writableDatabase.insert(TABLE_RD, (String) null, contentValues);
        writableDatabase.close();
    }

    public List<RDModel> getRDList() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM rd", (String[]) null);
        while (rawQuery.moveToNext()) {
            RDModel rDModel = new RDModel();
            rDModel.setId(rawQuery.getInt(rawQuery.getColumnIndex(RD_ID)));
            rDModel.setTitle(rawQuery.getString(rawQuery.getColumnIndex(RD_TITLE)));
            rDModel.setInvestmentAmount(rawQuery.getDouble(rawQuery.getColumnIndex(RD_INVESTMENT_AMOUNT)));
            rDModel.setInterestRate(rawQuery.getDouble(rawQuery.getColumnIndex(RD_INTEREST_RATE)));
            rDModel.setInstallment(rawQuery.getDouble(rawQuery.getColumnIndex(RD_INSTALLMENT)));
            rDModel.setYear(rawQuery.getDouble(rawQuery.getColumnIndex(RD_YEAR)));
            arrayList.add(rDModel);
        }
        return arrayList;
    }

    public void addPPFColumn(String str, double d, double d2, Double d3, int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PPF_TITLE, str);
        contentValues.put(PPF_INVESTMENT_AMOUNT, Double.valueOf(d));
        contentValues.put(PPF_INTEREST_RATE, Double.valueOf(d2));
        contentValues.put(PPF_MONTH, d3);
        contentValues.put(PPF_INSTALLMENT, Integer.valueOf(i));
        writableDatabase.insert(TABLE_PPF, (String) null, contentValues);
        writableDatabase.close();
    }

    public List<PPFModel> getPPFList() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM ppf", (String[]) null);
        while (rawQuery.moveToNext()) {
            PPFModel pPFModel = new PPFModel();
            pPFModel.setId(rawQuery.getInt(rawQuery.getColumnIndex(PPF_ID)));
            pPFModel.setTitle(rawQuery.getString(rawQuery.getColumnIndex(PPF_TITLE)));
            pPFModel.setInvestmentAmount(rawQuery.getDouble(rawQuery.getColumnIndex(PPF_INVESTMENT_AMOUNT)));
            pPFModel.setInterestRate(rawQuery.getDouble(rawQuery.getColumnIndex(PPF_INTEREST_RATE)));
            pPFModel.setInstallment(rawQuery.getDouble(rawQuery.getColumnIndex(PPF_INSTALLMENT)));
            pPFModel.setMonth(rawQuery.getDouble(rawQuery.getColumnIndex(PPF_MONTH)));
            arrayList.add(pPFModel);
        }
        return arrayList;
    }

    public void addSimpleInterestColumn(String str, double d, double d2, double d3) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SIMPLE_INTEREST_TITLE, str);
        contentValues.put(SIMPLE_INTEREST_LOAN_AMOUNT, Double.valueOf(d));
        contentValues.put(SIMPLE_INTEREST_INTEREST_RATE, Double.valueOf(d2));
        contentValues.put(SIMPLE_INTEREST_YEAR, Double.valueOf(d3));
        writableDatabase.insert(TABLE_SIMPLE_INTEREST, (String) null, contentValues);
        writableDatabase.close();
    }

    public List<SimpleInterestModel> getSimpleInterestList() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM simple_interest", (String[]) null);
        while (rawQuery.moveToNext()) {
            SimpleInterestModel simpleInterestModel = new SimpleInterestModel();
            simpleInterestModel.setId(rawQuery.getInt(rawQuery.getColumnIndex(SIMPLE_INTEREST_ID)));
            simpleInterestModel.setTitle(rawQuery.getString(rawQuery.getColumnIndex(SIMPLE_INTEREST_TITLE)));
            simpleInterestModel.setLoanAmount(rawQuery.getDouble(rawQuery.getColumnIndex(SIMPLE_INTEREST_LOAN_AMOUNT)));
            simpleInterestModel.setInterestRate(rawQuery.getDouble(rawQuery.getColumnIndex(SIMPLE_INTEREST_INTEREST_RATE)));
            simpleInterestModel.setYear(rawQuery.getDouble(rawQuery.getColumnIndex(SIMPLE_INTEREST_YEAR)));
            arrayList.add(simpleInterestModel);
        }
        return arrayList;
    }

    public void addCompoundInterestColumn(String str, double d, double d2, double d3) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COMPOUND_INTEREST_TITLE, str);
        contentValues.put(COMPOUND_INTEREST_LOAN_AMOUNT, Double.valueOf(d));
        contentValues.put(COMPOUND_INTEREST_INTEREST_RATE, Double.valueOf(d2));
        contentValues.put(COMPOUND_INTEREST_YEAR, Double.valueOf(d3));
        writableDatabase.insert(TABLE_COMPOUND_INTEREST, (String) null, contentValues);
        writableDatabase.close();
    }

    public List<CompoundInterestModel> getCompoundInterestList() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM compound_interest", (String[]) null);
        while (rawQuery.moveToNext()) {
            CompoundInterestModel compoundInterestModel = new CompoundInterestModel();
            compoundInterestModel.setId(rawQuery.getInt(rawQuery.getColumnIndex(COMPOUND_INTEREST_ID)));
            compoundInterestModel.setTitle(rawQuery.getString(rawQuery.getColumnIndex(COMPOUND_INTEREST_TITLE)));
            compoundInterestModel.setLoanAmount(rawQuery.getDouble(rawQuery.getColumnIndex(COMPOUND_INTEREST_LOAN_AMOUNT)));
            compoundInterestModel.setInterestRate(rawQuery.getDouble(rawQuery.getColumnIndex(COMPOUND_INTEREST_INTEREST_RATE)));
            compoundInterestModel.setYear(rawQuery.getDouble(rawQuery.getColumnIndex(COMPOUND_INTEREST_YEAR)));
            arrayList.add(compoundInterestModel);
        }
        return arrayList;
    }

    public void addTVMColumn(String str, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String str2 = str;
        contentValues.put(TVM_TITLE, str);
        contentValues.put(TVM_FUTURE_VALUE, Double.valueOf(d));
        contentValues.put(TVM_PAYMENT, Double.valueOf(d3));
        contentValues.put(TVM_PRESENT_VALUE, Double.valueOf(d2));
        contentValues.put(TVM_RATE, Double.valueOf(d4));
        contentValues.put(TVM_YEAR, Double.valueOf(d5));
        contentValues.put(TVM_INSTALLMENT, Double.valueOf(d6));
        contentValues.put(TVM_SELECT, Double.valueOf(d8));
        contentValues.put(TVM_MODE, Double.valueOf(d7));
        writableDatabase.insert(TABLE_TVM, (String) null, contentValues);
        writableDatabase.close();
    }

    public List<TVMModel> getTVMList() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM tvm", (String[]) null);
        while (rawQuery.moveToNext()) {
            TVMModel tVMModel = new TVMModel();
            tVMModel.setId(rawQuery.getInt(rawQuery.getColumnIndex(TVM_ID)));
            tVMModel.setTitle(rawQuery.getString(rawQuery.getColumnIndex(TVM_TITLE)));
            tVMModel.setFutureValue(rawQuery.getDouble(rawQuery.getColumnIndex(TVM_FUTURE_VALUE)));
            tVMModel.setPayment(rawQuery.getDouble(rawQuery.getColumnIndex(TVM_PAYMENT)));
            tVMModel.setPresentValue(rawQuery.getDouble(rawQuery.getColumnIndex(TVM_PRESENT_VALUE)));
            tVMModel.setRate(rawQuery.getDouble(rawQuery.getColumnIndex(TVM_RATE)));
            tVMModel.setYear(rawQuery.getDouble(rawQuery.getColumnIndex(TVM_YEAR)));
            tVMModel.setInstallment(rawQuery.getDouble(rawQuery.getColumnIndex(TVM_INSTALLMENT)));
            tVMModel.setSelect(rawQuery.getDouble(rawQuery.getColumnIndex(TVM_SELECT)));
            tVMModel.setMode(rawQuery.getDouble(rawQuery.getColumnIndex(TVM_MODE)));
            arrayList.add(tVMModel);
        }
        return arrayList;
    }

    public void addAddIColumn(String str, double d, double d2, double d3, double d4, double d5, double d6) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String str2 = str;
        contentValues.put(ADD_INVESTMENT_TITLE, str);
        contentValues.put(ADD_INVESTMENT_STARTING_PAYMENT, Double.valueOf(d));
        contentValues.put(ADD_INVESTMENT_MONTHLY_PAYMENT, Double.valueOf(d2));
        contentValues.put(ADD_INVESTMENT_RATE, Double.valueOf(d3));
        contentValues.put(ADD_INVESTMENT_MONTH, Double.valueOf(d4));
        contentValues.put(ADD_INVESTMENT_TOTAL_BALANCE, Double.valueOf(d6));
        contentValues.put(ADD_INVESTMENT_TOTAL_INVESTMENT, Double.valueOf(d5));
        writableDatabase.insert(TABLE_ADD_INVESTMENT, (String) null, contentValues);
        writableDatabase.close();
    }

    public List<AddInvestmentModel> getAddIList() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM add_investment", (String[]) null);
        while (rawQuery.moveToNext()) {
            AddInvestmentModel addInvestmentModel = new AddInvestmentModel();
            addInvestmentModel.setId(rawQuery.getInt(rawQuery.getColumnIndex(ADD_INVESTMENT_ID)));
            addInvestmentModel.setTitle(rawQuery.getString(rawQuery.getColumnIndex(ADD_INVESTMENT_TITLE)));
            addInvestmentModel.setStartingPayment(rawQuery.getDouble(rawQuery.getColumnIndex(ADD_INVESTMENT_STARTING_PAYMENT)));
            addInvestmentModel.setMonthlyPayment(rawQuery.getDouble(rawQuery.getColumnIndex(ADD_INVESTMENT_MONTHLY_PAYMENT)));
            addInvestmentModel.setRate(rawQuery.getDouble(rawQuery.getColumnIndex(ADD_INVESTMENT_RATE)));
            addInvestmentModel.setMonth(rawQuery.getDouble(rawQuery.getColumnIndex(ADD_INVESTMENT_MONTH)));
            addInvestmentModel.setTotalInvestment(rawQuery.getDouble(rawQuery.getColumnIndex(ADD_INVESTMENT_TOTAL_INVESTMENT)));
            addInvestmentModel.setBalance(rawQuery.getDouble(rawQuery.getColumnIndex(ADD_INVESTMENT_TOTAL_BALANCE)));
            arrayList.add(addInvestmentModel);
        }
        return arrayList;
    }

    public void addConverterHistory(String str, String str2, String str3, String str4, String str5, int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CONVERTER_HISTORY_DATE_AND_TIME, str);
        contentValues.put(CONVERTER_HISTORY_FORM_CODE, str2);
        contentValues.put(CONVERTER_HISTORY_TO_CODE, str3);
        contentValues.put(CONVERTER_HISTORY_FORM_AMOUNT, str4);
        contentValues.put(CONVERTER_HISTORY_TO_AMOUNT, str5);
        contentValues.put(CURRENCY_IS_FAVORITE, Integer.valueOf(i));
        writableDatabase.insert(TABLE_CONVERTER_HISTORY, (String) null, contentValues);
        writableDatabase.close();
    }

    public List<ConverterHistoryModel> getConverterHistory() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM converter_history", (String[]) null);
        while (rawQuery.moveToNext()) {
            ConverterHistoryModel converterHistoryModel = new ConverterHistoryModel();
            converterHistoryModel.setId(rawQuery.getInt(rawQuery.getColumnIndex(CONVERTER_HISTORY_ID)));
            converterHistoryModel.setTime(rawQuery.getString(rawQuery.getColumnIndex(CONVERTER_HISTORY_DATE_AND_TIME)));
            converterHistoryModel.setFromCode(rawQuery.getString(rawQuery.getColumnIndex(CONVERTER_HISTORY_FORM_CODE)));
            converterHistoryModel.setToCode(rawQuery.getString(rawQuery.getColumnIndex(CONVERTER_HISTORY_TO_CODE)));
            converterHistoryModel.setFromAmount(rawQuery.getString(rawQuery.getColumnIndex(CONVERTER_HISTORY_FORM_AMOUNT)));
            converterHistoryModel.setToAmount(rawQuery.getString(rawQuery.getColumnIndex(CONVERTER_HISTORY_TO_AMOUNT)));
            converterHistoryModel.setIsFavorite(rawQuery.getInt(rawQuery.getColumnIndex(CURRENCY_IS_FAVORITE)));
            arrayList.add(converterHistoryModel);
        }
        return arrayList;
    }

    public List<ConverterHistoryModel> getConverterFavorite() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM converter_history WHERE converter_is_favorite = 0", (String[]) null);
        while (rawQuery.moveToNext()) {
            ConverterHistoryModel converterHistoryModel = new ConverterHistoryModel();
            converterHistoryModel.setId(rawQuery.getInt(rawQuery.getColumnIndex(CONVERTER_HISTORY_ID)));
            converterHistoryModel.setTime(rawQuery.getString(rawQuery.getColumnIndex(CONVERTER_HISTORY_DATE_AND_TIME)));
            converterHistoryModel.setFromCode(rawQuery.getString(rawQuery.getColumnIndex(CONVERTER_HISTORY_FORM_CODE)));
            converterHistoryModel.setToCode(rawQuery.getString(rawQuery.getColumnIndex(CONVERTER_HISTORY_TO_CODE)));
            converterHistoryModel.setFromAmount(rawQuery.getString(rawQuery.getColumnIndex(CONVERTER_HISTORY_FORM_AMOUNT)));
            converterHistoryModel.setToAmount(rawQuery.getString(rawQuery.getColumnIndex(CONVERTER_HISTORY_TO_AMOUNT)));
            converterHistoryModel.setIsFavorite(rawQuery.getInt(rawQuery.getColumnIndex(CURRENCY_IS_FAVORITE)));
            arrayList.add(converterHistoryModel);
        }
        return arrayList;
    }

    public void updateConverterFavorite(String str, String str2, String str3, int i) {
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        contentValues.put(CONVERTER_HISTORY_FORM_CODE, str);
        contentValues.put(CONVERTER_HISTORY_TO_CODE, str2);
        contentValues.put(CONVERTER_HISTORY_FORM_AMOUNT, str3);
        contentValues.put(CURRENCY_IS_FAVORITE, Integer.valueOf(i));
        writableDatabase.update(TABLE_CONVERTER_HISTORY, contentValues, "converter_history_form_code = ? and converter_history_to_code = ? and converter_history_form_amount = ? ", new String[]{str, str2, str3});
    }

    public void removeConverterHistory(int i) {
        getWritableDatabase().delete(TABLE_CONVERTER_HISTORY, "converter_history_id = ? ", new String[]{String.valueOf(i)});
    }
}
