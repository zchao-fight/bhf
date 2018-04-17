package cn.ccf.controller.map;

import cn.ccf.constants.GVS_TYPE;
import cn.ccf.mapper.*;
import cn.ccf.pojo.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.FacetImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class SituationController {

    private static final String VIRTUAL_FILE_PATH = "d:/upload/";


    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private YZTCameraMapper yztCameraMapper;
    @Autowired
    private FacilityMapper facilityMapper;
    @Autowired
    private PreplanMapper preplanMapper;
    @Autowired
    private LawMapper lawMapper;
    @Autowired
    private YZTEventMapper yztEventMapper;
    @Autowired
    private ProfessorMapper professorMapper;
    @Autowired
    private CaseMapper caseMapper;

    @Autowired
    private CommandMapper commandMapper;
    @Autowired
    private MilitaryMapper militaryMapper;

    @Autowired
    private TreeMapper treeMapper;

    @Autowired
    private UploadMapper uploadMapper;

    //md5加密 spring框架自带md5加密
    public String MD5(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }


    @RequestMapping("map/index")
    public String showMap(HttpServletRequest request, int id) throws Exception{

        Logger logger = Logger.getLogger(SituationController.class);
        logger.info("我只是测试一下日志");

        //得到通讯录Databables
        List<Contact> contacts = treeMapper.getContact();
        request.setAttribute("contact", contacts);

        request.getSession().setAttribute("user_id", id);
        return "map/index";
    }

    @RequestMapping("map/createFacility")
    @ResponseBody
    public JSONObject createFacility(@RequestParam("file") MultipartFile file,Facility facility, HttpServletRequest request) {
        int result = facilityMapper.insert(facility);
        System.out.println(result);
        if (file.getSize() != 0) {
            String originalName = file.getOriginalFilename();
            int index = originalName.lastIndexOf(".");
            String uuid = UUID.randomUUID().toString();
            String newFileName = uuid + originalName.substring(index);
            try {
                file.transferTo(new File(VIRTUAL_FILE_PATH+newFileName));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                Upload upload = new Upload();
                upload.setFilename(newFileName);
                upload.setFilepath("http://localhost:8080");
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                upload.setAddtime(dateFormat.format(date));
                upload.setSourceid(facility.getId());
                String fileSuffix = originalName.substring(index+1);
                String[] suffixArray = {"jpg","png", "jpeg", "gif"};
                boolean picFlag = Arrays.asList(suffixArray).contains(fileSuffix.toLowerCase());
                if (picFlag) {
                    upload.setType(32769);
                } else {
                    upload.setType(32768);
                }
                uploadMapper.insert(upload);
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag", "1");
        System.out.println("1");
        return jsonObject;
    }

    @RequestMapping("map/getManagementUnit")
    @ResponseBody
    public List<Department> getManagementUnit() {

        List<Department> managementUnits;
        DepartmentExample departmentExample = new DepartmentExample();
        managementUnits = departmentMapper.selectByExample(departmentExample);
        return managementUnits;

    }

    @RequestMapping("map/saveLayer")
    @ResponseBody
    public JSONObject saveLayer(MilitaryWithBLOBs militaryWithBLOBs, HttpServletRequest request) {

        Integer userId = (Integer) request.getSession().getAttribute("user_id");
        militaryWithBLOBs.setUserid(userId);
        militaryMapper.insert(militaryWithBLOBs);

        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }

    @RequestMapping("map/displayLayer")
    @ResponseBody
    public JSONObject displayLayer(int id) {
        JSONObject jsonObject = new JSONObject();
        MilitaryWithBLOBs militaryWithBLOBs = militaryMapper.selectByPrimaryKey(id);
        jsonObject.put("wktText",militaryWithBLOBs.getWkttext());
        jsonObject.put("picSrc", militaryWithBLOBs.getPicsrc());
        jsonObject.put("picText", militaryWithBLOBs.getPictext());
        jsonObject.put("offsetY", militaryWithBLOBs.getOffsety());
        jsonObject.put("coordinate", militaryWithBLOBs.getCoordinate());
        return  jsonObject;
    }

    @RequestMapping("map/locateDepartment")
    @ResponseBody
    public JSONObject locateDeparment(int id) {
        JSONObject json = new JSONObject();
        Department department = departmentMapper.selectByPrimaryKey(id);

        int parentID = department.getParentid();
        String parentDepartment = "";
        String leaderName = "";
        if (parentID == 0 || parentID == -1) {
            parentDepartment = "无";
        } else {
            departmentMapper.selectByPrimaryKey(parentID);
            parentDepartment = departmentMapper.selectByPrimaryKey(parentID).getName();
        }
        if (department.getLeaderid() != null) {
            int leaderID = Integer.valueOf(department.getLeaderid());
            leaderName = userMapper.selectByPrimaryKey(leaderID).getName();
        } else {
            leaderName = "无";
        }
        json.put("id", department.getId());
        json.put("name", department.getName());
        json.put("addr", department.getAddr());
        json.put("phone", department.getPhone());
        json.put("tax", department.getTax());
        json.put("remark", department.getRemark());
        json.put("lng", department.getLng());
        json.put("lat", department.getLat());
        json.put("leaderName", leaderName);
        json.put("parentDepartment", parentDepartment);

        return json;
    }

    /**
     * zc 内部类
     */
    class YZTCameraVO extends YZTCamera {
        String cameraType, cameraStatus;

        public void setCameraType(String cameraType) {
            this.cameraType = cameraType;
        }

        public void setCameraStatus(String cameraStatus) {
            this.cameraStatus = cameraStatus;
        }

        public String getCameraType() {
            return cameraType;
        }

        public String getCameraStatus() {
            return cameraStatus;
        }
    }

    @RequestMapping("map/locateCamera")
    @ResponseBody
    public YZTCameraVO locateCamera(int id) {
        YZTCamera yztCamera = yztCameraMapper.selectByPrimaryKey(id);
        String cameraType;
        String cameraStatus;
        int objType = yztCamera.getObjtype();
        if (objType == GVS_TYPE.GVS_MONITOR_CAMERABLOT) {
            cameraType = "枪机";
        } else if (objType == GVS_TYPE.GVS_MONITOR_CAMERABALL) {
            cameraType = "球机";
        } else {
            cameraType = "大球";
        }

        int status = yztCamera.getStatus();
        if (status == 0) {
            cameraStatus = "好";
        } else if (status == 1) {
            cameraStatus = "坏";
        } else {
            cameraStatus = "未配置";
        }
        YZTCameraVO yZTCameraVO = new YZTCameraVO();
        yZTCameraVO.setId(yztCamera.getId());
        yZTCameraVO.setName(yztCamera.getName());
        yZTCameraVO.setLatitude(yztCamera.getLatitude());
        yZTCameraVO.setLongitude(yztCamera.getLongitude());
        yZTCameraVO.setAddress(yztCamera.getAddress());
        yZTCameraVO.setFinishtime(yztCamera.getFinishtime());
        yZTCameraVO.setUserunit(yztCamera.getUserunit());
        yZTCameraVO.setManagerunit(yztCamera.getManagerunit());
        yZTCameraVO.setRemark(yztCamera.getRemark());
        yZTCameraVO.setCameraType(cameraType);
        yZTCameraVO.setCameraStatus(cameraStatus);
        return yZTCameraVO;
    }

    @RequestMapping("map/locateFacility")
    @ResponseBody
    public JSONObject locateFacility(int id) {
        Facility facility = facilityMapper.selectByPrimaryKey(id);

        int status = facility.getStatus();
        String facilityStatus;
        if (status == 0) {
            facilityStatus = "正常";
        } else if (status == 1) {
            facilityStatus = "损坏";
        } else {
            facilityStatus = "未知";
        }

//       int type = facility.getObjtype();
//       switch (type) {
//           case 11:
//               break;
//           case 22:
//               break;
//       }
        JSONObject json = new JSONObject();
        json.put("id", facility.getId());
        json.put("longitude", facility.getLongitude());
        json.put("latitude", facility.getLatitude());
        json.put("name", facility.getName());
        json.put("address", facility.getAddress());
        json.put("objtype", "基础设施");
        json.put("childtype", facility.getChildtype());
        json.put("finishtime", facility.getFinishtime());
        json.put("managerunit", facility.getManagerunit());
        json.put("status", facilityStatus);
        json.put("invest", facility.getInvest());
        json.put("remark", facility.getRemark());
        return json;
    }

    @RequestMapping("map/deleteMilitaryLayer")
    @ResponseBody
    public JSONObject deleteMilitaryLayer(int id) {
        militaryMapper.deleteByPrimaryKey(id);
        return new JSONObject();
    }

    @RequestMapping("map/checkPreplanDetails")
    @ResponseBody
    public Preplan checkPreplan(int id) {
        Preplan preplan = preplanMapper.selectByPrimaryKey(id);
        return preplan;
    }

    @RequestMapping("map/checkCaseDetails")
    @ResponseBody
    public Case checkCase(int id) {
        //case关键字 变量名不能是case
        Case cases = caseMapper.selectByPrimaryKey(id);
        return cases;
    }

    @RequestMapping("map/checkProfessorDetails")
    @ResponseBody
    public Professor checkProfessorDetails(int id) {
        Professor professor = professorMapper.selectByPrimaryKey(id);
        return professor;
    }

    @RequestMapping("map/checkLawDetails")
    @ResponseBody
    public Law checkLawDetails(int id) {
        Law law = lawMapper.selectByPrimaryKey(id);
        return law;
    }

    @RequestMapping("map/checkEventDetails")
    @ResponseBody
    public YZTEvent checkEventDetails(int id) {
        YZTEvent yztEvent = yztEventMapper.selectByPrimaryKey(id);
        return yztEvent;
    }

    @RequestMapping("map/sendCommand")
    @ResponseBody
    public void sendCommand(HttpServletRequest request, String commandType, String commandParam) {

        Command command = new Command();
        command.setUserid((Integer) request.getSession().getAttribute("user_id"));
        String clientIP = "";
        try {
//            InetAddress address = InetAddress.getLocalHost();
//            clientIP = address.getHostAddress();
            clientIP = request.getRemoteAddr();
            command.setClientip(clientIP);

        } catch (Exception e) {
            e.printStackTrace();
        }
        command.setUsetype(0);
        command.setCommandtype(commandType);
        command.setCommandparam(commandParam);
        commandMapper.insertInToCommand(command);

        Record record = new Record();
//        record.setTableid(commandMapper.getAutoIncrementID());
        record.setTableid(command.getId());
        record.setTablename("com_command");
        record.setType(0);
        Date date = new Date();
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(date.getTime());//这个就是把时间戳经过处理得到期望格式的时间

        record.setTime(time);
        record.setIp(clientIP);
        commandMapper.insertInToRecord(record);
    }

    @RequestMapping("map/search")
    @ResponseBody
    public HashMap<String, List> search(HttpServletRequest request, String keyword) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.or(departmentExample.createCriteria().andNameLike(likeKeyword(keyword)));
        List<Department> departments = departmentMapper.selectByExample(departmentExample);

        FacilityExample facilityExample = new FacilityExample();
        facilityExample.or(facilityExample.createCriteria().andNameLike(likeKeyword(keyword)));
        List<Facility> facilities = facilityMapper.selectByExample(facilityExample);

        YZTCameraExample yztCameraExample = new YZTCameraExample();
        yztCameraExample.or(yztCameraExample.createCriteria().andNameLike(likeKeyword(keyword)));
        List<YZTCamera> yztCameras = yztCameraMapper.selectByExample(yztCameraExample);

        PreplanExample preplanExample = new PreplanExample();
        preplanExample.or(preplanExample.createCriteria().andNameLike(likeKeyword(keyword)));
        List<Preplan> preplans = preplanMapper.selectByExample(preplanExample);
        request.setAttribute("preplan", preplans);

        LawExample lawExample = new LawExample();
        lawExample.or(lawExample.createCriteria().andNameLike(likeKeyword(keyword)));
        List<Law> laws = lawMapper.selectByExample(lawExample);
        request.setAttribute("law", laws);

        YZTEventExample yztEventExample = new YZTEventExample();
        yztEventExample.or(yztEventExample.createCriteria().andNameLike(likeKeyword(keyword)));
        List<YZTEvent> yztEvents = yztEventMapper.selectByExample(yztEventExample);
        request.setAttribute("event", yztEvents);

        ProfessorExample professorExample = new ProfessorExample();
        professorExample.or(professorExample.createCriteria().andNameLike(likeKeyword(keyword)));
        List<Professor> professors = professorMapper.selectByExample(professorExample);
        request.setAttribute("professor", professors);

        CaseExample caseExample = new CaseExample();
        caseExample.or(caseExample.createCriteria().andNameLike(likeKeyword(keyword)));
        List<Case> cases = caseMapper.selectByExample(caseExample);
        request.setAttribute("case", cases);

        MilitaryExample militaryExample = new MilitaryExample();
        MilitaryExample.Criteria criteria = militaryExample.createCriteria();
        criteria.andUseridEqualTo((Integer) request.getSession().getAttribute("user_id"));
        criteria.andNameLike(likeKeyword(keyword));

//        militaryExample.or(militaryExample.createCriteria().andNameLike(likeKeyword(keyword)));

        List<MilitaryWithBLOBs> militaryWithBLOBs = militaryMapper.selectByExampleWithBLOBs(militaryExample);
        request.setAttribute("military", militaryWithBLOBs);

        HashMap<String, List> map = new HashMap<>();
        map.put("#departmentResult", departments);
        map.put("#facilityResult", facilities);
        map.put("#cameraResult", yztCameras);
        map.put("#preplanResult", preplans);
        map.put("#caseResult", cases);
        map.put("#professorResult", professors);
        map.put("#lawResult", laws);
        map.put("#eventResult", yztEvents);
        map.put("#military", militaryWithBLOBs);
        return map;

    }

    public String likeKeyword(String keyword) {
        return "%" + keyword + "%";
    }


}


