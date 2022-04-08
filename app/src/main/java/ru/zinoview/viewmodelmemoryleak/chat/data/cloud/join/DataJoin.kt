package ru.zinoview.viewmodelmemoryleak.chat.data.cloud.join

import ru.zinoview.viewmodelmemoryleak.chat.core.join.Join
import ru.zinoview.viewmodelmemoryleak.chat.core.join.Mapper

interface DataJoin : Join {

    object Success : DataJoin {
        override fun <T> map(mapper: Mapper<T>): T
            = mapper.map()
    }

    object Failure : DataJoin {
        override fun <T> map(mapper: Mapper<T>): T
            = mapper.mapFailure()
    }

}