package com.hm.hospitalproject;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/16:13
 * @Description:
 */
public class DrugConstant {
    /**
     * 被创建，等待配药
     */
    public static int created = 1;
    /**
     * 正在配药
     */
    public static int dispensing =2;

    /**
     *等待发药
     */
    public static int waitDistributeDrugs = 3;
    /**
     * 已经发药
     */
    public static int distributeDrugs = 4;

    /**
     *退药
     */
    public static int backDrug = -1;
}
