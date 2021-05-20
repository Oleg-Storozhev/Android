
package com.example.homework3.IBM;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Example {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("annualEarnings")
    @Expose
    private List<AnnualEarning> annualEarnings = null;

    private final AnnualEarning annualEarning = null;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<AnnualEarning> getAnnualEarnings() {
        return annualEarnings;
    }

    public void setAnnualEarnings(List<AnnualEarning> annualEarnings) {
        this.annualEarnings = annualEarnings;
    }

    public AnnualEarning getAnnualEarning(){
        return annualEarning;
    }

}
