package com.github.dreamhead.moco.matcher;

import com.github.dreamhead.moco.RequestExtractor;
import com.github.dreamhead.moco.RequestMatcher;
import com.github.dreamhead.moco.resource.Resource;
import com.google.common.base.Predicate;

public class EndsWithMatcher<T> extends AbstractOperatorMatcher<T> {
    public EndsWithMatcher(final RequestExtractor<T> extractor, final Resource expected) {
        super(extractor, expected, new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.endsWith(new String(expected.readFor(null)));
            }
        });
    }

    @Override
    protected RequestMatcher newMatcher(RequestExtractor<T> extractor, Resource resource) {
        return new StartsWithMatcher<T>(extractor, resource);
    }
}
