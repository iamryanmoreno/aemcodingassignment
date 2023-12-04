package com.aemcodingassignment.core.models;

import com.aemcodingassignment.core.models.utils.LinkUtil;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class InformationModel {

    @Inject
    private String link;

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return LinkUtil.buildLinkPath(link);
    }
}
