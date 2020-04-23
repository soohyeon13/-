package 카카오인턴대비.level2

import java.util.*

class Level2Truck {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray) : Int {
        val wait : Queue<Truck> = LinkedList()
        val passing : Queue<Truck> = LinkedList()
        for (i in truck_weights.indices) {
            wait.add(Truck(truck_weights[i],0))
        }
        var time = 0
        var totalWeight = 0
        while (!wait.isEmpty() || !passing.isEmpty()) {
            time +=1
            if (!passing.isEmpty()) {
                val truck = passing.peek()
                if (time - truck.entryTime >= bridge_length) {
                    val passTruck = passing.poll()
                    totalWeight -= passTruck.weight
                }
            }
            if (!wait.isEmpty()) {
                val truck = wait.peek()
                if (totalWeight + truck.weight <= weight) {
                    val entryTruck = wait.poll()
                    totalWeight += entryTruck.weight
                    passing.add(Truck(entryTruck.weight,time))
                }
            }
        }
        return time
    }
    data class Truck(
            val weight: Int,
            var entryTime: Int
    )
}