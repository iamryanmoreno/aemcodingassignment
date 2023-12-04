package com.aemcodingassignment.core.models.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LinkUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinkUtil.class);

    private static final String PATH_CONTENT = "/content/aemcodingassignment/";
    private static final String HTML = ".html";

    public static String buildLinkPath(String link) {
        if (link != null && link.startsWith(PATH_CONTENT)){
            return link + HTML;
        }
        return link;
    }
}
