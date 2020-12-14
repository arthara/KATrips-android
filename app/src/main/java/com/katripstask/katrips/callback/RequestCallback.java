package com.katripstask.katrips.callback;

import com.katripstask.katrips.response.StasiunResponse;

public interface RequestCallback<T> {
    StasiunResponse requestSuccess(T data);
    void requestFailed(String failedMsg);
}
