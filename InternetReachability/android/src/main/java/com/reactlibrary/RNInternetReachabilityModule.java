
package com.reactlibrary;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.net.Socket;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.InetAddress;


public class RNInternetReachabilityModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNInternetReachabilityModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNInternetReachability";
  }

  @ReactMethod
  public void isReachable(int timeout, String domain, final Promise promise) {
    int timeOutMillis = 5000;
    if(timeout>0) timeOutMillis = timeout;
    try {
		try (Socket soc = new Socket()) {
        	soc.connect(new InetSocketAddress(InetAddress.getByName(domain), 443), timeOutMillis);
	    }
    	promise.resolve(true);
	} catch (IOException ex) {
    	promise.resolve(false);
  	}
  }
}