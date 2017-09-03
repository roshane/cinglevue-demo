package com.example.demo.util;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by roshane on 9/3/17.
 */
@JsonPropertyOrder({"status", "message", "data"})
public class ApiResponse<T> {

    private T data;
    private String message;
    private int status;

    public static class Builder<T> {
        private T _data;
        private String _message;
        private int _status;
        private HttpStatus _httpStatus;

        public Builder<T> withData(T data) {
            this._data = data;
            return this;
        }

        public Builder<T> withMessage(String message) {
            this._message = message;
            return this;
        }

        public Builder<T> withStatus(HttpStatus httpStatus) {
            this._message = httpStatus.getReasonPhrase();
            this._status = httpStatus.value();
            this._httpStatus = httpStatus;
            return this;
        }

        public ResponseEntity<ApiResponse<?>> build() {
            return ResponseEntity.status(_httpStatus)
                    .body(new ApiResponse<T>(this));
        }
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    @SuppressWarnings("unchecked")
    private ApiResponse(Builder builder) {
        this.data = (T) builder._data;
        this.status = builder._status;
        this.message = builder._message;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
