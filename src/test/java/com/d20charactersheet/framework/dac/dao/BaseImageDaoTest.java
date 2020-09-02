package com.d20charactersheet.framework.dac.dao;

import static com.d20charactersheet.framework.boc.service.ImageService.DEFAULT_CHARACTER_IMAGE_ID;
import static com.d20charactersheet.framework.boc.service.ImageService.DEFAULT_THUMB_IMAGE_ID;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public abstract class BaseImageDaoTest {

  protected ImageDao imageDao;

  @Test
  public void testGetImage() {

    // Act
    final byte[] imageData = imageDao.getImage(DEFAULT_CHARACTER_IMAGE_ID);

    // Assert
    assertThat(imageData).isNotNull();
  }

  @Test
  public void testCreateImage() {
    // Arrange
    final byte[] imageData = imageDao.getImage(DEFAULT_CHARACTER_IMAGE_ID);

    // Act
    final int imageId = imageDao.createImage(imageData);

    // Assert
    assertThat(imageId).isNotEqualTo(DEFAULT_CHARACTER_IMAGE_ID);
    assertThat(imageId).isNotEqualTo(DEFAULT_THUMB_IMAGE_ID);

    // clean up
    imageDao.deleteImage(imageId);
  }

  @Test
  public void testDeleteImage() {
    // Arrange
    byte[] imageData = imageDao.getImage(DEFAULT_CHARACTER_IMAGE_ID);
    final int imageId = imageDao.createImage(imageData);

    // Act
    imageDao.deleteImage(imageId);

    // Assert
    assertThat(imageDao.getImage(imageId)).isNull();
  }
}
