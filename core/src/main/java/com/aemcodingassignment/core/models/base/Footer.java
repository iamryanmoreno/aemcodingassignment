package com.aemcodingassignment.core.models.base;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Footer {

    @Inject
    @Named("primaryLinks")
    Resource primary;

    @Inject
    @Named("secondaryLinks")
    Resource secondary;

    @Inject
    @Named("socialMediaLinks")
    Resource social;

    public Resource getPrimary() {
        return primary;
    }

    public Resource getSecondary() {
        return secondary;
    }

    public Resource getSocial() {
        return social;
    }

}
