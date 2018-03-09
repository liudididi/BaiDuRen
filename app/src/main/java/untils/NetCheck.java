package untils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetCheck {
	Context mContext;
	public NetCheck(Context context) {
		this.mContext = context;
	}

	public static NetworkInfo t(Context context) {
		ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		return mConnectivityManager.getActiveNetworkInfo();
	}

	public static boolean isNetConnected(Context context) {
		NetworkInfo mNetworkInfo = t(context);
		return (mNetworkInfo != null) && (mNetworkInfo.isConnectedOrConnecting());
	}

	protected boolean isShowNoNetworksPrompt() {
		return true;
	}



}
