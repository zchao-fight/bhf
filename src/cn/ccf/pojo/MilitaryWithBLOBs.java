package cn.ccf.pojo;

public class MilitaryWithBLOBs extends Military {
    private String wkttext;

    private String picsrc;

    private String coordinate;

    private String pictext;

    private String offsety;

    public String getWkttext() {
        return wkttext;
    }

    public void setWkttext(String wkttext) {
        this.wkttext = wkttext == null ? null : wkttext.trim();
    }

    public String getPicsrc() {
        return picsrc;
    }

    public void setPicsrc(String picsrc) {
        this.picsrc = picsrc == null ? null : picsrc.trim();
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate == null ? null : coordinate.trim();
    }

    public String getPictext() {
        return pictext;
    }

    public void setPictext(String pictext) {
        this.pictext = pictext == null ? null : pictext.trim();
    }

    public String getOffsety() {
        return offsety;
    }

    public void setOffsety(String offsety) {
        this.offsety = offsety == null ? null : offsety.trim();
    }
}