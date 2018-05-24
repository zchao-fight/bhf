package cn.ccf.mapper;

import cn.ccf.pojo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeMapper {
     //视频监控
     List<TreeNode> getParentTreeNode();
     List<YZTCamera> getChildTreeNode();
     //综合展示
     List<YZTCamera> getCamera();
     List<Department> getDepartment();
     List<Equipment> getEquipment();
     //通讯录
     List<Contact> getContact();
     //综合研判
     List<Preplan> getPreplan();
     List<Professor> getProfessor();
     List<Case> getCase();

}
