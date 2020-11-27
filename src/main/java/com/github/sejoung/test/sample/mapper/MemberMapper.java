package com.github.sejoung.test.sample.mapper;

import com.github.sejoung.test.sample.dto.MemberDTO;
import com.github.sejoung.test.sample.dto.MemberDetailDTO;
import java.util.List;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {

  List<MemberDTO> selectMemberListXML();

  List<MemberDetailDTO> selectMemberDetailListXML(Long memberId);

  @Select("select member_id as memberId, name, create_dt as createDate from MEMBER")
  @Results(value = {
    @Result(property = "memberId", column = "memberId"),
    @Result(property = "name", column = "name"),
    @Result(property = "createDate", column = "createDate"),
    @Result(property = "details", column = "memberId", javaType = List.class, many = @Many(select = "selectMemberDetailList"))
  })
  List<MemberDTO> selectMemberList();

  @Select("select member_detail_id as memberDetailId, type, description from MEMBER_DETAIL where member_id = #{memberId}")
  @Results(value = {
    @Result(property = "memberDetailId", column = "memberDetailId"),
    @Result(property = "type", column = "type"),
    @Result(property = "description", column = "description")
  })
  List<MemberDetailDTO> selectMemberDetailList(Long memberId);


  List<MemberDTO> selectMemberListJoinXML();

}
