package com.youlaiyouqu.boss.api.service;

import com.youlaiyouqu.boss.api.domain.ArtistReview;

import java.util.List;

public interface ArtistReviewService {

    List<ArtistReview> searchArtistReviewList(ArtistReview artistReview);

    List<ArtistReview> getArtistReviewList();

    void updateArtistReviewStatus(String id,  String status);

    void deleteArtistReviewById(String id);
}
