package com.dpiessens;

import jetbrains.buildServer.issueTracker.IssueFetcher;
import jetbrains.buildServer.issueTracker.IssueProvider;
import jetbrains.buildServer.util.cache.EhCacheUtil;
import jetbrains.buildServer.vcs.VcsManager;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the TfsIssueProviderFactory class
 * Created by dan.piessens on 6/2/2015.
 */
public class TfsIssueProviderFactoryTest {

    @Test
    public void testCreateProvider() throws Exception {

        final IssueFetcher fetcher = mock(IssueFetcher.class);
        final TfsDataProvider dataProvider = mock(TfsDataProvider.class);
        final VcsManager vcsManager = mock(VcsManager.class);
        final EhCacheUtil cacheUtil = mock(EhCacheUtil.class);
        final PluginDescriptor pluginDescriptor = mock(PluginDescriptor.class);
        when(pluginDescriptor.getPluginResourcesPath("admin/editIssueProvider.jsp")).thenReturn("admin/editIssueProvider.jsp");
        when(pluginDescriptor.getPluginResourcesPath("popup.jsp")).thenReturn("popup.jsp");
        final TfsIssueProviderType type = new TfsIssueProviderType(pluginDescriptor);

        TfsIssueProviderFactory factory = new TfsIssueProviderFactory(type, fetcher, dataProvider, vcsManager, cacheUtil);

        IssueProvider provider = factory.createProvider();

        assertNotNull(provider);

        verifyZeroInteractions(fetcher);
        verifyZeroInteractions(dataProvider);
        verifyZeroInteractions(vcsManager);
    }
}