package com.toranj.tyke.retrofit;

/**
 * Created by arash on 7/28/16.
 */
public interface TykeCallbackResponse<T> {
    void onResponse(T result);
    void onFailure();
}
