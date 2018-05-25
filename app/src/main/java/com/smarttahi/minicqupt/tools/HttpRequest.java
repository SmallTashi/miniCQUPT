package com.smarttahi.cquptinhand.tools;

import android.os.Handler;
import android.util.Log;

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

import javax.net.ssl.HttpsURLConnection;

public class HttpRequest {
    private static HttpsURLConnection connections = null;

    private static HttpURLConnection connection = null;

    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpsURLConnection conn = (HttpsURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestMethod("POST");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }

    public static void sentHttpRequest(final String parameter, final String api, final Callback callback) {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //"https://www.huluzc.com/calabash/code/phone?"+"&username="+pa+"&category=0"
                    URL url = new URL(api);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setReadTimeout(5 * 1000);
                    connection.setConnectTimeout(10 * 1000);
                    if (parameter == null) {
                        connection.setRequestMethod("GET");
                        connection.connect();
                    } else {
                        connection.setRequestMethod("POST");
                        connection.setDoInput(true);
                        connection.setDoOutput(true);
                        connection.setUseCaches(false);
                        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        OutputStream out = connection.getOutputStream();
                        out.write(parameter.getBytes());
                        out.close();
                    }
                    if (connection.getResponseCode() == 200) {
                        final byte[] temp = ReadStream(connection.getInputStream());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    callback.onSuccess(new Response(temp));
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
                }
            }
        }).start();
    }


    public static void GetVerif(final String parameter, final String api, HttpRequest.Callback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] date = new byte[0];

                try {
                    //"https://www.huluzc.com/calabash/code/phone?"+"&phone="+pa+"&category=0"
                    URL url = new URL(api);
                    connections = (HttpsURLConnection) url.openConnection();
                    connections.setReadTimeout(10 * 1000);
                    connections.setConnectTimeout(5 * 1000);
                    if (parameter == null) {
                        connections.setRequestMethod("GET");
                        connections.connect();
                    } else {
                        connections.setRequestMethod("POST");
                        connections.setDoInput(true);
                        connections.setDoOutput(true);
                        connections.setUseCaches(false);
                        connections.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                        connections.setRequestProperty("Content-Length", String.valueOf(parameter.length()));
                        OutputStream out = connections.getOutputStream();
                        out.write(parameter.getBytes());
                        out.close();
                    }
                    BufferedInputStream reader=new BufferedInputStream(connections.getInputStream());
                    date = ReadStream(reader);
                    reader.close();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (connections != null) {
                        connections.disconnect();
                    }
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
//                            new Response();
                        }
                    });
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
            Log.v("register", rawDate);
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

    public interface Callback {
        void onSuccess(Response response) throws JSONException;

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
