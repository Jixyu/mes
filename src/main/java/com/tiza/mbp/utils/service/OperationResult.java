package com.tiza.mbp.utils.service;

/**
 * CreateDate:2016/7/28
 *
 * @version 1.0.
 * @auther XieChen
 */
public class OperationResult {
    public enum ResultType {
        Success,
        Error,
        QueryNull,
    }

    private ResultType resultType;
    private String resultMessage;
    private Object resultData;

    public ResultType getResultType() {
        return resultType;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public OperationResult(ResultType resultType, String resultMessage) {
        this.resultType = resultType;
        this.resultMessage = resultMessage;
    }

    public OperationResult(ResultType resultType) {
        this.resultType = resultType;
    }

    public OperationResult(ResultType resultType, Object resultData, String resultMessage) {
        this.resultType = resultType;
        this.resultData = resultData;
        this.resultMessage = resultMessage;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }
}


