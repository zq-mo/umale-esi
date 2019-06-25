package com.citycloud.umale.esi.dao.province;

import com.citycloud.umale.esi.po.NodePunishimpart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface NodePunishimpartDao {


    int insertSelective(@Param("pojo") NodePunishimpart pojo);

    int insertList(@Param("pojos") List<NodePunishimpart> pojo);

}
