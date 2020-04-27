package 카카오인턴대비.level4

class Level4HotelRoom {
    private val map = HashMap<Long,Long>()
    private val arr = ArrayList<Long>()
    private var value : Long= 0
    private var start : Long= 0
    fun solution(k:Long,room_number: LongArray): LongArray {
        for (i in room_number.indices) {
            if (!map.containsKey(room_number[i]))  {
                arr.add(room_number[i])
                map[room_number[i]] = room_number[i] +1
            }else {
                start = room_number[i]
                checkRoom(room_number[i])
            }
        }
        return arr.toLongArray()
    }
    private fun checkRoom(room : Long) {
        if (!map.containsKey(map[room])) {
            value = map[room]!!
            arr.add(map[room]!!)
            map[map[room]!!] = map[room]!!+1
        }else {
            checkRoom(map[room]!!)
            map[room] = value
        }
    }
}