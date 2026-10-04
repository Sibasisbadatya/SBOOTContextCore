package org.example.ApplicationProperties;

import org.springframework.beans.factory.annotation.Value;

public class PaymentGateway {
    private String type;
    private Integer retryCount;

    public PaymentGateway(@Value("${paymentGateway.type}") String type,@Value("${paymentGateway.retry-count}") Integer retryCount) {
        this.type = type;
        this.retryCount = retryCount;
    }


    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
