package com.super404.AcWing.AcW850;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //Dijkstra算法（用二叉堆维护，时间复杂度（m*log(n)））
        int[] dist = new int[n+1];
        //是否已确定全局最小值(是否扩展过)
        boolean[] expand = new boolean[n+1];
        //先建图，存在出边数组中(分布记录到的点和对应的权重)
        List<List<Integer>> point = new ArrayList<List<Integer>>(); // 另一端点
        List<List<Integer>> edge = new ArrayList<List<Integer>>(); // 边权
        for(int i=0; i<=n; i++){
            point.add(new ArrayList<Integer>());
            edge.add(new ArrayList<Integer>());
            dist[i] = (int) 1e9;
        }
        for(int i=0; i<m; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            point.get(x).add(y);
            edge.get(x).add(z);
        }

        dist[1] = 0;
        //最小优先队列(第一元是点、第二元是距离)
        PriorityQueue<int[]> queue=
                new PriorityQueue<>((o1,o2)->{
                    return o1[1]- o2[1];});
        queue.offer(new int[]{1, dist[1]}); //初始点是1
        while(!queue.isEmpty()){
            //取最小优先队列的队头作为下一个起始点
            int x = queue.poll()[0]; //取出队头并remove掉
            if(expand[x]){
                continue; //已经扩展过的点直接跳过
            }
            expand[x] = true;
            //从上面找到的点出发，进行扩展，更新距离
            for(int i=0; i<point.get(x).size(); i++){
                int y = point.get(x).get(i);
                int z = edge.get(x).get(i);
                if(dist[y] > dist[x]+z){
                    dist[y] = dist[x]+z;
                    //队列中原本的y,dist[y]不用管，因为不是最小值，到后面再碰到就是拓展过的点，会自然跳过
                    queue.offer(new int[]{y, dist[y]});
                }
            }
        }
        System.out.println(dist[n] == 1e9 ? -1 : dist[n]);


    }
}
