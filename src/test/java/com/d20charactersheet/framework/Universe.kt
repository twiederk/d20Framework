package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.GameSystem

@SuppressWarnings("SameReturnValue")
interface Universe {

    val gameSystem: GameSystem

}