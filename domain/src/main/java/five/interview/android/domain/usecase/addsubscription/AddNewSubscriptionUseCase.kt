package five.interview.android.domain.usecase.addsubscription

import io.reactivex.Completable

interface AddNewSubscriptionUseCase {

    fun execute(url : String) : Completable

}