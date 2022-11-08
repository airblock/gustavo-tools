package com.jd.bluedragon.commons.biz.chain.base.basic.keyed;


import com.jd.bluedragon.commons.biz.chain.base.Catalog;
import com.jd.bluedragon.commons.biz.chain.base.Chain;
import org.junit.Before;
import org.junit.Test;

public class KeyedCommandTest {

    final GenericJsonConfigKeyedCatalogResolver genericJsonConfigKeyedCatalogResolver = new GenericJsonConfigKeyedCatalogResolver();

    @Before
    public void before() {
        new WaybillSignKeyedCommand1("command1");
        new WaybillSignKeyedCommand2("command2");
        new WaybillSignKeyedCommand2("command3");
    }

    /**
     * 创建一个Command 并cache到一致的map中
     */
    @Test
    public void test1() throws Exception {
        String jsonConfig = "{\"fba\":[\"command1\",\"command3\"]}";
        Catalog<String, KeyedContext> catalogByWaybillSign = genericJsonConfigKeyedCatalogResolver.resolve(jsonConfig);

        WaybillSignKeyedContext waybillSignKeyedContext = new WaybillSignKeyedContext(WaybillSign.FBA);

        Chain<KeyedContext> chain = catalogByWaybillSign.getChain(waybillSignKeyedContext.key().getMark());
        boolean execute = chain.execute(waybillSignKeyedContext);

        System.out.println(execute);
    }

}

