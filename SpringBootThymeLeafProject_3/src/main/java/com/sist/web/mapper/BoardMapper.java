package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;
@Mapper
@Repository
public interface BoardMapper {
	public List<BoardVO> boardListData(Map map);
	public int boardRowCount();
	public void boardInsert(BoardVO vo);
	
	public void boardHitIncrement(int no);
	public BoardVO boardDetailData(int no);
	
	public String boardGetPassword(int no);
	public void boardUpdate(BoardVO vo);
	
	/*
	 *  <select id="boardParentInfoData" resultType="com.sist.web.vo.BoardVO"
    parameterType="int">
      SELECT group_id,group_step,group_tab
      FROM SpringReplyBoard
      WHERE no=#{no}
    </select>
	<update id="boardGroupStepIncrement" parameterType="com.sist.web.vo.BoardVO">
	  UPDATE springReplyBoard SET
	  group_step=group_step+1
	  WHERE group_id=#{group_id} AND group_step>#{group_step}
	</update>
	<!-- 데이터 추가 -->
	<insert id="boardReplyInsert" parameterType="com.sist.web.vo.BoardVO">
     INSERT INTO springReplyBoard(no,name,subject,content,pwd,group_id,group_step,group_tab,root)
     VALUES(srb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},#{group_id},#{group_step},#{group_tab},#{root}
     )
   </insert>
   <update id="boardDepthIncrement" parameterType="int">
     UPDATE springReplyBoard SET
     depth=depth+1
     WHERE no=#{no}
   </update>
	 */
	
	public BoardVO boardParentInfoData(int no);
	public void boardGroupStepIncrement(BoardVO vo);
	public void boardReplyInsert(BoardVO vo);
	public void boardDepthIncrement(int no);
	
	/*
	 *  <select id="boardDeleteInfoData" resultType="com.sist.web.vo.BoardVO" parameterType="int">
     SELECT depth,root FROM springReplyBoardd
     WHERE no=#{no}
    </select>
    <update id="boardSubjectChange" parameterType="int">
      UPDATE springReplyBoard SET
      subject='관리자에 의해 삭제된 게시물입니다',
      content='관리자에 의해 삭제된 게시물입니다'
      WHERE no=#{no}
    </update>
    <delete id="boardDelete" parameterType="int">
      DELETE FROM springReplyBoard
      WHERE no=#{no}
    </delete>
    <update id="boardDepthDecrement" parameterType="int">
      UPDATE springReplyBoard SET
      depth=depth-1
      WHERE no=#{no}
    </update>
	 */
	public BoardVO boardDeleteInfoData(int no);
	public void boardSubjectChange(int no);
	public void boardDelete(int no);
	public void boardDepthDecrement(int no);
}
