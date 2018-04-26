package cn.ccf.constants;

//资源类型
public class GVS_TYPE
{
	public static final int GVS_UNKOWN = 0;             //未知
	public static final int GVS_LANDMARK = 0x10000;     //地标
	public static final int GVS_LINE = 0x20000;         //线
 	public static final int GVS_RECT = 0x40000;         //矩形
 	public static final int GVS_POLYGON = 0x80000;      //多变形
 	public static final int GVS_ALL_ICON = GVS_LANDMARK + GVS_LINE + GVS_RECT + GVS_POLYGON;

 	public static final int GVS_MAP = 0xF0000;          //地图
 	public static final int GVS_MAP_LAYER = GVS_MAP + 1;//图层

    //解放军单位
  	public static final int GVS_UNIT = GVS_ALL_ICON + 0x100;
  	public static final int GVS_UNIT_MILITARYREGION = GVS_UNIT + 0x01;  //军区
  	public static final int GVS_UNIT_MILITARDIVISION = GVS_UNIT + 0x02; //军分区
  	public static final int GVS_UNIT_GROUP = GVS_UNIT + 0x03;           //团
  	public static final int GVS_UNIT_CAMP = GVS_UNIT + 0x04;            //营连
   	public static final int GVS_UNIT_PROVINCE = GVS_UNIT + 0x05;        //省军区

    //武警单位
   	public static final int GVS_UNIT_TCROPS = GVS_UNIT + 0X10;          //总队
   	public static final int  GVS_UNIT_DETACHMENT = GVS_UNIT + 0X11;      //支队
   	public static final int GVS_UNIT_BRIGADE = GVS_UNIT + 0X12;         //大队
   	public static final int GVS_UNIT_POLICESTATION = GVS_UNIT + 0X13;   //派出所

    //监控设施
   	private static final int GVS_MONITOR = GVS_ALL_ICON + 0X200;
   	private static final int GVS_MONITOR_CAMERA = GVS_MONITOR + 0x10;
   	public static final int GVS_MONITOR_CAMERABLOT = GVS_MONITOR_CAMERA + 0X01; //枪机
   	public static final int GVS_MONITOR_CAMERABALL = GVS_MONITOR_CAMERA + 0X02; //球机
   	public static final int GVS_MONITOR_CAMERABIG = GVS_MONITOR_CAMERA + 0X03;  //大球

   	public static final int GVS_MONITOR_ALARM = GVS_MONITOR + 0X20;     //报警装置
   	public static final int GVS_MONITOR_TRANSFER = GVS_MONITOR + 0X21;  //传输路线
   	public static final int GVS_MONITOR_RADAR = GVS_MONITOR + 0X22;     //雷达
   	public static final int GVS_MONITOR_CENTER = GVS_MONITOR + 0X23;     //监控中心
   	public static final int GVS_MONITOR_STATION = GVS_MONITOR + 0X24;     //监控站


    //交通设施
   	private static final int GVS_TRAFFIC = GVS_ALL_ICON + 0X400;
   	public static final int GVS_TRAFFIC_ROAD = GVS_TRAFFIC + 0X01;      //道路
   	public static final int GVS_TRAFFIC_WHARF = GVS_TRAFFIC + 0X02;     //码头
   	public static final int GVS_TRAFFIC_TRAMAC = GVS_TRAFFIC + 0X03;    //停机平
   	public static final int GVS_TRAFFIC_BRIDGE = GVS_TRAFFIC + 0X04;    //桥梁
   	public static final int GVS_TRAFFIC_WAY = GVS_TRAFFIC + 0X05;    //通道
   	public static final int GVS_TRAFFIC_PORT = GVS_TRAFFIC + 0X06;    //口岸
   
    //拦阻设施
	private static final int GVS_BLOCK = GVS_ALL_ICON + 0X800;
   	public static final int GVS_BLOCK_VECHICLE = GVS_BLOCK + 0X01;      //车辆
   	public static final int GVS_BLOCK_ISOLATION =  GVS_BLOCK + 0X02;    //隔离带
   	public static final int GVS_BLOCK_WIRENET = GVS_BLOCK + 0X03;       //铁丝网
   	public static final int GVS_BLOCK_IRONFENCE = GVS_BLOCK + 0X04;     //铁栅栏

    //配套设施
	private static final int GVS_SUPPORTING = GVS_ALL_ICON + 0X1000;
   	public static final int GVS_SUPPORTING_1 = GVS_SUPPORTING + 0X01;   //标志牌
    public static final int GVS_SUPPORTING_2 = GVS_SUPPORTING + 0X02;   //灯塔
    public static final int GVS_SUPPORTING_3 = GVS_SUPPORTING + 0X03;   //电子墙
    public static final int GVS_SUPPORTING_4 = GVS_SUPPORTING + 0X04;   //瞭望台
    public static final int GVS_SUPPORTING_5 = GVS_SUPPORTING + 0X05;   //执勤房

    //其它
	private static final int GVS_OBJOther = GVS_ALL_ICON + 0X2000;
    public static final int GVS_OBJOther_1 = GVS_OBJOther + 0x01;       //界碑
    public static final int GVS_OBJOther_2 = GVS_OBJOther + 0x02;       //国门

    //自定义图标
    public static final int GVS_ICON = GVS_ALL_ICON + 0X3000;
    public static final int GVS_CAR = GVS_ICON + 0X01;                  //车辆
    public static final int GVS_PLANE = GVS_ICON + 0X02;                //飞机
    public static final int GVS_PEOPLE = GVS_ICON + 0X03;               //人员
    public static final int GVS_FONT = GVS_ICON + 0X04;                 //标绘字体

	//基础设施文件
	 public static final int COM_OBJECT = 0X8000;
	 public static final int COM_OBJECT_IMAGE = 0X8001;//图片 png jpg jpeg bmp
	 public static final int COM_OBJECT_VIDEO = 0X8002;//视频 mp4 avi rmvb
	 public static final int COM_OBJECT_DOC = 0X8003;  //DOC\PDF\TXT\EXCEL
	 public static final int COM_OBJECT_OTHER = 0X8004;//其他

	//情报附件
	 public static final int WD_SITUATION_REPORT = 0x10000;
	 public static final int WD_SITUATION_REPORT_ANNEX = 0x10001;//情报附件

	 public static final int COM_CONTACT = 0x20000;//联系人形象照片
	 public static final int COM_CONTACT_IMAGE = 0x20001;//图片

	 public static final int COM_PROFESSOR = 0x40000;//专家形象照片
	 public static final int COM_PROFESSOR_IMAGE = 0x40001;//图片

	//装备文件
	 public static final int COM_EQUIPMENT = 0X80000;
	 public static final int COM_EQUIPMENT_IMAGE = 0X80001;//图片 png jpg jpeg bmp
	 public static final int COM_EQUIPMENT_VIDEO = 0X80002;//视频 mp4 avi rmvb
	 public static final int COM_EQUIPMENT_DOC = 0X80003;  //DOC\PDF\TXT\EXCEL
	 public static final int COM_EQUIPMENT_OTHER = 0X80004;//其他

	//服务协议使用文件
	 public static final int SERVICE = 0x100000;
	 public static final int SERVICE_COORDINATION = SERVICE + 0x11;//协同标绘使用



}