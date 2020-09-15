package five.interview.android.domain.usecase.addsubscription

import five.interview.android.domain.repository.FeedRepository
import io.reactivex.Completable

class AddNewSubscriptionUseCaseImpl(private val feedRepository: FeedRepository) : AddNewSubscriptionUseCase{

    override fun execute(url: String): Completable {
        return feedRepository.addNewFeedSubscription(url)
    }
}