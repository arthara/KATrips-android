package com.katripstask.katrips.callback;

public interface RequestCallback<T> {
    void requestSuccess(T data);
    void requestFailed(String failedMsg);
}
