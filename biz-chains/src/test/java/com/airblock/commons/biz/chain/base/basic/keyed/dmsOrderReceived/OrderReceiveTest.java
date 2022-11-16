package com.airblock.commons.biz.chain.base.basic.keyed.dmsOrderReceived;


import com.airblock.commons.biz.chain.base.Catalog;
import com.airblock.commons.biz.chain.base.Chain;
import com.airblock.commons.biz.chain.base.basic.keyed.*;
import org.junit.Before;
import org.junit.Test;

public class OrderReceiveTest {

    final GenericJsonConfigKeyedCatalogResolver genericJsonConfigKeyedCatalogResolver = new GenericJsonConfigKeyedCatalogResolver();

    @Before
    public void before() {
        new GoodsCommand("goods");
        new PackageCommand("package");
        new ReportTableCommand("reportTable");
        new SoCommand("so");
        new WaybillCommand("waybill");
    }

    /**
     * 创建一个Command 并cache到一致的map中
     */
    @Test
    public void test1() throws Exception {
        //
        String jsonConfig = "{\"kejie\":[\"package\", \"waybill\"], \"boardCross\":[\"package\", \"waybill\", \"reportTable\"]}";
        Catalog<String, KeyedContext> catalogByWaybillSign = genericJsonConfigKeyedCatalogResolver.resolve(jsonConfig);

        WaybillSignKeyedContext waybillSignKeyedContext = new WaybillSignKeyedContext(WaybillSign.FBA);

        Chain<KeyedContext> chain = catalogByWaybillSign.getChain(waybillSignKeyedContext.key().getMark());
        boolean execute = chain.execute(waybillSignKeyedContext);

        System.out.println(execute);
    }

}

