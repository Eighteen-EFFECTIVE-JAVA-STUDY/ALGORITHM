package 신종신.주차2.w02_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Room> rooms = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer tokens = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(tokens.nextToken());
            int en = Integer.parseInt(tokens.nextToken());
            rooms.add(new Room(st, en));
        }

        Collections.sort(rooms);

        int cnt = 0;
        int t = 0;
        for(int i = 0; i < n; i++){
            if(t <= rooms.get(i).st){
                cnt++;
                t = rooms.get(i).en;
            }
        }

        System.out.println(cnt);
    }

    static class Room implements Comparable<Room> {
        int st;
        int en;

        public Room(int st, int en){
            this.st = st;
            this.en = en;
        }

        @Override
        public int compareTo(Room o){
            if(en == o.en) return st - o.st;
            return en - o.en;
        }
    }
}

