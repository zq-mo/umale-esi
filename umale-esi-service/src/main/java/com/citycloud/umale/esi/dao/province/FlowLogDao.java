package com.citycloud.umale.esi.dao.province;

import com.citycloud.umale.esi.po.FlowLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlowLogDao {


    int insertSelective(@Param("pojo") FlowLog pojo);

    int insertList(@Param("pojos") List<FlowLog> pojo);

}
