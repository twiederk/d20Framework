package com.d20charactersheet.framework.boc.service;

/**
 * Handles images.
 */
public interface ImageService {

  /**
   * The id of the default image of the character
   */
  int DEFAULT_CHARACTER_IMAGE_ID = 0;

  /**
   * The id of the default thumbnail of the character
   */
  int DEFAULT_THUMB_IMAGE_ID = 1;

  /**
   * Returns the data of the image.
   *
   * @param imageId
   *     The id of the image to retrieve.
   *
   * @return The data of the image.
   */
  byte[] getImage(int imageId);

  /**
   * Stores the image file in the persistent layer.
   *
   * @param filename
   *     The filename of the image to store.
   *
   * @return The id of the new created image.
   */
  int createImage(String filename);

  /**
   * Deletes the image from the persistent layer.
   *
   * @param imageId
   *     The id of the image to delete.
   */
  void deleteImage(int imageId);

}
