package five.interview.android.rssfeedreaderapp.base

interface ScopedPresenter {

    fun start()

    fun activate()

    fun deactivate()

    fun stop()

    fun destroy()

    fun back()
}