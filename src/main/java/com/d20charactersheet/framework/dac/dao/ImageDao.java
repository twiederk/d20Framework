package com.d20charactersheet.framework.dac.dao;

/**
 * The interface to the persistence layer to handle images.
 */
public interface ImageDao {

  /**
   * Returns the data of the image with the given id from the persistence layer.
   *
   * @param imageId
   *     The id of the image to return.
   *
   * @return The data of the image.
   */
  public byte[] getImage(int imageId);

  /**
   * Inserts the given image data into the persistence layer.
   *
   * @param imageData
   *     The image data.
   *
   * @return The id of the new created image.
   */
  public int createImage(byte[] imageData);

  /**
   * Deletes the image of the given id.
   *
   * @param imageId
   *     The id of the image to delete.
   */
  public void deleteImage(int imageId);

}
