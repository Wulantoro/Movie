package com.wulantorodev.movie.domain.executor

import java.util.concurrent.*


interface ThreadExecutor : Executor

class JobExecutor : ThreadExecutor {

    private val threadPoolExecutor = ThreadPoolExecutor(
         3,
        5,
        10,
        TimeUnit.SECONDS,
        LinkedBlockingQueue(),
        JobThreadFactory()


    )

    override fun execute(command: Runnable?) {
        command?.let { threadPoolExecutor.execute(it) }

    }
}

class JobThreadFactory(private val counter : Int = 0) : ThreadFactory {
    override fun newThread(r: Runnable?): Thread {
        return Thread(r, "android_${counter.inc()}")
    }

}