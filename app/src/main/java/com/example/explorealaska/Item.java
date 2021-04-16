package com.example.explorealaska;

/**
 * {@link Item} represents a item in our app, which is an icon with optional caption
 * It contains resource IDs for the image file and optional caption for that image.
 */
public class Item {
    /**
     * Constant value that represents no image was provided for this word
     */
    public static final int NO_CAPTION_PROVIDED = -1;

    /**
     * String resource ID for the default translation of the word
     */
    private int mCaptionId = NO_CAPTION_PROVIDED;

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
    public Item(int imageResourceId, int captionId) {
        mImageResourceId = imageResourceId;
        mCaptionId = captionId;
    }

    /* Getter and Setters */
    public int getImageResourceId() {
        return this.mImageResourceId;
    }

    public int getCaptionId() {
        return this.mCaptionId;
    }

    public void setCaptionId(int captionId) {
        this.mCaptionId = captionId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.mImageResourceId = imageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasCaption() {
        return this.mCaptionId != NO_CAPTION_PROVIDED;
    }
}
