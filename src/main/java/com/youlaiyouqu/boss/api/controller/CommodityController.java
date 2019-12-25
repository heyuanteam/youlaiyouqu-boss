package com.youlaiyouqu.boss.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.youlaiyouqu.boss.api.service.CommodityService;
import com.youlaiyouqu.boss.api.service.OrderService;
import com.youlaiyouqu.boss.api.service.VideoService;
import com.youlaiyouqu.boss.annotation.CurrentUser;
import com.youlaiyouqu.boss.annotation.LoginRequired;
import com.youlaiyouqu.boss.api.domain.Commodity;
import com.youlaiyouqu.boss.api.domain.Order;
import com.youlaiyouqu.boss.api.domain.SystemUser;
import com.youlaiyouqu.boss.api.domain.UploadFile;
import com.youlaiyouqu.boss.enums.CodeEnum;
import com.youlaiyouqu.boss.enums.ResponseData;
import com.youlaiyouqu.boss.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/commodity" ,produces = "application/json; charset=UTF-8")
public class CommodityController extends BaseController {

    @Autowired
    private CommodityService commodityService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private VideoService videoService;

    /**
     * 获取爆款列表及搜索
     * @param commodity
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getCommodityList")
    @ResponseBody
    @RequiresPermissions("explosive:menu")//具有 user:detail 权限的用户才能访问此方法
    @LoginRequired
    public ResponseData getCommodityList(Commodity commodity, HttpServletRequest request, HttpServletResponse response){
        getParameterMap(request,response);
        log.info("获取爆款列表及搜索   -------------->/commodity/getCommodityList");
        String page=request.getParameter("page");
        String commodityId =request.getParameter("commodityId");
        String commodityName =request.getParameter("commodityName");
        String category = request.getParameter("category");
        String status = request.getParameter("status");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        if (StringUtils.isEmpty(page) || !page.matches("[0-9]+"))
            page = "1";
        //查询未支付状态
        List<Commodity> commodityNoPayInfo = commodityService.getCommodityInfo("","","","10A","","");
        if (StringUtils.isNotEmpty(commodityNoPayInfo)) {
            for (Commodity c: commodityNoPayInfo
                 ) {
                if (StringUtils.isNotEmpty(c.getOrderId())){
                    Order orderById = orderService.getOrderById(c.getOrderId());
                    if (StringUtils.isNull(orderById)) continue;
                    else {
                        if ("10B".equals(orderById.getStatus()) && "10A".equals(c.getStatus())){
                            c.setStatus("10B");
                            commodityService.updateCommodityInfo(c);
                        }
                        else continue;
                    }
                }


            }
        }
        PageHelper.startPage(Integer.parseInt(page), 10);
        System.out.println(commodity);
        List<Commodity> commodityInfo = commodityService.getCommodityInfo(commodityId,commodityName,category,status,startTime,endTime);
        PageInfo<Commodity> pageInfo=new PageInfo<>(commodityInfo);
        long total = pageInfo.getTotal();
        int pages = pageInfo.getPages();
        int currentPage = Integer.parseInt(page);
        return new ResponseData(commodityInfo, currentPage,(int) total,pages);
    }

    /**
     * 获取爆款详情
     * @param id
     * @return
     */
    @RequestMapping("/getCommodityInfoById")
    @ResponseBody
    @RequiresPermissions("explosive:menu")//具有 user:detail 权限的用户才能访问此方法
    @LoginRequired
    public ResponseData getCommodityInfoById(String id){
        log.info("获取爆款详情   -------------->/commodity/getCommodityInfoById");
        if (StringUtils.isNull(id)){
            return new ResponseData(CodeEnum.E_90003);
        }
        Commodity commodityInfoById = commodityService.getCommodityInfoById(id);
        return new ResponseData(commodityInfoById);
    }


    /**
     * 删除爆款
     * @param id
     * @return
     */
    @RequestMapping("/deleteCommodity")
    @ResponseBody
    @RequiresPermissions("explosive:remove")//具有 user:detail 权限的用户才能访问此方法
    @LoginRequired
    public ResponseData deleteCommodity(String id){
        log.info("删除爆款   -------------->/commodity/deleteCommodity");
        if (StringUtils.isNull(id)){
            return new ResponseData(CodeEnum.E_90003);
        }
        Commodity commodityInfoById = commodityService.getCommodityInfoById(id);
        if (StringUtils.isNull(commodityInfoById)){
            return new ResponseData("未查询该数据！！");
        }
        else commodityService.deleteCommodity(id);
        return new ResponseData();
    }


