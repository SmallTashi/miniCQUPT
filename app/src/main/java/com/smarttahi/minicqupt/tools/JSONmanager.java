package com.smarttahi.minicqupt.tools;

import com.smarttahi.minicqupt.Data.Question;
import com.smarttahi.minicqupt.Data.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONmanager {
    public static int getArrayNumber(String data) throws JSONException {
        JSONArray array = new JSONArray(data);
        return array.length();
    }

    public static User checkUser(String data) throws JSONException {
        JSONObject object = new JSONObject(data);
        User user = new User();
        user.setStuNum(object.getString("stuNum"));
        user.setName(object.getString("name"));
        user.setCollege(object.getString("college"));
        user.setClassX(object.getString("class"));
        user.setClassNum(object.getString("classNum"));
        user.setGender(object.getString("gender"));
        user.setMajor(object.getString("major"));
        user.setGrade(object.getString("grade"));
        user.setIdNum(object.getString("idNum"));
        return user;
    }
    public static User getUser(String data,User user) throws JSONException {
        JSONObject bean = new JSONObject(data);
        user.setId(bean.getInt("id"));
        user.setIntroduction(bean.getString("introduce"));
        user.setNickname(bean.getString("nickname"));
        user.setPhoto_thumbnail_src(bean.getString("photo_thumbnail_src"));
        user.setPhoto_src(bean.getString("photo_src"));
        user.setUpdated_time(bean.getString("updated_time"));
        user.setPhone(bean.getString("phone"));
        user.setQq(bean.getString("qq"));
        return user;
    }

    public static Question.QuestionDataBean getQuestionList(String data) throws JSONException {
        JSONObject object = new JSONObject(data);
        Question.QuestionDataBean bean = new Question.QuestionDataBean();
        bean.setAnswer_num(object.getInt("answer_num"));
        bean.setCreated_at(object.getString("created_at"));
        bean.setTags(object.getString("tags"));
        bean.setTitle(object.getString("title"));
        bean.setDescription(object.getString("description"));
        bean.setDisappear_at(object.getString("disappear_at"));
        bean.setGender(object.getString("gender"));
        bean.setId(object.getInt("id"));
        bean.setNickname(object.getString("nickname"));
        bean.setKind(object.getString("kind"));
        bean.setIs_anonymous(object.getInt("is_anonymous"));
        bean.setReward(object.getInt("reward"));
        bean.setPhoto_thumbnail_src(object.getString("photo_thumbnail_src"));

        return bean;
    }

//    //通过反射解析
//    public static Object Analyse(int ParaNum,Object object,String data){
//        JSONObject jsonObject = new JSONObject();
//
//        Class clazz = object.getClass();
//        Method[] methods = clazz.getMethods();
//        Field[] fields = clazz.getFields();
//
//
//    }
}
