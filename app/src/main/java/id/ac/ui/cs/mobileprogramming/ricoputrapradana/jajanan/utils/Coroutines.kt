package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * static class for calling the "main" method
 */
object Coroutines {

    /**
     * Running "work" codes in asynchronous mechanism in Coroutine Scope
     */
    fun main(work: suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }

}