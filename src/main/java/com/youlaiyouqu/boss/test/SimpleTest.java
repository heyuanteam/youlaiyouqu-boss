package com.youlaiyouqu.boss.test;

import com.youlaiyouqu.boss.utils.PageBean;
import com.youlaiyouqu.boss.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SimpleTest {



    public static void main(String[] args) {

       /* String a="0.05";
        String b="0.1";
        BigDecimal bigDecimal = new BigDecimal(a).multiply(new BigDecimal(b)).setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal);
        System.out.println((int)5/3);

        Date javaUtilCurrentTime = new Date();
        System.out.println(javaUtilCurrentTime);
        String time1="2019-11-06 19:00:00";
        String time2="2019-11-06 21:00:00";
        String[] split1 = time1.split(" ");
        String[] split2 = time2.split(" ");
        time1.split(" ");
        int res=time1.compareTo(time2);
        System.out.println(res);
        int s1 = Integer.parseInt(split1[1].split(":")[0]);
        int s2 = Integer.parseInt(split2[1].split(":")[0]);
        System.out.println(s1-s2);
        System.out.println();
        String format = new SimpleDateFormat("HH").format(new Date());
        System.out.println(format);
        System.out.println("_______"+split2[1]+"_______"+split1[1]);

        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            System.out.println(path+"------"+path.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        /*String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println("path"+path);
        String url=System.getProperty("user.dir");
        System.out.println("url"+url);
        File upload1 =null;
        try {
            String path1 = ResourceUtils.getURL("classpath:").getPath();
            System.out.println("path1"+path1);
             upload1 = new File(path1,"static/images1");
            if(!upload1.exists()){
                upload1.mkdirs();
                System.out.println("----------");
                System.out.println("upload1 url:"+upload1.getAbsolutePath());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("upload1 getAbsolutePath:"+upload1.getAbsolutePath());
        System.out.println("upload1 getParent:"+upload1.getPath());
        try {
            System.out.println("upload1 getCanonicalPath:"+upload1.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        File upload= new File(path,"static/images");
        if(!upload.exists()){
            upload.mkdirs();
            System.out.println("----------");
        }
        System.out.println("upload url:"+upload.getAbsolutePath());*/
        /*String idCard="412726199410042431";
        System.getProperty("user.dir").replace("bin", "webapps/qrcode_image");
        //Pattern pattern = Pattern.compile(" ^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$");
        //Pattern pattern = Pattern.compile("\\\\d{15}(\\\\d{2}[0-9xX])?");
        Pattern pattern = Pattern.compile("^\\d{6}(18|19|20)?\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|[xX])$");


        if (pattern.matcher(idCard).matches() == false || idCard.length() != 18) {
            System.out.println("错误");
        }else System.out.println("正确");*/
        /*RedisTemplate<String, String> stringTemplate = new RedisTemplate<>();*/
       /* String a="2019-09-27 13:37:20";
        String b="2019-09-22 13:37:20";
        Date date = new Date("2019-09-22 13:37:20");*/
/*        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2019-10-22 13:37:20");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean before = new Date().after(date);
        if (before != false) System.out.println("2222"+before);
        else System.out.println(before);*/

        /*Date startDate = null;
        Date endDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2019-03-29 13:37:20");
            endDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2019-04-24 13:37:20");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean isStart = new Date().after(startDate);
        boolean notEnd = new Date().before(endDate);

        if (isStart &&  notEnd) System.out.println("发布中");
        else if (notEnd ==false) System.out.println("已过期");
        else System.out.println("未发布");*/

        /*String a="112";
        String b="123.23";
        String c="123a";
        if (a.matches("[0-9]+")){
            System.out.println("a:是整数"+a);
        }else {
            System.out.println("a:不是整数"+a);
        }if (b.matches("[0-9]+")){
            System.out.println("b:是整数"+b);
        }else {
            System.out.println("b:不是整数"+b);
        }if (c.matches("[0-9]+")){
            System.out.println("c：是整数"+c);
        }else {
            System.out.println("c:不是整数"+c);
        }*/

       /* List<String> list = Lists.newArrayList();
        List<String> list1 = Lists.newArrayList();
        list1.add("123");
        list.addAll(list1);
        System.out.println(list.get(0));*/


     /*   String [] strs= new String[]{
                "B044C53B38BA4E84B507E62402683E26",
                "4D42B0ED17C64653AD31FD402858FBBB",
                "C7EC5FA6E0964CC9AD14222D780F6AEB",
                "A408C597F8A140F68D10C21CCDFF2AF3",
                "F38607A875A44CF78D84176B545282B7"};
        for (String s : strs) {
            System.out.println(Math.abs(s.hashCode()) % 10+"");
        }*/

      /*  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date ="2019-10-22 19:00:00";
        String date1="";
        String da=date1.split(" ")[0];
        System.out.println(da);
        Date parse = null;
        try {
            parse = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar instance = Calendar.getInstance();
        instance.setTime(parse);
        instance.add(Calendar.MONTH, 1);
        String format = dateFormat.format(instance.getTime());
        System.out.println(dateFormat.format(instance.getTime()));

        Commodity commodity = new Commodity();

        System.out.println(commodity.getStartDate());*/

        /*http://101.37.252.177:8888/group1/M00/00/04/rBDoeV2IWPqASGlcACTDBUNyDd8640.mp4*/
        String s ="http://101.37.252.177:8888/group1/M00/00/04/rBDoeV2IWPqASGlcACTDBUNyDd8640.mp4";
        /* String[] split = s.split("8888");
       System.out.println("前端:"+split[0]+"     后段："+split[1]);
        String[] strings=s.split("/",s.lastIndexOf("/"));
        String[] split1 = s.split("/");
        int i = strings.length;
        System.out.println( strings.length);
        ///var/www/html/videoImage
        System.out.println(strings[i-1]);
        String a =split1[i-1];
        System.out.println("a:"+a);
        String[] a1=a.split("\\.");
        System.out.println("xin:"+a1[0]);*/
/*
        String[] split = s.split("/");
        String videoName = split[split.length - 1];
        String[] imageName = videoName.split("\\.");
        System.out.println("tu:"+ imageName[0]);*/

//        System.out.println(ResultJSONUtils.getHashValue("yuyue_upload_file_", "3778AC96E77C45C28B9DA9044D32E70A"));
//

//        System.out.println("------06:00-23:59----");
        //Calendar calendar = new
//        Date startDate = null;
//        Date endDate = null;
//        try {
//            startDate = new SimpleDateFormat("hh:mm:ss").parse("07:37:00");
//            endDate = new SimpleDateFormat("hh:mm:ss").parse("12:37:00");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        String startDate = "06:00";
//        String endDate = "20:59";
//        String format = new SimpleDateFormat("HH:mm").format(new Date());
//        System.out.println(format);
//        if (format.compareTo(startDate) >= 0 && format.compareTo(endDate) < 0 ){
//            System.out.println("开业 yes");
//        }else {
//            System.out.println("打烊no");
//        }

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        System.out.println(list.size());

        PageBean pageBean = new PageBean(list,3);
        System.out.println(pageBean.getStartIndex()+ "-" +pageBean.getEndIndex());
        List<String> finalList = pageBean.getItems();
        if (StringUtils.isEmpty(finalList)){
            System.out.println("--------");
        }else {
            for (String s1:finalList
            ) {
                System.out.println(s1);
            }
        }







    }

}
