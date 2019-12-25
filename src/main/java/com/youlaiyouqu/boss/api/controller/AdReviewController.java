package com.youlaiyouqu.boss.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.youlaiyouqu.boss.api.service.AdReviewService;
import com.youlaiyouqu.boss.api.service.AppUserService;
import com.youlaiyouqu.boss.annotation.LoginRequired;
import com.youlaiyouqu.boss.api.domain.Advertisement;
import com.youlaiyouqu.boss.api.domain.AppUser;
import com.youlaiyouqu.boss.enums.CodeEnum;
import com.youlaiyouqu.boss.enums.ResponseData;
import com.youlaiyouqu.boss.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/adReview" ,produces = "application/json; charset=UTF-8")
public class AdReviewController extends BaseController {

    @Autowired
    private AdReviewService adReviewService;
    @Autowired
    private AppUserService appUserService;


    @RequestMapping("/getAdReview")
    @ResponseBody
    @RequiresPermissions("advertisement:menu")//具有 user:detail 权限的用户才能访问此方法
    @LoginRequired
    public ResponseData getAdReview(HttpServletRequest request, HttpServletResponse response){
        getParameterMap(request,response);
        log.info("广告商详情-------------->>/adReview/getAdReview");
        String userId=request.getParameter("userId");
        if (StringUtils.isEmpty(userId)){
            return new ResponseData(CodeEnum.E_90003.getCode(),"用户id不可为空！");
        }
        Advertisement adReview = adReviewService.getAdReview(userId);
        return new ResponseData(adReview);
    }
    /**
     * 广告商审核列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getAdReviewList")
    @ResponseBody
    @RequiresPermissions("advertisement:menu")//具有 user:detail 权限的用户才能访问此方法
    @LoginRequired
    public ResponseData getAdReviewList(HttpServletRequest request, HttpServletResponse response){
        getParameterMap(request,response);
        log.info("广告商审核列表-------------->>/adReview/getAdReviewList");
        String page=request.getParameter("page");
        if (StringUtils.isEmpty(page) || !page.matches("[0-9]+"))
            page = "1";
        String merchantName =request.getParameter("merchantName");
        String merchantAddr =request.getParameter("merchantAddr");
        String phone = request.getParameter("phone");
        String status = request.getParameter("status");
        String applicationStartTime = request.getParameter("applicationStartTime");
        String applicationEndTime = request.getParameter("applicationEndTime");

        PageHelper.startPage(Integer.parseInt(page), 10);
        List<Advertisement> adReviewList = adReviewService.getAdReviewList("",merchantName,merchantAddr, phone, status, applicationStartTime,applicationEndTime);
        PageInfo<Advertisement> pageInfo=new PageInfo<>(adReviewList);
        long total = pageInfo.getTotal();
        int pages = pageInfo.getPages();
        int currentPage = Integer.parseInt(page);
        return new ResponseData(adReviewList, currentPage,(int) total,pages);
    }

    /**
     * 修改广告商审核状态
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/updateAdReviewStatus")
    @ResponseBody
    @RequiresPermissions("advertisement:save")//具有 user:detail 权限的用户才能访问此方法
    @LoginRequired
    public ResponseData updateAdReviewStatus(HttpServletRequest request, HttpServletResponse response){
        getParameterMap(request,response);
        log.info("修改广告商审核状态-------------->>/adReview/updateAdReviewStatus");
        String id = request.getParameter("id");
        String userId = request.getParameter("userId");
        String status = request.getParameter("status");
        if (StringUtils.isEmpty(id)){
            return new ResponseData(CodeEnum.PARAM_ERROR.getCode(),"参数id为空！！");
        }else if (StringUtils.isEmpty(userId)){
            return new ResponseData(CodeEnum.PARAM_ERROR.getCode(),"参数userId为空！！");
        }else if (StringUtils.isEmpty(status)){
            return new ResponseData(CodeEnum.PARAM_ERROR.getCode(),"参数status为空！！");
        }
        AppUser appUserMsg = appUserService.getAppUserMsg(userId,"");
        if (StringUtils.isNull(appUserMsg)){
            return new ResponseData(CodeEnum.PARAM_ERROR.getCode(),"参数userId错误！！");
        }
        if ("10C".equals(status) || "10B".equals(status)){

            adReviewService.updateAdReviewStatus(id,status);
            if("1".equals(appUserMsg.getUserType()))
                appUserMsg.setUserType("3");
            else if ("2".equals(appUserMsg.getUserType()))
                appUserMsg.setUserType("4");
            else
                return new ResponseData(CodeEnum.E_400);
            appUserService.updateAppUser(appUserMsg);
        } else {
            return new ResponseData(CodeEnum.PARAM_ERROR.getCode(), "type参数错误！！");
        }
        return new ResponseData();
    }

}
