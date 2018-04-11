package cn.ccf.pojo;

public class YZTEvent {
    private Integer id;

    private String name;

    private Integer eventtypeid;

    private Integer sourcetype;

    private String time;

    private String address;

    private String reportpeople;

    private Integer responsepeopleid;

    private Integer level;

    private Integer scale;

    private Double latitude;

    private Double longitude;

    private Integer commandgroupid;

    private Integer status;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getEventtypeid() {
        return eventtypeid;
    }

    public void setEventtypeid(Integer eventtypeid) {
        this.eventtypeid = eventtypeid;
    }

    public Integer getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(Integer sourcetype) {
        this.sourcetype = sourcetype;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getReportpeople() {
        return reportpeople;
    }

    public void setReportpeople(String reportpeople) {
        this.reportpeople = reportpeople == null ? null : reportpeople.trim();
    }

    public Integer getResponsepeopleid() {
        return responsepeopleid;
    }

    public void setResponsepeopleid(Integer responsepeopleid) {
        this.responsepeopleid = responsepeopleid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
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

    public Integer getCommandgroupid() {
        return commandgroupid;
    }

    public void setCommandgroupid(Integer commandgroupid) {
        this.commandgroupid = commandgroupid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}