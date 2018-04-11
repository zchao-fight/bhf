package cn.ccf.pojo;

public class YZTCamera {
    private Integer id;

    private Integer layerid;

    private String domainid;

    private String name;

    private Double latitude;

    private Double longitude;

    private String address;

    private Integer status;

    private String playurl;

    private String ptzurl;

    private String finishtime;

    private String userunit;

    private String managerunit;

    private String resourceid;

    private Integer objtype;

    private String statustime;

    private Integer hot;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLayerid() {
        return layerid;
    }

    public void setLayerid(Integer layerid) {
        this.layerid = layerid;
    }

    public String getDomainid() {
        return domainid;
    }

    public void setDomainid(String domainid) {
        this.domainid = domainid == null ? null : domainid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPlayurl() {
        return playurl;
    }

    public void setPlayurl(String playurl) {
        this.playurl = playurl == null ? null : playurl.trim();
    }

    public String getPtzurl() {
        return ptzurl;
    }

    public void setPtzurl(String ptzurl) {
        this.ptzurl = ptzurl == null ? null : ptzurl.trim();
    }

    public String getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(String finishtime) {
        this.finishtime = finishtime == null ? null : finishtime.trim();
    }

    public String getUserunit() {
        return userunit;
    }

    public void setUserunit(String userunit) {
        this.userunit = userunit == null ? null : userunit.trim();
    }

    public String getManagerunit() {
        return managerunit;
    }

    public void setManagerunit(String managerunit) {
        this.managerunit = managerunit == null ? null : managerunit.trim();
    }

    public String getResourceid() {
        return resourceid;
    }

    public void setResourceid(String resourceid) {
        this.resourceid = resourceid == null ? null : resourceid.trim();
    }

    public Integer getObjtype() {
        return objtype;
    }

    public void setObjtype(Integer objtype) {
        this.objtype = objtype;
    }

    public String getStatustime() {
        return statustime;
    }

    public void setStatustime(String statustime) {
        this.statustime = statustime == null ? null : statustime.trim();
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}