package com.github.dreamhead.moco.matcher;

import com.github.dreamhead.moco.HttpRequest;
import com.github.dreamhead.moco.MocoConfig;
import com.github.dreamhead.moco.RequestExtractor;
import com.github.dreamhead.moco.RequestMatcher;
import com.google.common.base.Optional;

public class ExistMatcher<T> implements RequestMatcher {
    private final RequestExtractor<T> extractor;

    public ExistMatcher(RequestExtractor<T> extractor) {
        this.extractor = extractor;
    }

    @Override
    public boolean match(HttpRequest request) {
        Optional<T> extractContent = extractor.extract(request);
        return extractContent.isPresent();
    }

    @Override
    public RequestMatcher apply(MocoConfig config) {
        return this;
    }
}
