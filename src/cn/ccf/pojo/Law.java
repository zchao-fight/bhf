package cn.ccf.pojo;

public class Law {
    private Integer id;

    private String type;

    private String name;

    private String keywords;

    private String digest;

    public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	private String abledtime;

    private String pulishnumber;

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

  

    public String getAbledtime() {
        return abledtime;
    }

    public void setAbledtime(String abledtime) {
        this.abledtime = abledtime == null ? null : abledtime.trim();
    }

    public String getPulishnumber() {
        return pulishnumber;
    }

    public void setPulishnumber(String pulishnumber) {
        this.pulishnumber = pulishnumber == null ? null : pulishnumber.trim();
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