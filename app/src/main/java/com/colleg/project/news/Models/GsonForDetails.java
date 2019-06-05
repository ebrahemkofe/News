package com.colleg.project.news.Models;

import java.util.List;

public class GsonForDetails {


    /**
     * post_id : 31
     * post_title : صباحك اندرجراوند| أغنية "سلام" لكريمة نايت
     * aouther : أحمد عمارة
     * soundcloud : https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/89930938&color=%23ff5500&auto_play=false&hide_related=false&show_comments=true&show_user=true&show_reposts=false&show_teaser=true&visual=true
     * under_image : كريمة نايت.. صورة أرشيفية
     * tags : [{"tag0":"كريمة نايت","tag1":"الجزائر","tag2":"فتحي سلامة","tag3":"جرامي","tag4":"مصر","tag5":"شرقيات"}]
     * post_img : https://2030news.online/uploads/blog/posts/post-15592926995cf0eb1b402ed.jpg
     * short_description : كلمات: كريمة نايت، وألحان: كريمة نايت وفريدريك جيل
     * long_description :

     كلمات: كريمة نايت
     ألحان: كريمة نايت وفريدريك جيل



     ولدت كريمة نايت بالجزائر، ونشأت بها، حيث احترفت الغناء، وامتهنت الرقص الحديث، قبل أن تسافر إلى مصر عام 1998، حيث عملت بالرقص على مسارح دار الأوبرا المصرية، كما شكلت بصوتها المختلف، رفقة الملحن فتحي سلامة الحاصل على جائزة الجرامي، ثنائياً متناغماً، قبل أن تنجح بانضمامها إلى فرقته شرقيات، في إصدار ألبوم غنائي مشترك وحيد، وإقامة حفلات غنائية عديدة بمختلف دول العالم، حتى استقرت بالسويد، حيث سجلت هناك بالتعاون مع الملحن فريدريك جيل، ألبومها المنفرد الأول، الذي يحتوي على 13 أغنية، كتبت كلماتها بنفسها، باللغة العربية تارة، والفرنسية تارة أخرى.
     * favorite : false
     */

    private int post_id;
    private String post_title;
    private String aouther;
    private String soundcloud;
    private String under_image;
    private String post_img;
    private String short_description;
    private String long_description;
    private String favorite;
    private List<TagsBean> tags;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getAouther() {
        return aouther;
    }

    public void setAouther(String aouther) {
        this.aouther = aouther;
    }

    public String getSoundcloud() {
        return soundcloud;
    }

    public void setSoundcloud(String soundcloud) {
        this.soundcloud = soundcloud;
    }

    public String getUnder_image() {
        return under_image;
    }

    public void setUnder_image(String under_image) {
        this.under_image = under_image;
    }

    public String getPost_img() {
        return post_img;
    }

    public void setPost_img(String post_img) {
        this.post_img = post_img;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class TagsBean {
        /**
         * tag0 : كريمة نايت
         * tag1 : الجزائر
         * tag2 : فتحي سلامة
         * tag3 : جرامي
         * tag4 : مصر
         * tag5 : شرقيات
         */

        private String tag0;
        private String tag1;
        private String tag2;
        private String tag3;
        private String tag4;
        private String tag5;

        public String getTag0() {
            return tag0;
        }

        public void setTag0(String tag0) {
            this.tag0 = tag0;
        }

        public String getTag1() {
            return tag1;
        }

        public void setTag1(String tag1) {
            this.tag1 = tag1;
        }

        public String getTag2() {
            return tag2;
        }

        public void setTag2(String tag2) {
            this.tag2 = tag2;
        }

        public String getTag3() {
            return tag3;
        }

        public void setTag3(String tag3) {
            this.tag3 = tag3;
        }

        public String getTag4() {
            return tag4;
        }

        public void setTag4(String tag4) {
            this.tag4 = tag4;
        }

        public String getTag5() {
            return tag5;
        }

        public void setTag5(String tag5) {
            this.tag5 = tag5;
        }
    }
}
