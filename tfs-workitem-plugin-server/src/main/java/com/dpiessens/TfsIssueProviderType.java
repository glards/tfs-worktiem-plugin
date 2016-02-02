package com.dpiessens;


import jetbrains.buildServer.issueTracker.IssueProviderType;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import org.jetbrains.annotations.NotNull;

public class TfsIssueProviderType extends IssueProviderType {

    private final String configUrl;

    private final String popupUrl;

    public TfsIssueProviderType(@NotNull final PluginDescriptor pluginDescriptor) {
        configUrl = pluginDescriptor.getPluginResourcesPath("admin/editIssueProvider.jsp");
        popupUrl = pluginDescriptor.getPluginResourcesPath("popup.jsp");
    }

    @NotNull
    @Override
    public String getType() {
        return "tfs-workitems";
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "TFS";
    }

    @NotNull
    @Override
    public String getEditParametersUrl() {
        return configUrl;
    }

    @NotNull
    @Override
    public String getIssueDetailsUrl() {
        return popupUrl;
    }
}
