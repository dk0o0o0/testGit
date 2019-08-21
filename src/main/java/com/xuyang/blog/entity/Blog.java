package com.xuyang.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class Blog{

	@Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    private Long id; // 用户的唯一标识

    //@NotEmpty(message = "标题不能为空")
    @Column(nullable = false, length = 50) // 映射为字段，值不能为空
    private String title;

    //@NotEmpty(message = "摘要不能为空")
    @Column(nullable = false) // 映射为字段，值不能为空
    private String summary;

    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    //@NotEmpty(message = "内容不能为空")
    @Column//(nullable = false) // 映射为字段，值不能为空
    private String content;
    
    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    //@NotEmpty(message = "内容不能为空")
    @Column//(nullable = false) // 映射为字段，值不能为空
    private String htmlContent; // 将 md 转为 html

}
