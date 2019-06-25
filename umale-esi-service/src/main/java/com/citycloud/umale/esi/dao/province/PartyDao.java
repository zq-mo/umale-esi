package com.citycloud.umale.esi.dao.province;

import com.citycloud.umale.esi.po.Party;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PartyDao {

    int insertList(@Param("pojos") List<Party> pojo);
}
