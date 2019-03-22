package com.cjdpearce.blackjack


import javafx.geometry.Pos
import javafx.scene.layout.StackPane
import tornadofx.*
import java.util.*

class viewBuilder: View() {
    // dependency injection
    private val controller: viewController by inject()

    // set up neighborhood
    override val root = gridpane {
//        vgap = 15.0
//        padding = insets(15)
        row {
            add(controller.background())
            add(controller.background())
            add(controller.background())
            //add(controller.cardPane())
            add(controller.background())
            add(controller.background())
        }
        row{
            add(controller.background())
            add(controller.cardPane())
            add(controller.background())
            add(controller.cardPane())
            add(controller.background())
        }
        row {
            add(controller.background())
            add(controller.background())
            add(controller.background())
            //add(controller.cardPane())
            add(controller.background())
            add(controller.background())
        }
        row {
            add(controller.background())
            add(controller.background())
            add(controller.background())
            //add(controller.cardPane())
            add(controller.background())
            add(controller.background())
        }
        row {
            add(controller.background())
            add(controller.background())
            add(controller.background())
            //add(controller.cardPane())
            add(controller.background())
            add(controller.background())
        }
        // you can add a lot more rows below as you like.
        // use this to check placement:
         isGridLinesVisible = false
    }
}

class Styles : Stylesheet() {
    companion object {
        val main by cssclass()
        val neighborhood by cssclass()
    }

    init {
        main {
            backgroundColor += c("4E9830")
        }

        neighborhood {
            backgroundColor += c("4E9830")
            prefWidth = 470.px
            prefHeight = 590.px
        }
    }
}


// in the controller package
class viewController: Controller() {

    fun background(): StackPane {
        return StackPane().apply {
            rectangle {
                fill = c("4E9830")
                width = 100.0
                height = 125.0
            }
        }
    }

    fun cardPane(): StackPane {
        return StackPane().apply {
//            rectangle {
//                fill = c("4E9830")
//                width = 100.0
//                height = 100.0
//            }
            rectangle {
                fill = c("#efeffe")
                width = 100.0
                height= 125.0
            }
        }
    }

    private fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start

}
