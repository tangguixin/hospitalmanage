package com.hm.hospitalproject.utils;


import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

@Component
public class Queuing {

    /**
     * 全局队列表：通过专家或者科室名加时间组成的Key，保存对应的排队队列
     */
    private static Map<String,Vector<Integer>> allQueue = new TreeMap<>();

    /**
     *生成某个专家或者科室的某个时间段的等待队列
     * @param nameAndTime:专家名 或者 科室名 +时间段的字符串
     * @return 对应的队列
     */
    public static Vector<Integer> getQueue(String nameAndTime){
        if(!allQueue.containsKey(nameAndTime)){
            Vector<Integer> newQueue=new Vector<>();
            allQueue.put(nameAndTime,newQueue);
            return allQueue.get(nameAndTime);
        }
        return allQueue.get(nameAndTime);
    }

    /**
     * 删除对应专家或者科室的某个时间段的队列
     * @param nameAndTime 专家名 或者 科室名 +时间段的字符串
     */
    public static void deleteQueue(String nameAndTime){
        if(allQueue.containsKey(nameAndTime)){
            allQueue.remove(nameAndTime);
        }
    }

    /**
     * 将某个病人压入某个专家或者科室的等待队列
     * @param key 专家名 或者 科室名 +时间段的字符串
     * @param patientID 要入队的病人ID
     * @return
     */
    public static boolean pushMan(String key, int patientID){
        if(allQueue.containsKey(key)){
            allQueue.get(key).add(patientID);
            return true;
        }
        return false;
    }

    /**
     *将病人从某个队列出队
     * @param key 专家名 或者 科室名 +时间段的字符串
     * @param patientId 要入队的病人ID
     * @return
     */
    public static boolean popMan(String key,int patientId){
        if(allQueue.containsKey(key)){
            return allQueue.get(key).removeElement(patientId);
        }
        return false;
    }

    /**
     *传入队列名和患者ID查询该患者前面有多少人(如果患者未入队，则返回队列长度)
     * @param key  专家名 或者 科室名 +时间段的字符串
     * @param patientID 查询前面人数的病人ID
     * @return 当前病人的前面有多少人排队
     */
    public static int countMan(String key, int  patientID){
        for(int i=0;i<allQueue.get(key).size();i++){
            if(allQueue.get(key).get(i)==patientID){
                return i;
            }
        }
        return allQueue.get(key).size();
    }
}
