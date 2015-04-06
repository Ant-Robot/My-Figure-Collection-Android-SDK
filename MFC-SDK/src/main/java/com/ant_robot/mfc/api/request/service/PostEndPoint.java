package com.ant_robot.mfc.api.request.service;

import com.ant_robot.mfc.api.request.MFCRequest;

import retrofit.Endpoint;

/**
 * Created by climbatize on 06/04/15.
 */
public class PostEndPoint implements Endpoint {

    public enum MODE {
        LOGIN(0), ITEM(1);

        int method;

        MODE(int i) {
            method = i;
        }

        public int toInt() {
            return method;
        }

        public String getName() {
            switch (method) {
                case 0:
                    return "Login";
                default:
                    return "Item";
            }
        }

        @Override
        public String toString() {
            switch (method) {
                case 0:
                    return MFCRequest.LOGIN;
                default:
                    return MFCRequest.ITEM;
            }
        }
    }

    public PostEndPoint(MODE mode) {
        super();
        this.setMode(mode);
    }

    public MODE getMode() {
        return mode;
    }

    public void setMode(MODE mode) {
        this.mode = mode;
    }

    private MODE mode;

    @Override
    public String getUrl() {
        return this.mode.toString();
    }

    @Override
    public String getName() {
        return this.mode.getName();
    }
}
