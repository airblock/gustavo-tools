package com.jd.bluedragon.commons.biz.chain.base.basic.keyed;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class WaybillSignKeyedContext extends AbstractKeyedContext<WaybillSign> {

    private Object parameters;

    public WaybillSignKeyedContext(WaybillSign key) {
        super(key);
    }
}
