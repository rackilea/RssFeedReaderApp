package five.interview.android.rssfeedreaderapp.injection.application.module

import dagger.Module
import dagger.Provides
import five.interview.android.domain.repository.FeedRepository
import five.interview.android.domain.usecase.addsubscription.AddNewSubscriptionUseCase
import five.interview.android.domain.usecase.addsubscription.AddNewSubscriptionUseCaseImpl

@Module
class UseCaseModule {

    @Provides
    fun provideAddNewSubscriptionUseCase(feedRepository: FeedRepository): AddNewSubscriptionUseCase {
        return AddNewSubscriptionUseCaseImpl(feedRepository)
    }

    interface Exposes {

        fun addNewSubscriptionUseCase() : AddNewSubscriptionUseCase

    }
}