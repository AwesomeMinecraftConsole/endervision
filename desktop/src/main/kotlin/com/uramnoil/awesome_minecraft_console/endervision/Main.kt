import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.LineViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.NotificationViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.OnlinePlayersViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.*
import com.uramnoil.awesome_minecraft_console.endervision.compose.app
import com.uramnoil.awesome_minecraft_console.endervision.compose.viewmodel.CommandViewModel
import com.uramnoil.awesome_minecraft_console.endervision.infrastructure.EnderVisionServiceImpl
import com.uramnoil.awesome_minecraft_console.endervision.infrastructure.*
import com.uramnoil.awesome_minecraft_console.endervision.presentation.CommandController
import com.uramnoil.awesome_minecraft_console.endervision.presentation.OperationController
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import org.kodein.di.DI
import org.kodein.di.bindSingleton

suspend fun main() {
    app()
}