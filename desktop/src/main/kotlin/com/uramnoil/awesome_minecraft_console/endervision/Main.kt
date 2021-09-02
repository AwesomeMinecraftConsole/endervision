import com.uramnoil.awesome_minecraft_console.endervision.compose.app
import com.uramnoil.awesome_minecraft_console.endervision.compose.viewmodel.CommandViewModel
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.Line
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.LineViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import org.kodein.di.DI
import org.kodein.di.bindSingleton

suspend fun main() {
    val lineFlow = MutableSharedFlow<Line>()
    val viewModelModule = DI.Module("view_models", false) {
        bindSingleton {
            LineViewModel(lineFlow)
        }
        bindSingleton {
            CommandViewModel("")
        }
    }
    val controllerModule = DI.Module("controllers", false) {

    }

    app(viewModelModule, controllerModule)
}