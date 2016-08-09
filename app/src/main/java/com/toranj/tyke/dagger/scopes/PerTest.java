package com.toranj.tyke.dagger.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by arash on 8/5/16.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerTest {
}

