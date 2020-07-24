package com.team.sioh6.ui.buy;

import android.os.Parcel;
import android.os.Parcelable;

public class BuyModel implements Parcelable {
    private String userImgUrl;
    private String userName;
    private String timeStamp;
    private String productImg;
    private String productTitle;
    private String productDetails;

    public BuyModel() {
    }

    public static final Creator<BuyModel> CREATOR = new Creator<BuyModel>() {
        @Override
        public BuyModel createFromParcel(Parcel in) {
            return new BuyModel(in);
        }

        @Override
        public BuyModel[] newArray(int size) {
            return new BuyModel[size];
        }
    };

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userImgUrl);
        dest.writeString(userName);
        dest.writeString(timeStamp);
        dest.writeString(productImg);
        dest.writeString(productTitle);
        dest.writeString(productDetails);
        dest.writeInt(id);
    }

    protected BuyModel(Parcel in) {
        userImgUrl = in.readString();
        userName = in.readString();
        timeStamp = in.readString();
        productImg = in.readString();
        productTitle = in.readString();
        productDetails = in.readString();
        id = in.readInt();
    }
}
