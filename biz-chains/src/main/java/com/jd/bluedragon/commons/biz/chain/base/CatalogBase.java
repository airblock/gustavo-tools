package com.jd.bluedragon.commons.biz.chain.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CatalogBase<T, K extends BizContext> implements Catalog<T, K> {

    // ----------------------------------------------------- Instance Variables

    protected Map<T, Chain<K>> chains = Collections.synchronizedMap(new HashMap());

    // --------------------------------------------------------- Constructors

    public CatalogBase() {
    }

    public CatalogBase(Map<T, Chain<K>> chains) {
        this.chains = Collections.synchronizedMap(chains);
    }

    // --------------------------------------------------------- Public Methods
    public void addChain(T name, Chain<K> chain) {
        chains.put(name, chain);
    }

    public Chain<K> getChain(T name) {
        return chains.get(name);
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