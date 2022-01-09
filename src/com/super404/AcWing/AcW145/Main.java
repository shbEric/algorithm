package com.super404.AcWing.AcW145;

import java.util.Arrays;
import java.util.Scanner;
//贪心（先安排最大价值的商品在它到期那天卖，然后依次这样安排，如果它的到期被占了，则找它前面空闲的，直到0天则不能卖）
//用到了并查集的路径压缩
public class Main {
    //第0天不可用，只用1-10000
    private static int[] fa = new int[10001];

    private static int find(int x){
        if(x == fa[x]) {
            return x;
        }
        return fa[x] = find(fa[x]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[][] pairs = new int[n][2];
            for(int i=0; i<n; i++){
                pairs[i][0] = sc.nextInt();
                pairs[i][1] = sc.nextInt();
            }
            //按商品价值从小到大（相同价值，到期时间从小到大）
            Arrays.sort(pairs, (o1, o2) -> {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            });
            //MakeSet
            for (int i = 0; i <= 10000; i++) {
                fa[i] = i;
            }

            int ans=0;
            for(int i=n-1; i>=0; i--){
                int profit = pairs[i][0];
                int day = pairs[i][1];
                int lastAvailableDay = find(day);
                if(lastAvailableDay > 0){
                    ans += profit;
                    fa[lastAvailableDay] = lastAvailableDay -1;
                }
            }
            System.out.println(ans);
        }
    }
}
