package com.example.explorealaska;

public class Park extends Item {
    /**
     * Constant value that represents no image was provided for this word
     */
    public static final int NO_CAPTION_PROVIDED = -1;

    /**
     * String resource ID for the default translation of the word
     */
    private int mCaptionId = NO_CAPTION_PROVIDED;

    /**
     * Create a new {@link Park} object.
     *
     * @param imageResourceId is the drawable resource ID for the image associated with the
     *                        {@link Park}
     * @param captionId       is the string resource ID for the caption
     */
    public Park(int imageResourceId, int captionId) {
        super(imageResourceId);
        mCaptionId = captionId;
    }

    // Getter and Setter
    public int getCaptionId() {
        return mCaptionId;
    }

    public void setCaptionId(int captionId) {
        mCaptionId = captionId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasCaption() {
        return mCaptionId != NO_CAPTION_PROVIDED;
    }
}
