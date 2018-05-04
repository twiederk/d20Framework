package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.service.exportimport.ImportReport;

/**
 * Compares the imported object of an import report by its toString method.
 */
public class ImportReportComparator implements Comparator<ImportReport<? extends Object>>, Serializable {

  private static final long serialVersionUID = 1L;

  @Override
  public int compare(final ImportReport<? extends Object> report1, final ImportReport<? extends Object> report2) {
    final Object object1 = report1.getImportObject();
    final Object object2 = report2.getImportObject();
    return object1.toString().compareToIgnoreCase(object2.toString());
  }

}