    /**
     * 修改商品状态及发布时间
     * @param commodity
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updateCommodityInfo",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("explosive:save")//具有 user:detail 权限的用户才能访问此方法
    @LoginRequired
    public ResponseData updateCommodityInfo(@RequestBody Commodity commodity, HttpServletRequest request, HttpServletResponse response){
        getParameterMap(request,response);
        log.info("修改商品状态及发布时间 --------------->/commodity/updateCommodityInfo");
        System.out.println(commodity);
        if (StringUtils.isNull(commodity.getCommodityId())){
            return new ResponseData(CodeEnum.PARAM_ERROR.getCode(),"爆款Id为空！！");
        }
        Commodity commodityInfoById = commodityService.getCommodityInfoById(commodity.getCommodityId());
        if (StringUtils.isNull(commodityInfoById)){
            return new ResponseData("未查询该数据！！");
        }

        if (StringUtils.isEmpty(commodity.getStatus())  ||  "10A".equals(commodity.getStatus())
                || "10B".equals(commodity.getStatus())  || "10D".equals(commodity.getStatus())
                || "10E".equals(commodity.getStatus() ) ){
            commodityService.updateCommodityInfo(commodity);
            return new ResponseData(CodeEnum.SUCCESS.getCode(),"爆款信息修改成功！！");
        }else if("10C".equals(commodity.getStatus())){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            /*List<AdPrice> advertisementFeeInfo = commodityService.getAdvertisementFeeInfo(commodity.getPriceId());
            if (StringUtils.isEmpty(advertisementFeeInfo)){
                return new ResponseData(CodeEnum.PARAM_ERROR.getCode(),"价格为查询到！");
            }*/
             if (StringUtils.isEmpty(commodity.getStartDate()) &&  StringUtils.isEmpty(commodity.getEndDate())){
                //设置开始时间结束时间
                 String adDuration = commodity.getAdPrice().getAdDuration();
                 if (StringUtils.isEmpty(adDuration)){
                     return new ResponseData(CodeEnum.PARAM_ERROR.getCode(),"价格对象中未查询到推广的时长！！");
                 }
                 //设置开始时间结束时间
                 Calendar instance = Calendar.getInstance();
                 instance.setTime(new Date());
                 String start = simpleDateFormat.format(instance.getTime());
                 commodity.setStartDate(start);
                 instance.add(Calendar.MONTH, Integer.parseInt(adDuration));
                 String end = simpleDateFormat.format(instance.getTime());
                 commodity.setEndDate(end);

            }


 /*           Date parseStart = null;
            Date parseEnd=null;
            try {
                 parseStart = simpleDateFormat.parse(start);

                instance.add(Calendar.MONTH, 3);

                String end = simpleDateFormat.format(instance.getTime());
                parseEnd = simpleDateFormat.parse(start);
            } catch (ParseException e) {
                e.printStackTrace();
            }


*/
            Commodity releaseCommodity = getReleaseCommodity(commodity);
            if (StringUtils.isEmpty(releaseCommodity.getVideoId()))
                return new ResponseData(CodeEnum.SUCCESS.getCode(),"暂无视频");
            System.out.println("开始时间："+commodity.getStartDate());
            System.out.println("结束时间："+commodity.getEndDate());
            System.out.println(releaseCommodity);
            commodityService.updateCommodityInfo(releaseCommodity);
        }
        return new ResponseData();
    }

    /**
     * 设置爆款推广位置
     * @param commodity
     * @return
     */
    public Commodity getReleaseCommodity(Commodity commodity){
        //设置爆款推广位置
        List<UploadFile> videoInfoList = videoService.getVideoInfoList();
        if (StringUtils.isEmpty(videoInfoList)){
            return commodity;
        }else {
            for (UploadFile uploadFile:videoInfoList
            ) {
                List<Commodity> releaseCommodity = commodityService.getReleaseCommodity(uploadFile.getId());
                if (releaseCommodity.size() == 5)continue;
                else {
                    commodity.setVideoId(uploadFile.getId());
                    break;
                }
            }
            System.out.println(commodity);
            return commodity;
        }
    }

    /**
     * 添加商品信息
     * @param commodity
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/addCommodityInfo",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("explosive:save")//具有 user:detail 权限的用户才能访问此方法
    @LoginRequired
    public ResponseData addCommodityInfo(@CurrentUser SystemUser systemUser, @RequestBody Commodity commodity, HttpServletRequest request, HttpServletResponse response){
        log.info("添加商品信息 --------------->/commodity/addCommodityInfo");
        if (StringUtils.isNotNull(commodity.getCommodityPrice()) && commodity.getCommodityPrice().signum() == -1){
            return new ResponseData(CodeEnum.PARAM_ERROR.getCode(),"金钱输入错误！！");
        }
        commodity.setCommodityId(UUID.randomUUID().toString().toUpperCase().replace("-",""));
        commodity.setMerchantId(systemUser.getId());

        if ("10C".equals(commodity.getStatus())){
            Commodity releaseCommodity = getReleaseCommodity(commodity);
            if (StringUtils.isEmpty(releaseCommodity.getVideoId()))
                return new ResponseData(CodeEnum.SUCCESS.getCode(),"暂无视频！！");
            else commodityService.insertCommodity(releaseCommodity);
        }

        return new ResponseData(CodeEnum.SUCCESS.getCode(),"添加成功！！");
    }



}
