package com.citycloud.umale.esi.dao.province;

import com.citycloud.umale.esi.po.NodeTakeevidence;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NodeTakeevidenceDao {


    int insertSelective(@Param("pojo") NodeTakeevidence pojo);

    int insertList(@Param("pojos") List<NodeTakeevidence> pojo);

}
