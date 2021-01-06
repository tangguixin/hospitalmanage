package com.hm.hospitalproject.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/11:09
 * @Description:
 */

//病例表
@Entity
@Data
public class caseRecoder {
    @Id
    private Integer caseId;
    @Column
    private Integer patientsId;
    @Column
    private Integer doctorId;
    @Column
    private Timestamp creatTime;
    /*
    主诉：（1）主诉是指患者入院就诊的主要症状、体征及其发生时间、性质或程度、部位等，根据主诉能产生第一诊断。主诉语言要简洁明了，一般以不超过20字为宜。
    （2）不以诊断或检验结果为主诉内容（确无症状者例外）。主诉多于一项时，可按主次或发生时间的先后分别列出。
     */
    @Column
    private String zhusu;
    /*
    现病史：现病史是病史中的主体部分。围绕主诉，按症状出现的先后，详细记录从起病到就诊时疾病的发生、发展及其变化的经过和诊疗情况。其内容主要包括：
    （1）起病时间、缓急，可能的病因和诱因（必要时包括起病前的一些情况）。
    （2）主要症状（或体征）出现的时间、部位、性质、程度及其演变过程。
    （3）伴随症状的特点及变化，对具有鉴别诊断意义的重要阳性和阴性症状（或体征）亦应加以说明。（4）对患有与本病有关的慢性病者或旧病复发者，应着重了解其初发时的情况和重大变化以及最近复发的情况。（5）发病以来曾在何处做何种诊疗（包括诊疗日期，检查结果，用药名称及其剂量、用法，手术方式，疗效等）。（6）与本科疾病无关的未愈仍需诊治的其他科重要伤病，应另段叙述。（7）发病以来的一般情况，如精神、食欲、食量、睡眠、大小便 、体力和体重的变化等。
     */
    @Column
    private String xianbingshi;

    @Column
    private String jiazhushi;
    /*
    根据具体情况添加
     */
}
