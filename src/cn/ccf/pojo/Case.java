package cn.ccf.pojo;
public class Case {
    private Integer id;

    private String type;

    private String name;

    private String keywords;

    private String eventscale;

    private String eventlevel;

    private String eventtime;

    private String eventaddress;

    private String eventdescribe;

    private String eventsolution;

    private String eventresult;

    private String filename;

    private String filepath;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getEventscale() {
        return eventscale;
    }

    public void setEventscale(String eventscale) {
        this.eventscale = eventscale == null ? null : eventscale.trim();
    }

    public String getEventlevel() {
        return eventlevel;
    }

    public void setEventlevel(String eventlevel) {
        this.eventlevel = eventlevel == null ? null : eventlevel.trim();
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime == null ? null : eventtime.trim();
    }

    public String getEventaddress() {
        return eventaddress;
    }

    public void setEventaddress(String eventaddress) {
        this.eventaddress = eventaddress == null ? null : eventaddress.trim();
    }

    public String getEventdescribe() {
        return eventdescribe;
    }

    public void setEventdescribe(String eventdescribe) {
        this.eventdescribe = eventdescribe == null ? null : eventdescribe.trim();
    }

    public String getEventsolution() {
        return eventsolution;
    }

    public void setEventsolution(String eventsolution) {
        this.eventsolution = eventsolution == null ? null : eventsolution.trim();
    }

    public String getEventresult() {
        return eventresult;
    }

    public void setEventresult(String eventresult) {
        this.eventresult = eventresult == null ? null : eventresult.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}