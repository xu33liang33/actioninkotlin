package chapter04.qiantao4_1_4

import java.io.Serializable


interface State:Serializable

interface ViewInter {
    fun getCurrentState():State

    fun restoreState(state:State){}
}

