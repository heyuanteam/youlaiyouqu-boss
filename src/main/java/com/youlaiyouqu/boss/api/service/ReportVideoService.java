package com.youlaiyouqu.boss.api.service;

import com.youlaiyouqu.boss.api.domain.ReportVideo;

import java.util.List;


public interface ReportVideoService {

    //获取举报列表
    List<ReportVideo> getReportVideos(String status,String authorId,String videoId);

    //获取举报列表
    void updateReportStatus(String videoId ,String status);

    List<String> getUserIds(String videoId);

    List<String> getAuthorIds();

    List<ReportVideo> getVideoIds();
}
