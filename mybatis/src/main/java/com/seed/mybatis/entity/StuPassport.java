package com.seed.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学生通行证表
 * </p>
 *
 * @author LianSong
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StuPassport implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证
     */
    private String idcard;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 性别：1男2女
     */
    private Integer gender;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 人脸识别状态
     */
    private Boolean faceVerify;

    /**
     * 注册方式,1自主创建,2后台创建
     */
    private Integer registerType;

    /**
     * 是否班主任确认,0未提交,1待确认,2同意,3拒绝
     */
    private Integer hasConfirm;

    /**
     * stu_passport_log.id,最新的日志Id
     */
    private Long logId;

    /**
     * 创建时间
     */
    private LocalDateTime ctime;

    /**
     * 更新时间
     */
    private LocalDateTime utime;

    /**
     * 启用状态 true启用，false禁用
     */
    private Boolean status;


}
