package com.ant_robot.mfc.api.request.json;

import com.google.gson.GsonBuilder;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/**
* Created by Climbatize on 23/03/2015.
*/
public class DynamicJsonConverter implements Converter {

    @Override
    public Object fromBody(TypedInput typedInput, Type type) throws ConversionException {
        try {
            InputStream in = typedInput.in(); // convert the typedInput to String
            String string = fromStream(in);
            in.close(); // we are responsible to close the InputStream after use

            string = StringUtils.replace(string, "{}", "null");
            //string = StringUtils.replace(string, "0000-00-00", "null");

            if (String.class.equals(type)) {
                return string;
            } else {
                return new GsonBuilder()
                        .setDateFormat(getDateFormat())
                        .create().fromJson(string, type); // convert to the supplied type, typically Object, JsonObject or Map<String, Object>
            }
        } catch (Exception e) { // a lot may happen here, whatever happens
            throw new ConversionException(e); // wrap it into ConversionException so retrofit can process it
        }
    }

    protected String getDateFormat() {
        return "yyyy-MM-dd";
    }

    @Override
    public TypedOutput toBody(Object object) { // not required
        return null;
    }

    private static String fromStream(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append("\r\n");
        }
        return out.toString();
    }
}
