package ru.zinoview.viewmodelmemoryleak.chat.ui.chat

import ru.zinoview.viewmodelmemoryleak.chat.ui.core.CommunicationObserve
import ru.zinoview.viewmodelmemoryleak.chat.ui.core.ObserveConnection

interface ChatViewModelObserve : CommunicationObserve<List<UiChatMessage>>, ObserveConnection