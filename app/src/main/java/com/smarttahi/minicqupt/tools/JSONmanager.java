package com.smarttahi.minicqupt.tools;

import com.smarttahi.minicqupt.Data.Question;
import com.smarttahi.minicqupt.Data.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class JSONmanager {
    public static int getArrayNumber(String data) throws JSONException {
        JSONArray array = new JSONArray(data);
        return array.length();
    }

    public static void getUser(String data) throws JSONException {
        JSONObject object = new JSONObject(data);
        User user = new User();

            JSONArray result = new JSONArray(object.getJSONArray(data));

                JSONObject bean = new JSONObject();
                user.setStuNum(bean.getString("stuNum"));

                user.setId(bean.getInt("id"));
                user.setIntroduction(bean.getString("college"));
                user.setNickname(bean.getString("nickname"));
                user.setPhoto_thumbnail_src(bean.getString("college"));
                user.setPhoto_src(bean.getString("college"));
                user.setUpdated_time(bean.getString("college"));
                user.setPhone(bean.getString("college"));
                user.setQq(bean.getString("college"));

                user.setName(bean.getString("name"));


                user.setCollege(bean.getString("college"));
                user.setClassX(bean.getString("class"));
                user.setClassNum(object.getString("classNum"));
                user.setGender(bean.getString("gender"));
                user.setMajor(bean.getString("major"));
                user.setGrade(bean.getString("grade"));
                user.setIdNum(bean.getString("idNum"));

        MyApplication.setUser(user);

    }


    public static Question.DataBean getQuestionList(String data) {


        return null;
    }
}
