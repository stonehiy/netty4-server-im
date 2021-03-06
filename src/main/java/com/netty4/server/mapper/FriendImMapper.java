package com.netty4.server.mapper;

import com.netty4.server.entity.FriendIm;
import org.apache.ibatis.annotations.Param;

public interface FriendImMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_friend
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_friend
     *
     * @mbg.generated
     */
    int insert(FriendIm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_friend
     *
     * @mbg.generated
     */
    int insertSelective(FriendIm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_friend
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    FriendIm selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") FriendIm.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_friend
     *
     * @mbg.generated
     */
    FriendIm selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_friend
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(FriendIm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_friend
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(FriendIm record);
}