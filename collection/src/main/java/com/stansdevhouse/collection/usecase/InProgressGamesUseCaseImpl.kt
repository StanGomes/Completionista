package com.stansdevhouse.collection.usecase

import com.stansdevhouse.collection.data.InProgressGamesUseCase
import com.stansdevhouse.data.CarouselGame
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InProgressGamesUseCaseImpl @Inject constructor() : InProgressGamesUseCase {
    override val getInProgressGames: Flow<List<CarouselGame>>
        get() = flow {
            emit(
                listOf(
                    CarouselGame(
                        title = "Grand Theft Auto",
                        imageUrl = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg"
                    ),
                    CarouselGame(
                        title = "Grand Theft Auto 2",
                        imageUrl = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg"
                    ),
                    CarouselGame(
                        title = "Grand Theft Auto 3",
                        imageUrl = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg"
                    ),
                    CarouselGame(
                        title = "Grand Theft Auto 4",
                        imageUrl = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg"
                    ),
                    CarouselGame(
                        title = "Grand Theft Auto 5",
                        imageUrl = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg"
                    ),
                    CarouselGame(
                        title = "Grand Theft Auto 6",
                        imageUrl = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg"
                    )
                )
            )
        }
}