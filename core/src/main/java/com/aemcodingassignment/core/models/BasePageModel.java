package com.aemcodingassignment.core.models;

import com.adobe.aem.wcm.seo.SeoTags;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Model(adaptables = {Resource.class,
		SlingHttpServletRequest.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BasePageModel {

    @Inject
    @Via(SlingBindings.RESOURCE)
    private String generator;

    @Inject
    @Via(SlingBindings.RESOURCE)
    private String keywords;

    @Inject
    @Via(SlingBindings.RESOURCE)
    @Named(value = SeoTags.PN_CANONICAL_URL)
    private String canonicalURL;

    @Inject
    @Via(SlingBindings.RESOURCE)
    private String scriptHeader;

    @Inject
    @Via(SlingBindings.RESOURCE)
    private String contentHeader;

    @Inject
    @Via(SlingBindings.RESOURCE)
    private String scriptBody;

    @Inject
    @Via(SlingBindings.RESOURCE)
    private String contentBody;

    @Inject
    @Via(SlingBindings.RESOURCE)
    private String scriptFooter;

    @Inject
    @Via(SlingBindings.RESOURCE)
    private String contentFooter;

    public String getGenerator() {
        return generator;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getCanonicalURL() {
        return canonicalURL;
    }

    public String getScriptHeader() {
        return scriptHeader;
    }

    public String getContentHeader() {
        return contentHeader;
    }

    public String getScriptBody() {
        return scriptBody;
    }

    public String getContentBody() {
        return contentBody;
    }

    public String getScriptFooter() {
        return scriptFooter;
    }

    public String getContentFooter() {
        return contentFooter;
    }

    public void init(SlingBindings slingBindings) {
    }
}
