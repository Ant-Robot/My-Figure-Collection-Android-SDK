package com.ant_robot.mfc.api.request;

import android.util.Log;

import com.ant_robot.mfc.api.pojo.UserCollection;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;


/**
 * Created by e0000429 on 20/03/2015.
 */
public enum MFCRequest {
    INSTANCE;
    public static final String ROOT = "http://myfigurecollection.net/api.php";
    private final RestAdapter restAdapter;

    private MFCRequest()
    {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(60, TimeUnit.SECONDS);
        client.setReadTimeout(60, TimeUnit.SECONDS);


        restAdapter = new RestAdapter.Builder().setClient(new OkClient(client)).setConverter(new DynamicJsonConverter()).setEndpoint(ROOT).setLogLevel(RestAdapter.LogLevel.FULL).build();
    }

    public CollectionService getCollectionService()
    {
        return restAdapter.create(CollectionService.class);
    }


    static class DynamicJsonConverter implements Converter {

        @Override public Object fromBody(TypedInput typedInput, Type type) throws ConversionException {
            try {
                InputStream in = typedInput.in(); // convert the typedInput to String
                String string = fromStream(in);
                in.close(); // we are responsible to close the InputStream after use

                string = string.replace("{}","\"\"");

                Log.d("test", string);
                if (String.class.equals(type)) {
                    return string;
                } else {
                    return new Gson().fromJson(string, type); // convert to the supplied type, typically Object, JsonObject or Map<String, Object>
                }
            } catch (Exception e) { // a lot may happen here, whatever happens
                throw new ConversionException(e); // wrap it into ConversionException so retrofit can process it
            }
        }

        @Override public TypedOutput toBody(Object object) { // not required
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


}
