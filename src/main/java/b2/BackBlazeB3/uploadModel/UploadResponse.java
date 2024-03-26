package b2.BackBlazeB3.uploadModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UploadResponse {

    @SerializedName("fileId")
    @Expose
    private String fileId;
    @SerializedName("fileName")
    @Expose
    private String fileName;
    @SerializedName("accountId")
    @Expose
    private String accountId;
    @SerializedName("bucketId")
    @Expose
    private String bucketId;
    @SerializedName("contentLength")
    @Expose
    private Integer contentLength;
    @SerializedName("contentSha1")
    @Expose
    private String contentSha1;
    @SerializedName("contentType")
    @Expose
    private String contentType;

    @SerializedName("serverSideEncryption")
    @Expose
    private ServerSideEncryption serverSideEncryption;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getBucketId() {
        return bucketId;
    }

    public void setBucketId(String bucketId) {
        this.bucketId = bucketId;
    }

    public Integer getContentLength() {
        return contentLength;
    }

    public void setContentLength(Integer contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentSha1() {
        return contentSha1;
    }

    public void setContentSha1(String contentSha1) {
        this.contentSha1 = contentSha1;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }


    public ServerSideEncryption getServerSideEncryption() {
        return serverSideEncryption;
    }

    public void setServerSideEncryption(ServerSideEncryption serverSideEncryption) {
        this.serverSideEncryption = serverSideEncryption;
    }

}
