package com.youlaiyouqu.boss.api.service.impl;

import com.youlaiyouqu.boss.api.service.ReportVideoService;
import com.youlaiyouqu.boss.api.domain.ReportVideo;
import com.youlaiyouqu.boss.api.mapper.ReportVideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "ReportVideoService")
public class ReportVideoServiceImpl implements ReportVideoService {
    @Autowired
    private ReportVideoMapper reportVideoMapper;

    @Override
    public List<ReportVideo> getReportVideos(String status,String authorId,String videoId) {
        return reportVideoMapper.getReportVideos(status,authorId,videoId);
    }

    @Override
    public void updateReportStatus(String videoId, String status) {
        reportVideoMapper.updateReportStatus(videoId,status);
    }

    @Override
    public List<String> getUserIds(String videoId) {
        return reportVideoMapper.getUserIds(videoId);
    }

    @Override
    public List<String> getAuthorIds() {
        return reportVideoMapper.getAuthorIds();
    }

    @Override
    public List<ReportVideo>getVideoIds() {
        return reportVideoMapper.getVideoIds();
    }
}
