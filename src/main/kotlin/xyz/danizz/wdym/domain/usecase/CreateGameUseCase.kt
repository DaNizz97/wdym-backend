package xyz.danizz.wdym.domain.usecase

import xyz.danizz.wdym.domain.model.Game
import xyz.danizz.wdym.domain.model.GameType
import xyz.danizz.wdym.domain.model.MemesBasedGame
import xyz.danizz.wdym.domain.model.SituationBasedGame
import xyz.danizz.wdym.domain.repository.GameRepository
import kotlin.random.Random

class CreateGameUseCase(
    private val gameRepository: GameRepository
) {
    operator fun invoke(name: String, type: GameType): Game {
        val code = Random.nextInt(100000, 999999)

        val newGame =  when (type) {
            GameType.MEMES -> MemesBasedGame(name, code)
            GameType.SITUATION -> SituationBasedGame(name, code)
        }
        gameRepository.put(newGame)
        return newGame
    }
}