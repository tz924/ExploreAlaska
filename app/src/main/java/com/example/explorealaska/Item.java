package com.example.explorealaska;

/**
 * {@link Item} represents a item in our app, which is an icon with caption It contains resource IDs
 * for the image file and the caption for that image.
 */
public class Item {

  private int imageResourceId;
  private String caption;


  /**
   * Create a new {@link Item} object.
   *
   * @param caption         is the string for the caption
   * @param imageResourceId is the drawable resource ID for the image associated with the {@link
   *                        Item}
   */
  public Item(int imageResourceId, String caption) {
    this.imageResourceId = imageResourceId;
    this.caption = caption;
  }

  /* Getter and Setters */
  public String getCaption() {
    return caption;
  }

  public int getImageResourceId() {
    return imageResourceId;
  }
}
