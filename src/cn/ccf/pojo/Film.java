package cn.ccf.pojo;

public class Film {
    private Integer id;

    private String title;

    private String country;

    private String during;

    private String leadingrole;

    private String type;

    private Boolean top;

    private String createtime;

    private String imgurl;

    private String filmurl;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getDuring() {
        return during;
    }

    public void setDuring(String during) {
        this.during = during == null ? null : during.trim();
    }

    public String getLeadingrole() {
        return leadingrole;
    }

    public void setLeadingrole(String leadingrole) {
        this.leadingrole = leadingrole == null ? null : leadingrole.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Boolean getTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public String getFilmurl() {
        return filmurl;
    }

    public void setFilmurl(String filmurl) {
        this.filmurl = filmurl == null ? null : filmurl.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}