package com.super404.Week2.LeeCode811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String cpdomain : cpdomains){
            String[] split = cpdomain.split(" ");
            String[] domains = split[1].split("\\.");
            String domain ="";
            for(int i=domains.length-1; i>=0; i--){
                domain = domains[i] + (i<domains.length-1 ? "." : "") + domain;
                map.put(domain, map.getOrDefault(domain, 0)+Integer.valueOf(split[0]));
            }
        }
        List<String> list = new ArrayList<>();
        for(String key : map.keySet()){
            String ans = map.get(key) + " " + key;
            list.add(ans);
        }
        return list;

    }
}
