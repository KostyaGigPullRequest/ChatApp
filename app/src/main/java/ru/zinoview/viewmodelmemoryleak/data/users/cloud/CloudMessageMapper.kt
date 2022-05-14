package ru.zinoview.viewmodelmemoryleak.data.users.cloud

import ru.zinoview.viewmodelmemoryleak.core.users.AbstractUser
import ru.zinoview.viewmodelmemoryleak.core.users.UserBitmap

interface CloudMessageMapper<T> {

    fun map(
        id: String,
        nickName: String,
        cloudLastMessage: CloudLastMessage,
        bitmap: android.graphics.Bitmap
    ) : T

    class Base : CloudMessageMapper<AbstractUser> {

        override fun map(
            id: String,
            nickName: String,
            cloudLastMessage: CloudLastMessage,
            bitmap: android.graphics.Bitmap
        ) = AbstractUser.Base(id,nickName,cloudLastMessage.map(Unit),UserBitmap.Base(bitmap))

    }
}