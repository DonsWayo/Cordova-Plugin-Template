/**
 */
package com.example;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import java.util.Date;

public class MyCordovaPlugin extends CordovaPlugin {
    private static final String TAG = "MyCordovaPlugin";

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        Log.d(TAG, "Initializing MyCordovaPlugin");
    }

    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if(action.equals("echo")) {
          final String msg = args.getString(0);
          // use this if you do not need to run on the UI thread
          cordova.getThreadPool().execute(new Runnable() {
              public void run() {
                  echo(msg,callbackContext);
              }
          });

          /***
          // use this if you do need to run on UI thread
          cordova.getActivity().runOnUiThread(new Runnable() {
              public void run() {
                  this.echo(msg,callbackContext);
              }
          });
          ***/
          return true;
        }
        return false;
    }

    private void echo(String message, CallbackContext callbackContext) {
    	final PluginResult result;

        if (message != null && message.length() > 0) {
            result = new PluginResult(PluginResult.Status.OK, message);
        } else {
            result = new PluginResult(PluginResult.Status.ERROR, "Expected one non-empty string argument.");
        }
        callbackContext.sendPluginResult(result);
    }

}
