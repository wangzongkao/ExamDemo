package com.migu.schedule;


import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *类名和方法不能修改
 */
public class Schedule {

    private static int initialValue = 1;
    Map<Integer, TaskInfo> map = new  HashMap<Integer, TaskInfo>();
    Map<Integer, Integer> cost = new HashMap<Integer, Integer>();
    public int init() {
        map.clear();
        if(map.size() == 0)
        {
            return ReturnCodeKeys.E001;
        }
        return ReturnCodeKeys.E000;
    }


    public int registerNode(int nodeId) {
        if(nodeId>0)
        {
            if(map.get(nodeId) == null)
            {
                if(map.size()==0)
                {
                    map.put(initialValue, new TaskInfo());
                }
                else
                {
                    map.put(nodeId, new TaskInfo());
                }
                return ReturnCodeKeys.E003;
            }
            else
            {
                return ReturnCodeKeys.E005;
            }
        }
        else
        {
            return ReturnCodeKeys.E004;
        }
    }

    public int unregisterNode(int nodeId) {
        TaskInfo taskInfo = map.remove(nodeId);
        if(taskInfo == null)
        {
            return ReturnCodeKeys.E007;
        }
        else
        {
            return ReturnCodeKeys.E006;
        }
    }


    public int addTask(int taskId, int consumption) {

        if(taskId<=0)
        {
            return ReturnCodeKeys.E009;
        }
        if(cost.containsKey(taskId))
        {
            return ReturnCodeKeys.E010;
        }
        cost.put(taskId, consumption);
        return ReturnCodeKeys.E008;
    }


    public int deleteTask(int taskId) {
        if(taskId<=0)
        {
            return ReturnCodeKeys.E009;
        }
        if(cost.containsKey(taskId))
        {
            cost.remove(taskId);
            return ReturnCodeKeys.E011;
        }
        else
        {
            return ReturnCodeKeys.E012;
        }

    }


    public int scheduleTask(int threshold) {
        int x = cost.size();
        List<HashMap<Integer, Integer>> list = new ArrayList<HashMap<Integer,Integer>>();
        if(threshold>0&&threshold<=10)
        {
            return ReturnCodeKeys.E013;
        }
        else if(threshold >10)
        {
            return ReturnCodeKeys.E014;
        }
        else
        {
            return ReturnCodeKeys.E002;
        }
    }


    public int queryTaskStatus(List<TaskInfo> tasks) {
        if(tasks == null)
        {
            return ReturnCodeKeys.E016;
        }
        return ReturnCodeKeys.E000;
    }

}
