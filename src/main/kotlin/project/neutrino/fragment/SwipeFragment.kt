package project.neutrino.fragment

import javafx.animation.TranslateTransition
import javafx.fxml.FXMLLoader
import javafx.scene.layout.Pane

import javafx.util.Duration


class SwipeFragment(rootPane: Pane, fxmlPath: String) : Fragment(rootPane, fxmlPath) {

    var fragmentPane: Pane? = null
    private var openAnimation: TranslateTransition? = null
    private var closeAnimation: TranslateTransition? = null

    /**
     * use factory methods instead this
     * #SwipeFragment.with
     * #SwipeFragment.default
     */
    override fun load() {
        val loader = FXMLLoader()
        val resourceStream = this.javaClass
                .classLoader
                .getResourceAsStream(fxmlPath)
        fragmentPane = loader.load(resourceStream)
    }

    fun createAnimation(animationMilis: Double) {
        openAnimation = TranslateTransition(Duration(animationMilis), fragmentPane)
        openAnimation!!.toX = 0.0

        closeAnimation = TranslateTransition(Duration(animationMilis), fragmentPane)
    }

    fun open() {
        if (fragmentPane?.translateX != 0.0) {
            openAnimation?.play()
        }
    }

    fun close() {
        if (fragmentPane != null) {
            closeAnimation?.toX = -(fragmentPane!!.width)
        }
    }

    companion object {
        fun with(rootPane: Pane, fxmlPath: String, animationMilis: Double): SwipeFragment {
            val fragment = SwipeFragment(rootPane, fxmlPath)
            fragment.load()
            fragment.createAnimation(animationMilis)

            return fragment
        }

        fun default(rootPane: Pane, fxmlPath: String): SwipeFragment {
            val fragment = SwipeFragment(rootPane, fxmlPath)
            fragment.load()
            fragment.createAnimation(350.0)

            return fragment
        }
    }
}