package com.example.explorealaska;

/**
 * {@link Item} represents a item in our app, which is an icon with optional caption
 * It contains resource IDs for the image file and optional caption for that image.
 */
public class Item {

    /**
     * Image resource ID for the word
     */
    private int mImageResourceId;

    /**
     * Create a new {@link Item} object.
     *
     * @param captionId       is the string resource ID for the caption
     * @param imageResourceId is the drawable resource ID for the image associated with the {@link Item}
     */
    public Item(int imageResourceId) {
        mImageResourceId = imageResourceId;
    }

    /* Getter and Setters */
    public int getImageResourceId() {
        return this.mImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.mImageResourceId = imageResourceId;
    }
}
