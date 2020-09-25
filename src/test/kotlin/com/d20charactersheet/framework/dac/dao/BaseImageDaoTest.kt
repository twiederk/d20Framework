package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.service.ImageService
import org.assertj.core.api.Assertions.*
import org.junit.Test

abstract class BaseImageDaoTest {

    protected lateinit var imageDao: ImageDao

    @Test
    fun testGetImage() {

        // Act
        val imageData = imageDao.getImage(ImageService.DEFAULT_CHARACTER_IMAGE_ID)

        // Assert
        assertThat(imageData).isNotNull
    }

    @Test
    fun testCreateImage() {
        // Arrange
        val imageData = imageDao.getImage(ImageService.DEFAULT_CHARACTER_IMAGE_ID)

        // Act
        val imageId = imageDao.createImage(imageData)

        // Assert
        assertThat(imageId).isNotEqualTo(ImageService.DEFAULT_CHARACTER_IMAGE_ID)
        assertThat(imageId).isNotEqualTo(ImageService.DEFAULT_THUMB_IMAGE_ID)

        // clean up
        imageDao.deleteImage(imageId)
    }

    @Test
    fun testDeleteImage() {
        // Arrange
        val imageData = imageDao.getImage(ImageService.DEFAULT_CHARACTER_IMAGE_ID)
        val imageId = imageDao.createImage(imageData)

        // Act
        imageDao.deleteImage(imageId)

        // Assert
        val exception = catchThrowable { imageDao.getImage(imageId) }
        assertThat(exception).hasMessage("Can't get image with imageId: $imageId")
    }
}