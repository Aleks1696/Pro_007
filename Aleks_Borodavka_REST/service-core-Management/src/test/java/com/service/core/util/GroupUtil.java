package com.service.core.util;

import com.service.api.request.parameters.GroupParametrs;
import com.service.core.domain.GroupRecord;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GroupUtil {

    public static Long BAD_GROUP_ID = 32325435353L;

    public static GroupParametrs createGroupParameters(){
        GroupParametrs parameters = new GroupParametrs();
        parameters.setTitle("Test_Group");
        parameters.setBeginDate("2018/10/18");
        parameters.setEndDate("2019/10/19");

        return parameters;
    }

    public static GroupParametrs updatedGroupParameters(){
        GroupParametrs parameters = new GroupParametrs();
        parameters.setTitle("Test_Group_Updated");
        parameters.setBeginDate("2018/10/14");
        parameters.setEndDate("2019/10/14");
        return parameters;
    }



    public static GroupRecord createGroupRecord(){
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        GroupRecord groupRecord = new GroupRecord();
        groupRecord.setTitle("Test_Group");
        groupRecord.setBeginDate(LocalDate.parse("2018/10/18", parser));
        groupRecord.setEndDate(LocalDate.parse("2019/10/19", parser));
        return groupRecord;
    }

    public static List<GroupRecord> createGroupRecordList(){
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        List<GroupRecord> list = new ArrayList<>();

        GroupRecord group1 = new GroupRecord();
        group1.setTitle("Test_Group1");
        group1.setBeginDate(LocalDate.parse("2018/10/18", parser));
        group1.setEndDate(LocalDate.parse("2019/10/19", parser));

        GroupRecord group2 = new GroupRecord();
        group2.setTitle("Test_Group2");
        group2.setBeginDate(LocalDate.parse("2018/10/10", parser));
        group2.setEndDate(LocalDate.parse("2019/10/10", parser));

        list.add(group1);
        list.add(group2);
        return list;
    }



}
