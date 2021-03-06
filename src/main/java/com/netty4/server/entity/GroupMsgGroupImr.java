package com.netty4.server.entity;

import java.time.LocalDateTime;

public class GroupMsgGroupImr {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column imr_group_msg_group.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column imr_group_msg_group.fk_to_id
     *
     * @mbg.generated
     */
    private Long fkToId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column imr_group_msg_group.fk_group_msg_id
     *
     * @mbg.generated
     */
    private Long fkGroupMsgId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column imr_group_msg_group.state
     *
     * @mbg.generated
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column imr_group_msg_group.create_time
     *
     * @mbg.generated
     */
    private LocalDateTime createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column imr_group_msg_group.id
     *
     * @return the value of imr_group_msg_group.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column imr_group_msg_group.id
     *
     * @param id the value for imr_group_msg_group.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column imr_group_msg_group.fk_to_id
     *
     * @return the value of imr_group_msg_group.fk_to_id
     *
     * @mbg.generated
     */
    public Long getFkToId() {
        return fkToId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column imr_group_msg_group.fk_to_id
     *
     * @param fkToId the value for imr_group_msg_group.fk_to_id
     *
     * @mbg.generated
     */
    public void setFkToId(Long fkToId) {
        this.fkToId = fkToId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column imr_group_msg_group.fk_group_msg_id
     *
     * @return the value of imr_group_msg_group.fk_group_msg_id
     *
     * @mbg.generated
     */
    public Long getFkGroupMsgId() {
        return fkGroupMsgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column imr_group_msg_group.fk_group_msg_id
     *
     * @param fkGroupMsgId the value for imr_group_msg_group.fk_group_msg_id
     *
     * @mbg.generated
     */
    public void setFkGroupMsgId(Long fkGroupMsgId) {
        this.fkGroupMsgId = fkGroupMsgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column imr_group_msg_group.state
     *
     * @return the value of imr_group_msg_group.state
     *
     * @mbg.generated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column imr_group_msg_group.state
     *
     * @param state the value for imr_group_msg_group.state
     *
     * @mbg.generated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column imr_group_msg_group.create_time
     *
     * @return the value of imr_group_msg_group.create_time
     *
     * @mbg.generated
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column imr_group_msg_group.create_time
     *
     * @param createTime the value for imr_group_msg_group.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table imr_group_msg_group
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fkToId=").append(fkToId);
        sb.append(", fkGroupMsgId=").append(fkGroupMsgId);
        sb.append(", state=").append(state);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table imr_group_msg_group
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GroupMsgGroupImr other = (GroupMsgGroupImr) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFkToId() == null ? other.getFkToId() == null : this.getFkToId().equals(other.getFkToId()))
            && (this.getFkGroupMsgId() == null ? other.getFkGroupMsgId() == null : this.getFkGroupMsgId().equals(other.getFkGroupMsgId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table imr_group_msg_group
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFkToId() == null) ? 0 : getFkToId().hashCode());
        result = prime * result + ((getFkGroupMsgId() == null) ? 0 : getFkGroupMsgId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table imr_group_msg_group
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id", "id", "BIGINT"),
        fkToId("fk_to_id", "fkToId", "BIGINT"),
        fkGroupMsgId("fk_group_msg_id", "fkGroupMsgId", "BIGINT"),
        state("state", "state", "INTEGER"),
        createTime("create_time", "createTime", "TIMESTAMP");

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table imr_group_msg_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table imr_group_msg_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table imr_group_msg_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table imr_group_msg_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table imr_group_msg_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table imr_group_msg_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table imr_group_msg_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table imr_group_msg_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column, String javaProperty, String jdbcType) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table imr_group_msg_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.column + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table imr_group_msg_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.column + " ASC";
        }
    }
}