package com.ant_robot.mfc.api.request.json;

/**
 * Created by clim on 06/09/2015.
 */
public class GalleryJsonConverter extends DynamicJsonConverter{
    @Override
    protected String getDateFormat() {
        return "EEE, dd MMM yyyy HH:mm:ss Z";
    }
}
