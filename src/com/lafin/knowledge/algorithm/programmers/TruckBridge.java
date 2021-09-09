package com.lafin.knowledge.algorithm.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * [스택, 큐] 다리를 지나는 트럭
 * 
 * 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다. 
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 
 * 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 
 * 다리는 weight 이하까지의 무게를 견딜 수 있습니다. 
 * 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
 * 
 * 예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다. 
 * 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
 * 
 * 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
 * 0	[]	[]	[7,4,5,6]
 * 1~2	[]	[7]	[4,5,6]
 * 3	[7]	[4]	[5,6]
 * 4	[7]	[4,5]	[6]
 * 5	[7,4]	[5]	[6]
 * 6~7	[7,4,5]	[6]	[]
 * 8	[7,4,5,6]	[]	[]
 */

class Truck {
    int weight;
    int elapsedTimeInBridge = 0;

    public Truck(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getElapsedTimeInBridge() {
        return elapsedTimeInBridge;
    }

    public void elapsedTime() {
        this.elapsedTimeInBridge++;
    }
}

public class TruckBridge {

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> queue = Arrays.stream(truckWeights)
                .mapToObj(Truck::new)
                .collect(Collectors.toCollection(LinkedList::new));
        Queue<Truck> bridge = new LinkedList<>();

        int elapsedTime = 0;

        while (!queue.isEmpty() || !bridge.isEmpty()) {

            elapsedTime++;
            bridge.forEach(Truck::elapsedTime);

            if (!bridge.isEmpty()) {
                Truck truck = bridge.peek();
                if (truck.getElapsedTimeInBridge() >= bridgeLength) {
                    bridge.poll();
                }
            }

            if (!queue.isEmpty()) {
                Truck truck = queue.peek();
                if (isBridgeAvailable(bridgeLength, weight, bridge, truck)) {
                    bridge.add(queue.poll());
                }
            }
        }

        return elapsedTime;
    }

    private boolean isBridgeAvailable(int bridgeLength, int weight, Queue<Truck> bridge, Truck truck) {
        return bridge.size() < bridgeLength && truck.getWeight() + bridge.stream().mapToInt(Truck::getWeight).sum() <= weight;
    }

    public static void main(String[] args) {
        TruckBridge truckBridge = new TruckBridge();

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        int expect = 8;

        System.out.println("기대 결과 : " + expect);
        System.out.println(truckBridge.solution(bridge_length, weight, truck_weights));
    }
}
