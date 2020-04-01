package com.ykb.spring;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private String               errorStr;
    private int                  errorCause;
    private final List<ErrorObj> extraErrors = new ArrayList<>();

    public void addError(final ErrorObj oErrorObjParam) {
        this.extraErrors.add(oErrorObjParam);
    }

    public ErrorObj(final String errorStrParam,
                    final int errorCauseParam) {
        super();
        this.errorStr = errorStrParam;
        this.errorCause = errorCauseParam;
    }

    public String getErrorStr() {
        return this.errorStr;
    }

    public void setErrorStr(final String errorStrParam) {
        this.errorStr = errorStrParam;
    }

    public int getErrorCause() {
        return this.errorCause;
    }

    public void setErrorCause(final int errorCauseParam) {
        this.errorCause = errorCauseParam;
    }

    public List<ErrorObj> getExtraErrors() {
        return this.extraErrors;
    }


}
