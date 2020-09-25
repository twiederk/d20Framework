package com.d20charactersheet.framework.dac.dao

/**
 * The interface to the persistence layer to handle images.
 */
interface ImageDao {
    /**
     * Returns the data of the image with the given id from the persistence layer.
     *
     * @param imageId
     * The id of the image to return.
     *
     * @return The data of the image.
     */
    fun getImage(imageId: Int): ByteArray

    /**
     * Inserts the given image data into the persistence layer.
     *
     * @param imageData
     * The image data.
     *
     * @return The id of the new created image.
     */
    fun createImage(imageData: ByteArray): Int

    /**
     * Deletes the image of the given id.
     *
     * @param imageId
     * The id of the image to delete.
     */
    fun deleteImage(imageId: Int)
}