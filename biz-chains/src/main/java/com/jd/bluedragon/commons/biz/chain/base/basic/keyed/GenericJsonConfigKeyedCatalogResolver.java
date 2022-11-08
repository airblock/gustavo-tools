package com.jd.bluedragon.commons.biz.chain.base.basic.keyed;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.jd.bluedragon.commons.biz.chain.base.*;
import com.jd.bluedragon.commons.biz.chain.base.basic.ChainBase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenericJsonConfigKeyedCatalogResolver implements CatalogResolver<String, KeyedContext> {
    @Override
    public Catalog<String, KeyedContext> resolve(String config) {
        Map<String, List<String>> catalogMap
                = JSONObject.parseObject(config, new TypeReference<Map<String, List<String>>>() {});
        CatalogBase<String, KeyedContext> catalogBase = new CatalogBase();
        catalogMap.entrySet().stream().forEach(stringListEntry -> {
            List<Command> collect
                    = stringListEntry.getValue().stream().map(Command.commandMapper::get).collect(Collectors.toList());
            catalogBase.addChain(stringListEntry.getKey()
                    , new ChainBase<>(collect));
        });

        return catalogBase;

    }
}
