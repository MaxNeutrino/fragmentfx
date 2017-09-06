package project.neutrino.fragment

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.layout.Pane


class HistoryFragment(rootPane: Pane, fxmlPath: String) : Fragment(rootPane, fxmlPath) {

    private var previous: ObservableList<Node>? = null

    override fun load() {
        previous = rootPane.children
        super.load()
    }

    fun back() {
        rootPane.children.setAll(previous)
    }

    companion object {
        fun with(rootPane: Pane, fxmlPath: String): HistoryFragment {
            val fragment = HistoryFragment(rootPane, fxmlPath)
            fragment.load()
            return fragment
        }
    }
}