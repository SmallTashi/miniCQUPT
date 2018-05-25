package com.smarttahi.cquptinhand.Data;

import java.util.List;

public class Question {
    /**
     * status : 200
     * info : success
     * data : {"is_self":0,"title":"这个代码太难写了\\\\ue056","description":"代码是真的难","reward":"2","disappear_at":"2018-04-27 02:22:22","tags":"PHP","kind":"其他","photo_urls":[],"questioner_nickname":"。","questioner_photo_thumbnail_src":"","questioner_gender":"女","answers":[{"id":"10","nickname":"Jay","photo_thumbnail_src":"http://wx.idsbllp.cn/cyxbsMobile/Public/photo/thumbnail/1503374869_593154551.png","gender":"男","content":"菜","created_at":"2018-04-22 14:08:50","praise_num":"0","comment_num":"0","is_adopted":"0","is_praised":0,"photo_url":[]}]}
     */

    private int status;
    private String info;
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * is_self : 0
         * title : 这个代码太难写了\\ue056
         * description : 代码是真的难
         * reward : 2
         * disappear_at : 2018-04-27 02:22:22
         * tags : PHP
         * kind : 其他
         * photo_urls : []
         * questioner_nickname : 。
         * questioner_photo_thumbnail_src :
         * questioner_gender : 女
         * answers : [{"id":"10","nickname":"Jay","photo_thumbnail_src":"http://wx.idsbllp.cn/cyxbsMobile/Public/photo/thumbnail/1503374869_593154551.png","gender":"男","content":"菜","created_at":"2018-04-22 14:08:50","praise_num":"0","comment_num":"0","is_adopted":"0","is_praised":0,"photo_url":[]}]
         */

        private int is_self;
        private String title;
        private String description;
        private String reward;
        private String disappear_at;
        private String tags;
        private String kind;
        private String questioner_nickname;
        private String questioner_photo_thumbnail_src;
        private String questioner_gender;
        private List<?> photo_urls;
        private List<AnswersBean> answers;

        public int getIs_self() {
            return is_self;
        }

        public void setIs_self(int is_self) {
            this.is_self = is_self;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getReward() {
            return reward;
        }

        public void setReward(String reward) {
            this.reward = reward;
        }

        public String getDisappear_at() {
            return disappear_at;
        }

        public void setDisappear_at(String disappear_at) {
            this.disappear_at = disappear_at;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getQuestioner_nickname() {
            return questioner_nickname;
        }

        public void setQuestioner_nickname(String questioner_nickname) {
            this.questioner_nickname = questioner_nickname;
        }

        public String getQuestioner_photo_thumbnail_src() {
            return questioner_photo_thumbnail_src;
        }

        public void setQuestioner_photo_thumbnail_src(String questioner_photo_thumbnail_src) {
            this.questioner_photo_thumbnail_src = questioner_photo_thumbnail_src;
        }

        public String getQuestioner_gender() {
            return questioner_gender;
        }

        public void setQuestioner_gender(String questioner_gender) {
            this.questioner_gender = questioner_gender;
        }

        public List<?> getPhoto_urls() {
            return photo_urls;
        }

        public void setPhoto_urls(List<?> photo_urls) {
            this.photo_urls = photo_urls;
        }

        public List<AnswersBean> getAnswers() {
            return answers;
        }

        public void setAnswers(List<AnswersBean> answers) {
            this.answers = answers;
        }

        public static class AnswersBean {
            /**
             * id : 10
             * nickname : Jay
             * photo_thumbnail_src : http://wx.idsbllp.cn/cyxbsMobile/Public/photo/thumbnail/1503374869_593154551.png
             * gender : 男
             * content : 菜
             * created_at : 2018-04-22 14:08:50
             * praise_num : 0
             * comment_num : 0
             * is_adopted : 0
             * is_praised : 0
             * photo_url : []
             */

            private String id;
            private String nickname;
            private String photo_thumbnail_src;
            private String gender;
            private String content;
            private String created_at;
            private String praise_num;
            private String comment_num;
            private String is_adopted;
            private int is_praised;
            private List<?> photo_url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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

            public String getPraise_num() {
                return praise_num;
            }

            public void setPraise_num(String praise_num) {
                this.praise_num = praise_num;
            }

            public String getComment_num() {
                return comment_num;
            }

            public void setComment_num(String comment_num) {
                this.comment_num = comment_num;
            }

            public String getIs_adopted() {
                return is_adopted;
            }

            public void setIs_adopted(String is_adopted) {
                this.is_adopted = is_adopted;
            }

            public int getIs_praised() {
                return is_praised;
            }

            public void setIs_praised(int is_praised) {
                this.is_praised = is_praised;
            }

            public List<?> getPhoto_url() {
                return photo_url;
            }

            public void setPhoto_url(List<?> photo_url) {
                this.photo_url = photo_url;
            }
        }
    }
}
