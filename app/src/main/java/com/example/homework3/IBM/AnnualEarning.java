
package com.example.homework3.IBM;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnnualEarning {

    @SerializedName("fiscalDateEnding")
    @Expose
    private String fiscalDateEnding;
    @SerializedName("reportedEPS")
    @Expose
    private String reportedEPS;

    public String getFiscalDateEnding() {
        return fiscalDateEnding;
    }

    public void setFiscalDateEnding(String fiscalDateEnding) {
        this.fiscalDateEnding = fiscalDateEnding;
    }

    public String getReportedEPS() {
        return reportedEPS;
    }

    public void setReportedEPS(String reportedEPS) {
        this.reportedEPS = reportedEPS;
    }

}
