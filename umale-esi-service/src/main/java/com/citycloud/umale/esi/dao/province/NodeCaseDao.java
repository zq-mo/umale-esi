package com.citycloud.umale.esi.dao.province;

import com.citycloud.umale.esi.po.NodeCase;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface NodeCaseDao {


    int insertSelective(@Param("pojo") NodeCase pojo);

    int insertList(@Param("pojos") List<NodeCase> pojo);


}
