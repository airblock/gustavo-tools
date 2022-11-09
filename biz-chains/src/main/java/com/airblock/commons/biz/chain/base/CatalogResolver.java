package com.airblock.commons.biz.chain.base;

@FunctionalInterface
public interface CatalogResolver<S, T extends Context> {

    Catalog<S, T> resolve(S config);

}
