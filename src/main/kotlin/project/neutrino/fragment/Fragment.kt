package project.neutrino.fragment

import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.layout.Pane


open class Fragment(val rootPane: Pane, protected val fxmlPath: String) {

    open fun load() {
        val loader = FXMLLoader()
        val resourceStream = this.javaClass
                .classLoader
                .getResourceAsStream(fxmlPath)
        val fragmentNode: Node = loader.load(resourceStream)
        rootPane.children.setAll(fragmentNode)
    }

    /**
     * Factory method, create and load fragment to rootPane
     */
    companion object {
        fun with(rootPane: Pane, fxmlPath: String): Fragment {
            val fragment = HistoryFragment(rootPane, fxmlPath)
            fragment.load()
            return fragment
        }
    }
}