package edu.wctc.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestErrorResponse {
    private int status;
    private String message;
    private long timestamp;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int value) {
        status = value;
    }

    public void setTimestamp(long currentTimeMillis) {
        timestamp = currentTimeMillis;
    }
}
