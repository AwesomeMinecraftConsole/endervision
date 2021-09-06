import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.LineViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.NotificationViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.OnlinePlayersViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.*
import com.uramnoil.awesome_minecraft_console.endervision.compose.app
import com.uramnoil.awesome_minecraft_console.endervision.compose.viewmodel.CommandViewModel
import com.uramnoil.awesome_minecraft_console.endervision.grpc.EnderVisionServiceImpl
import com.uramnoil.awesome_minecraft_console.endervision.infrastructure.*
import com.uramnoil.awesome_minecraft_console.endervision.presentation.CommandController
import com.uramnoil.awesome_minecraft_console.endervision.presentation.OperationController
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

suspend fun main() {
    val job = Job()
    val coroutineContext: CoroutineContext = job
    val coroutineScope = CoroutineScope(coroutineContext)

    val lineFlow = MutableSharedFlow<Line>()
    val notificationFlow = MutableSharedFlow<Notification>()
    val onlinePlayersFlow = MutableSharedFlow<OnlinePlayers>()

    val viewModelModule = DI.Module("view_models", false) {
        bindSingleton {
            LineViewModel(lineFlow)
        }
        bindSingleton {
            NotificationViewModel(notificationFlow)
        }
        bindSingleton {
            OnlinePlayersViewModel(onlinePlayersFlow)
        }
        bindSingleton {
            CommandViewModel("")
        }
    }

    val controllerModule = DI.Module("controllers", false) {
        // Hack: Functional Interfaceをファイルに切り分ける
        val enderVisionServiceImplService = EnderVisionServiceImpl(
            newLineUseCaseInputPort = NewLineUseCaseInteractor {
                coroutineScope.launch {
                    lineFlow.emit(it)
                }
            },
            sendNotificationUseCaseInputPort = SendNotificationUseCaseInteractor {
                coroutineScope.launch {
                    notificationFlow.emit(it)
                }
            },
            updateOnlinePlayersUseCaseInputPort = UpdateOnlinePlayersUseCaseInteractor {
                coroutineScope.launch {
                    onlinePlayersFlow.emit(it)
                }
            },
            channel = ManagedChannelBuilder
                .forAddress(System.getenv("ENDERVISION_HOST") ?: "127.0.0.1", 50051)
                .usePlaintext()
                .keepAliveTime(1000, TimeUnit.MILLISECONDS)
                .keepAliveTimeout(5000, TimeUnit.MILLISECONDS)
        )
        enderVisionServiceImplService.start()

        bindSingleton { CommandController(SendCommandUseCaseInteractor(enderVisionServiceImplService)) }
        bindSingleton { OperationController(SendOperationUseCaseInteractor(enderVisionServiceImplService)) }
    }

    app(viewModelModule, controllerModule)
    job.complete()
}