package com.netty4.server.mapper;

import com.netty4.server.entity.FriendGroupIm;
import org.apache.ibatis.annotations.Param;

public interface FriendGroupImMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_friend_group
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_friend_group
     *
     * @mbg.generated
     */
    int insert(FriendGroupIm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_friend_group
     *
     * @mbg.generated
     */
    int insertSelective(FriendGroupIm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_friend_group
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    FriendGroupIm selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") FriendGroupIm.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_friend_group
     *
     * @mbg.generated
     */
    FriendGroupIm selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_friend_group
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(FriendGroupIm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_friend_group
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(FriendGroupIm record);
}