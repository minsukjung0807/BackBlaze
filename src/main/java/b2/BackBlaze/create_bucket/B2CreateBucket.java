package b2.BackBlaze.create_bucket;

import org.json.JSONObject;

import b2.BackBlaze.api.HttpRequest;
import b2.BackBlaze.api.HttpRequest.onHttpRequestListener;
import b2.BackBlaze.authorize_account.response.B2AuthResponse;
import b2.BackBlaze.create_bucket.model.BucketType;
import b2.BackBlaze.create_bucket.response.B2CreateBucketResponse;

public class B2CreateBucket {

    private HttpRequest httpRequest;

    public interface OnCreateBucketStateListener { 
        abstract void onSuccess(B2CreateBucketResponse b2CreateBucketResponse);
        abstract void onFailed(String message);
    }

    public OnCreateBucketStateListener onCreateBucketStateListener;

    public void setOnCreateBucketStateListener(OnCreateBucketStateListener onCreateBucketStateListener){
        this.onCreateBucketStateListener = onCreateBucketStateListener;
    }

    public B2CreateBucket() {
       httpRequest = new HttpRequest();
    }

    public void startCreatingBucket(B2AuthResponse b2AuthResponse, String bucketName, BucketType bucketType) {
        JSONObject parameters = new JSONObject();

        httpRequest.setOnHttpRequestListener(new onHttpRequestListener() {
            @Override
            public void onSuccess(JSONObject response) {
                onCreateBucketStateListener.onSuccess(new B2CreateBucketResponse(bucketName, response.getString("bucketId"), bucketType));
            }
            @Override
            public void onFailed(JSONObject response) {
                onCreateBucketStateListener.onFailed("실패!: " + response.getString("message") +
                response.getInt("status") + response.getString("code"));
            }
           });

        parameters.put("accountId", b2AuthResponse.getAccountID());
        parameters.put("bucketName", bucketName);
        parameters.put("bucketType", bucketType.getIdentifier());

        httpRequest.call(b2AuthResponse.getAPIURL()+ "/b2api/v3/", "b2_create_bucket", b2AuthResponse.getAuthToken(), parameters);
    }

    

      
}