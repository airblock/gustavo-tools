package com.jd.bluedragon.commons.biz.chain.base.basic.keyed;

import com.jd.bluedragon.commons.biz.chain.base.Catalog;
import com.jd.bluedragon.commons.biz.chain.base.Chain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CatalogBase<T, K extends KeyedContext> implements Catalog<T, K> {

    // ----------------------------------------------------- Instance Variables

    protected Map<T, Chain<K>> chains = Collections.synchronizedMap(new HashMap());

    // --------------------------------------------------------- Constructors

    public CatalogBase() {
    }

    // --------------------------------------------------------- Public Methods
    public void addChain(T name, Chain<K> chain) {
        chains.put(name, chain);
    }

    public Chain<K> getChain(T name) {
        return chains.get(name);
    }

    public boolean execute(K context) throws Exception {
        if (!chains.containsKey(context.key())) {
            throw new UnsupportedOperationException("no chain definition of "+ context.key());
        }

        return chains.get(context.key()).execute(context);
    }

    public Iterator<T> getNames() {
        return (chains.keySet().iterator());
    }

    public String toString() {

        Iterator names = getNames();
        StringBuffer str =
                new StringBuffer("[" + this.getClass().getName() + ": ");

        while (names.hasNext()) {
            str.append(names.next());
            if (names.hasNext()) {
                str.append(", ");
            }
        }
        str.append("]");

        return str.toString();

    }

}