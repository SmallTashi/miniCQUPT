package com.smarttahi.cquptinhand.Data;

public class User {
    /**
     * status : 200
     * info : success
     * state : 200
     * data : {"id":2828,"stunum":"2016210xxx","introduction":"An Android Developer","username":"李吉","nickname":"Jay","gender":"男","photo_thumbnail_src":"http://wx.idsbllp.cn/cyxbsMobile/Public/photo/thumbnail/1520430636_1133226083.png","photo_src":"http://wx.idsbllp.cn/cyxbsMobile/Public/photo/1520430636_1133226083.png","updated_time":"2018-05-05 23:15:35","phone":"159235xxxxx","qq":"14325xxxxx"}
     */

    private int status;
    private String info;
    private int state;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2828
         * stunum : 2016210xxx
         * introduction : An Android Developer
         * username : 李吉
         * nickname : Jay
         * gender : 男
         * photo_thumbnail_src : http://wx.idsbllp.cn/cyxbsMobile/Public/photo/thumbnail/1520430636_1133226083.png
         * photo_src : http://wx.idsbllp.cn/cyxbsMobile/Public/photo/1520430636_1133226083.png
         * updated_time : 2018-05-05 23:15:35
         * phone : 159235xxxxx
         * qq : 14325xxxxx
         */

        private int id;
        private String stunum;
        private String introduction;
        private String username;
        private String nickname;
        private String gender;
        private String photo_thumbnail_src;
        private String photo_src;
        private String updated_time;
        private String phone;
        private String qq;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStunum() {
            return stunum;
        }

        public void setStunum(String stunum) {
            this.stunum = stunum;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getPhoto_thumbnail_src() {
            return photo_thumbnail_src;
        }

        public void setPhoto_thumbnail_src(String photo_thumbnail_src) {
            this.photo_thumbnail_src = photo_thumbnail_src;
        }

        public String getPhoto_src() {
            return photo_src;
        }

        public void setPhoto_src(String photo_src) {
            this.photo_src = photo_src;
        }

        public String getUpdated_time() {
            return updated_time;
        }

        public void setUpdated_time(String updated_time) {
            this.updated_time = updated_time;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }
    }
}
