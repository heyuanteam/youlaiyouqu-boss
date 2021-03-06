package com.youlaiyouqu.boss.api.domain;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: Lucifer
 * @create: 2018-12-04 16:18
 * @description:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadFile implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
//  文件名
    private String filesName;
//  标题
    private String title;
//  节目视频分类
    private String categoryId;
//  时间
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date uploadTime;
//  视频第一帧图片链接
    private String videoAddress;
//  文件地址
    private String filesPath;
//  文件类型
    private String filesType;
//  文件大小
    private String fileSize;
//    作者iD
    private String authorId;
//    描述
    private String description;
//    用户关注数量(粉丝量)
    private String attentionAmount;
//  播放量
    private String playAmount;
//    点赞量
    private String likeAmount;
//    评论数量
    private String commentAmount;
//    时长
   private String duration;
    //状态
    private String status;
    //举报状态
    private String reportStatus;
    //用户后台人员上传视频（勿删）
    private String tableName;
    //用户信息
    private AppUser appUser;
    //
    private List<ReportVideo> reportVideoList;
}
