package cn.ccf.constants;

public class Authority {

	
	public static final int AUTH_CTRL = 0x10;//不受控
	public static final int AUTH_STATUS_OK = 0x01;//有权限
	public static final int AUTH_UNKOWN = -1;//未知权限
    //门户权限(标签)
	public static final int AUTH_PORTAL = 0x01000000;//联防网站        
	public static final int AUTH_PORTAL_NOTICE = AUTH_PORTAL + 0x100000 + AUTH_CTRL + AUTH_STATUS_OK;//通知公告
	public static final int AUTH_PORTAL_ZB = AUTH_PORTAL + 0x200000 + AUTH_CTRL + AUTH_STATUS_OK;//值班信息
	public static final int AUTH_PORTAL_WORK = AUTH_PORTAL + 0x300000 + AUTH_CTRL + AUTH_STATUS_OK;//工作动态
	public static final int AUTH_PORTAL_NEW = AUTH_PORTAL + 0x400000 + AUTH_CTRL + AUTH_STATUS_OK;//联防要闻
	public static final int AUTH_PORTAL_BASIC_STYLE = AUTH_PORTAL + 0x500000 + AUTH_CTRL + AUTH_STATUS_OK;//基层风采
	public static final int AUTH_PORTAL_LAW = AUTH_PORTAL + 0x600000 + AUTH_CTRL + AUTH_STATUS_OK;//政策法规
	public static final int AUTH_PORTAL_SC = AUTH_PORTAL + 0x700000 + AUTH_CTRL + AUTH_STATUS_OK;//统计信息
	public static final int AUTH_PORTAL_VIDEO = AUTH_PORTAL + 0x800000 + AUTH_CTRL + AUTH_STATUS_OK;//戍边影院
	public static final int AUTH_PORTAL_VIDEO_VIEW = AUTH_PORTAL + 0x810000 + AUTH_CTRL + AUTH_STATUS_OK;//观看影片
	public static final int AUTH_PORTAL_VIDEO_MGR = AUTH_PORTAL + 0x820000;//影院管理
	public static final int AUTH_PORTAL_VIDEO_MGR_UPLOAD = AUTH_PORTAL + 0x821000;//上传电影
	public static final int AUTH_PORTAL_VIDEO_MGR_DEL = AUTH_PORTAL + 0x822000;//删除电影
	public static final int AUTH_PORTAL_VIDEO_MGR_TYPE = AUTH_PORTAL + 0x823000;//类别管理
	public static final int AUTH_PORTAL_TALK = AUTH_PORTAL + 0x900000 + AUTH_CTRL + AUTH_STATUS_OK;//论坛互动
	public static final int AUTH_PORTAL_TALK_ADD_TYPE = AUTH_PORTAL + 0x910000;//添加类别
	public static final int AUTH_PORTAL_TALK_ADD_PLATE = AUTH_PORTAL + 0x920000;//添加板块
	public static final int AUTH_PORTAL_TALK_ADD_TOP = AUTH_PORTAL + 0x930000;//置顶/取消
	public static final int AUTH_PORTAL_TALK_MY = AUTH_PORTAL + 0x940000 + AUTH_CTRL + AUTH_STATUS_OK;//个人中心
	public static final int AUTH_PORTAL_TALK_SEND = AUTH_PORTAL + 0x950000 + AUTH_CTRL + AUTH_STATUS_OK;//发帖
	public static final int AUTH_PORTAL_TALK_RECV = AUTH_PORTAL + 0x960000 + AUTH_CTRL + AUTH_STATUS_OK;//回帖
	public static final int AUTH_PORTAL_TALK_DEL = AUTH_PORTAL + 0x970000;//删帖
			
	/**		
	public static final int AUTH_PORTAL = 16777216;
	public static final int AUTH_PORTAL_NOTICE = 17825809;
	public static final int AUTH_PORTAL_ZB = 18874385;
	public static final int AUTH_PORTAL_WORK = 19922961;
	public static final int AUTH_PORTAL_NEW = 20971537;
	public static final int AUTH_PORTAL_BASIC_STYLE = 22020113;
	public static final int AUTH_PORTAL_LAW = 23068689;
	public static final int AUTH_PORTAL_SC = 24117265;
	public static final int AUTH_PORTAL_VIDEO = 25165841;
	public static final int AUTH_PORTAL_VIDEO_VIEW = 25231377;
	public static final int AUTH_PORTAL_VIDEO_MGR = 25296896;
	public static final int AUTH_PORTAL_VIDEO_MGR_UPLOAD = 25300992;
	public static final int AUTH_PORTAL_VIDEO_MGR_DEL = 25305088;
	public static final int AUTH_PORTAL_VIDEO_MGR_TYPE = 25309184;
	public static final int AUTH_PORTAL_TALK = 26214417;
	public static final int AUTH_PORTAL_TALK_ADD_TYPE = 26279936;
	public static final int AUTH_PORTAL_TALK_ADD_PLATE = 26345472;
	public static final int AUTH_PORTAL_TALK_ADD_TOP = 26411008;
	public static final int AUTH_PORTAL_TALK_MY = 26476561;
	public static final int AUTH_PORTAL_TALK_SEND = 26542097;
	public static final int  AUTH_PORTAL_TALK_RECV = 26607633;
	public static final int AUTH_PORTAL_TALK_DEL = 26673152;
	*/
	
}
