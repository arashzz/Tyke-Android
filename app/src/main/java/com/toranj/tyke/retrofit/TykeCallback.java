package com.toranj.tyke.retrofit;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by arash on 7/26/16.
 */
public class TykeCallback<T> implements Callback<T> {

    private T result;
    private TykeCallbackResponse<T> tykeCallbackResponse;

    public TykeCallback(TykeCallbackResponse tykeCallbackResponse) {
        this.tykeCallbackResponse = tykeCallbackResponse;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if(response != null) {
            Object body = response.body();
            try {
                result = (T)body;
                if(tykeCallbackResponse != null) {
                    tykeCallbackResponse.onResponse(result);
                }
                else {
                    Log.w("TykeCallback", "There is no listener assigned for this callback");
                }
            }
            catch(ClassCastException e) {
                Log.e("TykeCallback", "The response body is not the same type as T");
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.e("Tyke", "Arash");
    }
}
