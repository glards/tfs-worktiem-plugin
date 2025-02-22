package com.dpiessens;

import jetbrains.buildServer.issueTracker.AbstractIssueProviderFactory;
import jetbrains.buildServer.issueTracker.IssueFetcher;
import jetbrains.buildServer.issueTracker.IssueProvider;
import jetbrains.buildServer.issueTracker.IssueProviderType;
import jetbrains.buildServer.util.cache.EhCacheUtil;
import jetbrains.buildServer.vcs.VcsManager;
import org.jetbrains.annotations.NotNull;

public class TfsIssueProviderFactory extends AbstractIssueProviderFactory {

    private final IssueFetcher myFetcher;
    private final TfsDataProvider dataProvider;
    private final VcsManager vcsManager;
    private final EhCacheUtil cacheUtil;

    public TfsIssueProviderFactory(final IssueProviderType type, IssueFetcher fetcher, TfsDataProvider dataProvider, VcsManager vcsManager, EhCacheUtil cacheUtil) {
        super(type, fetcher);
        this.myFetcher = fetcher;
        this.dataProvider = dataProvider;
        this.vcsManager = vcsManager;
        this.cacheUtil = cacheUtil;
    }

    @NotNull
    public IssueProvider createProvider() {
        return new TfsIssueProvider(this.myType, this.myFetcher, this.dataProvider, this.vcsManager, this.cacheUtil);
    }
}
