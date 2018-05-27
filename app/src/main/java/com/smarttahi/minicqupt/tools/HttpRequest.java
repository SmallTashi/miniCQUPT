package com.smarttahi.minicqupt.tools;

import android.os.Handler;
import android.util.Log;

import com.smarttahi.minicqupt.Data.Question;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class HttpRequest {

    private static OutputStream out = null;

    private static HttpURLConnection connection = null;

    public static void sentHttpRequest(final String parameter, final String api, final Callback callback) {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(api);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setReadTimeout(5 * 1000);
                    connection.setConnectTimeout(10 * 1000);
                    connection.setRequestMethod("POST");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setUseCaches(false);
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    out = connection.getOutputStream();
                    out.write(parameter.getBytes());
                    out.flush();

                    if (connection.getResponseCode() == 200) {
                        final byte[] in = ReadStream(connection.getInputStream());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONmanager jsoNmanager = new JSONmanager();
                                  Response data = new Response(in);
                                    ArrayList<Question.DataBean> list = new ArrayList<>();
                                    for (int i = 0; i < JSONmanager.getArrayNumber(data.getDate()); i++) {
                                        Question.DataBean dataBean = new Question.DataBean();
                                       dataBean= JSONmanager.getQuestionList(data.getDate());
                                        list.add(dataBean);
                                    }

                                    callback.onSuccess(list);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    callback.onFiled(e);
                                }
                                //使用回调，返回请求得到的数据
                            }
                        });
                    } else {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.onFiled(new Exception("网络连接失败"));
                            }
                        });
                    }
                } catch (final ProtocolException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFiled(e);
                        }
                    });
                } catch (final IOException e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFiled(e);
                        }
                    });
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                    if (out!=null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    public static void sentHttpRequest(final String parameter, final String api,final String api2, final Callback callback) {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(api);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setReadTimeout(5 * 1000);
                    connection.setConnectTimeout(10 * 1000);
                    connection.setRequestMethod("POST");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setUseCaches(false);
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    out = connection.getOutputStream();
                    out.write(parameter.getBytes());
                    out.flush();
                    if (connection.getResponseCode() == 200) {
                        final byte[] in = ReadStream(connection.getInputStream());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    if(api.equals(Config.Api_Question_List)){
                                        JSONmanager jsoNmanager = new JSONmanager();
                                        Response data2 = new Response(in);
                                        ArrayList<Question.DataBean> list = new ArrayList<>();
                                        for (int i = 0; i < JSONmanager.getArrayNumber(data2.getDate()); i++) {
                                            Question.DataBean dataBean;
                                            dataBean= JSONmanager.getQuestionList(data2.getDate());
                                            list.add(dataBean);
                                        }
                                        callback.onSuccess(list);
                                    }
                                    Response data = new Response(in);
                                    callback.onSuccess(data);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    callback.onFiled(e);
                                }
                                //使用回调，返回请求得到的数据
                            }
                        });
                    } else {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.onFiled(new Exception("网络连接失败"));
                            }
                        });
                    }
                } catch (final ProtocolException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFiled(e);
                        }
                    });
                } catch (final IOException e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFiled(e);
                        }
                    });
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                    if (out!=null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }


    public static class Response {
        private int State;
        private String Info;
        private String Date = null;

        Response(byte[] response) {
            String rawDate = new String(response);
            try {
                JSONObject object = new JSONObject(rawDate);
                State = object.getInt("status");
                Info = object.getString("info");
                Date = object.getString("data");
            } catch (JSONException e) {
                e.printStackTrace();
                Date = null;
            }
        }

        public String getInfo() {
            return Info;
        }

        public String getDate() {
            return Date;
        }

        public int getState() {
            return State;
        }
    }

    public static String getJSONOf(String date, String name) {
        try {
            return new JSONObject(date).getString(name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static interface Callback {
        void onSuccess(Response response) throws JSONException;

        void onSuccess(ArrayList<?> response) throws JSONException;

        void onFiled(Exception e);
    }

    private static byte[] ReadStream(InputStream in) {
        //建立通道对象
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //创建保存数据的字节数组
        byte[] temp = new byte[1024];
        //开始读取数据
        int len;
        try {
            if (in != null) {
                while ((len = in.read(temp)) != -1) {
                    outputStream.write(temp, 0, len);
                    //数据由输入流写入字节数组，
                    //由字节数组写入到输出流中
                }
                in.close();
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
