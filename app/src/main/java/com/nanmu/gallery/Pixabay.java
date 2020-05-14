package com.nanmu.gallery;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.versionedparcelable.ParcelField;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kusunoki on 2020/5/14 0014 14:37.
 */
public class Pixabay {
    int total;
    int totalHits;
    @SerializedName("hits")
    List<PhotoItem> photoItemList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public List<PhotoItem> getPhotoItemList() {
        return photoItemList;
    }

    public void setPhotoItemList(List<PhotoItem> photoItemList) {
        this.photoItemList = photoItemList;
    }
}


/**
 * Created by kusunoki on 2020/5/14 0014 14:38.
 */

class PhotoItem implements Parcelable {
    long id;
    String pageURL;
    String type;
    String tags;
    String previewURL;
    int previewWidth;
    int previewHeight;
    String webformatURL;
    int webformatWidth;
    int webformatHeight;
    String largeImageURL;
    int imageWidth;
    int imageHeight;
    long imageSize;
    int views;
    int downloads;
    int favorites;
    int likes;
    int comments;
    long user_id;
    String user;
    String userImageURL;

    protected PhotoItem(Parcel in) {
        id = in.readLong();
        pageURL = in.readString();
        type = in.readString();
        tags = in.readString();
        previewURL = in.readString();
        previewWidth = in.readInt();
        previewHeight = in.readInt();
        webformatURL = in.readString();
        webformatWidth = in.readInt();
        webformatHeight = in.readInt();
        largeImageURL = in.readString();
        imageWidth = in.readInt();
        imageHeight = in.readInt();
        imageSize = in.readLong();
        views = in.readInt();
        downloads = in.readInt();
        favorites = in.readInt();
        likes = in.readInt();
        comments = in.readInt();
        user_id = in.readLong();
        user = in.readString();
        userImageURL = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(pageURL);
        dest.writeString(type);
        dest.writeString(tags);
        dest.writeString(previewURL);
        dest.writeInt(previewWidth);
        dest.writeInt(previewHeight);
        dest.writeString(webformatURL);
        dest.writeInt(webformatWidth);
        dest.writeInt(webformatHeight);
        dest.writeString(largeImageURL);
        dest.writeInt(imageWidth);
        dest.writeInt(imageHeight);
        dest.writeLong(imageSize);
        dest.writeInt(views);
        dest.writeInt(downloads);
        dest.writeInt(favorites);
        dest.writeInt(likes);
        dest.writeInt(comments);
        dest.writeLong(user_id);
        dest.writeString(user);
        dest.writeString(userImageURL);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PhotoItem> CREATOR = new Creator<PhotoItem>() {
        @Override
        public PhotoItem createFromParcel(Parcel in) {
            return new PhotoItem(in);
        }

        @Override
        public PhotoItem[] newArray(int size) {
            return new PhotoItem[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public int getPreviewWidth() {
        return previewWidth;
    }

    public void setPreviewWidth(int previewWidth) {
        this.previewWidth = previewWidth;
    }

    public int getPreviewHeight() {
        return previewHeight;
    }

    public void setPreviewHeight(int previewHeight) {
        this.previewHeight = previewHeight;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public int getWebformatWidth() {
        return webformatWidth;
    }

    public void setWebformatWidth(int webformatWidth) {
        this.webformatWidth = webformatWidth;
    }

    public int getWebformatHeight() {
        return webformatHeight;
    }

    public void setWebformatHeight(int webformatHeight) {
        this.webformatHeight = webformatHeight;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public long getImageSize() {
        return imageSize;
    }

    public void setImageSize(long imageSize) {
        this.imageSize = imageSize;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }
}
