package com.smarttahi.minicqupt.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class CommentList {
    /**
     * status : 200
     * info : success
     * data : [{"content":"测试","created_at":"2018-02-24 01:45:56","nickname":"溟\\\\n濛","photo_thumbnail_src":"http://wx.idsbllp.cn/cyxbsMobile/Public/photo/thumbnail/1503374918_2132490885.png","gender":"男"},{"content":"测试2","created_at":"2018-02-24 01:48:42","nickname":"溟\\\\n濛","photo_thumbnail_src":"http://wx.idsbllp.cn/cyxbsMobile/Public/photo/thumbnail/1503374918_2132490885.png","gender":"男"}]
     */

    private int status;
    private String info;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * content : 测试
         * created_at : 2018-02-24 01:45:56
         * nickname : 溟\\n濛
         * photo_thumbnail_src : http://wx.idsbllp.cn/cyxbsMobile/Public/photo/thumbnail/1503374918_2132490885.png
         * gender : 男
         */

        private String content;
        private String created_at;
        private String nickname;
        private String photo_thumbnail_src;
        private String gender;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPhoto_thumbnail_src() {
            return photo_thumbnail_src;
        }

        public void setPhoto_thumbnail_src(String photo_thumbnail_src) {
            this.photo_thumbnail_src = photo_thumbnail_src;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.content);
            dest.writeString(this.created_at);
            dest.writeString(this.nickname);
            dest.writeString(this.photo_thumbnail_src);
            dest.writeString(this.gender);
        }

        public DataBean() {
        }

         DataBean(Parcel in) {
            this.content = in.readString();
            this.created_at = in.readString();
            this.nickname = in.readString();
            this.photo_thumbnail_src = in.readString();
            this.gender = in.readString();
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
