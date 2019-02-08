package com.cjdpearce.blackjack


import javafx.geometry.Pos
import javafx.scene.layout.BackgroundSize
import javafx.scene.layout.StackPane
import tornadofx.*


class viewBuilder : View("Blackjack") {

    val numCol: Int = 8

     //every view has a root component
    override val root = gridpane {
            add(background())
            add(card(Pos.CENTER_LEFT))
         add(card(Pos.CENTER))
    }

    fun background(): StackPane {
        return stackpane {
            rectangle {
                fill = c("4E9830")
                width = 1000.0
                height = 1000.0
            }
        }
    }

    fun card(position: Pos): StackPane {
      return stackpane { rectangle {
          fill = c("#FFFFFF")
          width = 100.0
          height = 160.0
          alignment=position
      } }
    }
}
