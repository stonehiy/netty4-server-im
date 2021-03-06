package com.netty4.server.mapper;

import com.netty4.server.entity.UserStateIm;
import org.apache.ibatis.annotations.Param;

public interface UserStateImMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_user_state
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_user_state
     *
     * @mbg.generated
     */
    int insert(UserStateIm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_user_state
     *
     * @mbg.generated
     */
    int insertSelective(UserStateIm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_user_state
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserStateIm selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") UserStateIm.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_user_state
     *
     * @mbg.generated
     */
    UserStateIm selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_user_state
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserStateIm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_user_state
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserStateIm record);
}