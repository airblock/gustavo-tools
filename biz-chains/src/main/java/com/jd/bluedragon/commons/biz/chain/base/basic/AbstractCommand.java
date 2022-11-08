package com.jd.bluedragon.commons.biz.chain.base.basic;

import com.jd.bluedragon.commons.biz.chain.base.Command;
import com.jd.bluedragon.commons.biz.chain.base.Context;

public abstract class AbstractCommand<T extends Context> implements Command<T> {

    public AbstractCommand(String name) {
        markCommand(name, this);
    }
}
