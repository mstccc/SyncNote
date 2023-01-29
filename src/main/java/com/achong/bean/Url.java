package com.achong.bean;

public class Url {
    private String url;
    private String strData;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStrData() {
        return strData;
    }

    public void setStrData(String strData) {
        this.strData = strData;
    }

    public Url(String url, String strData) {
        this.url = url;
        this.strData = strData;
    }


    @Override
    public String toString() {
        return "Url{" +
                "url='" + url + '\'' +
                ", strData='" + strData + '\'' +
                '}';
    }

}
