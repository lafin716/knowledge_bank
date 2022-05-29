package com.lafin.knowledge.exam;

import java.util.HashMap;
import java.util.Map;

public class RoomAppointment {

    Map<Long, Long> checkedIn = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            long room = checkIn(room_number[i]);
            answer[i] = room;
        }

        return answer;
    }

    public long checkIn(long room) {
        if (!checkedIn.containsKey(room)) {
            checkedIn.put(room, room + 1);
            return room;
        }

        long empty = checkIn(room);
        checkedIn.put(room, empty);
        return empty;
    }

    public static void main(String[] args) {
        RoomAppointment ra = new RoomAppointment();

        long[] result = ra.solution(10, new long[]{1,3,4,1,3,1});

        System.out.println(result);
    }
}
