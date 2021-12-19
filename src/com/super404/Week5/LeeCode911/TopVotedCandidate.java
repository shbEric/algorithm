package com.super404.Week5.LeeCode911;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopVotedCandidate {
    List<Integer> leaders;
    HashMap<Integer, Integer> voteCounts;
    int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        leaders = new ArrayList<Integer>();
        voteCounts = new HashMap<Integer, Integer>();
        //初始化为不存在的候选人
        int leader = -1;
        voteCounts.put(-1,-1);
        for(int person : persons){
            //累加候选人票数
            voteCounts.put(person, voteCounts.getOrDefault(person,0)+1);
            //>=，则取当前候选人
            if(voteCounts.get(person) >= voteCounts.get(leader)){
                leader = person;
            }
            leaders.add(leader);
        }

    }

    public int q(int t) {
        int left=0, right = this.times.length-1;
        while(left < right){
            int mid = left + (right-left+1)/2;
            //要找小于等于t的最大值
            if(times[mid]<=t){
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return leaders.get(left);
    }
}
