package com.smarttahi.minicqupt.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class User {

    /**
     * status : 200
     * info : success
     * data : {"stuNum":"2016210xxx","name":"李吉","college":"通信与信息工程学院","class":"01041602班","classNum":"01041602","gender":"男","major":"0104","grade":"2016","idNum":"xxxxx"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * stuNum : 2016210xxx
         * name : 李吉
         * college : 通信与信息工程学院
         * class : 01041602班
         * classNum : 01041602
         * gender : 男
         * major : 0104
         * grade : 2016
         * idNum : xxxxx
         */

        private String stuNum;
        private String name;
        private String college;
        private String classX;
        private String classNum;
        private String gender;
        private String major;
        private String grade;
        private String idNum;

        public String getStuNum() {
            return stuNum;
        }

        public void setStuNum(String stuNum) {
            this.stuNum = stuNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public String getClassX() {
            return classX;
        }

        public void setClassX(String classX) {
            this.classX = classX;
        }

        public String getClassNum() {
            return classNum;
        }

        public void setClassNum(String classNum) {
            this.classNum = classNum;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getIdNum() {
            return idNum;
        }

        public void setIdNum(String idNum) {
            this.idNum = idNum;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.stuNum);
            dest.writeString(this.name);
            dest.writeString(this.college);
            dest.writeString(this.classX);
            dest.writeString(this.classNum);
            dest.writeString(this.gender);
            dest.writeString(this.major);
            dest.writeString(this.grade);
            dest.writeString(this.idNum);
        }

        public DataBean() {
        }

        DataBean(Parcel in) {
            this.stuNum = in.readString();
            this.name = in.readString();
            this.college = in.readString();
            this.classX = in.readString();
            this.classNum = in.readString();
            this.gender = in.readString();
            this.major = in.readString();
            this.grade = in.readString();
            this.idNum = in.readString();
        }

        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }



}
