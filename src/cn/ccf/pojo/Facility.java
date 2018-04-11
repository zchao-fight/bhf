package cn.ccf.pojo;

public class Facility {
    private Integer id;

    private Integer layerid;

    private String domainid;

    private Integer objtype;

    private String name;

    private String address;

    private String buildrange;

    private Double latitude;

    private Double longitude;

    private Integer status;

    private String finishtime;

    private Double invest;

    private String managerunit;

    private String mediaid;

    private String childtype;

    private String statustime;

    private Integer hot;

    private String remark;

    private byte[] kml;

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

    public Integer getObjtype() {
        return objtype;
    }

    public void setObjtype(Integer objtype) {
        this.objtype = objtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBuildrange() {
        return buildrange;
    }

    public void setBuildrange(String buildrange) {
        this.buildrange = buildrange == null ? null : buildrange.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(String finishtime) {
        this.finishtime = finishtime == null ? null : finishtime.trim();
    }

    public Double getInvest() {
        return invest;
    }

    public void setInvest(Double invest) {
        this.invest = invest;
    }

    public String getManagerunit() {
        return managerunit;
    }

    public void setManagerunit(String managerunit) {
        this.managerunit = managerunit == null ? null : managerunit.trim();
    }

    public String getMediaid() {
        return mediaid;
    }

    public void setMediaid(String mediaid) {
        this.mediaid = mediaid == null ? null : mediaid.trim();
    }

    public String getChildtype() {
        return childtype;
    }

    public void setChildtype(String childtype) {
        this.childtype = childtype == null ? null : childtype.trim();
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

    public byte[] getKml() {
        return kml;
    }

    public void setKml(byte[] kml) {
        this.kml = kml;
    }
}