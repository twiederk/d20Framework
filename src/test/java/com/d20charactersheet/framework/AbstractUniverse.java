package com.d20charactersheet.framework;

import com.d20charactersheet.framework.boc.service.GameSystem;

public abstract class AbstractUniverse implements Universe {

  GameSystem gameSystem;

  @Override
  public GameSystem getGameSystem() {
    return gameSystem;
  }

}
