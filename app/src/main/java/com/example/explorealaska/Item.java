package com.example.explorealaska;

/**
 * {@link Item} represents a item in our app, which is an icon with caption
 * It contains resource IDs for the image file and the caption for that image.
 */
public class Item {

    private int mImageResourceId;
    private String mCaption;


    /**
     * Create a new {@link Item} object.
     *
     * @param caption         is the string for the caption
     * @param imageResourceId is the drawable resource ID for the image associated with the {@link Item}
     */
    public Item(int imageResourceId, String caption) {
        mImageResourceId = imageResourceId;
        mCaption = caption;
    }

    /* Getter and Setters */
    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String Caption) {
        this.mCaption = Caption;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.mImageResourceId = imageResourceId;
    }
}
