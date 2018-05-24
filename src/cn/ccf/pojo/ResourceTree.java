package cn.ccf.pojo;

import lombok.Data;

@Data
public class ResourceTree {
    private String id;
    private String pId;
    private String name;
    private String type;
    private double log;
    private double lat;
    private String icon;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }
}
