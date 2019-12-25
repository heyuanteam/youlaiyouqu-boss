package com.youlaiyouqu.boss.api.mapper;

import com.youlaiyouqu.boss.api.domain.ReportVideo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReportVideoMapper extends MyBaseMapper<ReportVideo> {

    @Select("SELECT COUNT(*) FROM(SELECT DISTINCT(video_id) from yuyue_video_report where `status` = '10A')s")
    int getReportVideosNum();


    //获取举报列表
    List<ReportVideo> getReportVideos(@Param(value = "status") String status,
                                      @Param(value = "authorId") String authorId,
                                      @Param(value = "videoId") String videoId);



    //获取举报列表
    @Update("update yuyue_video_report set status = #{status} where video_id = #{videoId}")
    void updateReportStatus(@Param(value = "videoId") String videoId ,@Param(value = "status") String status);


    @Select("SELECT DISTINCT(user_id) FROM yuyue_video_report where  video_id = #{videoId}  and status = '10A' ")
    List<String> getUserIds(String videoId);

    @Select("SELECT DISTINCT(author_id) FROM yuyue_video_report ")
    List<String> getAuthorIds();

    @Select("SELECT DISTINCT(video_id),author_id FROM yuyue_video_report ")
    List<ReportVideo> getVideoIds();
}
