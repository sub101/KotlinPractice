class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val playerPos = players.indices.associateBy { players[it] }.toMutableMap()

        for (calling in callings) {
            val pos = playerPos[calling] ?: continue

            players[pos] = players[pos-1]
            players[pos-1] = calling
            playerPos[players[pos]] = pos
            playerPos[calling] = pos - 1
        }

        return players
    }
}