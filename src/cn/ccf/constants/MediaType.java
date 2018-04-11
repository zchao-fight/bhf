package cn.ccf.constants;

public class MediaType {

	public static final int TYPE_UNKOWN = 0;// 未知
	// 门户;边防要闻
	public static final int MH_NEWS = 0x100;
	public static final int MH_NEWS_MEDIA_ALL = 0x0100;// 任何类型
	public static final int MH_NEWS_MEDIA_IMAGE = 0x0101;// 图片 png jpg jpeg bmp
	public static final int MH_NEWS_MEDIA_ADUIO = 0x0102;// 音频 mp3
	public static final int MH_NEWS_MEDIA_VIDOE = 0x0103;// 视频 avi
	public static final int MH_NEWS_MEDIA_DOC = 0x0104;// 文档 doc docx
	public static final int MH_NEWS_MEDIA_RTF = 0x0105;//rtf 

	// 门户，基层风采
	public static final int MH_BASIC_STYLE = 0x200;
	public static final int MH_BASIC_STYLE_MEDIA_ALL = 0x0200;
	public static final int MH_BASIC_STYLE_MEDIA_IMAGE = 0x0201;
	public static final int MH_BASIC_STYLE_MEDIA_DOC = 0x0204;// 文档 doc docx
	public static final int MH_BASIC_STYLE_MEDIA_RTF = 0x0205;//rtf 

	// 门户，通知公告
	public static final int MH_NOTICE = 0x0400;
	public static final int MH_NOTICE_MEDIA_ALL = 0x0400;
	public static final int MH_NOTICE_MEDIA_DOC = 0x0404;
	public static final int MH_NOTICE_MEDIA_RTF = 0x0405;//rtf 

	// 门户，工作动态
	public static final int MH_WORK = 0x0800;
	public static final int MH_WORK_MEDIA_ALL = 0x0800;
	public static final int MH_WORK_MEDIA_IMAGE = 0x801;
	public static final int MH_WORK_MEDIA_DOC = 0x0804;
	public static final int MH_WORK_MEDIA_RTF = 0x0805;

	// 门户，置顶图片 == sourceid = 0;
	public static final int MH_IMAGE = 0x1000;
	public static final int MH_IMAGE_MEDIA_ALL = 0x1000;
	public static final int MH_IMAGE_MEDIA_IMAGE = 0x1001;// 图片 png jpg jpeg bmp

}
