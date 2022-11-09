package com.airblock.commons.biz.chain.base.basic.keyed;


import com.airblock.commons.biz.chain.base.Catalog;
import com.airblock.commons.biz.chain.base.Chain;
import org.junit.Before;
import org.junit.Test;

public class KeyedCacheableCommandTest {

    final GenericJsonConfigKeyedCatalogResolver genericJsonConfigKeyedCatalogResolver = new GenericJsonConfigKeyedCatalogResolver();

    @Before
    public void before() {
        new WaybillSignKeyedCacheableCommand1("command1");
        new WaybillSignKeyedCacheableCommand2("command2");
        new WaybillSignKeyedCacheableCommand2("command3");
    }

    /**
     * 创建一个Command 并cache到一致的map中
     */
    @Test
    public void test1() throws Exception {
        String jsonConfig = "{\"kejie\":[\"command2\"], \"fba\":[\"command1\", \"command3\"]}";
        Catalog<String, KeyedContext> catalogByWaybillSign = genericJsonConfigKeyedCatalogResolver.resolve(jsonConfig);

        WaybillSignKeyedContext waybillSignKeyedContext = new WaybillSignKeyedContext(WaybillSign.FBA);

        Chain<KeyedContext> chain = catalogByWaybillSign.getChain(waybillSignKeyedContext.key().getMark());
        boolean execute = chain.execute(waybillSignKeyedContext);

        System.out.println(execute);
    }

}

