package com.citycloud.umale.esi.dao.province;

import com.citycloud.umale.esi.po.NodeYscase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface NodeYscaseDao {

    int insertList(@Param("pojos") List<NodeYscase> pojo);

}
