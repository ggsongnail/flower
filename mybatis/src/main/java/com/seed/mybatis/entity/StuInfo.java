package com.seed.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学生信息表
 * </p>
 *
 * @author LianSong
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StuInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 出生时间
     */
    private LocalDate birthday;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 学历对应的枚举ID,与gradjob保持一致
     */
    private String degreeId;

    /**
     * 学历
     */
    private String degree;

    /**
     * 院校名称
     */
    private String schoolName;

    /**
     * 院校号
     */
    private String schoolCode;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 个人头像
     */
    private String avatarUrl;

    /**
     * 生源所在地
     */
    private String originCode;

    /**
     * 省内省外枚举 1-省内 2-省外
     */
    private Integer provincial;

    private String provincialName;

    /**
     * 工作经验，枚举
     */
    private Integer workExp;

    /**
     * 工作经验
     */
    private String workExpName;

    /**
     * 性别： 1 男， 2女
     */
    private Integer gender;

    /**
     * 性别
     */
    private String genderName;

    /**
     * 当前城市ID
     */
    private Integer currentCityId;

    /**
     * 政治面貌, 枚举
     */
    private String political;

    private String politicalName;

    /**
     * 当前所在城市
     */
    private String currentCity;

    /**
     * 座右铭
     */
    private String motto;

    /**
     * 身高，单位cm
     */
    private Integer height;

    /**
     * 视力
     */
    private Float vision;

    /**
     * 体重， 单位kg
     */
    private Float weight;

    private Long majorId;

    /**
     * 完整专业名
     */
    private String fullMajorName;

    /**
     * 专业
     */
    private String majorName;

    /**
     * 专业国标码
     */
    private String majorCode;

    /**
     * 省标专业国标码
     */
    private String majorProvinceCode;

    /**
     * 院校专业年份
     */
    private Integer majorYear;

    /**
     * 毕业时间
     */
    private String graduationYear;

    /**
     * 毕业时间
     */
    private String graduateTime;

    /**
     * 入学时间
     */
    private String entranceTime;

    /**
     * 院系id
     */
    private Long collegeId;

    /**
     * 院系名称
     */
    private String collegeName;

    /**
     * 学号
     */
    private String studentCode;

    /**
     * 班级id
     */
    private Long schoolClassId;

    /**
     * 班级名称
     */
    private String schoolClassName;

    /**
     * 贫困级别
     */
    private Integer difficultLevel;

    /**
     * 残疾类别
     */
    private Integer disabilityLevel;

    /**
     * 民族代码
     */
    private String nationalCode;

    /**
     * 民族名称
     */
    private String nationalName;

    /**
     * 创建时间
     */
    private LocalDateTime ctime;

    /**
     * 更新时间
     */
    private LocalDateTime utime;

    private Boolean identityBind;

    /**
     * 状态,0删除,1正常
     */
    private Boolean status;

    /**
     * 是否签订三方协议
     */
    private Boolean tripartite;


}
