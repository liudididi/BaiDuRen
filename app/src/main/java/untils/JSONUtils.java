package untils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by 地地 on 2018/1/19.
 * 邮箱：461211527@qq.com.
 */

public class JSONUtils {
    public  static  RequestBody  mapToJson(HashMap<String,Object> map){
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        String json = gson.toJson(map);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        return  body;
    }
}
