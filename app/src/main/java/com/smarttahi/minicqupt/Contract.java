package com.smarttahi.minicqupt;

public interface Contract {
    interface MvpView {
        void addToast(String s);

        void showHome();

    }

    interface Presenter {
        void exitLogin();

        void login(String name, String paw);

        void checkState();
    }

    interface MvpCallBack {
        void onSuccess(String data);

        void onFailed();

        void onError(String s);
    }
}
