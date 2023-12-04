package com.aemcodingassignment.core.models.base;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Header {

    private static final Logger log = LoggerFactory.getLogger(Header.class);

    @Inject
    @Named("secondaryLinks")
    private Resource secondary;

    private List<HeaderItem> navigationSection;

    @SlingObject
    Resource resource;

    @Inject
    @Default(values = "/content/aemcodingassignment/en")
    String menu;

    @PostConstruct
    public void init() {
        try {
            navigationSection = new ArrayList<>();
            Page listingPage = Objects.requireNonNull(resource.getResourceResolver().adaptTo(PageManager.class)).getContainingPage(menu);
            Iterator<Page> pages = listingPage.listChildren();
            pages.forEachRemaining(
                a -> {
                    List<NavLink> links = new ArrayList<>();
                    a.listChildren()
                        .forEachRemaining(
                            b -> {
                                Boolean b1 = Boolean.valueOf(String.valueOf(b.getProperties().get("hideInAllSubpage")));
                                if (Boolean.valueOf(String.valueOf(b.getProperties().get("hideInAllSubpage")))) return;
                                links.add(new NavLink(b.getTitle(), b.getPath()));
                            });
                    if (Boolean.valueOf(String.valueOf(a.getProperties().get("hideInNavigation")))) return;
                    navigationSection.add(new HeaderItem(a.getTitle(), links));
                });
        } catch (RuntimeException e) {
            log.error("Error: {}", e.getMessage());
        }
    }

    public Resource getSecondary() {
        return secondary;
    }

    public List<HeaderItem> getNavigationSection() {
        return Collections.unmodifiableList(navigationSection);
    }
}
