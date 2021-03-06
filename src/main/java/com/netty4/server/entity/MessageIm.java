package com.netty4.server.entity;

import java.time.LocalDateTime;

public class MessageIm {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column im_message.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column im_message.state
     *
     * @mbg.generated
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column im_message.send_time
     *
     * @mbg.generated
     */
    private LocalDateTime sendTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column im_message.fk_message_type_id
     *
     * @mbg.generated
     */
    private Long fkMessageTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column im_message.fk_from_id
     *
     * @mbg.generated
     */
    private Long fkFromId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column im_message.fk_to_id
     *
     * @mbg.generated
     */
    private Long fkToId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column im_message.content
     *
     * @mbg.generated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column im_message.id
     *
     * @return the value of im_message.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column im_message.id
     *
     * @param id the value for im_message.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column im_message.state
     *
     * @return the value of im_message.state
     *
     * @mbg.generated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column im_message.state
     *
     * @param state the value for im_message.state
     *
     * @mbg.generated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column im_message.send_time
     *
     * @return the value of im_message.send_time
     *
     * @mbg.generated
     */
    public LocalDateTime getSendTime() {
        return sendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column im_message.send_time
     *
     * @param sendTime the value for im_message.send_time
     *
     * @mbg.generated
     */
    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column im_message.fk_message_type_id
     *
     * @return the value of im_message.fk_message_type_id
     *
     * @mbg.generated
     */
    public Long getFkMessageTypeId() {
        return fkMessageTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column im_message.fk_message_type_id
     *
     * @param fkMessageTypeId the value for im_message.fk_message_type_id
     *
     * @mbg.generated
     */
    public void setFkMessageTypeId(Long fkMessageTypeId) {
        this.fkMessageTypeId = fkMessageTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column im_message.fk_from_id
     *
     * @return the value of im_message.fk_from_id
     *
     * @mbg.generated
     */
    public Long getFkFromId() {
        return fkFromId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column im_message.fk_from_id
     *
     * @param fkFromId the value for im_message.fk_from_id
     *
     * @mbg.generated
     */
    public void setFkFromId(Long fkFromId) {
        this.fkFromId = fkFromId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column im_message.fk_to_id
     *
     * @return the value of im_message.fk_to_id
     *
     * @mbg.generated
     */
    public Long getFkToId() {
        return fkToId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column im_message.fk_to_id
     *
     * @param fkToId the value for im_message.fk_to_id
     *
     * @mbg.generated
     */
    public void setFkToId(Long fkToId) {
        this.fkToId = fkToId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column im_message.content
     *
     * @return the value of im_message.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column im_message.content
     *
     * @param content the value for im_message.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_message
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
        sb.append(", state=").append(state);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", fkMessageTypeId=").append(fkMessageTypeId);
        sb.append(", fkFromId=").append(fkFromId);
        sb.append(", fkToId=").append(fkToId);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_message
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
        MessageIm other = (MessageIm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getSendTime() == null ? other.getSendTime() == null : this.getSendTime().equals(other.getSendTime()))
            && (this.getFkMessageTypeId() == null ? other.getFkMessageTypeId() == null : this.getFkMessageTypeId().equals(other.getFkMessageTypeId()))
            && (this.getFkFromId() == null ? other.getFkFromId() == null : this.getFkFromId().equals(other.getFkFromId()))
            && (this.getFkToId() == null ? other.getFkToId() == null : this.getFkToId().equals(other.getFkToId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table im_message
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getSendTime() == null) ? 0 : getSendTime().hashCode());
        result = prime * result + ((getFkMessageTypeId() == null) ? 0 : getFkMessageTypeId().hashCode());
        result = prime * result + ((getFkFromId() == null) ? 0 : getFkFromId().hashCode());
        result = prime * result + ((getFkToId() == null) ? 0 : getFkToId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table im_message
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id", "id", "BIGINT"),
        state("state", "state", "INTEGER"),
        sendTime("send_time", "sendTime", "TIMESTAMP"),
        fkMessageTypeId("fk_message_type_id", "fkMessageTypeId", "BIGINT"),
        fkFromId("fk_from_id", "fkFromId", "BIGINT"),
        fkToId("fk_to_id", "fkToId", "BIGINT"),
        content("content", "content", "LONGVARCHAR");

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table im_message
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table im_message
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table im_message
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table im_message
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table im_message
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table im_message
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table im_message
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table im_message
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
         * This method corresponds to the database table im_message
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.column + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table im_message
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.column + " ASC";
        }
    }
}