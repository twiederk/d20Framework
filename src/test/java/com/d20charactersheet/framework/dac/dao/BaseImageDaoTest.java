package com.d20charactersheet.framework.dac.dao;

import static com.d20charactersheet.framework.boc.service.ImageService.DEFAULT_CHARACTER_IMAGE_ID;
import static com.d20charactersheet.framework.boc.service.ImageService.DEFAULT_THUMB_IMAGE_ID;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public abstract class BaseImageDaoTest {

  protected ImageDao imageDao;

  @Test
  public void testGetImage() {
    final byte[] imageData = imageDao.getImage(DEFAULT_CHARACTER_IMAGE_ID);
    assertNotNull(imageData);
  }

  @Test
  public void testCreateImage() {
    final byte[] imageData = imageDao.getImage(DEFAULT_CHARACTER_IMAGE_ID);
    final int imageId = imageDao.createImage(imageData);
    assertTrue(imageId != DEFAULT_CHARACTER_IMAGE_ID);
    assertTrue(imageId != DEFAULT_THUMB_IMAGE_ID);

    // clean up
    imageDao.deleteImage(imageId);
  }

  @Test
  public void testDeleteImage() {
    byte[] imageData = imageDao.getImage(DEFAULT_CHARACTER_IMAGE_ID);
    final int imageId = imageDao.createImage(imageData);
    imageDao.deleteImage(imageId);
    imageData = imageDao.getImage(imageId);
    assertNull(imageData);
  }
}
