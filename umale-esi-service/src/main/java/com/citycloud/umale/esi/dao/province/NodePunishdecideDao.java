package com.citycloud.umale.esi.dao.province;

import com.citycloud.umale.esi.po.NodePunishdecide;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface NodePunishdecideDao {


    int insertSelective(@Param("pojo") NodePunishdecide pojo);

    int insertList(@Param("pojos") List<NodePunishdecide> pojo);


}
